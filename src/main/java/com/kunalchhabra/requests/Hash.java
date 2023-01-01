package com.kunalchhabra.requests;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hash class
 * This class provides methods to hash a byte array to Hash Hex String.
 * It provides utility methods to get popular Hash like MD5, SHA-1, SHA-256, SHA-512.
 */
public class Hash {
    private final byte[] message;

    /**
     * Constructor
     * @param message byte array to be hashed
     */
    protected Hash(byte[] message) {
        this.message = message;
    }

    /**
     * Generic Hash function to calculate Hash of a byte array.
     * @param algorithm Hash algorithm to be used
     * @return Hash Hex String
     */
    private String getHash(String algorithm) {
        try {
            MessageDigest hash = MessageDigest.getInstance(algorithm);
            hash.update(this.message);
            byte[] digest = hash.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            return bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Get MD5 hash of the byte array
     * @return MD5 hash of the byte array
     */
    public String getMD5() {
        return this.getHash("MD5");
    }

    /**
     * Get SHA-1 hash of the byte array
     * @return SHA-1 hash of the byte array
     */
    public String getSHA1() {
        return this.getHash("SHA-1");
    }

    /**
     * Get SHA-256 hash of the byte array
     * @return SHA-256 hash of the byte array
     */
    public String getSHA256() {
        return this.getHash("SHA-256");
    }

    /**
     * Get SHA-512 hash of the byte array
     * @return SHA-512 hash of the byte array
     */
    public String getSHA512() {
        return this.getHash("SHA-512");
    }
}
