package com.spring.aop.springaop;

import org.springframework.stereotype.Service;

@Service
public class Business2 {
    private final Dao2 dao2;

    public Business2(Dao2 dao2) {
        this.dao2 = dao2;
    }

    public String calculateSomething() {
        //business logic
        return dao2.retrieveSomething();
    }
}
