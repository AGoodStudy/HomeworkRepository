package cn.dsh.shixun.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 传输user数据实体类
 *
 * @author dsh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String token;

    private String nickname;

    private String email;

    private Integer age;

    private String gender;

    private String avatar;


}
