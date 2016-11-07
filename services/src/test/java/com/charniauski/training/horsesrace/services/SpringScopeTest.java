package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.List;

public class SpringScopeTest {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchEntityException, IntrospectionException {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");

        ClientService clientServiceBean = springContext.getBean(ClientService.class);
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

        RaceDetail raceDetail=raceDetailService.get(2L);
        System.out.println(raceDetail);
        RaceCard raceCard=raceCardServiceBean.get(1L);
        System.out.println(raceCard);
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
        List<RaceCard> allByRacecourseAfterCurrentDate = raceCardServiceBean.getAllByRacecourseAfterCurrentDate(1L);
        System.out.println(allByRacecourseAfterCurrentDate);

    }


}
