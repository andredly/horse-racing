package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.util.SqlCreate;
import com.charniauski.training.horsesrace.datamodel.Client;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SpringScopeTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");

        Client client = new Client();
        client.setId(null);
        client.setGender("M");
        client.setLastName("New");
        client.setFirstName("Tras");
        client.setDate(new Timestamp(new Date().getTime()));
        client.setAddress("Адрес");
//        System.out.println(client.getId());
        SqlCreate sqlCreateBean = springContext.getBean(SqlCreate.class);
        System.out.println(sqlCreateBean);
//        String sqlInsertEntity = sqlInsertCreateBean.sqlInsertEntity(client);

//        System.out.println(sqlInsertEntity);
        ClientService clientServiceBean = springContext.getBean(ClientService.class);;
        Client client1 = clientServiceBean.get(18L);
        System.out.println("Новый: "+client1);
        System.out.println("Delete: "+clientServiceBean.delete(client1));
        System.out.println("Попытка записать вытянутого");
//        clientServiceBean.save(client1);

        System.out.println("Попытка записать нового");
        clientServiceBean.save(client);
        System.out.println(clientServiceBean.get(client.getId()));
//        boolean delete = clientServiceBean.delete(client);
//        System.out.println(delete);


//        AbstractModel client1 = clientServiceBean.get(2L);
//        System.out.println(client1);
    }
}
