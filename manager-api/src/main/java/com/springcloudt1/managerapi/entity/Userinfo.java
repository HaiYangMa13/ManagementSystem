package com.springcloudt1.managerapi.entity;

import java.io.Serializable;
/**
 * userinfo
 * @author 
 */
public class Userinfo implements Serializable {
    private Integer id;

    private String name;

    private String pwd;

    private static final long serialVersionUID = 1L;

    public Userinfo (Integer id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public Userinfo (String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public Userinfo () {
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPwd () {
        return pwd;
    }

    public void setPwd (String pwd) {
        this.pwd = pwd;
    }

    public static long getSerialVersionUID () {
        return serialVersionUID;
    }
}