package com.kadet.java.policeStation.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
public class Sheriff extends Policeman {

    public Sheriff(Status status, String fio, String email, Date birthday, boolean sex, String login, String password) {
        super(status, fio, email, birthday, sex, login, password);
    }

    public void setStatus (Status status) {
        this.status = status;
    }

}
