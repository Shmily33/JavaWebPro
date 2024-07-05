package com.javaweb;

import com.example.EnableHeaderConfig;
import com.example.TokenParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@ComponentScan({"com.example","com.javaweb"})
//@Import({TokenParser.class})
@EnableHeaderConfig
@SpringBootApplication
public class Day08AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day08AopApplication.class, args);
	}

}
