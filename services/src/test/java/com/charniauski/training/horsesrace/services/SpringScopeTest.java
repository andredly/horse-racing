package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.cache.SimpleCache;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.apache.commons.io.FileUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.IntrospectionException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SpringScopeTest {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchEntityException, IntrospectionException, SQLException, ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        AccountService accountServiceBean = springContext.getBean(AccountService.class);
        BetService betServiceBean = springContext.getBean(BetService.class);
        CommandService commandServiceBean = springContext.getBean(CommandService.class);
        EventService eventServiceBean = springContext.getBean(EventService.class);
        HorseService horseServiceBean = springContext.getBean(HorseService.class);
        RaceCardService raceCardServiceBean = springContext.getBean(RaceCardService.class);
        RacecourseService racecourseServiceBean = springContext.getBean(RacecourseService.class);
        RaceDetailService raceDetailService = springContext.getBean(RaceDetailService.class);


//        Long testAccountId;
//        Account testAccount = new Account();
//        testAccount.setLogin("TestLoginNew");
//        testAccount.setPassword("pass");
//        Timestamp timestamp = new Timestamp(new Date().getTime());
//        testAccount.setDateRegisterAccount(timestamp);
//        testAccount.setBalance(0.0);
//        testAccount.setStatus(Status.CLIENT);
//        testAccount.setEmail("test@test.ru");
//        testAccount.setIsDelete(false);
//        testAccountId = accountServiceBean.save(testAccount);
//        testAccount.setId(testAccountId);
//        Account account = accountServiceBean.get(testAccountId);
//        System.out.println(account.getIsDelete());
////        account.setId(testAccountId);
//        System.out.println(account);
//        CacheAdapterEhcache bean = springContext.getBean(CacheAdapterEhcache.class);
//        List<Racecourse> allAfterCurrentDate = racecourseServiceBean.getAllAfterCurrentDate();
//        allAfterCurrentDate.forEach(System.out::println);
//        for (int i = 0; i < 10; i++) {
//            Account account = accountServiceBean.get(1L);
////            System.out.println(account);
//            Thread.sleep(500);
//            Account account1 = accountServiceBean.get(2L);
//            Account account2 = accountServiceBean.get(3L);
////            System.out.println(account2);
//        }
//        System.out.println("Stop");


//        Account testAccount;
//        testAccount = new Account();
//        testAccount.setLogin("TestLoginNew2");
//        testAccount.setPassword("pass");
//        testAccount.setIsDelete(false);
//        testAccount.setFirstName("Test");
//        testAccount.setLastName("Test");
//        try {
//            testAccount.setDateBirth(simpleDateFormat.parse("2016-10-12"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        testAccount.setAddress("address");
//        Timestamp timestamp = new Timestamp(new Date().getTime());
//        testAccount.setDateRegisterAccount(timestamp);
//        testAccount.setBalance(0.0);
//        testAccount.setStatus(Status.CLIENT);
//        testAccount.setEmail("test@test.ru");
//        Long save = accountServiceBean.save(testAccount);
//        Account account = accountServiceBean.get(save);
//        System.out.println(account);
//        Account testLoginNew = accountServiceBean.getByLogin("TestLoginNew1");
//        System.out.println(testLoginNew);
//        testLoginNew.setLogin("sdf2");
//        testLoginNew.setId(null);
//        Long account1 = accountServiceBean.save(testLoginNew);
//        List<Account> all = accountServiceBean.getAll();
//        System.out.println(all);
//        springContext.getBean("")

    }
}










