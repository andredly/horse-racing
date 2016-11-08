package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.AccountDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.testUtil.CreateBase;
import com.charniauski.training.horsesrace.services.wrapper.AccountWrapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class AccountServiceTest {

    @Inject
    private AccountService accountService;

    @Inject
    private AccountDao accountDao;

    @Inject
    private BetService betService;

    @Inject
    private ClientService clientService;

    private Account testAccount;

    private Long testAccountId;

    @BeforeClass
    public static void prepareTestData() {
        new CreateBase().init();
    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() {
        testAccount = new Account();
        testAccount.setLogin("TestLoginNew");
        testAccount.setPassword("pass");
        testAccount.setIsDelete(false);
        Timestamp timestamp = new Timestamp(new Date().getTime());
        testAccount.setDateRegisterAccount(timestamp);
        testAccount.setBalance(0.0);
        testAccount.setStatus(Status.CLIENT);
        testAccount.setEmail("test@test.ru");
        testAccountId=3L;
    }

    @After
    public void deleteMethodData() {
        testAccount=null;
        testAccountId = null;
    }


    @Test
    public void getByIdTest() {
//        testAccount.setId(testAccountId);
        Account account = accountDao.get(1L);
        assertNotNull(account);
        assertEquals(new Long(1L), account.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = null;
        if (testAccount.getId() == null) {
            testAccount.setLogin("TestLogin1");
            id = accountDao.insert(testAccount);
        } else {
        }
        Account account = accountDao.get(id);
        assertNotNull(account);
        testAccount.setDateRegisterAccount(new Date(testAccount.getDateRegisterAccount().getTime()));
        testAccount.setId(id);
        assertEquals(testAccount,account);
        accountDao.delete(id);
    }

    @Test
    public void saveUpdateTest() {
        assertNotNull(testAccountId);
        testAccount.setId(testAccountId);
        if (testAccount.getId() == null) {
        } else {
            accountDao.update(testAccount);
        }
        Account account = accountDao.get(testAccountId);
        testAccount.setDateRegisterAccount(new Date(testAccount.getDateRegisterAccount().getTime()));
        assertEquals(testAccount, account);
        testAccount.setLogin("log2");
    }

    @Test
    public void deleteTest() {
        testAccount.setLogin("Delete");
        Long id = accountDao.insert(testAccount);
        boolean delete = accountDao.delete(id);
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
        accountDao.delete(account.getId());
        accountDao.delete(account1.getId());
    }

    @Test
    public void getAllTest() {
        List<Account> all = accountDao.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getAccountByLoginTest(){
        Account testLoginNew = accountDao.getByLogin("log");
        assertEquals("log",testLoginNew.getLogin());
    }

    @Test
    public void getAccountStatusByLoginTest(){
        Status status = accountDao.getStatusByLogin("log");
        assertEquals(Status.ADMIN,status);
    }

    @Test
    public void getAllAccountsByStatusTest(){
        List<Account> allAccountsByStatus = accountDao.getAllAccountsByStatus(Status.CLIENT);
        assertEquals(2,allAccountsByStatus.size());
        allAccountsByStatus.forEach(account -> assertEquals(Status.CLIENT, account.getStatus()));
    }

    @Test
    public void saveByAccountAndClientTest(){
        Account account=accountService.get(1L);
        Client client=clientService.get(1L);
        Long id = accountService.save(account, client);
        Account account1 = accountService.get(id);
        Client client1=clientService.get(id);
        assertEquals(account,account1);
        assertEquals(client,client1);
    }

    @Test
    public void getAccountWrapperTest(){
        AccountWrapper accountWrapper=new AccountWrapper();
        Account account1 = accountDao.get(1L);
        accountWrapper.setAccount(account1);
        accountWrapper.setClient(clientService.get(1L));
        accountWrapper.setBets(betService.getAllByLogin(account1.getLogin()));
        AccountWrapper accountWrapper1=accountService.getAccountWrapper("log");
        assertEquals(accountWrapper,accountWrapper1);
    }


    @Test
    public void fakeDelete(){
        Account account = accountDao.get(1L);
        account.setIsDelete(true);
        accountDao.update(account);
        Account account1 = accountDao.get(account.getId());
        assertNotNull(account1);
        assertEquals(account.getIsDelete(),account1.getIsDelete());
    }

}
