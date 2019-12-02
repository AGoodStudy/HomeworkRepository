package cn.dsh.sessionandcookietime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "cn.dsh.sessionandcookietime.filter")
public class SessionandcookietimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionandcookietimeApplication.class, args);
    }

}
