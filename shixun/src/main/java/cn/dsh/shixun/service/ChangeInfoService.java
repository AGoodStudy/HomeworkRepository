package cn.dsh.shixun.service;

import cn.dsh.shixun.dao.UserMapper;
import cn.dsh.shixun.entity.User;
import cn.dsh.shixun.utils.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 更改昵称业务
 *
 * @author dsh
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChangeInfoService {

    private final UserMapper userMapper;

    public String changeUserInfo(User user, HttpServletRequest request) {

        String userid = String.valueOf(request.getAttribute("userid"));
        user.setId(Long.valueOf(userid));

        if (user.getAge() != null || user.getGender() != null || user.getNickname() != null) {

            if (user.getGender() != null && user.getGender().length() != 1) {
                return Constant.CHANGEERROR;
            }

            int i = userMapper.updateUserInfoById(user);
            if (i > 0) {
                return Constant.SUCCESS;
            }

            return Constant.CHANGEERROR;
        }
        return Constant.CHANGEERROR;
    }

    public String changeAvatar(MultipartFile file, HttpServletRequest request) {

        String userid = String.valueOf(request.getAttribute("userid"));

        User user = User.builder().id(Long.valueOf(userid)).build();

        String avatarPath = "D:/avatars/"+file.getOriginalFilename();

        File dest = new File(avatarPath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            return "false";
        }
        user.setAvatar(avatarPath);
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i == 1) {
            return avatarPath;
        }

        return "false";
    }

}
