package com.kadet.java.policeStation.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
public class Resume {

    private String name;
    private String email;
    private Date birthday;
    private boolean sex;

    public Resume(String name, String email, Date birthday, boolean sex) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isMan() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
