package com.example;

import org.springframework.stereotype.Component;

@EnableHeaderConfig
@Component
public class TokenParser {

    public void parse(){
        System.out.println("TokenParser ... parse ...");
    }

}
