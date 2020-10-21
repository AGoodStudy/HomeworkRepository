package cn.dsh.shixun.controller;


import cn.dsh.shixun.annoation.PassToken;
import cn.dsh.shixun.annoation.UserLoginToken;
import cn.dsh.shixun.entity.VerCodeInfo;
import cn.dsh.shixun.service.EmailService;
import cn.dsh.shixun.service.UserEmailService;
import cn.dsh.shixun.utils.Constant;
import cn.dsh.shixun.utils.ReturnUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 发送邮箱接口
 *
 * @author dsh
 */
@RestController
@RequestMapping("/vercode")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailController {

    private final EmailService emailService;

    private final UserEmailService userEmailService;

    /**
     * 通过邮箱登陆获取验证码
     *
     * @param verCodeInfo
     * @return
     */
    @PassToken
    @PostMapping(value = "/login",produces = "application/json")
    public JSONObject sendLoginVerCode(@Validated @RequestBody VerCodeInfo verCodeInfo) {

        //验证码有效时间10分钟
        verCodeInfo.setFailureTime(System.currentTimeMillis() + Constant.TENMINUTE);

        String result = emailService.sendEmail(verCodeInfo.getUserEmail(), "l", verCodeInfo);

        if ("success".equals(result)) {
            //邮箱发送成功
            JSONObject toFront = ReturnUtil.returnJson(Constant.RESULTOK, Constant.MESSAGE, Constant.EMAILSUCCESS);
            return toFront;
        }

        //邮箱send出错，可能是没有此邮箱
        JSONObject toFront = ReturnUtil.returnJson(Constant.ERROREMAIL, Constant.MESSAGE, Constant.EMAILERROR);
        return toFront;
    }

    /**
     * 更改密码前获取验证码
     */
    @UserLoginToken
    @PostMapping(value = "/changepwd",produces = "application/json")
    public JSONObject sendChangeVerCode(HttpServletRequest request) {

        String userid = String.valueOf(request.getAttribute("userid"));

        String email = userEmailService.getUserEmailById(Long.valueOf(userid));

        VerCodeInfo codeInfo = VerCodeInfo.builder()
                .failureTime(System.currentTimeMillis() + Constant.TENMINUTE)
                .userEmail(email)
                .build();

        String result = emailService.sendEmail(email, "c", codeInfo);
        if (Constant.SUCCESS.equals(result)) {
            //邮箱发送成功
            JSONObject toFront = ReturnUtil.returnJson(Constant.RESULTOK, Constant.MESSAGE, Constant.EMAILSUCCESS);
            return toFront;

        }

        //邮箱send出错，可能是没有此邮箱
        JSONObject toFront = ReturnUtil.returnJson(Constant.ERROREMAIL, Constant.MESSAGE, Constant.EMAILERROR);
        return toFront;
    }

}
