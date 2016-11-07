package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.EventDao;
import com.charniauski.training.horsesrace.datamodel.Event;
import com.charniauski.training.horsesrace.datamodel.enums.EventType;
import com.charniauski.training.horsesrace.datamodel.enums.ResultEvent;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.testUtil.CreateBase;
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
public class EventServiceTest {

    @Inject
    private EventService eventService;

    @Inject
    private EventDao eventDao;

    private Event testEvent;
    private Long testEventId;


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
        testEvent = new Event();
        testEvent.setDateRegister(new Timestamp(new Date().getTime()));
        testEvent.setBookmaker("dred");
        testEvent.setCoefficientEvent(2.6);
        testEvent.setEventType(EventType.WIN);
        testEvent.setResultEvent(ResultEvent.UNKNOWN);
        testEvent.setRaceDetailId(1L);
        testEventId = 1L;
    }

    @After
    public void deleteMethodData() {
        testEvent = null;
        testEventId = null;
    }


    @Test
    public void getByIdTest() {
        testEvent.setId(testEventId);
        Event event = eventDao.get(testEvent.getId());
        assertNotNull(event);
        assertEquals(testEvent.getId(), event.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = null;
        if (testEvent.getId() == null) {
            testEvent.setEventType(EventType.PLACE3);
            testEvent.setResultEvent(ResultEvent.UNKNOWN);
            testEvent.setRaceDetailId(1L);
            id = eventDao.insert(testEvent);
        } else {
        }
        Event event = eventDao.get(id);
        assertNotNull(event);
        testEvent.setDateRegister(new Date(testEvent.getDateRegister().getTime()));
        testEvent.setId(id);
        assertEquals(testEvent, event);
        eventDao.delete(id);
    }

    @Test
    public void saveUpdateTest() {
        assertNotNull(testEventId);
        testEvent.setId(testEventId);
        if (testEvent.getId() == null) {
        } else {
            eventDao.update(testEvent);
        }
        Event event = eventDao.get(testEventId);
        testEvent.setDateRegister(new Date(testEvent.getDateRegister().getTime()));
        assertEquals(testEvent, event);
    }

    @Test
    public void deleteTest() {
        testEvent.setEventType(EventType.PLACE3);
        testEvent.setResultEvent(ResultEvent.UNKNOWN);
        testEvent.setRaceDetailId(1L);
        Long id = eventDao.insert(testEvent);
        boolean delete = eventDao.delete(id);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() throws NoSuchEntityException {
        Event testEvent2 = new Event();
        testEvent2.setEventType(EventType.PLACE3);
        testEvent2.setResultEvent(ResultEvent.UNKNOWN);
        testEvent2.setRaceDetailId(1L);
        testEvent2.setCoefficientEvent(2.6);
        testEvent2.setBookmaker("ывап");
        List<Event> arrayList = new ArrayList<>();
        testEvent.setEventType(EventType.PLACE3);
        testEvent.setResultEvent(ResultEvent.UNKNOWN);
        testEvent.setRaceDetailId(2L);
        arrayList.addAll(Arrays.asList(testEvent, testEvent2));
        eventService.saveAll(arrayList);
        Event event = eventService.get(6L);
        Event event2 = eventService.get(7L);
        testEvent.setId(event.getId());
        testEvent2.setId(event2.getId());
        testEvent.setDateRegister(new Date(testEvent.getDateRegister().getTime()));
        testEvent2.setDateRegister(new Date(testEvent2.getDateRegister().getTime()));
        assertEquals(testEvent, event);
        assertEquals(testEvent2, event2);
        eventDao.delete(event.getId());
        eventDao.delete(event2.getId());
    }

    @Test
    public void getAllTest() {
        List<Event> all = eventDao.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getAllByRaceDetailTest() {
        List<Event> events = eventService.getAllByRaceDetail(1L);
        events.forEach(event -> assertEquals(new Long(1L), event.getRaceDetailId()));
        List<Event> all = eventService.getAll();
        assertFalse(events.size() > all.size());
    }

    @Test
    public void getAllByResultEventTest() {
        List<Event> events = eventService.getAllByResultEvent(ResultEvent.FALSE);
        events.forEach(event -> assertEquals(ResultEvent.FALSE, event.getResultEvent()));
        List<Event> all = eventService.getAll();
        assertFalse(events.size() > all.size());
    }

    @Test
public void getAllByResultEventAndRaceDetailTest(){
        List<Event> events = eventService.getAllByResultEventAndRaceDetail(ResultEvent.UNKNOWN,2L);
        events.forEach(event -> {
            assertEquals(ResultEvent.UNKNOWN, event.getResultEvent());
            assertEquals(new Long(2L), event.getRaceDetailId());
        });
        List<Event> all = eventService.getAll();
        assertFalse(events.size() > all.size());
    }

    @Test
    public void updateResultEventTest(){
        Event event = eventDao.get(4L);
        event.setResultEvent(ResultEvent.CANCELED);
        eventService.updateResultEvent(4L,ResultEvent.CANCELED);
        Event event1 = eventDao.get(4L);
        assertEquals(event, event1);
    }

}
