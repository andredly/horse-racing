package com.charniauski.training.horsesrace.services;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");

        String[] beanDefinitionNames = springContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }

//        ClientService clientServiceBean = springContext.getBean(ClientService.class);
//        Client client = clientServiceBean.get(2L);

    }
}
