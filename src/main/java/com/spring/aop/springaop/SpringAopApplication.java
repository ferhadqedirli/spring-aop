package com.spring.aop.springaop;

import com.spring.aop.springaop.business.Business1;
import com.spring.aop.springaop.business.Business2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

    private final Business1 business1;
    private final Business2 business2;

    public SpringAopApplication(Business1 business1, Business2 business2) {
        this.business1 = business1;
        this.business2 = business2;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringAopApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info(business1.calculateSomething());
        LOGGER.info(business2.calculateSomething());
    }
}
