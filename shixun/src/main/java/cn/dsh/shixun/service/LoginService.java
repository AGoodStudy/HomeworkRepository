package cn.dsh.shixun.service;

import cn.dsh.shixun.dao.UserMapper;
import cn.dsh.shixun.entity.User;
import cn.dsh.shixun.entity.UserDTO;
import cn.dsh.shixun.utils.Constant;
import cn.dsh.shixun.utils.SnowflakeIdWorker;
import cn.dsh.shixun.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆业务层
 *
 * @author dsh
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginService {

    private final UserMapper userMapper;

    /**
     * 通过邮箱登陆
     *
     * @param userEmail
     * @return
     */
    public UserDTO loginByEmail(String userEmail, HttpServletRequest request) {

        String identIfication = String.valueOf(request.getAttribute("identIfication"));

        User user = userMapper.findByEmail(userEmail);
        if (user == null) {

            //如果是新用户的情况
            User newUser = User.builder()
                    .id(SnowflakeIdWorker.generateId())
                    .email(userEmail)
                    .nickname(Constant.INITNAME)
                    .age(0)
                    .gender("男")
                    .build();

            //添加新用户
            Integer i = userMapper.insertSelective(newUser);
            if (i == 1) {
                //添加新用户成功
                UserDTO userDTO = new UserDTO();
                BeanUtils.copyProperties(newUser,userDTO);
                userDTO.setToken(TokenUtils.getToken(newUser.getId(),identIfication));
                return userDTO;
            }
            //如果添加新用户失败
            return null;
        }

        //如果是老用户的情况
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        userDTO.setToken(TokenUtils.getToken(user.getId(),identIfication));
        return userDTO;
    }


    /**
     * 通过账号密码登陆
     *
     * @return
     */
    public UserDTO loginByPwd(String userEmail, String password, HttpServletRequest request) {

        String identIfication = String.valueOf(request.getAttribute("identIfication"));

        //密码转为md5
        String md5pwd = DigestUtils.md5DigestAsHex(password.getBytes());

        User user = userMapper.loginByPassword(userEmail, md5pwd);

        if (user == null) {
            return null;
        }

        UserDTO userDTO = UserDTO.builder()
                .token(TokenUtils.getToken(user.getId(),identIfication))
                .build();

        BeanUtils.copyProperties(user, userDTO);
        return userDTO;

    }

}
