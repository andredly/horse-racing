package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.cache.SimpleCache;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

//        RaceCard raceCards=raceCardServiceBean.get(1L);
//        raceCards.stream().forEach(raceCard -> System.out.println(raceCard));
//

//        RaceDetail raceDetail=raceDetailService.get(2L);
//        System.out.println(raceDetail);
//        RaceCard raceCard=raceCardServiceBean.get(1L);
//        System.out.println(raceCard);
//PropertyUtilsBean propertyUtilsBean=new PropertyUtilsBean();

//        RaceCard raceCard=new RaceCard();
//        raceCard.setDateStart(new Timestamp(new Date().getTime()));
//        raceCard.setRaceType("CardType");
//        raceCard.setRacecourseId(1L);
//
//
//        BeanInfo beanInfo = Introspector.getBeanInfo(raceCard.getClass());
//        System.out.println(beanInfo);
//        PropertyDescriptor[] pdList = beanInfo.getPropertyDescriptors();
//        System.out.println(Arrays.toString(pdList));
//        PropertyUtilsBean propertyUtilsBean=new PropertyUtilsBean();
//        Map<String, Object> describe = propertyUtilsBean.describe(raceCard);
//        System.out.println(describe);
//        BeanUtilsBean instance = BeanUtilsBean.getInstance();
//        BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
//        ConvertUtils.register(new DateConverter(null), Date.class);
//        RaceCard raceCard1=new RaceCard();
//        instance.populate(raceCard1,describe);
//        System.out.println(raceCard);
//        PropertyDescriptor[] propertyDescriptors = propertyUtilsBean.getPropertyDescriptors(raceCard);
//
//        PropertyDescriptor propertyDescriptor = propertyDescriptors[0];
//        System.out.println(propertyDescriptor.getClass());
//        propertyDescriptor.setPropertyEditorClass(raceCard.getClass());
//        System.out.println(propertyDescriptor.getPropertyEditorClass());
//        System.out.println(propertyDescriptor.getPropertyType());
//        System.out.println(propertyDescriptor.getWriteMethod());
//
//
//        System.out.println(Arrays.toString(propertyDescriptors));
//        BeanUtilsBean instance = BeanUtilsBean.getInstance();
//        Method writeMethod = propertyUtilsBean.getWriteMethod(RaceCard.class, propertyDescriptors[0]);
//        writeMethod.setAccessible(true);
//        String s=new String("");
//        Date invoke = (Date)writeMethod.invoke(s, null);
//        System.out.println(invoke);
//        System.out.println(writeMethod);
//        RaceCard raceCard1=RaceCard.class.newInstance();
//        instance.populate(raceCard1,describe);
//        System.out.println(raceCard1);
//        ReflectionUtil.getMapColumnAndArgEntity(raceCards.get(0));

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
//
//        Account testAccount;
//        testAccount = new Account();
//        testAccount.setLogin("TestLoginNew1");
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
//        Account testLoginNew = accountServiceBean.getByLogin("TestLoginNew");
//        System.out.println(testLoginNew);
//        testLoginNew.setLogin("sdf1");
//        testLoginNew.setId(null);
//        Long account1 = accountServiceBean.save(testLoginNew);
//        List<Account> all = accountServiceBean.getAll();
//        System.out.println(all);

//ScheduledExecutorService executor=Executors.newScheduledThreadPool(5);
ExecutorService executor=Executors.newCachedThreadPool();

//        Future<String> future = executor.submit(new Task());
        Collection<Callable<String>> tasks = new ArrayList<>();
        tasks.add(new Task());
        List<Future<String>> futures = executor.invokeAll(tasks, 4, TimeUnit.SECONDS);
//        ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(new Task1(), 5, 1, TimeUnit.SECONDS);
//        try {
            System.out.println("Started..");
//            System.out.println(scheduledFuture.get(10, TimeUnit.SECONDS));
//            System.out.println(futures.get(70, TimeUnit.SECONDS));
            System.out.println("Finished!");
//        } catch (TimeoutException e) {
////            scheduledFuture.cancel(true);
////            future.cancel(true);
//            System.out.println("Terminated!");
//        }
        executor.shutdownNow();

//        http://www.baeldung.com/java-executor-service-tutorial

    }
}

class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Delete!";
    }

}

class Task1 implements Runnable {


    @Override
    public void run() {
        System.out.println("Delete");
    }
}











