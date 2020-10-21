package cn.dsh.shixun.interceptor;


import cn.dsh.shixun.annoation.PassToken;
import cn.dsh.shixun.annoation.UserLoginToken;
import cn.dsh.shixun.utils.Constant;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.util.DigestUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author dsh
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        //获取浏览器的user-agent
        String UA = request.getHeader("user-agent");
        if (UA == null) {
            UA = "1";
        }
        String identification = UA;

        String identIfication = DigestUtils.md5DigestAsHex(identification.getBytes());

        //从请求头重取出token
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                request.setAttribute("identIfication", identIfication);
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    returnResult(response, Constant.NOHEADTKEN);
                    return false;
                    //throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId;
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    returnResult(response, Constant.ERRORHEADTKEN);
                    return false;
                    //throw new RuntimeException("token中无id");
                }
                // 验证浏览器或设备是否正常

                String iden;

                try {
                    iden = JWT.decode(token).getAudience().get(1);
                } catch (JWTDecodeException e) {
                    returnResult(response, Constant.ERRORHEADTKEN);
                    return false;
                }

                if (!identIfication.equals(iden)) {
                    returnResult(response, Constant.HEADTOKENFAILURE);
                    return false;
                }

                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(Constant.TOKEN_SECRET)).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    returnResult(response, Constant.HEADTOKENFAILURE);
                    return false;
                    //throw new RuntimeException("token失效或错误");
                }
                request.setAttribute("userid", userId);
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {
    }


    private void returnResult(HttpServletResponse response, String why) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            JSONObject res = new JSONObject();
            res.put(Constant.RESULT, Constant.ERRORTOKEN);
            res.put(Constant.MESSAGE, why);
            out = response.getWriter();
            out.append(res.toString());
        } catch (IOException e) {
            e.printStackTrace();
            try {
                response.sendError(500);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
