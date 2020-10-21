package cn.dsh.shixun.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * 返回json对象工具类
 *
 * @author dsh
 */
public class ReturnUtil {

    public static JSONObject returnJson(String resultValue,String messageName,Object messageValue) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put(Constant.RESULT, resultValue);
        jsonObject.put(messageName, messageValue);

        return jsonObject;
    }

}
