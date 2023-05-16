package org.example.web.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public CompoentB componentBWithKeyA(){
        var c = new CompoentB();
        c.setKey("a");
        return c;
    }

    @Bean
    public CompoentB componentBWithKeyB(){
        var c = new CompoentB();
        c.setKey("b");
        return c;
    }
}
