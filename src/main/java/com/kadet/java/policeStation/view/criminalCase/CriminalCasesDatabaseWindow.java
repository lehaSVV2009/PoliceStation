package com.kadet.java.policeStation.view.criminalCase;

import com.kadet.java.policeStation.database.CriminalCaseDatabase;
import com.kadet.java.policeStation.entity.CriminalCase;
import com.kadet.java.policeStation.view.AbstractWindow;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
public class CriminalCasesDatabaseWindow extends AbstractWindow {

    private List<CriminalCasePanel> criminalCasePanels;

    private CriminalCaseDatabase criminalDatabase = CriminalCaseDatabase.getInstance();

    public CriminalCasesDatabaseWindow(Window window) {
        super(window);
    }

    protected void initializeComponents () {
        criminalCasePanels = new ArrayList<CriminalCasePanel>();
    }

    protected void addComponents () {
        for (CriminalCasePanel panel : criminalCasePanels) {
            add(panel);
        }
    }

    private void removeComponents () {
        for (CriminalCasePanel criminalPanel : criminalCasePanels) {
            remove(criminalPanel);
        }
        removeCriminalCasePanels();
    }

    private void removeCriminalCasePanels () {
        while (criminalCasePanels.size() != 0) {
            criminalCasePanels.remove(criminalCasePanels.get(0));
        }
    }

    public void updateComponents () {
        removeComponents();
        List<CriminalCase> criminals = criminalDatabase.getCriminalCases();
        for (CriminalCase criminalCase : criminals) {
            CriminalCasePanel criminalPanel = new CriminalCasePanel(this, criminalCase);
            criminalCasePanels.add(criminalPanel);
        }
        addComponents();
    }

    @Override
    public void setVisible(boolean b) {
        if (b == true) {
            updateComponents();
        }
        super.setVisible(b);
        if (b == false) {
            getParent().setVisible(true);
        }
    }


}
