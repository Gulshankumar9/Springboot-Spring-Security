package com.eazybytes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

//this pojo class represent the database
@Entity
public class Customer {

    //all variables act as columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")//primary key will be used automaticcaly
    @GenericGenerator(name = "native", strategy = "native")//when strategy is native then sequence no is autocreated and autoincremented.
    private int id;
    private String email;
    private String pwd;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
