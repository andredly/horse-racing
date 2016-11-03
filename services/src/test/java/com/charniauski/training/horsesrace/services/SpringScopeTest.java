package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SpringScopeTest {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchEntityException {
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


        AccountService accountServiceBean = springContext.getBean(AccountService.class);
        BetService betServiceBean = springContext.getBean(BetService.class);
        CommandService commandServiceBean = springContext.getBean(CommandService.class);
        EventService eventServiceBean = springContext.getBean(EventService.class);
        HorseService horseServiceBean = springContext.getBean(HorseService.class);
        RaceCardService raceCardServiceBean = springContext.getBean(RaceCardService.class);
        RacecourseService racecourseServiceBean = springContext.getBean(RacecourseService.class);
        RaceDetailService raceDetailService = springContext.getBean(RaceDetailService.class);

//        Account account = accountServiceBean.get(1L);
//        System.out.println(account);
//        account.setEmail("ыва");
//        System.out.println(account);
//        accountServiceBean.update(account);
////        Long save1 = accountServiceBean.save(account);
////        System.out.println(save);
//        account.setLogin("яlklm;с");
//        account.setId(6L);
//        account.setBalance(10000.0);
//        System.out.println(account);
//        Long save2 = accountServiceBean.save(account);
//        System.out.println(save2);
//        System.out.println(accountServiceBean.delete(account));
//        List<Account> all = accountServiceBean.getAll();
//                for (Account client1 : all) {
//            System.out.println(client1);
//        }

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

//        Command bet = commandServiceBean.get(2L);
//        System.out.println(bet);
//        bet.setJockey("чвапрывпа");
//        Long save = commandServiceBean.save(bet);
//        System.out.println(save);
//        bet.setId(null);
//        bet.setTrainer("ыв");
//        bet.setJockey("131");
//        bet.setUrlImageColor("яачва");
//        System.out.println(bet);
//        Long save1 = commandServiceBean.save(bet);
//        System.out.println(save1);
//        bet.setId(6L);
//        System.out.println(commandServiceBean.delete(bet));
//        List<Command> all = commandServiceBean.getAll();
//        for (Command client1 : all) {
//            System.out.println(client1);
//        }
//        System.out.println();

//        Event bet = eventServiceBean.get(2L);
//        System.out.println(bet);
//        bet.setDateRegister(new Timestamp(new Date().getTime()));
//        Long save = eventServiceBean.save(bet);
//        System.out.println(save);
//        bet.setId(null);
//        bet.setRaceDetailId(4L);
//        System.out.println(bet);
//        Long save1 = eventServiceBean.save(bet);
//        System.out.println(save1);
//
//        bet.setId(19L);
//        System.out.println(eventServiceBean.delete(bet));
//        List<Event> all = eventServiceBean.getAll();
//        for (Event client1 : all) {
//            System.out.println(client1);
//        }
//        System.out.println();

//        Horse bet = horseServiceBean.get(2L);
//        System.out.println(bet);
//        bet.setAge(10);
//        Long save = horseServiceBean.save(bet);
//        System.out.println(save);
//        bet.setId(null);
//        bet.setNickName("япячпячиепыывап");
//        System.out.println(bet);
//        Long save1 = horseServiceBean.save(bet);
//        System.out.println(save1);
//        bet.setId(9L);
//        System.out.println(horseServiceBean.delete(bet));
//        List<Horse> all = horseServiceBean.getAll();
//        for (Horse client1 : all) {
//            System.out.println(client1);
//        }
//        System.out.println();

//        RaceCard bet = raceCardServiceBean.get(2L);
//        System.out.println(bet);
//        bet.setDateFinish(new Timestamp(new Date().getTime()));
//        Long save = raceCardServiceBean.save(bet);
//        System.out.println(save);
//        bet.setId(null);
//        bet.setRaceType("япячпячиепыывап");
//        System.out.println(bet);
//        Long save1 = raceCardServiceBean.save(bet);
//        System.out.println(save1);
//        bet.setId(10L);
////        System.out.println(raceCardServiceBean.delete(bet));
//        List<RaceCard> all = raceCardServiceBean.getAllAfterCurrentDate(2L);
//        for (RaceCard client1 : all) {
//            System.out.println(client1);
//        }
//        System.out.println();

//        RaceDetail bet = raceDetailService.get(2L);
//        System.out.println(bet);
//        bet.setHorseResult(1);
//        bet.setHorseId(9L);
//        Long save = raceDetailService.save(bet);
//        System.out.println(save);
//        bet.setId(null);
//        bet.setRaceCardId(3L);
//        bet.setHorseId(10L);
//        bet.setNumberStartBox(10);
//        System.out.println(bet);
//        Long save1 = raceDetailService.save(bet);
//        System.out.println(save1);
//        bet.setId(21L);
//        System.out.println(raceDetailService.delete(bet));
//        List<RaceDetail> all = raceDetailService.getAll();
//        for (RaceDetail client1 : all) {
//            System.out.println(client1);
//        }
//        System.out.println();

//        SecurityLevel bet = securityLevelService.get(2L);
//        System.out.println(bet);
//        bet.setStatus(AccountStatus.CLIENT.name());
//        Long save = securityLevelService.save(bet);
//        System.out.println(save);
//        bet.setId(null);
//        System.out.println(bet);
//        Long save1 = securityLevelService.save(bet);
//        System.out.println(save1);
//
//        bet.setId(3L);
//        System.out.println(securityLevelService.delete(bet));
//        List<SecurityLevel> all = securityLevelService.getAll();
//        for (SecurityLevel client1 : all) {
//            System.out.println(client1);
//        }
//        System.out.println();

//        Racecourse bet = racecourseServiceBean.get(2L);
//        System.out.println(bet);
//        bet.setCountry("фывафывафыва");
//        Long save = racecourseServiceBean.save(bet);
//        System.out.println(save);
//        bet.setId(null);
//        bet.setName("япяhjhhыывап");
//        System.out.println(bet);
//        Long save1 = racecourseServiceBean.save(bet);
//        System.out.println(save1);
//        bet.setName("япячпп");
//        bet.setId(3L);
//        System.out.println(racecourseServiceBean.delete(bet));
//        List<Racecourse> all = racecourseServiceBean.getAllAfterCurrentDate();
//        for (Racecourse client1 : all) {
//            System.out.println(client1);
//        }
//        System.out.println();
//        Racecourse racecourse = racecourseServiceBean.getByName("usa");
//        System.out.println(racecourse);
//        SecurityLevel securityLevel = securityLevelServiceBean.getSecurityLevel(AccountStatus.CLIENT);
//        System.out.println(securityLevel);
//        AccountWithClient accountWithClient = accountServiceBean.getAccountWithClient(3L);
//        Account account = accountWithClient.getAccount();
//        Client client1 = accountWithClient.getClient();
//        System.out.println(account);
//        System.out.println(client1);
//        account.setLogin("New8");
//        account.setId(null);
//        account.setBalance(null);
//        client1.setId(null);
//        client1.setLastName("Testing6");
//        Long save = accountServiceBean.save(accountWithClient);
//        System.out.println(save);
//        Account account1=accountServiceBean.getByLogin("Log5");
//        System.out.println(account1);
//        Logger logger= LoggerFactory.getLogger(SpringScopeTest.class);
//        logger.info("Привет");
//        logger.error(account.getEmail());
//
//        List<RaceCard> raceCards=raceCardServiceBean.getAllAfterCurrentDate(2L);
//        System.out.println(raceCards);

//        SecurityLevel1 securityLevel1 = new SecurityLevel1();
//        securityLevel1.setId(2L);
//        securityLevel1.setSecurityLevel(SecurityLevel1.AccountStatus1.BOOKMAKER);
//        BeanUtilsBean instance = BeanUtilsBean.getInstance();
//        PropertyUtilsBean propertyUtils = instance.getPropertyUtils();
//        Map<String, Object> describe = propertyUtils.describe(SecurityLevel1.class);
//        System.out.println(describe);
//        SecurityLevel1 securityLevel=SecurityLevel1.class.newInstance();
//
//      instance.populate(securityLevel,describe);
//        System.out.println(securityLevel1);

//        SecurityLevel1 securityLevel1 = new SecurityLevel1();
//        securityLevel1.setId(2L);
//        securityLevel1.setSecurityLevel(SecurityLevel1.AccountStatus1.BOOKMAKER);

//        SecurityLevel1 securityLevel11 = securityLevel1;

//        List<RaceCard> allAfterCurrentDate = raceCardServiceBean.getThreeNextAfterCurrentDate();
//        System.out.println(allAfterCurrentDate);

//        Long idByRacecourseAndHorse = raceDetailService.getIdByRaceCardAndHorse(1L, 2L);
//        System.out.println(idByRacecourseAndHorse);
//        RaceCard raceCard = raceCardServiceBean.get(idByRacecourseAndHorse);
//        System.out.println(raceCard);


//        RaceDetail idByRacecourseAndHorse = raceDetailService.getByRaceCardAndHorse(2L, 1L);
//        System.out.println(idByRacecourseAndHorse);
//        boolean b = raceDetailService.saveHorseResult(2L, 1L, 35);
//        RaceDetail raceDetail =raceDetailService.get(idByRacecourseAndHorse.getId());
//        System.out.println(b);
//        System.out.println(raceDetail);


//        DuplicateKeyException
        RaceDetail raceDetail=new RaceDetail();
        raceDetail.setId(26L);
        raceDetail.setNumberStartBox(1);
        raceDetail.setHorseResult(1);
        raceDetail.setHorseId(null);
        raceDetail.setRaceCardId(5L);
        raceDetail.setCommandId(2L);
        Long save = raceDetailService.save(raceDetail);
        System.out.println(save);


    }


}
