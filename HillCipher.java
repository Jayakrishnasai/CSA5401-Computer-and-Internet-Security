class HillCipher { 
    private static int[][] keyMatrix; 
    private static int keySize; 

    private static String prepareText(String text) { 
        text = text.toUpperCase().replaceAll("[^A-Z]", ""); 
        if (text.length() % keySize != 0) { 
            int padding = keySize - (text.length() % keySize); 
            for (int i = 0; i < padding; i++) { 
                text += 'X'; 
            } 
        } 
        return text; 
    } 

    private static int[][] getKeyMatrix(String key) { 
        keyMatrix = new int[keySize][keySize]; 
        int k = 0; 
        for (int i = 0; i < keySize; i++) { 
            for (int j = 0; j < keySize; j++) { 
                keyMatrix[i][j] = key.charAt(k) - 'A'; 
                k++; 
            } 
        } 
        return keyMatrix; 
    } 

    private static String encrypt(String text, String key) { 
        text = prepareText(text); 
        keyMatrix = getKeyMatrix(key); 
        StringBuilder encrypted = new StringBuilder(); 
        for (int i = 0; i < text.length(); i += keySize) { 
            int[] textBlock = new int[keySize]; 
            for (int j = 0; j < keySize; j++) { 
                textBlock[j] = text.charAt(i + j) - 'A'; 
            } 
            int[] encryptedBlock = new int[keySize]; 
            for (int j = 0; j < keySize; j++) { 
                for (int l = 0; l < keySize; l++) { 
                    encryptedBlock[j] += keyMatrix[j][l] * textBlock[l]; 
                } 
                encryptedBlock[j] %= 26; 
                encrypted.append((char) (encryptedBlock[j] + 'A')); 
            } 
        } 
        return encrypted.toString(); 
    } 

    public static void main(String[] args) throws java.lang.Exception { 
        String key = "HILL"; 
        String text = "SECURITY"; 
        keySize = 2; 
        String encrypted = encrypt(text, key); 
        System.out.println("Simulating Hill Cipher\n----------------------"); 
        System.out.println("Input Message : " + text); 
        System.out.println("Encrypted Message : " + encrypted); 
    } 
}
