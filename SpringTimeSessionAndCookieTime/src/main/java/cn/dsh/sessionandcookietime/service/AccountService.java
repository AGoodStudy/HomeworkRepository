package cn.dsh.sessionandcookietime.service;

import cn.dsh.sessionandcookietime.domain.Account;
import cn.dsh.sessionandcookietime.mapper.AcconuntMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AccountService {

    @Autowired
    private AcconuntMapper acconuntMapper;


    public Account findAccount(Account account) {
        if (acconuntMapper.findAccount(account) == null) {
            return new Account();
        } else {
            Account account1 = new Account();
            account1 = acconuntMapper.findAccount(account);

            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = servletRequestAttributes.getRequest();
            HttpServletResponse response = servletRequestAttributes.getResponse();

            //浏览器存储用户名密码
            Cookie cUsername = new Cookie("username",account1.getUsername());
            response.addCookie(cUsername);
            Cookie cNumber = new Cookie("number", account1.getNumber());
            response.addCookie(cNumber);
            Cookie cPassword = new Cookie("password", account1.getPassword());
            response.addCookie(cPassword);


            //靠cookie设置session存活时间
            HttpSession session = request.getSession();
            session.setAttribute("onLineUser", account1.getNumber());

            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(60 * 30);
            response.addCookie(cookie);

            return account1;
        }
    }

    public String insertOne(Account account) {
        acconuntMapper.insertOne(account);
        return "success";
    }

    public String getLastTime(String accountNumber) {
        String allName = accountNumber + "lastTime";
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();

        Cookie[] cookies = request.getCookies();
        boolean flag = false;//没有cookie为 学好加lasttime
        boolean nullcookies = false;//cookies不为空
        if (cookies == null) {
            nullcookies = true;
        }

        if (nullcookies == false && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (allName.equals(name)) {

                    flag = true;

                    //返回上次登录的时间
                    String value = cookie.getValue();
                    try {
                        value = URLDecoder.decode(value, "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }


                    //设置这次登陆的时间
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String newDate = sdf.format(date);
                    //cookie不能存入空格，转化为url编码，java8以后cookie可以存中文
                    try {
                        newDate = URLEncoder.encode(newDate, "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    cookie.setValue("你上次的登陆时间是:" + newDate);
                    //设置cookie存活时间:一个月
                    cookie.setMaxAge(60 * 60 * 24 * 30);

                    response.addCookie(cookie);


                    return value;
                }
            }
        }

        if (nullcookies == true || cookies.length == 0 || flag == false) {
            //第一次访问
            //设置这次登陆的时间
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String newDate = sdf.format(date);
            //cookie不能存入空格，转化为url编码,java8以后cookie可以存中文
            try {
                newDate = URLEncoder.encode(newDate, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            Cookie cookie = new Cookie(allName, "你上次的登陆时间是:" + newDate);
            //设置cookie存活时间:一个月
            cookie.setMaxAge(60 * 60 * 24 * 30);

            response.addCookie(cookie);

            return "这是你第一次登陆";
        }

        return "";
    }

    public void filterUser() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();

        try {
            response.sendRedirect(request.getContextPath() + "/index.html?flag=1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String check() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();

        String onlineUser = (String) request.getSession().getAttribute("onLineUser");
        System.out.println(onlineUser);
        if (onlineUser == null || onlineUser.equals("")) {
            return "nullsession";
        } else {
            return "fullsession";
        }
    }
}
