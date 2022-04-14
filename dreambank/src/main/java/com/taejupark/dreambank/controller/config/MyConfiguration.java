package com.taejupark.dreambank.controller.config;

import com.taejupark.dreambank.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public Customer customer() {
        return new Customer();
    }
}
