package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.entity.CriminalStatus;

import javax.swing.*;
import java.awt.*;

/**
 * Date: 28.11.13
 * Time: 20:49
 *
 * @author Кадет
 */
public class CriminalStatusPanel extends AbstractPanel {

    private String labelText;
    private JLabel criminalStatusLabel;

    private JComboBox<String> criminalStatusComboBox;

    public CriminalStatusPanel(Window parent, String labelText) {
        super(parent);
        this.labelText = labelText;
    }

    protected void initializeComponents() {

        criminalStatusLabel = new JLabel(labelText);

        criminalStatusComboBox = new JComboBox<String>();
        for (CriminalStatus criminalStatus : CriminalStatus.values()) {
            criminalStatusComboBox.addItem(criminalStatus.name());
        }
    }

    protected void addComponents() {
        add(criminalStatusLabel);
        add(criminalStatusComboBox);
    }

    @Override
    protected void updateComponents() {

    }

    public CriminalStatus getCriminalStatus () {
        return CriminalStatus.valueOf((String)criminalStatusComboBox.getSelectedItem());
    }
}
