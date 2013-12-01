package com.kadet.java.policeStation.database;

import com.kadet.java.policeStation.entity.Criminal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
public class CriminalDatabase {

    private final static CriminalDatabase instance = new CriminalDatabase();

    public static final CriminalDatabase getInstance () {
        return instance;
    }

    private List<Criminal> criminals;

    public CriminalDatabase() {
        this.criminals = new ArrayList<Criminal>();
    }

    public void addCriminal (Criminal criminal) {
        criminals.add(criminal);
    }

    public List<Criminal> getCriminals() {
        return criminals;
    }
}
