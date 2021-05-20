package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.infra.IEnterpriseServiceInfra;

@Configuration
public class AppConfig {

    @Autowired
    private ApplicationContext context;

    @Bean
    public IEnterpriseServiceInfra enterpriseServiceInfra(@Value("${enterprise.service.used}") String qualifier) {
        return (IEnterpriseServiceInfra) context.getBean(qualifier);
    }
}
