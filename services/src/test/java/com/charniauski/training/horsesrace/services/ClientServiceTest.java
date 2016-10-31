package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.ClientDao;
import com.charniauski.training.horsesrace.datamodel.Client;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ClientServiceTest {

    @Inject
    private ClientDao clientDao;

    private Client testClient;

    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

    @BeforeClass
    public static void prepareTestData() {

    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() {
        testClient = new Client();
        testClient.setId(2L);
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
    }


    @Test
    public void getByIdTest() {
        Client client = clientDao.get(testClient.getId());
        Assert.assertNotNull(client);
        Assert.assertEquals(testClient.getId(), client.getId());
    }

    @Test
    public void saveTest() {
        testClient.setId(100L);
        Long insert = clientDao.insert(testClient);
        Client client = clientDao.get(insert);
        Assert.assertEquals(testClient, client);
        clientDao.delete(client.getId());
    }
}
