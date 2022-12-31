package com.kunalchhabra.requests;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    private final byte[] message;

    protected Hash(byte[] message) {
        this.message = message;
    }

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

    public String getMD5() {
        return this.getHash("MD5");
    }

    public String getSHA1() {
        return this.getHash("SHA-1");
    }

    public String getSHA256() {
        return this.getHash("SHA-256");
    }

    public String getSHA512() {
        return this.getHash("SHA-512");
    }
}
