package com.example.springCar.thymeleaf;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThConfig {
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
