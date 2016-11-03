package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.AccountDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class AccountServiceTest {

    @Inject
    private AccountService accountService;

    @Inject
    private AccountDao accountDao;

    private Account testAccount;

    private Long testAccountId;

    @BeforeClass
    public static void prepareTestData() {

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
        testAccount.setBalance(0.0);
        testAccount.setStatus(Status.CLIENT);
        testAccount.setEmail("test@test.ru");
        testAccountId = accountDao.insert(testAccount);
    }

    @After
    public void deleteMethodData() {
        accountDao.delete(testAccountId);
        testAccountId = null;
    }


    @Test
    public void getByIdTest() {
        testAccount.setId(testAccountId);
        Account account = accountDao.get(testAccount.getId());
        assertNotNull(account);
        assertEquals(testAccount.getId(), account.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = testAccount.getId();
        Account account1 = accountDao.get(id);
        assertNull(account1);
        if (testAccount.getId() == null) {
            testAccount.setLogin("TestLogin1");
            id = accountDao.insert(testAccount);
        } else {
            accountDao.update(testAccount);
        }
        Account account = accountDao.get(id);
        assertNotNull(account);
        testAccount.setId(id);
        assertEquals(testAccount, account);
        accountDao.delete(id);
    }

    @Test
    public void saveUpdateTest() {
        assertNotNull(testAccountId);
        testAccount.setId(testAccountId);
        if (testAccount.getId() == null) {
            testAccountId = accountDao.insert(testAccount);
        } else {
            accountDao.update(testAccount);
        }
        Account account = accountDao.get(testAccountId);
        assertEquals(testAccount, account);
    }

    @Test
    public void deleteTest() {
        testAccount.setLogin("Delete");
        Long id = accountDao.insert(testAccount);
        boolean delete = accountDao.delete(id);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() throws NoSuchEntityException {
        Account testAccount1 = new Account();
        testAccount1.setLogin("TestLoginNew1");
        testAccount1.setPassword("pass");
        testAccount1.setBalance(0.0);
        testAccount1.setStatus(Status.CLIENT);
        testAccount1.setEmail("test1@test.ru");
        List<Account> arrayList = new ArrayList<>();
        testAccount.setLogin("TestLoginNew2");
        arrayList.addAll(Arrays.asList(testAccount, testAccount1));
        accountService.saveAll(arrayList);
        Account account = accountDao.getByLogin("TestLoginNew2");
        Account account1 = accountDao.getByLogin("TestLoginNew1");
        testAccount.setId(account.getId());
        testAccount1.setId(account1.getId());
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
        Account testLoginNew = accountDao.getByLogin("TestLoginNew");
        testAccount.setId(testAccountId);
        assertEquals(testAccount,testLoginNew);
    }

    @Test
    public void getAccountStatusByLoginTest(){
        Status status = accountDao.getStatusByLogin("TestLoginNew");
        testAccount.setId(testAccountId);
        assertEquals(testAccount.getStatus(),status);
    }

    @Test
    public void getAllAccountsByStatusTest() throws NoSuchEntityException {
        accountDao.delete(testAccountId);
        Account testAccount1 = new Account();
        testAccount1.setLogin("TestLoginNew1");
        testAccount1.setPassword("pass");
        testAccount1.setBalance(0.0);
        testAccount1.setStatus(Status.CLIENT);
        testAccount1.setEmail("test1@test.ru");
        List<Account> arrayList = new ArrayList<>();
        testAccount.setLogin("TestLoginNew2");
        arrayList.addAll(Arrays.asList(testAccount, testAccount1));
        accountService.saveAll(arrayList);
        List<Account> allAccountsByStatus = accountDao.getAllAccountsByStatus(Status.CLIENT);
        assertEquals(2,allAccountsByStatus.size());
        assertEquals(testAccount1.getStatus(),allAccountsByStatus.get(0).getStatus());
        assertEquals(testAccount1.getStatus(),allAccountsByStatus.get(1).getStatus());
        Account account = accountDao.getByLogin("TestLoginNew2");
        Account account1 = accountDao.getByLogin("TestLoginNew1");
        testAccount.setId(account.getId());
        testAccount1.setId(account1.getId());
        accountDao.delete(account.getId());
        accountDao.delete(account1.getId());

    }

}
