package com.charniauski.training.horsesrace.services;

import com.charniauski.training.horsesrace.daodb.SecurityLevelDao;
import com.charniauski.training.horsesrace.datamodel.SecurityLevel;
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
public class SecurityLevelServiceTest {

    @Inject
    private SecurityLevelService securityLevelService;

    @Inject
    private SecurityLevelDao securityLevelDao;

    private SecurityLevel testSecurityLevel;

    private Long testSecurityLevelId;

    @BeforeClass
    public static void prepareTestData() {

    }

    @AfterClass
    public static void deleteTestData() {
//        System.out.println("deleteTestData");
    }

    @Before
    public void prepareMethodData() {
        testSecurityLevel = new SecurityLevel();
        testSecurityLevel.setClientStatus("ANONYMOUS");
        testSecurityLevelId = securityLevelDao.insert(testSecurityLevel);
    }

    @After
    public void deleteMethodData() {
        securityLevelDao.delete(testSecurityLevelId);
        testSecurityLevelId = null;
    }


    @Test
    public void getByIdTest() {
        SecurityLevel securityLevel = securityLevelDao.get(testSecurityLevelId);
        testSecurityLevel.setId(testSecurityLevelId);
        assertNotNull(securityLevel);
        assertEquals(testSecurityLevelId, securityLevel.getId());
    }

    @Test
    public void saveInsertTest() {
        Long id = testSecurityLevel.getId();
        SecurityLevel securityLevel1 = securityLevelDao.get(id);
        assertNull(securityLevel1);
        if (testSecurityLevel.getId() == null) {
            testSecurityLevel.setClientStatus("ANONYMOUS1");
            id = securityLevelDao.insert(testSecurityLevel);
        } else {
            securityLevelDao.update(testSecurityLevel);
        }
        SecurityLevel securityLevel = securityLevelDao.get(id);
        assertNotNull(securityLevel);
        testSecurityLevel.setId(id);
        assertEquals(testSecurityLevel, securityLevel);
        securityLevelDao.delete(id);
    }

    @Test
    public void saveUpdateTest() {
        assertNotNull(testSecurityLevelId);
        testSecurityLevel.setId(testSecurityLevelId);
        if (testSecurityLevel.getId() == null) {
            testSecurityLevelId = securityLevelDao.insert(testSecurityLevel);
        } else {
            securityLevelDao.update(testSecurityLevel);
        }
        SecurityLevel securityLevel = securityLevelDao.get(testSecurityLevelId);
        assertEquals(testSecurityLevel, securityLevel);
    }

    @Test
    public void deleteTest() {
        testSecurityLevel.setClientStatus("ANONYMOUS1");
        Long id = securityLevelDao.insert(testSecurityLevel);
        boolean delete = securityLevelDao.delete(id);
        assertTrue(delete);
    }

    @Test
    public void saveAllTest() {
        SecurityLevel testSecurityLevel1 = new SecurityLevel();
        testSecurityLevel1.setClientStatus("ANONYMOUS1");
        List<SecurityLevel> arrayList = new ArrayList<>();
        testSecurityLevel.setClientStatus("ANONYMOUS2");
        arrayList.addAll(Arrays.asList(testSecurityLevel, testSecurityLevel1));
        System.out.println(arrayList);
        securityLevelService.saveAll(arrayList);
//        SecurityLevel securityLevel = securityLevelDao.getSecurityLevel();
//        SecurityLevel securityLevel1 = securityLevelDao.getSecurityLevelByName("TEST1");
//        testSecurityLevel.setId(securityLevel.getId());
//        testSecurityLevel1.setId(securityLevel1.getId());
//        assertEquals(testSecurityLevel, securityLevel);
//        assertEquals(testSecurityLevel1, securityLevel1);
//        securityLevelDao.delete(securityLevel1.getId());
//        securityLevelDao.delete(securityLevel.getId());
    }

    @Test
    public void getAll() {
        List<SecurityLevel> all = securityLevelDao.getAll();
        assertNotNull(all);
        assertNotNull(all.get(0).getId());
    }

    @Test
    public void getSecurityLevelByLogin(){
//        SecurityLevel testLoginNew = securityLevelDao.getSecurityLevelByName("TEST");
        testSecurityLevel.setId(testSecurityLevelId);
//        assertEquals(testSecurityLevel,testLoginNew);
    }

}
