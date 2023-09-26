package com.springboot.config;

import com.springboot.appinfo.ApplicationInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Configuration
public class JsonPlaceHolderConfiguration {

    @Value("${info.company.name}")
    private String companyName;

    @Autowired
    private Environment environment;

    @Bean
    public CommandLineRunner jsonPlaceholder(ApplicationInformation applicationInformation) {
        return args -> {
            System.out.println("Command Line runner hurray");
            System.out.println(companyName);
            System.out.println(environment.getProperty("info.app.version"));
            System.out.println(applicationInformation);
            System.out.println(Arrays.toString(environment.getActiveProfiles()));
        };
    }
}
