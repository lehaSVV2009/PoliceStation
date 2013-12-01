package com.kadet.java.policeStation.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class Policeman {

    protected Status status;
    private String fio;
    private Date birthday;
    private boolean sex;
    private String login;
    private String password;

    public Policeman(Status status, String fio, Date birthday, boolean sex, String login, String password) {
        this.status = status;
        this.fio = fio;
        this.birthday = birthday;
        this.sex = sex;
        this.login = login;
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public String getFio() {
        return fio;
    }

    public Date getBirthday() {
        return birthday;
    }

    public boolean isMale() {
        return sex == true;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
