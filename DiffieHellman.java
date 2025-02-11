import java.math.BigInteger; 
import java.security.SecureRandom; 
class DiffieHellman { 
    private static BigInteger p; 
    private static BigInteger g; 
    private static BigInteger privateKeyA; 
    private static BigInteger privateKeyB; 
    private static BigInteger publicKeyA; 
    private static BigInteger publicKeyB; 
    private static BigInteger sharedSecretA; 
    private static BigInteger sharedSecretB; 

    public static void main(String[] args) throws Exception { 
        SecureRandom random = new SecureRandom(); 
        p = BigInteger.probablePrime(512, random); 
        g = BigInteger.valueOf(2); 
        privateKeyA = new BigInteger(512, random); 
        privateKeyB = new BigInteger(512, random); 
        publicKeyA = g.modPow(privateKeyA, p); 
        publicKeyB = g.modPow(privateKeyB, p); 
        sharedSecretA = publicKeyB.modPow(privateKeyA, p); 
        sharedSecretB = publicKeyA.modPow(privateKeyB, p); 
        System.out.println("Simulating Diffie-Hellman Key Exchange\n----------------------"); 
        System.out.println("Public Key A : " + publicKeyA); 
        System.out.println("Public Key B : " + publicKeyB); 
        System.out.println("Shared Secret A : " + sharedSecretA); 
        System.out.println("Shared Secret B : " + sharedSecretB); 
    } 
}
