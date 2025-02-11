class VigenereCipher { 
    private static String generateKey(String str, String key) { 
        int x = str.length(); 
        for (int i = 0; ; i++) { 
            if (x == i) i = 0; 
            if (key.length() == str.length()) break; 
            key += key.charAt(i); 
        } 
        return key; 
    } 

    private static String encrypt(String str, String key) { 
        StringBuilder result = new StringBuilder(); 
        for (int i = 0; i < str.length(); i++) { 
            char x = (char) (((str.charAt(i) + key.charAt(i)) % 26) + 'A'); 
            result.append(x); 
        } 
        return result.toString(); 
    } 

    private static String decrypt(String str, String key) { 
        StringBuilder result = new StringBuilder(); 
        for (int i = 0; i < str.length(); i++) { 
            char x = (char) (((str.charAt(i) - key.charAt(i) + 26) % 26) + 'A'); 
            result.append(x); 
        } 
        return result.toString(); 
    } 

    public static void main(String[] args) throws java.lang.Exception { 
        String str = "SECURITY"; 
        String key = "KEY"; 
        String generatedKey = generateKey(str, key); 
        String encrypted = encrypt(str, generatedKey); 
        String decrypted = decrypt(encrypted, generatedKey); 
        System.out.println("Simulating Vigenere Cipher\n----------------------"); 
        System.out.println("Input Message : " + str); 
        System.out.println("Encrypted Message : " + encrypted); 
        System.out.println("Decrypted Message : " + decrypted); 
    } 
}
