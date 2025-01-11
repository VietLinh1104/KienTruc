package com.example.KienTruc.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Cho phép tất cả các origin gửi yêu cầu đến API của bạn
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")  // Frontend ReactJS
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Các phương thức HTTP bạn muốn cho phép
                .allowedHeaders("*")  // Cho phép tất cả các header
                .allowCredentials(true);  // Nếu bạn cần hỗ trợ cookies hoặc thông tin xác thực
    }
}
