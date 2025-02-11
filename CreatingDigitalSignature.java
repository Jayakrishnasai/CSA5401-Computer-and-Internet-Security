import java.security.*;
import java.util.Base64;
class CreatingDigitalSignature {
    public static void main(String[] args) throws Exception {
        // Generate a key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();

        // Create a signature object
        Signature sign = Signature.getInstance("SHA256withRSA");

        // Sign the data
        String text = "SECURITY";
        sign.initSign(pair.getPrivate());
        sign.update(text.getBytes());

        // Generate the signature
        byte[] signature = sign.sign();

        // Output the results
        System.out.println("Simulating Digital Signature\n----------------------");
        System.out.println("Input Message : " + text);
        System.out.println("Digital Signature : " + Base64.getEncoder().encodeToString(signature));

        // Verify the signature
        Signature verifySign = Signature.getInstance("SHA256withRSA");
        verifySign.initVerify(pair.getPublic());
        verifySign.update(text.getBytes());

        boolean isCorrect = verifySign.verify(signature);
        System.out.println("Signature verification: " + isCorrect);
    }
}
