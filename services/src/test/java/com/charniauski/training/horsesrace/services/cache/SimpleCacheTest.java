package com.charniauski.training.horsesrace.services.cache;

import com.charniauski.training.horsesrace.services.cacherequest.Cacheable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Created by ivc4 on 22.11.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
public class SimpleCacheTest {

    @Inject
    private Cacheable cacheable;

    @Test
    public void putKeyAndValueTest() {
        cacheable.put("1", 100);
        Object o = cacheable.get("1");
        assertNotNull(o);
        assertEquals(100, o);
    }

    @Test
    public void putKeyAndValueAndTimeToLiveSecondsTest() {
        cacheable.put("1", 100L, 10);
        Object o = cacheable.get("1");
        assertNotNull(o);
        assertEquals(100L, o);
    }

    @Test
    public void isKeyInCacheTest() {
        cacheable.put("1", new Object[]{100, 10});
        boolean keyInCache = cacheable.isKeyInCache("1");
        assertTrue(keyInCache);
    }

    @Test
    public void getTest() {
        Long value = 100L;
        Integer timeToLiveSeconds = 10;
        cacheable.put("1", value, timeToLiveSeconds);
        Object o = cacheable.get("1");
        assertNotNull(o);
        assertEquals(value, o);
    }

    @Test
    public void getTimeIsOutTest() throws InterruptedException {
        Long value = 100L;
        Integer timeToLiveSeconds = 1;
        cacheable.put("1", value, timeToLiveSeconds);
        Thread.sleep(2000);
        boolean keyInCache = cacheable.isKeyInCache("1");
        assertFalse(keyInCache);
    }

}
