package com.kadet.java.policeStation.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
public class CriminalCase implements Comparable<CriminalCase>{

    private List<Criminal> criminals;
    private String description;
    private Date lastChange;

    public CriminalCase(Criminal criminal, String description, Date lastChange) {
        this.criminals = new ArrayList<Criminal>();
        criminals.add(criminal);
        this.description = description;
        this.lastChange = lastChange;
    }

    public CriminalCase(List<Criminal> criminals, String description, Date lastChange) {
        this.criminals = criminals;
        this.description = description;
        this.lastChange = lastChange;
    }

    public void addCriminal (Criminal criminal) {
        criminals.add(criminal);
    }

    public List<Criminal> getCriminals() {
        return criminals;
    }

    public void setCriminals(List<Criminal> criminals) {
        this.criminals = criminals;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastChange() {
        return lastChange;
    }

    @Override
    public int compareTo(CriminalCase o) {
        return lastChange.compareTo(o.getLastChange());
    }

    @Override
    public String toString() {
        return "CriminalCase{" +
                "description='" + description + '\'' +
                ", lastChange=" + lastChange +
                '}';
    }
}