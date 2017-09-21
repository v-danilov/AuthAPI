package com.auth.api.dao;


import com.auth.api.models.Credential;

public interface CredentialDAO {

    void addCredential(Credential credential);

    Credential getCredentialByLogin(String login);

    int validateCredential(String login, String pass);
}
