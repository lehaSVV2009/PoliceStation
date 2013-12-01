package com.kadet.java.policeStation.view.criminal;

import com.kadet.java.policeStation.database.CriminalDatabase;
import com.kadet.java.policeStation.entity.Criminal;
import com.kadet.java.policeStation.view.AbstractWindow;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
public class CriminalsDatabaseWindow extends AbstractWindow {

    private List<CriminalPanel> criminalPanels;

    private CriminalDatabase criminalDatabase = CriminalDatabase.getInstance();

    public CriminalsDatabaseWindow(JDialog window) {
        super(window);
    }

    protected void initializeComponents () {
        criminalPanels = new ArrayList<CriminalPanel>();
    }

    protected void addComponents () {
        for (CriminalPanel panel : criminalPanels) {
            add(panel);
        }
    }

    private void removeComponents () {
        for (CriminalPanel criminalPanel : criminalPanels) {
            remove(criminalPanel);
        }
        removeCriminalPanels();
    }

    private void removeCriminalPanels () {
        while (criminalPanels.size() != 0) {
            criminalPanels.remove(criminalPanels.get(0));
        }
    }

    public void updateComponents () {
        removeComponents();
        List<Criminal> criminals = criminalDatabase.getCriminals();
        for (Criminal criminal : criminals) {
            CriminalPanel criminalPanel = new CriminalPanel(this, criminal);
            criminalPanels.add(criminalPanel);
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
