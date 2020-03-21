package fun.imcoder.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan({"fun.imcoder.cloud.mapper"})
@ServletComponentScan
public class ImcoderBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImcoderBlogApplication.class, args);
    }

}
