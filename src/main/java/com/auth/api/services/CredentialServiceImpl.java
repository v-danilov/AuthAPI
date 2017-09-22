package com.auth.api.services;


import com.auth.api.dao.CredentialDAO;
import com.auth.api.models.Credential;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CredentialServiceImpl implements CredentialService {

    private CredentialDAO credentialDAO;

    public void setCredentialDAO(CredentialDAO credentialDAO) {this.credentialDAO = credentialDAO;}

    @Transactional
    public JSONObject addCredential(Credential credential){


        if(isUniqCred(credential.getLogn())){
            if(checkLoginFormat(credential.getLogn())) {
                if (credential.getLogn().length() <= 45) {
                    credentialDAO.addCredential(credential);
                    JSONObject resopnse_json = new JSONObject();
                    resopnse_json.put("type", "success");
                    resopnse_json.put("username", credential.getLogn());
                    return resopnse_json;
                }
                return generateError("To long login name");

            }
            return generateError("Wrong login format.");
        }
        return generateError("User already exists.");

    }

    @Transactional
    public JSONObject checkCredential(String login, String pass){
        Credential validateCred = credentialDAO.getCredentialByLogin(login);
        if(validateCred != null){
            if(validateCred.getPassword().equals(pass)){
                JSONObject resopnse_json = new JSONObject();
                resopnse_json.put("type", "success");
                resopnse_json.put("username", validateCred.getLogn());
                resopnse_json.put("key", validateCred.getId());
                return resopnse_json;
            }
            return generateError("Wrong password.");
        }
        return generateError("User not found.");
    }

    @Transactional
    private boolean isUniqCred(String login){
        return (credentialDAO.getCredentialByLogin(login) == null);
    }

    private boolean checkLoginFormat(String login){

        Pattern email_regexp =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = email_regexp .matcher(login);
        return matcher.find();

    }

    private JSONObject generateError(String mes){
        JSONObject resopnse_json = new JSONObject();
        resopnse_json.put("type", "error");
        resopnse_json.put("message", mes);
        return resopnse_json;
    }

}
