package com.auth.api.models;

import javax.persistence.*;


@Entity
@Table(name = "CREDENTIAL")
public class Credential {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idcredential")
    private int id;

    @Column(name = "login")
    private String logn;

    @Column(name = "password")
    private String password;

    public Credential() {

    }

    public Credential(String logn, String password) {
        this.logn = logn;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getLogn() {
        return logn;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "id=" + id +
                ", logn='" + logn + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
