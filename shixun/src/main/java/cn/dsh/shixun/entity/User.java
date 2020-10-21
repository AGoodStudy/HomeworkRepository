package cn.dsh.shixun.entity;

import javax.persistence.*;

import lombok.*;

@Data
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String email;

    private String password;

    private String nickname;

    private Integer age;

    private String gender;

    private String avatar;
}