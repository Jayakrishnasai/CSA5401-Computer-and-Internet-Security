import java.security.MessageDigest; 
class sha1 { 
    public static void main(String[] args) throws Exception { 
        String text = "SECURITY"; 
        MessageDigest md = MessageDigest.getInstance("SHA-1"); 
        byte[] messageDigest = md.digest(text.getBytes()); 
        StringBuilder hexString = new StringBuilder(); 
        for (byte b : messageDigest) { 
            String hex = Integer.toHexString(0xff & b); 
            if (hex.length() == 1) hexString.append('0'); 
            hexString.append(hex); 
        } 
        System.out.println("Simulating SHA-1 Hashing\n----------------------"); 
        System.out.println("Input Message : " + text); 
        System.out.println("SHA-1 Hash : " + hexString.toString()); 
    } 
}
