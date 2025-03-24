package cn.demo_text3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("cn.demo_text3.mapper")
public class DemoText3Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoText3Application.class, args);
    }

}
