package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.ClientDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
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
public class ClientServiceTest {

    @Inject
    private ClientDao clientDao;

    @Inject
    private AccountService accountService;

    @Inject
    ClientService clientService;

    private Client testClient;

    private Account testAccount;

    private Long testAccountId;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @BeforeClass
    public static void prepareTestData() {

    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() throws NoSuchEntityException {
        testAccount = new Account();
        testAccount.setLogin("TestLoginNew");
        testAccount.setPassword("pass");
        testAccount.setDateRegisterAccount(new Date());
        testAccount.setBalance(0.0);
        testAccount.setStatus(Status.BOOKMAKER);
        testAccount.setEmail("test@test.ru");
        testAccountId = accountService.save(testAccount);
        testClient = new Client();
        testClient.setFirstName("TestFistName");
        testClient.setLastName("TestLastName");
        try {
            testClient.setDate(simpleDateFormat.parse("2016-10-2016"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        testClient.setAddress("address");
    }

    @After
    public void deleteMethodData() {
        testClient = null;
        testAccount.setId(testAccountId);
        accountService.delete(testAccount);
        testAccountId = null;
    }


    @Test
    public void getByIdTest() {
        testClient.setId(testAccountId);
        Long id = clientDao.insert(testClient);
        Client client = clientDao.get(testClient.getId());
        assertNotNull(client);
        assertEquals(testClient.getId(), client.getId());
        clientDao.delete(id);
    }

    @Test
    public void saveTest() {
        testClient.setId(testAccountId);
        Long insert = clientDao.insert(testClient);
        Client client = clientDao.get(insert);
        assertEquals(testClient, client);
        clientDao.delete(client.getId());
    }

    @Test
    public void updateTest() {
        testClient.setId(testAccountId);
        Long insert = clientDao.insert(testClient);
        testClient.setId(insert);
        testClient.setFirstName("NewTestFirstName");
        Integer update = clientDao.update(testClient);
        Client client = clientDao.get(insert);
        assertEquals(testClient, client);
        clientDao.delete(client.getId());
    }

    @Test
    public void deleteTest() {
        testClient.setId(testAccountId);
        Long insert = clientDao.insert(testClient);
        boolean delete = clientDao.delete(insert);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() throws NoSuchEntityException {
        Account testAccount1 = new Account();
        testAccount1.setLogin("TestLoginNew1");
        testAccount1.setPassword("pass");
        testAccount1.setDateRegisterAccount(new Date());
        testAccount1.setBalance(0.0);
        testAccount1.setStatus(Status.CLIENT);
        testAccount1.setEmail("test1@test.ru");
        Long testAccountId1 = accountService.save(testAccount1);
        testClient.setId(testAccountId);
        Client testClient1 = new Client();
        testClient1.setId(testAccountId1);
        testClient1.setFirstName("TestFistName1");
        testClient1.setLastName("TestLastName1");
        try {
            testClient1.setDate(simpleDateFormat.parse("2016-10-2016"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        testClient1.setAddress("address1");

        List<Client> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(testClient, testClient1));
        clientService.saveAll(arrayList);
        Client client = clientDao.get(testClient.getId());
        Client client1 = clientDao.get(testClient1.getId());
//        testAccount.setId(client.getId());
//        testAccount1.setId(client1.getId());
        assertEquals(testClient, client);
        assertEquals(testClient1, client1);
        clientDao.delete(client1.getId());
        clientDao.delete(client.getId());
        testAccount1.setId(testAccountId1);
        accountService.delete(testAccount1);
    }
    
    @Test
    public void getAll(){
        testClient.setId(testAccountId);
        clientDao.insert(testClient);
        List<Client> all = clientDao.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
        clientDao.delete(testAccountId);
    }

}
