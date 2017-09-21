package com.auth.api.dao;


import com.auth.api.models.Credential;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class CredentialDAOImpl implements CredentialDAO {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CredentialDAO.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void addCredential(Credential credential){
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println("Try to add " + credential);
        session.persist(credential);
        logger.info("Credential successfully added. Credential info: " + credential);
    }

    @Transactional
    public Credential getCredentialByLogin(String login){
        Session session = this.sessionFactory.getCurrentSession();
        Credential credential = (Credential)session.createQuery("from Credential where login=:_login")
                .setParameter("_login", login)
                .uniqueResult();
        return credential;
    }

    @Transactional
    public int validateCredential(String login, String pass){
        Session session = this.sessionFactory.getCurrentSession();
        int res = (Integer) session.createQuery("SELECT EXISTS(FROM credential WHERE login=:_login and password=:_pass)")
                .setParameter("_login", login)
                .setParameter("_pass", pass)
                .uniqueResult();
        return res;
    }

}
