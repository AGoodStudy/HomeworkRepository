package cn.dsh.shixun.service;

import cn.dsh.shixun.dao.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 获取用户邮箱的业务
 *
 * @author dsh
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserEmailService {

    private final UserMapper userMapper;

    public String getUserEmailById(Long userid) {

        String email = userMapper.selectEmailById(userid);

        return email;
    }

}
