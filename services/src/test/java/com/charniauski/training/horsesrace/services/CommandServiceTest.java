package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.CommandDao;
import com.charniauski.training.horsesrace.datamodel.Command;
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
public class CommandServiceTest {

    @Inject
    private CommandService commandService;

    @Inject
    private CommandDao commandDao;

    private Command testCommand;

    private Long testCommandId;

    @BeforeClass
    public static void prepareTestData() {

    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() {
        testCommand = new Command();
        testCommand.setNameCommand("100");
        testCommand.setJockey("Joi");
        testCommand.setTrainer("Join");
        testCommand.setUrlImageColor("HTTP-");
        testCommandId = commandDao.insert(testCommand);
    }

    @After
    public void deleteMethodData() {
        commandDao.delete(testCommandId);
        testCommandId = null;
    }


    @Test
    public void getByIdTest() {
        Command command = commandDao.get(testCommandId);
        testCommand.setId(testCommandId);
        assertNotNull(command);
        assertEquals(testCommandId, command.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = testCommand.getId();
        Command command1 = commandDao.get(id);
        assertNull(command1);
        if (testCommand.getId() == null) {
            testCommand.setNameCommand("101");
            id = commandDao.insert(testCommand);
        } else {
            commandDao.update(testCommand);
        }
        Command command = commandDao.get(id);
        assertNotNull(command);
        testCommand.setId(id);
        assertEquals(testCommand, command);
        commandDao.delete(id);
    }

    @Test
    public void saveUpdateTest() {
        assertNotNull(testCommandId);
        testCommand.setId(testCommandId);
        if (testCommand.getId() == null) {
            testCommandId = commandDao.insert(testCommand);
        } else {
            commandDao.update(testCommand);
        }
        Command command = commandDao.get(testCommandId);
        assertEquals(testCommand, command);
    }

    @Test
    public void deleteTest() {
        testCommand.setNameCommand("101");
        Long id = commandDao.insert(testCommand);
        boolean delete = commandDao.delete(id);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() {
        Command testCommand1 = new Command();
        testCommand1.setNameCommand("101");
        testCommand1.setJockey("Joi");
        testCommand1.setTrainer("Join");
        testCommand1.setUrlImageColor("HTTP-");
        List<Command> arrayList = new ArrayList<>();
        testCommand.setNameCommand("102");
        arrayList.addAll(Arrays.asList(testCommand, testCommand1));
        commandService.saveAll(arrayList);
        Command command = commandDao.getCommandByNameCommand("102");
        Command command1 = commandDao.getCommandByNameCommand("101");
        testCommand.setId(command.getId());
        testCommand1.setId(command1.getId());
        assertEquals(testCommand, command);
        assertEquals(testCommand1, command1);
        commandDao.delete(command1.getId());
        commandDao.delete(command.getId());
    }

    @Test
    public void getAll() {
        List<Command> all = commandDao.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getCommandByLogin(){
        Command testLoginNew = commandDao.getCommandByNameCommand("100");
        testCommand.setId(testCommandId);
        assertEquals(testCommand,testLoginNew);
    }

}
