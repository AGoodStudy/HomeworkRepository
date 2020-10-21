package cn.dsh.shixun.controller;

import cn.dsh.shixun.annoation.PassToken;
import cn.dsh.shixun.entity.UserDTO;
import cn.dsh.shixun.entity.VerCodeInfo;
import cn.dsh.shixun.service.LoginService;
import cn.dsh.shixun.service.VerCodeService;
import cn.dsh.shixun.utils.Constant;
import cn.dsh.shixun.utils.ReturnUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 两种登陆方式接口
 *
 * @author dsh
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/login")
public class LoginController {

    private final VerCodeService verCodeService;

    private final LoginService loginService;

    @PassToken
    @PostMapping(value = "/byemail", produces = "application/json")
    public JSONObject loginByEmail(@RequestBody @Validated VerCodeInfo codeInfo, HttpServletRequest request) {
        String key = codeInfo.getUserEmail() + "l";
        String verCode = codeInfo.getVerCode();
        String result = verCodeService.checkCode(key, verCode);
        if (Constant.SUCCESS.equals(result)) {

            //验证码成功
            UserDTO userDTO = loginService.loginByEmail(codeInfo.getUserEmail(), request);
            if (userDTO == null) {
                //插入数据库异常
                JSONObject toFront = ReturnUtil.returnJson(Constant.ERRORLOGIN, Constant.MESSAGE, Constant.REGISTERERROR);
                return toFront;

            }

            //一切正常
            JSONObject toFront = ReturnUtil.returnJson(Constant.RESULTOK, Constant.USERINFO, userDTO);
            return toFront;

        }

        //验证码过时或者错误
        JSONObject toFront = ReturnUtil.returnJson(Constant.ERRORLOGIN, Constant.MESSAGE, result);
        return toFront;

    }


    @PassToken
    @PostMapping(value = "/bypassword", produces = "application/json")
    public JSONObject loginByPassword(@RequestBody JSONObject jsonObjects, HttpServletRequest request, HttpServletResponse response) {


        String password = String.valueOf(jsonObjects.get("password"));
        String userEmail = String.valueOf(jsonObjects.get("userEmail"));

        boolean flag = Constant.NULL.equals(password) || Constant.NULL.equals(userEmail) || StringUtils.isAnyBlank(password, userEmail);

        if (flag) {

            JSONObject toFront = ReturnUtil.returnJson(Constant.ERRORLOGIN, Constant.MESSAGE, Constant.NULLUSEREMAILPWD);
            return toFront;
        }

        UserDTO userDTO = loginService.loginByPwd(userEmail, password, request);
        if (userDTO == null) {

            JSONObject toFront = ReturnUtil.returnJson(Constant.ERRORLOGIN, Constant.MESSAGE, Constant.ERRORUSEREMAILPWD);
            return toFront;
        }

        JSONObject toFront = ReturnUtil.returnJson(Constant.RESULTOK, Constant.USERINFO, userDTO);
        return toFront;
    }

}
