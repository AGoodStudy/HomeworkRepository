package cn.dsh.shixun.dao;

import cn.dsh.shixun.entity.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

    /**
     * 通过邮箱找到用户信息
     * @param userEmail
     * @return
     */
    User findByEmail(String userEmail);

    /**
     * 通过账号密码登陆
     * @param userEmail 用户账号
     * @param md5pwd md5加密后的密码
     * @return 返回用户信息
     */
    User loginByPassword(String userEmail, String md5pwd);

    /**
     * 通过id查找邮箱
     * @param id 用户id
     * @return 返回对应邮箱
     */
    String selectEmailById(Long id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Integer updateUserInfoById(User user);

}