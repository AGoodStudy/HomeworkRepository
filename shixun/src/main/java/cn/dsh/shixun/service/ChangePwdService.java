package cn.dsh.shixun.service;

import cn.dsh.shixun.dao.UserMapper;
import cn.dsh.shixun.entity.User;
import cn.dsh.shixun.utils.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * 更改密码的业务层
 *
 * @author dsh
 * @date 2020/4/1
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChangePwdService {

    private final UserMapper userMapper;

    private final VerCodeService verCodeService;

    /**
     * 更改密码业务
     *
     * @param request
     * @param verCode
     * @param newPwd
     * @return
     */
    public String changePwd(HttpServletRequest request, String verCode, String newPwd) {

        String userid = String.valueOf(request.getAttribute("userid"));

        String email = userMapper.selectEmailById(Long.valueOf(userid));

        String key = email + "c";
        String checkResult = verCodeService.checkCode(key, verCode);

        if (Constant.SUCCESS.equals(checkResult)) {
            //验证码正确
            //加密用户密码
            String md5Pwd = DigestUtils.md5DigestAsHex(newPwd.getBytes());

            //更改用户密码
            User newUser = User.builder()
                    .id(Long.valueOf(userid))
                    .password(md5Pwd)
                    .build();

            int i = userMapper.updateByPrimaryKeySelective(newUser);

            if (i == 1) {
                    return Constant.SUCCESS;
            }

            //数据库出问题的情况
            return Constant.CHANGEERROR;
        }

        //验证码错误
        return checkResult;
    }
}
