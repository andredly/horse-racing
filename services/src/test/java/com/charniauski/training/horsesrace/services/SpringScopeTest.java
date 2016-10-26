package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.util.SqlUtil;
import com.charniauski.training.horsesrace.datamodel.*;
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
//        ClientService clientServiceBean = springContext.getBean(ClientService.class);;
//        List<Client> all = clientServiceBean.getAll();
//        for (Client client1:all){
//            System.out.println(client1);
//        }
//        System.out.println();

        SecurityLevelService clientServiceBean = springContext.getBean(SecurityLevelService.class);

        AccountService accountServiceBean = springContext.getBean(AccountService.class);
        BetService betServiceBean = springContext.getBean(BetService.class);
        CommandService commandServiceBean = springContext.getBean(CommandService.class);
        EventService eventServiceBean = springContext.getBean(EventService.class);
        HorseService horseServiceBean = springContext.getBean(HorseService.class);
        RaceCardService raceCardServiceBean = springContext.getBean(RaceCardService.class);
        RacecourseService racecourseServiceBean = springContext.getBean(RacecourseService.class);
        SecurityLevelService securityLevelServiceBean = springContext.getBean(SecurityLevelService.class);

        Account account = accountServiceBean.get(1L);
        System.out.println(account);
        account.setId(null);
        System.out.println(account);
//        Long save = accountServiceBean.save(account);
//        Long save1 = accountServiceBean.save(account);
//        System.out.println(save);
        account.setId(6L);
        account.setBalance(10000.0);
        System.out.println(account);
        Long save2 = accountServiceBean.save(account);
        System.out.println(save2);
//        boolean delete = accountServiceBean.delete(account);
//        System.out.println(delete);


//        List<SecurityLevel> all = clientServiceBean.getAll();
//        for (SecurityLevel client1 : all) {
//            System.out.println(client1);
//        }
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
