//TODO: Complete java docs and code in missing spots.
import java.security.*;
import java.nio.charset.*;

//This code is already made for you, it is extended by Hashing to generate the SHA-512 hash of a String. No explicit call to any method here is required.
/**
 * This class us used by the Hashing class to create the CHF.
 */
public class SHA512 {
    /**
     * This function creates a message using the string passed.
     * @param message the String you need hashed.
     * @return the CHF.
     */
    protected static String hashSHA512(String message) {
        String sha512ValueHexa = "";
        try {
            MessageDigest digest512 = MessageDigest.getInstance("SHA-512");
            sha512ValueHexa = byteToHex(digest512.digest(message.getBytes(StandardCharsets.UTF_8)));
        }
        catch(NoSuchAlgorithmException exp) {
            exp.getMessage();
        }
        return sha512ValueHexa;
    }
    /**
     * Helper method to create CHF.
     * @param digest provided from hashSHA512 function.
     * @return  a String to help create the CHF.
     */
    public static String byteToHex(byte[] digest) {
        StringBuilder vector = new StringBuilder();
        for (byte c : digest) {
            vector.append(String.format("%02X", c));
        }
        String output = vector.toString();
        return output;
    }
}
