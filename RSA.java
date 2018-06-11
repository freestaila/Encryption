import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA{
    private BigInteger mod, d, publicKey;

    private int bitlen = 1024;

    /** Create an instance that can encrypt using someone elses public key. */
    public RSA(BigInteger newmod, BigInteger newpublicKey) {
        mod = newmod;
        publicKey = newpublicKey;
    }

    /** Create an instance that can both encrypt and decrypt. */
    public RSA(int bits) {
        bitlen = bits;
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bitlen / 2, 100, r);
        BigInteger q = new BigInteger(bitlen / 2, 100, r);
        mod = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        publicKey = new BigInteger("3");
        while (m.gcd(publicKey).intValue() > 1) {
            publicKey = publicKey.add(new BigInteger("2"));
        }
        d = publicKey.modInverse(m);
    }

    /** Encrypt the given plaintext message. */
    public synchronized String encrypt(String message) {
        return (new BigInteger(message.getBytes())).modPow(publicKey, mod).toString();
    }

    /** Encrypt the given plaintext message. */
    public synchronized BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, mod);
    }

    /** Decrypt the given ciphertext message. */
    public synchronized String decrypt(String message) {
        return new String((new BigInteger(message)).modPow(d, mod).toByteArray());
    }

    /** Decrypt the given ciphertext message. */
    public synchronized BigInteger decrypt(BigInteger message) {
        return message.modPow(d, mod);
    }

    /** Generate a new public and private key set. */
    public synchronized void generateKeys() {
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bitlen / 2, 100, r);
        BigInteger q = new BigInteger(bitlen / 2, 100, r);
        mod = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q
                .subtract(BigInteger.ONE));
        publicKey = new BigInteger("3");
        while (m.gcd(publicKey).intValue() > 1) {
            publicKey = publicKey.add(new BigInteger("2"));
        }
        d = publicKey.modInverse(m);
    }

    /** Return the modulus. */
    public synchronized BigInteger getMod() {
        return mod;
    }

    /** Return the public key. */
    public synchronized BigInteger getPublicKey() {
        return publicKey;
    }
}