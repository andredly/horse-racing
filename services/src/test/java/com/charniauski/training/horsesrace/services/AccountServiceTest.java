package com.charniauski.training.horsesrace.services;


import com.charniauski.training.horsesrace.daoapi.AccountDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.testutil.BaseCreator;
import com.charniauski.training.horsesrace.services.wrapper.AccountWrapper;
import org.h2.engine.Constants;
import org.h2.tools.RunScript;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
public class AccountServiceTest {

    @Inject
    private AccountService accountService;

    @Inject
    private AccountDao accountDao;

    @Inject
    private BaseCreator baseCreator;

    @Inject
    private BetService betService;

    private Account testAccount;

    private Long testAccountId;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Parameterized.Parameters
    public static void getBaseCreator(BaseCreator baseCreator){
    }


    @BeforeClass
    public static void prepareTestData() {
//        try {
//            RunScript.execute("jdbc:postgresql://localhost:5432/postgres",
//                    "postgres", "root", "src/test/resources/horses_race_postgres_create.sql", Constants.UTF8, true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        BaseCreator baseCreator1 = (BaseCreator) springContext.getBean("baseCreator");
        baseCreator1.createRelationDB();
    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() {
        baseCreator.createXMLDB();
        testAccount = new Account();
        testAccount.setLogin("TestLoginNew");
        testAccount.setPassword("pass");
        testAccount.setIsDelete(false);
        testAccount.setFirstName("Test");
        testAccount.setLastName("Test");
        try {
            testAccount.setDateBirth(simpleDateFormat.parse("2016-10-12"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        testAccount.setAddress("address");
        Timestamp timestamp = new Timestamp(new Date().getTime());
        testAccount.setDateRegisterAccount(timestamp);
        testAccount.setBalance(0.0);
        testAccount.setStatus(Status.CLIENT);
        testAccount.setEmail("test@test.ru");
        testAccountId = 3L;

    }

    @After
    public void deleteMethodData() {
        testAccount = null;
        testAccountId = null;
    }


    @Test
    public void getByIdTest() {
//        testAccount.setId(testAccountId);
        Account account = accountService.get(1L);
        assertNotNull(account);
        assertEquals(new Long(1L), account.getId());
    }

    @Test
    public void saveInsertTest() {
        testAccount.setLogin("TestLogin1");
        Long id = accountService.save(testAccount);
        Account account = accountService.get(id);
        assertNotNull(account);
        testAccount.setDateRegisterAccount(new Date(testAccount.getDateRegisterAccount().getTime()));
        testAccount.setId(id);
        assertEquals(testAccount, account);
        account.setId(id);
        accountService.delete(account);
    }

    @Test
    public void saveUpdateTest() {
        assertNotNull(testAccountId);
        testAccount.setId(testAccountId);
        accountService.save(testAccount);
        Account account = accountService.get(testAccountId);
        testAccount.setDateRegisterAccount(new Date(testAccount.getDateRegisterAccount().getTime()));
        assertEquals(testAccount, account);
        testAccount.setLogin("log2");
    }

    @Test
    public void deleteTest() {
        testAccount.setLogin("Delete");
        Long id = accountService.save(testAccount);
        testAccount.setId(id);
        boolean delete = accountService.delete(testAccount);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() {
        Account testAccount1 = new Account();
        testAccount1.setLogin("TestLoginNew1");
        testAccount1.setPassword("pass");
        testAccount1.setIsDelete(false);
        testAccount1.setDateRegisterAccount(new Date());
        testAccount1.setBalance(0.0);
        testAccount1.setStatus(Status.CLIENT);
        testAccount1.setEmail("test1@test.ru");
        testAccount1.setFirstName("Test");
        testAccount1.setLastName("Test");
        try {
            testAccount1.setDateBirth(simpleDateFormat.parse("2016-10-12"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        testAccount1.setAddress("address");
        List<Account> arrayList = new ArrayList<>();
        testAccount.setLogin("TestLoginNew2");
        testAccount.setIsDelete(false);
        arrayList.addAll(Arrays.asList(testAccount, testAccount1));
        accountService.saveAll(arrayList);
        Account account = accountDao.getByLogin("TestLoginNew2");
        Account account1 = accountDao.getByLogin("TestLoginNew1");
        testAccount.setId(account.getId());
        testAccount1.setId(account1.getId());
        testAccount.setDateRegisterAccount(new Date(testAccount.getDateRegisterAccount().getTime()));
        testAccount1.setDateRegisterAccount(new Date(testAccount1.getDateRegisterAccount().getTime()));
        assertEquals(testAccount, account);
        assertEquals(testAccount1, account1);
        //// TODO: 13.11.2016
        accountService.delete(account);
        accountService.delete(account1);
    }

    @Test
    public void getAllTest() {
        List<Account> all = accountService.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getAccountByLoginTest() {
        Account testLoginNew = accountService.getByLogin("log");
        assertEquals("log", testLoginNew.getLogin());
    }

    @Test
    public void getAccountStatusByLoginTest() {
        Status status = accountService.getStatusByLogin("log");
        assertEquals(Status.ADMIN, status);
    }

    @Test
    public void getAllAccountsByStatusTest() {
        List<Account> allAccountsByStatus = accountService.getAllByStatus(Status.CLIENT);
        assertEquals(2, allAccountsByStatus.size());
        allAccountsByStatus.forEach(account -> assertEquals(Status.CLIENT, account.getStatus()));
    }


    @Test
    public void getAccountWrapperTest() {
        AccountWrapper accountWrapper = new AccountWrapper();
        Account account1 = accountService.get(1L);
        accountWrapper.setAccount(account1);
        accountWrapper.setBets(betService.getAllByLogin(account1.getLogin()));
        AccountWrapper accountWrapper1 = accountService.getAccountWrapper("log");
        assertEquals(accountWrapper, accountWrapper1);
    }


    @Test
    public void fakeDelete() {
        Account account = accountDao.get(2L);
        account.setIsDelete(true);
        accountDao.update(account);
        Account account1 = accountDao.get(account.getId());
        assertNotNull(account1);
        assertEquals(account.getIsDelete(), account1.getIsDelete());
    }

}
