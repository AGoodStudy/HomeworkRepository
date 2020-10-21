package cn.dsh.shixun.service;

import cn.dsh.shixun.entity.VerCodeInfo;
import cn.dsh.shixun.utils.Constant;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 对验证码进行操作的业务层
 *
 * @author dsh
 */
@Service
public class VerCodeService {

    private Map<String, VerCodeInfo> codeInfos = new ConcurrentHashMap<>();

    /**
     * 添加验证码信息
     *
     * @param key
     * @param codeInfo
     */
    public void addCodeInfo(String key, VerCodeInfo codeInfo) {
        codeInfos.put(key, codeInfo);
        System.out.println(codeInfos);
    }

    /**
     * 校验验证码
     *
     * @param key
     * @param verCode
     * @return
     */
    public String checkCode(String key, String verCode) {
        for (String existKey : codeInfos.keySet()) {

            if (existKey.equals(key)) {
                VerCodeInfo codeInfo = codeInfos.get(existKey);

                if (verCode.equals(codeInfo.getVerCode())) {

                    long nowTime = System.currentTimeMillis();

                    if (nowTime < codeInfo.getFailureTime()) {
                        return Constant.SUCCESS;
                    }

                    return Constant.VERCODEFAILURE;

                }

                return Constant.VERCODEERROR;

            }
        }

        return Constant.NOVERCODE;
    }


}
