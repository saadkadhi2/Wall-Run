package sample.ordermenu;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class EncryptDecrypt {
    private static final String UNICODE_FORMAT= "UTF-8";


    public static SecretKey generateKey(String encryptionType) {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(encryptionType);
            SecretKey myKey = keyGen.generateKey();
            return myKey;
        }
        catch(Exception e) {
            return null;
        }
    }
    public static byte[] encryptString(String dataToEncrypt,  SecretKey myKey, Cipher cipher) {
        try {
            byte[] text = dataToEncrypt.getBytes(UNICODE_FORMAT);
            cipher.init(Cipher.ENCRYPT_MODE, myKey);
            byte[] textEncrypted = cipher.doFinal(text);

            return textEncrypted;
        }
        catch(Exception e) {
            return null;
        }
    }
    public static String decryptString(byte[] dataToDecrypt, SecretKey myKey, Cipher cipher) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, myKey);
            byte[] textDecrypted = cipher.doFinal(dataToDecrypt);
            String r = new String(textDecrypted);
            return r;
        } catch(Exception e) {
            return null;
        }
    }
}
