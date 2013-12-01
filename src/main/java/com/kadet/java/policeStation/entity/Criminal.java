package com.kadet.java.policeStation.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
public class Criminal {

    private String fio;
    private Date birthday;
    private boolean sex;
    private List<CriminalCase> criminalCases;
    private CriminalStatus criminalStatus;

    public Criminal(String fio, Date birthday, boolean sex, CriminalStatus criminalStatus) {
        this.fio = fio;
        this.birthday = birthday;
        this.sex = sex;
        this.criminalStatus = criminalStatus;
        this.criminalCases = new ArrayList<CriminalCase>();
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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

    public CriminalStatus getCriminalStatus() {
        return criminalStatus;
    }

    public void setCriminalStatus(CriminalStatus criminalStatus) {
        this.criminalStatus = criminalStatus;
    }

    public void addCriminalCase (CriminalCase criminalCase) {
        criminalCases.add(criminalCase);
    }

    @Override
    public String toString() {
        return "Criminal{" +
                "fio='" + fio + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", criminalCases=" + criminalCases +
                ", criminalStatus=" + criminalStatus +
                '}';
    }
}
