package com.kadet.java.policeStation.database;

import com.kadet.java.policeStation.entity.Policeman;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class PolicemanDatabase {

    private final static PolicemanDatabase instance = new PolicemanDatabase();

    public static final PolicemanDatabase getInstance () {
        return instance;
    }


    private List<Policeman> policemen;

    public PolicemanDatabase() {
        this.policemen = new ArrayList<Policeman>();
    }

    public void addPoliceman (Policeman policeman) {
        policemen.add(policeman);
    }

    public List<Policeman> getPolicemen() {
        return policemen;
    }

    public boolean remove (Policeman policeman) {
        return policemen.remove(policeman);
    }
}
