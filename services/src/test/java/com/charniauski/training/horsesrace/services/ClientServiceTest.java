package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.charniauski.training.horsesrace.datamodel.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ClientServiceTest {

    @Inject
    private ClientService clientService;

//    @Test
//    public void getByIdtest() {
//        AbstractModel client = clientService.get(1L);
//
//        Assert.assertNotNull("book for id=1 should not be null", client);
//        Assert.assertEquals(new Long(1), client.getId());
//    }

}
