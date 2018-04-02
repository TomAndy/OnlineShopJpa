package com.mp.onlinestore.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:ResponseMessages.properties")
public class ResponseMessages {

    @Autowired
    private Environment env;

    public String getMessage(String code) {
        return env.getProperty(code);
    }

}
