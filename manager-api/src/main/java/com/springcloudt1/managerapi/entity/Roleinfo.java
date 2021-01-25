package com.springcloudt1.managerapi.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * roleinfo
 * @author 
 */

public class Roleinfo implements Serializable {
    private Integer id;

    private String name;

    private String beizhu;

    private Set rights = new HashSet();
    private static final long serialVersionUID = 1L;

    public Roleinfo (Integer id, String name, String beizhu, Set rights) {
        this.id = id;
        this.name = name;
        this.beizhu = beizhu;
        this.rights = rights;
    }

    public Roleinfo (String name, String beizhu, Set rights) {
        this.name = name;
        this.beizhu = beizhu;
        this.rights = rights;
    }

    public Roleinfo () {
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

    public String getBeizhu () {
        return beizhu;
    }

    public void setBeizhu (String beizhu) {
        this.beizhu = beizhu;
    }

    public Set getRights () {
        return rights;
    }

    public void setRights (Set rights) {
        this.rights = rights;
    }

    public static long getSerialVersionUID () {
        return serialVersionUID;
    }
}