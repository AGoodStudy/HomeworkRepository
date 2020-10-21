package cn.dsh.shixun.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

/**
 * 生成token工具类
 *
 * @author dsh
 */
public class TokenUtils {

    /**
     * 用户token过期时间为12小时
     */
    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;


    public static String getToken(Long userId,String iden) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        String token = "";
        token = JWT.create().withAudience(String.valueOf(userId),iden)
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(Constant.TOKEN_SECRET));
        return token;
    }

}
