package com.kadet.java.policeStation.view.criminalCase;

import com.kadet.java.policeStation.entity.CriminalCase;
import com.kadet.java.policeStation.view.AbstractWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public class CriminalCaseWindow extends AbstractWindow{

    private JLabel criminalCaseInfo;
    private CriminalCase criminalCase;


    public CriminalCaseWindow(Window parent, CriminalCase criminalCase) {
        super(parent);
        this.criminalCase = criminalCase;
    }

    @Override
    protected void initializeComponents() {
        criminalCaseInfo = new JLabel();
    }

    @Override
    protected void addComponents() {
        add(criminalCaseInfo);
    }


    public void updateComponents () {
        criminalCaseInfo.setText(criminalCase.toString());
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
