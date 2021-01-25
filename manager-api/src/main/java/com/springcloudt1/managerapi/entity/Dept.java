package com.springcloudt1.managerapi.entity;

import java.io.Serializable;

/**
 * dept
 *
 * @author
 */
public class Dept implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String manager;

    public Dept (Integer id, String name, String manager) {
        this.id = id;
        this.name = name;
        this.manager = manager;
    }

    public Dept (String name, String manager) {
        this.name = name;
        this.manager = manager;
    }

    public Dept () {
    }

    public static long getSerialVersionUID () {
        return serialVersionUID;
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

    public String getManager () {
        return manager;
    }

    public void setManager (String manager) {
        this.manager = manager;
    }
}