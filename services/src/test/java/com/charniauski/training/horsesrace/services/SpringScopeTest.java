package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.util.NullAwareBeanUtilsBean;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

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
//        Racecourse racecourse=racecourseServiceBean.get(1L);
        RaceCard racecourse=raceCardServiceBean.get(1L);
        Validator validator=Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<RaceCard>> validate = validator.validate(racecourse);
        System.out.println(validate);
        Map<String, Object> describe = PropertyUtils.describe(racecourse);
        BeanUtilsBean instance = NullAwareBeanUtilsBean.getInstance();
        RaceCard racecourse1 = RaceCard.class.newInstance();
        instance.populate(racecourse1,describe);
        System.out.println(racecourse1);


    }
}










