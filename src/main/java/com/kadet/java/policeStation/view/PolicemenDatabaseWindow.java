package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.database.PolicemanDatabase;
import com.kadet.java.policeStation.entity.Policeman;
import com.kadet.java.policeStation.entity.Sheriff;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:12
 * To change this template use File | Settings | File Templates.
 */
public class PolicemenDatabaseWindow extends AbstractWindow {

    private List<FirePolicemanPanel> firePolicemanPanels;

    private PolicemanDatabase policemanDatabase = PolicemanDatabase.getInstance();

    private Sheriff currentSheriff;

    public PolicemenDatabaseWindow(Window parent) {
        super(parent);
    }

    @Override
    protected void initializeComponents() {
        this.firePolicemanPanels = new ArrayList<FirePolicemanPanel>();
    }

    private void removeComponents() {
        for (FirePolicemanPanel panel : firePolicemanPanels) {
            remove(panel);
        }
        firePolicemanPanels.clear();
    }

    @Override
    protected void addComponents() {
        for (FirePolicemanPanel panel : firePolicemanPanels) {
            add(panel);
        }
    }

    public void updateComponents() {
        removeComponents();
        List<Policeman> policemen = policemanDatabase.getPolicemen();
        for (Policeman policeman : policemen) {
            if (policeman != currentSheriff) {
                FirePolicemanPanel firePolicemanPanel
                        = new FirePolicemanPanel(this, policeman);
                firePolicemanPanels.add(firePolicemanPanel);
            }
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

    public void setCurrentSheriff(Sheriff currentSheriff) {
        this.currentSheriff = currentSheriff;
    }
}
