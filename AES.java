import javax.crypto.*;
class AES { 
    private static byte[] encrypt(byte[] data, SecretKey key) throws Exception { 
        Cipher cipher = Cipher.getInstance("AES"); 
        cipher.init(Cipher.ENCRYPT_MODE, key); 
        return cipher.doFinal(data); 
    } 
    private static byte[] decrypt(byte[] data, SecretKey key) throws Exception { 
        Cipher cipher = Cipher.getInstance("AES"); 
        cipher.init(Cipher.DECRYPT_MODE, key); 
        return cipher.doFinal(data); 
    } 
    public static void main(String[] args) throws Exception { 
        String text = "SECURITY"; 
        KeyGenerator keyGen = KeyGenerator.getInstance("AES"); 
        keyGen.init(128); 
        SecretKey key = keyGen.generateKey(); 
        byte[] encryptedData = encrypt(text.getBytes(), key); 
        byte[] decryptedData = decrypt(encryptedData, key); 
        System.out.println("Simulating AES Cipher\n----------------------"); 
        System.out.println("Input Message : " + text); 
        System.out.println("Encrypted Message : " + new String(encryptedData)); 
        System.out.println("Decrypted Message : " + new String(decryptedData)); 
    } 
}
