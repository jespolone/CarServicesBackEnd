package com.jespApiTest.CarServices.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "email")
public class EmailConfiguration {

    private String to;
    private String subject;
    private String body;
    private String username;
    private String password;
}