package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.GenericDao;
import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.datamodel.Client;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ClientServiceTest {

    @Inject
    private ClientService clientService;

    @Mock
    private GenericDao genericDao;

    private Client client;

    @BeforeClass
    public static void prepareTestData() {
//        System.out.println("prepareTestData");
    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() {
        client=new Client();
        client.setId(1L);
        client.setFirstName("TestFist");
        client.setLastName("TestLast");
        client.setGender("mail");
        client.setDate(new Date());
        client.setAddress("address");
    }

    @After
    public void deleteMethodData() {
        client=null;
    }


    @Test
    public void getByIdTest() {
        Client client = clientService.get(1L);
        Assert.assertNotNull(client);
        Assert.assertEquals(new Long(1), client.getId());
    }
}
