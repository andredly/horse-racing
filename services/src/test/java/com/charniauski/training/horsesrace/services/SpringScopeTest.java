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
        client.setLastName("New");
        client.setFirstName("Tras");
        client.setDate(new Date());
        client.setAddress("Адрес");
//        System.out.println(client.getId());
//        String sqlInsertOrUpdateEntity = sqlInsertCreateBean.sqlInsertOrUpdateEntity(client);

//        System.out.println(sqlInsertOrUpdateEntity);
        ClientService clientServiceBean = springContext.getBean(ClientService.class);
        ;
//        List<Client> all = clientServiceBean.getAll();
//        for (Client client1:all){
//            System.out.println(client1);
//        }
//        System.out.println();

        SecurityLevelService securityLevelService = springContext.getBean(SecurityLevelService.class);

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
        account.setLogin("яlklm;с");
        account.setId(5L);
        account.setBalance(10000.0);
        System.out.println(account);
        Long save2 = accountServiceBean.save(account);
        System.out.println(save2);

//        Bet bet=betServiceBean.get(2L);
//        System.out.println(bet);
//        bet.setBetType("чвапрывпа");
//        Long save = betServiceBean.save(bet);
//        System.out.println(save);
//        bet.setId(null);
//        bet.setEventId(8L);
//        bet.setAccountId(3L);
//        Long save1 = betServiceBean.save(bet);
//        System.out.println(save1);
//        bet.setId(17L);
//        System.out.println(betServiceBean.delete(bet));
//        List<Bet> all = betServiceBean.getAll();
//        for (Bet client1 : all) {
//            System.out.println(client1);
//        }
//        System.out.println();

//        Client bet = clientServiceBean.get(2L);
//        System.out.println(bet);
//        bet.setLastName("чвапрывпа");
//        Long save = clientServiceBean.save(bet);
//        System.out.println(save);
//        bet.setId(null);
//        bet.setAddress("ыв");
//        Long save1 = clientServiceBean.save(bet);
//        System.out.println(save1);
//        bet.setId(6L);
//        System.out.println(clientServiceBean.delete(bet));
//        List<Client> all = clientServiceBean.getAll();
//        for (Client client1 : all) {
//            System.out.println(client1);
//        }
//        System.out.println();

        Command bet = commandServiceBean.get(2L);
        System.out.println(bet);
        bet.setJockey("чвапрывпа");
        Long save = commandServiceBean.save(bet);
        System.out.println(save);
        bet.setId(null);
        bet.setTrainer("ыв");
        bet.setJockey("131");
        bet.setUrlImageColor("яачва");
        System.out.println(bet);
        Long save1 = commandServiceBean.save(bet);
        System.out.println(save1);
        bet.setId(6L);
        System.out.println(commandServiceBean.delete(bet));
        List<Command> all = commandServiceBean.getAll();
        for (Command client1 : all) {
            System.out.println(client1);
        }
        System.out.println();
    }
}
