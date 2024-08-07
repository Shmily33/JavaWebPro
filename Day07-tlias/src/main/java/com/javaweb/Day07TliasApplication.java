package com.javaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Day07TliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day07TliasApplication.class, args);
    }

}
