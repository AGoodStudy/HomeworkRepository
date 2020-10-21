package cn.dsh.shixun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.dsh")
public class ShixunApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShixunApplication.class, args);
    }

}
