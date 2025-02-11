import javax.crypto.*; 
class DES { 
    private static byte[] encrypt(byte[] data, SecretKey key) throws Exception { 
        Cipher cipher = Cipher.getInstance("DES"); 
        cipher.init(Cipher.ENCRYPT_MODE, key); 
        return cipher.doFinal(data); 
    } 
    private static byte[] decrypt(byte[] data, SecretKey key) throws Exception { 
        Cipher cipher = Cipher.getInstance("DES"); 
        cipher.init(Cipher.DECRYPT_MODE, key); 
        return cipher.doFinal(data); 
    } 
    public static void main(String[] args) throws Exception { 
        String text = "SECURITY"; 
        KeyGenerator keyGen = KeyGenerator.getInstance("DES"); 
        keyGen.init(56); 
        SecretKey key = keyGen.generateKey(); 
        byte[] encryptedData = encrypt(text.getBytes(), key); 
        byte[] decryptedData = decrypt(encryptedData, key); 
        System.out.println("Simulating DES Cipher\n----------------------"); 
        System.out.println("Input Message : " + text); 
        System.out.println("Encrypted Message : " + new String(encryptedData)); 
        System.out.println("Decrypted Message : " + new String(decryptedData)); 
    } 
}
