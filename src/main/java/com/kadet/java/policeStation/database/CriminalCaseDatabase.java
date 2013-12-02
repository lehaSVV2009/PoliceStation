package com.kadet.java.policeStation.database;

import com.kadet.java.policeStation.entity.CriminalCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
public class CriminalCaseDatabase {

    private static final CriminalCaseDatabase instance = new CriminalCaseDatabase();

    public final static CriminalCaseDatabase getInstance () {
        return instance;
    }

    private List<CriminalCase> criminalCases;

    public CriminalCaseDatabase() {
        criminalCases = new ArrayList<CriminalCase>();
    }

    public void addCriminalCase (CriminalCase criminalCase) {
        criminalCases.add(criminalCase);
    }

    public List<CriminalCase> getLastCriminalCases (int criminalCasesNumber) {
        sortByDate(criminalCases);
        List<CriminalCase> lastCriminalCases = new ArrayList<CriminalCase>();
        for (int criminalCaseIndex = 0; criminalCaseIndex < criminalCases.size() && criminalCaseIndex < criminalCasesNumber; ++criminalCaseIndex) {
            lastCriminalCases.add(
                    criminalCases.get(criminalCaseIndex));
        }
        return lastCriminalCases;
    }

    private void sortByDate (List<CriminalCase> criminalCases) {
        Collections.sort(criminalCases);
    }

    public List<CriminalCase> getCriminalCases() {
        return criminalCases;
    }

    public int getCriminalCasesNumber() {
        return criminalCases.size();
    }

    public List<CriminalCase> subList (int firstIndex, int lastIndex) {
        if (firstIndex < 0 || lastIndex < 1 || firstIndex >= lastIndex || firstIndex > criminalCases.size()) {
            throw new RuntimeException("Bad parameters error!");
        }
        List<CriminalCase> subCriminalCases
                = new ArrayList<CriminalCase>();
        for (int resumeIndex = firstIndex; resumeIndex < lastIndex && resumeIndex < criminalCases.size(); ++resumeIndex) {
            subCriminalCases.add(
                    criminalCases.get(resumeIndex)
            );
        }
        return subCriminalCases;
    }

    public List<CriminalCase> subListFromLast (int firstIndex, int lastIndex, int last) {
        List<CriminalCase> lastCriminalCases
                = getLastCriminalCases(last);
        if (firstIndex < 0 || lastIndex < 1 || firstIndex >= lastIndex || firstIndex > lastCriminalCases.size()) {
            throw new RuntimeException("Bad parameters error!");
        }
        List<CriminalCase> subCriminalCases
                = new ArrayList<CriminalCase>();
        for (int resumeIndex = firstIndex; resumeIndex < lastIndex && resumeIndex < lastCriminalCases.size(); ++resumeIndex) {
            subCriminalCases.add(
                    lastCriminalCases.get(resumeIndex)
            );
        }
        return subCriminalCases;
    }

}