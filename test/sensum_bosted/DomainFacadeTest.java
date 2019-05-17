/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jakob
 */
public class DomainFacadeTest {
    
    static DomainFacade instance;
    
    public DomainFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = DomainFacade.getInstance();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class DomainFacade.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DomainFacade expResult = null;
        DomainFacade result = DomainFacade.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DomainFacade.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DomainFacade.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class DomainFacade.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        DomainFacade instance = DomainFacadeTest.instance;
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatientsMap method, of class DomainFacade.
     */
    @Test
    public void testGetPatientsMap() {
        System.out.println("getPatientsMap");
        DomainFacade instance = DomainFacadeTest.instance;
        Map<UUID, String> expResult = null;
        //Map<UUID, String> result = instance.getPatientsMap();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializePatient method, of class DomainFacade.
     */
    @Test
    public void testInitializePatient() {
        System.out.println("initializePatient");
        UUID patientId = null;
        DomainFacade instance = DomainFacadeTest.instance;
        instance.initializePatient(patientId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatientName method, of class DomainFacade.
     */
    @Test
    public void testGetPatientName() {
        System.out.println("getPatientName");
        DomainFacade instance = DomainFacadeTest.instance;
        String expResult = "";
        String result = instance.getPatientName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatientCPR method, of class DomainFacade.
     */
    @Test
    public void testGetPatientCPR() {
        System.out.println("getPatientCPR");
        DomainFacade instance = DomainFacadeTest.instance;
        String expResult = "";
        String result = instance.getPatientCPR();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatientImage method, of class DomainFacade.
     */
    @Test
    public void testGetPatientImage() {
        System.out.println("getPatientImage");
        DomainFacade instance = DomainFacadeTest.instance;
        String expResult = "";
        String result = instance.getPatientImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatientInfo method, of class DomainFacade.
     */
    @Test
    public void testGetPatientInfo() {
        System.out.println("getPatientInfo");
        DomainFacade instance = DomainFacadeTest.instance;
        String expResult = "";
        String result = instance.getPatientInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPatient method, of class DomainFacade.
     */
    @Test
    public void testCreatePatient() {
        System.out.println("createPatient");
        String name = "";
        String cpr = "";
        String info = "";
        DomainFacade instance = DomainFacadeTest.instance;
        boolean expResult = false;
        boolean result = instance.createPatient(name, cpr, info);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotationsMap method, of class DomainFacade.
     */
    @Test
    public void testGetNotationsMap() {
        System.out.println("getNotationsMap");
        DomainFacade instance = DomainFacadeTest.instance;
        Map<Date, UUID> expResult = null;
        Map<Date, UUID> result = instance.getNotationsMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeDiary method, of class DomainFacade.
     */
    @Test
    public void testInitializeDiary() {
        System.out.println("initializeDiary");
        DomainFacade instance = DomainFacadeTest.instance;
        instance.initializeDiary();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeNotation method, of class DomainFacade.
     */
    @Test
    public void testInitializeNotation() {
        System.out.println("initializeNotation");
        UUID notationId = null;
        DomainFacade instance = DomainFacadeTest.instance;
        instance.initializeNotation(notationId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotation method, of class DomainFacade.
     */
    @Test
    public void testGetNotation() {
        System.out.println("getNotation");
        DomainFacade instance = DomainFacadeTest.instance;
        String expResult = "";
        String result = instance.getNotation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNotation method, of class DomainFacade.
     */
    @Test
    public void testSaveNotation() {
        System.out.println("saveNotation");
        String content = "";
        DomainFacade instance = DomainFacadeTest.instance;
        boolean expResult = false;
        boolean result = instance.saveNotation(content);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNotation method, of class DomainFacade.
     */
    @Test
    public void testCreateNotation() {
        System.out.println("createNotation");
        DomainFacade instance = DomainFacadeTest.instance;
        UUID expResult = null;
        UUID result = instance.createNotation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotationDate method, of class DomainFacade.
     */
    @Test
    public void testGetNotationDate() {
        System.out.println("getNotationDate");
        DomainFacade instance = DomainFacadeTest.instance;
        Date expResult = null;
        Date result = instance.getNotationDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class DomainFacade.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String userName = "erso";
        String password = "zzz";
        DomainFacade instance = DomainFacadeTest.instance;
        boolean expResult = false;
        boolean result = instance.login(userName, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class DomainFacade.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        DomainFacade instance = DomainFacadeTest.instance;
        boolean expResult = false;
        boolean result = instance.logout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
