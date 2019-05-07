/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

/**
 *
 * @author jakob
 */
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHashing {

    private static final String delimiter = "::";
    private byte[] salt;

    MessageDigest md;

    public PasswordHashing() {
        // Generate the random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        this.salt = salt;
    }

    public PasswordHashing(byte[] salt) {
        this.salt = salt;
    }

    public String hash(String password) {
        try {
            // Select the message digest for the hash computation -> MD5
            md = MessageDigest.getInstance("MD5");

            // Passing the salt to the digest for the computation
            md.update(salt);

            // Generate the salted hash
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            String sb = Base64.encode(hashedPassword);
            String sbSalt = Base64.encode(salt);

            sb = (sb + "::" + sbSalt);

            password = sb.toString();
            return password;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("No such algorithm exception");
        }
        return null;
    }

    public boolean compare(String password, String hash) {
        return hash.equals(hash(password));
    }

    public static byte[] extractSalt(String hash) {

        String[] temp = hash.split(delimiter);
        return Base64.decode(temp[1]);

    }
}
