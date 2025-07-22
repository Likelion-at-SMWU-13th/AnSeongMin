package com.likelion.config;
import com.likelion.bean.Lion;
import com.likelion.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.likelion.proxy", "com.likelion.service", "com.likelion.repository"})
public class ProjectConfig {


}
