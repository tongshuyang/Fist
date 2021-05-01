package cn.litman.fist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.litman.fist.mapper")
public class FistApplication {

    public static void main(String[] args) {
        SpringApplication.run(FistApplication.class, args);
    }

}
