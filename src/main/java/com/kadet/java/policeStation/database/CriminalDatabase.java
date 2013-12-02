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

    public int getCriminalsNumber () {
        return criminals.size();
    }

    public List<Criminal> subList (int firstIndex, int lastIndex) {
        if (firstIndex < 0 || lastIndex < 1 || firstIndex >= lastIndex || firstIndex > criminals.size()) {
            throw new RuntimeException("Bad parameters error!");
        }
        List<Criminal> subCriminals
                = new ArrayList<Criminal>();
        for (int resumeIndex = firstIndex; resumeIndex < lastIndex && resumeIndex < criminals.size(); ++resumeIndex) {
            subCriminals.add(
                    criminals.get(resumeIndex)
            );
        }
        return subCriminals;
    }}
