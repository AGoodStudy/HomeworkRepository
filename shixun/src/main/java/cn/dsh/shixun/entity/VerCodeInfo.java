package cn.dsh.shixun.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


/**
 * 封装验证码信息实体类
 *
 * @author dsh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerCodeInfo {

    /**
     * 验证码
     */
    private String verCode;

    /**
     * 失效时间
     */
    private long failureTime;

    /**
     * 用户邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", message = "邮箱格式错误")
    private String userEmail;
}