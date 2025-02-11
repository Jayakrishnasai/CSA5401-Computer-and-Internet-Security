class RailFenceCipher { 
    private static String encrypt(String text, int key) { 
        StringBuilder[] rail = new StringBuilder[key]; 
        for (int i = 0; i < key; i++) { 
            rail[i] = new StringBuilder(); 
        } 
        boolean dirDown = false; 
        int row = 0; 
        for (char c : text.toCharArray()) { 
            rail[row].append(c); 
            if (row == 0 || row == key - 1) { 
                dirDown = !dirDown; 
            } 
            row += dirDown ? 1 : -1; 
        } 
        StringBuilder result = new StringBuilder(); 
        for (StringBuilder r : rail) { 
            result.append(r); 
        } 
        return result.toString(); 
    } 

    public static void main(String[] args) throws java.lang.Exception { 
        String text = "SECURITY"; 
        int key = 3; 
        String encrypted = encrypt(text, key); 
        System.out.println("Simulating Rail Fence Cipher\n----------------------"); 
        System.out.println("Input Message : " + text); 
        System.out.println("Encrypted Message : " + encrypted); 
    } 
}
