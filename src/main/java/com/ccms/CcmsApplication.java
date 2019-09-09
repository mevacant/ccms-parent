package com.ccms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages="com.ccms.mapper")
public class CcmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcmsApplication.class, args);
	}

}
