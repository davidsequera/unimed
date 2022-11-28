//package com.unimed.persistence.auth;
//
//import at.favre.lib.crypto.bcrypt.BCrypt;
//
//public class Auth {
//    final static  int COST = 12;
//    public static String hashPassword(String password){
//        return BCrypt.withDefaults().hashToString(COST, password.toCharArray());
//    }
//    public static boolean verifyPassword(String password, String hash){
//        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hash);
//        return result.verified;
//    }
//}
