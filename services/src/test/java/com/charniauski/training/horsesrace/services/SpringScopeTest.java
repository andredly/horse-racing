package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringScopeTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");

        System.out.println(springContext.getBean(User.class).hashCode());
        System.out.println(springContext.getBean(User.class).hashCode());
    }
}
