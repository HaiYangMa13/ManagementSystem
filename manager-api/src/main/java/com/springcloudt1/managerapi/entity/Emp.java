package com.springcloudt1.managerapi.entity;

import java.io.Serializable;
/**
 * emp
 * @author 
 */
public class Emp implements Serializable {
    private Integer id;

    private String name;

    private String empno;

    private String sex;

    private Integer sal;

    private String birth;

    private String pwd;

    private String photoname;

    private Integer deptid;

    private Integer roleid;

    private Dept dept;

    private Roleinfo roleinfo;

    private static final long serialVersionUID = 1L;

    public Emp (Integer id, String name, String empno, String sex, Integer sal, String birth, String pwd, String photoname, Integer deptid, Integer roleid, Dept dept ,Roleinfo roleinfo) {
        this.id = id;
        this.name = name;
        this.empno = empno;
        this.sex = sex;
        this.sal = sal;
        this.birth = birth;
        this.pwd = pwd;
        this.photoname = photoname;
        this.deptid = deptid;
        this.roleid = roleid;
        this.dept = dept;
        this.roleinfo = roleinfo;
    }

    public Emp (String name, String empno, String sex, Integer sal, String birth, String pwd, String photoname, Integer deptid, Integer roleid, Dept dept ,Roleinfo roleinfo) {
        this.name = name;
        this.empno = empno;
        this.sex = sex;
        this.sal = sal;
        this.birth = birth;
        this.pwd = pwd;
        this.photoname = photoname;
        this.deptid = deptid;
        this.roleid = roleid;
        this.dept = dept;
        this.roleinfo = roleinfo;
    }

    public Emp () {
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

    public String getEmpno () {
        return empno;
    }

    public void setEmpno (String empno) {
        this.empno = empno;
    }

    public String getSex () {
        return sex;
    }

    public void setSex (String sex) {
        this.sex = sex;
    }

    public Integer getSal () {
        return sal;
    }

    public void setSal (Integer sal) {
        this.sal = sal;
    }

    public String getBirth () {
        return birth;
    }

    public void setBirth (String birth) {
        this.birth = birth;
    }

    public String getPwd () {
        return pwd;
    }

    public void setPwd (String pwd) {
        this.pwd = pwd;
    }

    public String getPhotoname () {
        return photoname;
    }

    public void setPhotoname (String photoname) {
        this.photoname = photoname;
    }

    public Integer getDeptid () {
        return deptid;
    }

    public void setDeptid (Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getRoleid () {
        return roleid;
    }

    public void setRoleid (Integer roleid) {
        this.roleid = roleid;
    }

    public Dept getDept () {
        return dept;
    }

    public void setDept (Dept dept) {
        this.dept = dept;
    }

    public Roleinfo getRoleinfo () {
        return roleinfo;
    }

    public void setRoleinfo (Roleinfo roleinfo) {
        this.roleinfo = roleinfo;
    }

    public static long getSerialVersionUID () {
        return serialVersionUID;
    }
}