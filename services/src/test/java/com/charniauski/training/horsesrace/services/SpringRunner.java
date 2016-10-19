package com.charniauski.training.horsesrace.services;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");

        String[] beanDefinitionNames = springContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }

        UserService bookServiceBean = springContext.getBean(UserService.class);
        System.out.println("BookService exists:" + (bookServiceBean != null ? true : false));

        System.out.println("BookService.dao exists:" + (bookServiceBean.isDaoExist() ? true : false));
    }
}
