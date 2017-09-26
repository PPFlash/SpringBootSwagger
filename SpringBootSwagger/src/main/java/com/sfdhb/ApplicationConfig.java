package com.sfdhb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author pp
 * @date 2017年9月20日14:58:43
 * "String Boot" 启动类 
 *
 */
@EnableTransactionManagement //开启事务支持
@SpringBootApplication //@SpringBootApplication就是@Configuration+@EnableAutoConfiguration+@ComponentScan等组合在一下.
public class ApplicationConfig{

    public static void main(String[] args) throws Exception {
    	//启动String Boot
        SpringApplication.run(ApplicationConfig.class, args);
    }

}