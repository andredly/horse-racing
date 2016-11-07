package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.ClientDao;
import com.charniauski.training.horsesrace.datamodel.Account;
import com.charniauski.training.horsesrace.datamodel.Client;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.testUtil.CreateBase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ClientServiceTest {

    @Inject
    private ClientDao clientDao;

    @Inject
    private ClientService clientService;

    @Inject
    private AccountService accountService;

    private Client testClient;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @BeforeClass
    public static void prepareTestData() {
        new CreateBase().init();
    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() throws NoSuchEntityException {
        testClient = new Client();
        testClient.setId(2L);
        testClient.setFirstName("TestFistName");
        testClient.setLastName("TestLastName");
        try {
            testClient.setDate(simpleDateFormat.parse("2016-10-12"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        testClient.setAddress("address");
    }

    @After
    public void deleteMethodData() {
        testClient = null;
    }


    @Test
    public void getByIdTest() {
        Client client = clientDao.get(1L);
        assertNotNull(client);
        assertEquals(new Long(1L), client.getId());
    }

    @Test
    public void saveTest() {
        Long insert = clientDao.insert(testClient);
        Client client = clientDao.get(insert);
        assertEquals(testClient, client);
        clientDao.delete(client.getId());
    }

    @Test
    public void updateTest() {
        testClient.setId(2L);
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
        testClient.setId(2L);
        Long insert = clientDao.insert(testClient);
        boolean delete = clientDao.delete(insert);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() throws NoSuchEntityException {
        testClient.setId(2L);
        Client testClient1 = new Client();
        testClient1.setId(3L);
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
        assertEquals(testClient, client);
        assertEquals(testClient1, client1);
        clientDao.delete(client1.getId());
        clientDao.delete(client.getId());
    }
    
    @Test
    public void getAll(){
        List<Client> all = clientDao.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getByLoginTest(){
        Account account = accountService.getByLogin("log");
        Client client=clientDao.get(account.getId());
        Account account1 = accountService.get(client.getId());
        assertEquals(account,account1);
    };

}
