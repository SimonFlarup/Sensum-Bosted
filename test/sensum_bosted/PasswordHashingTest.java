/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jakob
 */
public class PasswordHashingTest {
    
    public PasswordHashingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of hash method, of class PasswordHashing.
     */
    @Test
    public void testHash() {
        System.out.println("hash");
        String password = "";
        PasswordHashing instance = new PasswordHashing();
        String expResult = "";
        String result = instance.hash(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compare method, of class PasswordHashing.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        String password = "";
        String hash = "";
        PasswordHashing instance = new PasswordHashing();
        boolean expResult = false;
        boolean result = instance.compare(password, hash);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of extractSalt method, of class PasswordHashing.
     */
    @Test
    public void testExtractSalt() {
        System.out.println("extractSalt");
        String hash = "";
        byte[] expResult = null;
        byte[] result = PasswordHashing.extractSalt(hash);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
