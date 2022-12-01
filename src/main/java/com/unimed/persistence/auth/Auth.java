package com.unimed.persistence.auth;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Auth {
    final static  int COST = 12;
    public static String hashPassword(String password){
        return  BCrypt.hashpw(password, BCrypt.gensalt(COST));
    }
    public static boolean verifyPassword(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }
}
