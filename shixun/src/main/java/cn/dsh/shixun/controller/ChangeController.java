package cn.dsh.shixun.controller;

import cn.dsh.shixun.annoation.UserLoginToken;
import cn.dsh.shixun.entity.User;
import cn.dsh.shixun.service.ChangePwdService;
import cn.dsh.shixun.service.ChangeInfoService;
import cn.dsh.shixun.utils.Constant;
import cn.dsh.shixun.utils.ReturnUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 更改密码以及更改昵称
 *
 * @author dsh
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChangeController {

    private final ChangeInfoService changeInfoService;

    private final ChangePwdService changePwdService;

    /**
     * 更改昵称
     *
     * @return
     */
    @UserLoginToken
    @PostMapping(value = "/changeinfo",produces = "application/json")
    public JSONObject changeNickName(@RequestBody User user, HttpServletRequest request) {

        String result = changeInfoService.changeUserInfo(user, request);
        if (Constant.SUCCESS.equals(result)) {

            //改名成功
            JSONObject toFront = ReturnUtil.returnJson(Constant.RESULTOK, Constant.MESSAGE, Constant.CHANGESUCCESS);
            return toFront;
        }

        JSONObject toFront = ReturnUtil.returnJson(Constant.ERRORNICKNAME, Constant.MESSAGE, result);
        return toFront;
    }


    /**
     * 更改密码
     *
     * @param jsonObject
     * @param request
     * @return
     */
    @UserLoginToken
    @PostMapping(value = "/changepwd",produces = "application/json")
    public JSONObject changePassword(@RequestBody JSONObject jsonObject, HttpServletRequest request) {

        String verCode = String.valueOf(jsonObject.get("verCode"));
        String newPwd = String.valueOf(jsonObject.get("newPassword"));

        boolean verCodeNull = Constant.NULL.equals(verCode) || StringUtils.isBlank(verCode);
        boolean newPwdNull = Constant.NULL.equals(newPwd) || StringUtils.isBlank(newPwd);

        if (verCodeNull) {

            JSONObject toFront = ReturnUtil.returnJson(Constant.ERRORPWD, Constant.MESSAGE, Constant.NULLVERCODE);
            return toFront;
        }

        if (newPwdNull) {

            JSONObject toFront = ReturnUtil.returnJson(Constant.ERRORPWD, Constant.MESSAGE, Constant.NULLPASSWORD);
            return toFront;
        }

        String result = changePwdService.changePwd(request, verCode, newPwd);

        if (Constant.SUCCESS.equals(result)) {
            //更改密码成功
            JSONObject toFront = ReturnUtil.returnJson(Constant.RESULTOK, Constant.MESSAGE, Constant.CHANGESUCCESS);
            return toFront;
        }

        JSONObject toFront = ReturnUtil.returnJson(Constant.ERRORPWD, Constant.MESSAGE, result);
        return toFront;
    }

    @UserLoginToken
    @PostMapping(value = "/changeavatar",produces = "application/json")
    public JSONObject changeAvatar(MultipartFile file, HttpServletRequest request) {

        if (file == null || file.isEmpty()) {
            JSONObject toFront = ReturnUtil.returnJson("ERRORAVATAR", Constant.MESSAGE, "请选择上传的图片");
            return toFront;
        }
        String result = changeInfoService.changeAvatar(file, request);
        if (Constant.FALSE.equals(result)) {
            JSONObject toFront = ReturnUtil.returnJson("ERRORAVATAR", Constant.MESSAGE, "上传失败");
            return toFront;
        }
        JSONObject toFront = ReturnUtil.returnJson(Constant.SUCCESS, Constant.MESSAGE, result);
        return toFront;
    }

}
