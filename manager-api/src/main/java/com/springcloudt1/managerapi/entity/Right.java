package com.springcloudt1.managerapi.entity;

import java.io.Serializable;

/**
 * right
 * @author 
 */
public class Right implements Serializable {
    private Integer id;

    private String name;

    private String url;

    private static final long serialVersionUID = 1L;

    public Right (Integer id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Right (String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Right () {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}