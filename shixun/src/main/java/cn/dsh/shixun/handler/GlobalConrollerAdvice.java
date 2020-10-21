package cn.dsh.shixun.handler;

import cn.dsh.shixun.utils.Constant;
import cn.dsh.shixun.utils.ReturnUtil;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.UnsupportedEncodingException;

/**
 * 全局异常处理
 *
 * @author dsh
 * @date 2020/3/30
 */
@RestControllerAdvice
public class GlobalConrollerAdvice {

    /**
     * 验证邮箱格式错误异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JSONObject handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        JSONObject reason = ReturnUtil.returnJson(Constant.ERROREMAIL, Constant.MESSAGE, e.getBindingResult().getFieldError().getDefaultMessage());
        return reason;
    }

    /**
     * 上传文件超过大小异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public JSONObject handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {

        JSONObject reason = ReturnUtil.returnJson(Constant.ERRORUPLOAD, Constant.MESSAGE, Constant.TOOLARGEFILE);
        return reason;
    }

    /**
     * 传值格式异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(JsonParseException.class)
    public JSONObject handleJsonParseException(JsonParseException e) {

        JSONObject reason = ReturnUtil.returnJson(Constant.ERRORJSON, Constant.MESSAGE, Constant.JSONERROR);
        return reason;
    }

    /**
     * 传值类型异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NumberFormatException.class)
    public JSONObject handleNumberFormatException(NumberFormatException e) {

        JSONObject reason = ReturnUtil.returnJson(Constant.ERRORTYPE, Constant.MESSAGE, Constant.ARGUMENTTYPEERROR);
        return reason;
    }

    /**
     * 传值参数异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public JSONObject handleIllegalArgumentException(IllegalArgumentException e) {

        JSONObject reason = ReturnUtil.returnJson(Constant.ERRORARGUMENT, Constant.MESSAGE, Constant.ARGUMENTERROR);
        return reason;
    }


    /**
     * 传值类型异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public JSONObject handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        JSONObject reason = ReturnUtil.returnJson(Constant.ERRORJSON, Constant.MESSAGE, Constant.JSONERROR);
        return reason;
    }

    /**
     * 传值类型异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public JSONObject handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        JSONObject reason = ReturnUtil.returnJson(Constant.ERRORJSON, Constant.MESSAGE, Constant.JSONERROR);
        return reason;
    }

    /**
     * 请求方式异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JSONObject handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        JSONObject reason = ReturnUtil.returnJson(Constant.ERRORMETHOD, Constant.MESSAGE, Constant.ERRORMETHODVALUE);
        return reason;
    }


    @ExceptionHandler(UnsupportedEncodingException.class)
    public JSONObject handleUnsupportedEncodingException(UnsupportedEncodingException e) {
        JSONObject reason = ReturnUtil.returnJson(Constant.ERRORDOWNLOAD, Constant.MESSAGE, Constant.DOWNLOADFAIL);
        return reason;
    }

    @ExceptionHandler(ClassCastException.class)
    public JSONObject handleClassCastException(ClassCastException e) {
        JSONObject reason = ReturnUtil.returnJson(Constant.ERRORJSON, Constant.MESSAGE, Constant.JSONERROR);
        return reason;
    }
}
