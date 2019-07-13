package com.mti.utils.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public abstract class Encryptor {
    public static String toSHA1(byte[] convertme) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert md != null;
        return new String(md.digest(convertme));
    }

    public static String getRandomToken(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Arrays.toString(bytes);
    }

    public static String getRandomDriverCode() {
        RandomString randomString = new RandomString(6);
        return randomString.nextString();
    }
}
