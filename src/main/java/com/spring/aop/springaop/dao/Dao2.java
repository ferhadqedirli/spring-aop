package com.spring.aop.springaop.dao;

import com.spring.aop.springaop.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

    @TrackTime
    public String retrieveSomething() {
        return "Dao2";
    }
}
