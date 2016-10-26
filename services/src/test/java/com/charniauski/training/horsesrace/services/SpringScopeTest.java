package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.util.SqlUtil;
import com.charniauski.training.horsesrace.datamodel.Client;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SpringScopeTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");

        Client client = new Client();
        client.setId(null);
        client.setGender("M");
        client.setLastName("New");
        client.setFirstName("Tras");
        client.setDate(new Date());
        client.setAddress("Адрес");
//        System.out.println(client.getId());
//        String sqlInsertOrUpdateEntity = sqlInsertCreateBean.sqlInsertOrUpdateEntity(client);

//        System.out.println(sqlInsertOrUpdateEntity);
        ClientService clientServiceBean = springContext.getBean(ClientService.class);;
        List<Client> all = clientServiceBean.getAll();
        for (Client client1:all){
            System.out.println(client1);
        }
        System.out.println();
//        for (int i=0;i<10;i++) {
//            System.out.println("Попытка записать нового");
//        Long insert = clientServiceBean.insert(client);
//        }
//        Client client1 = clientServiceBean.get(19L);
//        System.out.println("Новый: id="+insert+"- "+client1);
//        System.out.println("Delete: "+clientServiceBean.delete(client1));
//        System.out.println("Попытка записать вытянутого");
//        client1.setId(null);
//        clientServiceBean.insert(client1);
//
//        System.out.println("Попытка записать нового");
//        clientServiceBean.insert(client);
//        System.out.println(clientServiceBean.get(20L));
//        boolean delete = clientServiceBean.delete(client);
//        System.out.println(delete);


//        AbstractModel client1 = clientServiceBean.get(2L);
//        System.out.println(client1);
    }
}
