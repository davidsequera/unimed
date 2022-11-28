package com.unimed.persistence.database;

import com.unimed.entities.*;

import java.util.List;

public interface DatabaseMapper {
    void connect() throws Exception;
    void getProperties() throws Exception;
    void disconnect();
    List<Caso> cosult() throws Exception;
    Caso buy(String id) throws Exception;
    Usuario logIn(String user)  throws Exception;
    Usuario signUp(String user, String password)  throws Exception;
}
