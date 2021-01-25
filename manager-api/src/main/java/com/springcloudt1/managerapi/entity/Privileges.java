package com.springcloudt1.managerapi.entity;

import java.io.Serializable;

/**
 * privileges
 * @author 
 */
public class Privileges implements Serializable {
    private Integer roleId;

    private Integer rightId;

    public Privileges (Integer roleId, Integer rightId) {
        this.roleId = roleId;
        this.rightId = rightId;
    }

    public Privileges () {
    }

    private static final long serialVersionUID = 1L;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

}