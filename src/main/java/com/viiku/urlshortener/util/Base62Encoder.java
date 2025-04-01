package com.viiku.urlshortener.util;

import java.util.UUID;

public class Base62Encoder {

    private static final String BASE62_CHARS =
            "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String encode(long number) {
        if (number == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.insert(0, BASE62_CHARS.charAt((int)(number % 62)));
            number /= 62;
        }
        return sb.toString();
    }

    public static String generateShortCode() {
        // Use UUID to get a unique value, then encode it
        long mostSignificantBits = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        return encode(mostSignificantBits).substring(0, 8); // Take first 8 characters
    }
}
