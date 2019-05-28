/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
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
     * Test if the plain text password has been changed
     * and if a new instance of PasswordHashing returns a different result
     */
    @Test
    public void testHash() {
        System.out.println("hash");
        String password = "Test";
        PasswordHashing instance = new PasswordHashing();
        PasswordHashing secondInstance = new PasswordHashing();
        String result = instance.hash(password);
        String secondResult = secondInstance.hash(password);
        assert(!result.equals(password) && !result.equals(secondResult));
    }

    /**
     * Test of compare method, of class PasswordHashing.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        String password = "Test";
        String hashed = "2/fYpzQLGN3FGXqVf4yHaQ==::hZe8Q11TuPK7sB0Od6AXzg==";
        byte[] salt = PasswordHashing.extractSalt(hashed);
        byte[] secondSalt = PasswordHashing.extractSalt("e/GZxGp/RuKihcQ3Du/UZg==::DbEZE1e17ezGEbGKnGaTrA==");
        PasswordHashing instance = new PasswordHashing(salt);
        PasswordHashing secondInstance = new PasswordHashing(secondSalt);
        boolean result = instance.compare(password, hashed);
        boolean secondResult = secondInstance.compare(password, hashed);
        assert(result && !secondResult);
    }

    /**
     * Test of extractSalt method, of class PasswordHashing.
     */
    @Test
    public void testExtractSalt() {
        System.out.println("extractSalt");
        String hash = "e/GZxGp/RuKihcQ3Du/UZg==::DbEZE1e17ezGEbGKnGaTrA==";
        byte[] expResult = Base64.decode("DbEZE1e17ezGEbGKnGaTrA==");
        byte[] result = PasswordHashing.extractSalt(hash);
        assertArrayEquals(expResult, result);
    }
    
}
