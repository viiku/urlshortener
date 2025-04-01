//package com.viiku.urlshortener.util;
//
//import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.util.Base64;
//
//public class UrlShortenerGenerator {
//
//    public static String generateShortUrl(String url, String alias) {
//
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//            byte[] hash = digest.digest(url.getBytes(StandardCharsets.UTF_8));
//            String hashedString = Base64.getUrlEncoder().withoutPadding().encodeToString(hash).substring(0, 8);
//            return "https://"+alias+ hashedString;
//        } catch (Exception e) {
//            throw new RuntimeException("Error generating short URL", e);
//        }
//    }
//}
