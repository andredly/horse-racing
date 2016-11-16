package com.charniauski.training.horsesrace.services;


import com.charniauski.training.horsesrace.daoapi.CommandDao;
import com.charniauski.training.horsesrace.datamodel.Command;
import com.charniauski.training.horsesrace.services.exception.NoSuchEntityException;
import com.charniauski.training.horsesrace.services.testutil.BaseCreator;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
public class CommandServiceTest {

    @Inject
    private CommandService commandService;

    @Inject
    private BaseCreator baseCreator;

    private Command testCommand;

    private Long testCommandId;


    @Parameterized.Parameters
    public static void getBaseCreator(BaseCreator baseCreator){
        baseCreator.createRelationDB();
    }

    @BeforeClass
    public static void prepareTestData() {
    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() {
      baseCreator.createXMLDB();
        testCommand = new Command();
        testCommand.setJockey("Joi");
        testCommand.setTrainer("Join");
        testCommand.setUrlImageColor("HTTP-");
        testCommandId=3L;
    }

    @After
    public void deleteMethodData() {
        testCommand=null;
        testCommandId = null;
    }


    @Test
    public void getByIdTest() {
        Command command = commandService.get(1L);
        assertNotNull(command);
        assertEquals(new Long(1L), command.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = null;
            testCommand.setJockey("Joi1");
            testCommand.setTrainer("Join1");
            testCommand.setUrlImageColor("HTTP-1");
            id = commandService.save(testCommand);
        Command command = commandService.get(id);
        assertNotNull(command);
        testCommand.setId(id);
        assertEquals(testCommand, command);
        testCommand.setId(id);
        commandService.delete(testCommand);
    }

    @Test
    public void saveUpdateTest() {
        assertNotNull(testCommandId);
        testCommand.setId(testCommandId);
            commandService.save(testCommand);
        Command command = commandService.get(testCommandId);
        assertEquals(testCommand, command);
    }

    @Test
    public void deleteTest() {
        testCommand.setJockey("Joi1");
        testCommand.setTrainer("Join1");
        testCommand.setUrlImageColor("HTTP-1");
        Long id = commandService.save(testCommand);
        testCommand.setId(id);
        boolean delete = commandService.delete(testCommand);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() throws NoSuchEntityException {
        Command testCommand1 = new Command();
        testCommand1.setJockey("Joi1");
        testCommand1.setTrainer("Join1");
        testCommand1.setUrlImageColor("HTTP-1");
        List<Command> arrayList = new ArrayList<>();
        testCommand.setJockey("Joi2");
        testCommand.setTrainer("Join2");
        testCommand.setUrlImageColor("HTTP-2");
        arrayList.addAll(Arrays.asList(testCommand, testCommand1));
        List<Long> longs = commandService.saveAll(arrayList);
        Command command = commandService.get(longs.get(0));
        Command command1 = commandService.get(longs.get(1));
        testCommand.setId(command.getId());
        testCommand1.setId(command1.getId());
        assertEquals(testCommand, command);
        assertEquals(testCommand1, command1);
        commandService.delete(command1);
        commandService.delete(command);
    }

    @Test
    public void getAll() {
        List<Command> all = commandService.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getByTrainerAndJockeyAndUrlTest(){
        Command command = commandService.get(1L);
        Command command1 = commandService.getByTrainerAndJockeyAndUrl("jon", "uri", "http1");
        assertEquals(command,command1);
    }

}
