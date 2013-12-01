package com.kadet.java.policeStation.util;

import com.kadet.java.policeStation.entity.CriminalStatus;

import javax.swing.*;
import java.awt.*;

/**
 * Date: 28.11.13
 * Time: 20:49
 *
 * @author Кадет
 */
public class CriminalStatusPanel extends JPanel {

    private Window parent;

    private String labelText;
    private JLabel criminalStatusLabel;

    private JComboBox<String> criminalStatusComboBox;

    public CriminalStatusPanel(Window parent, String labelText) {
        this.labelText = labelText;
        this.parent = parent;
        initialize();
        initializeComponents();
        addComponents();
    }

    private void initialize() {
        setLayout(new FlowLayout());
    }

    private void initializeComponents() {

        criminalStatusLabel = new JLabel(labelText);

        criminalStatusComboBox = new JComboBox<String>();
        for (CriminalStatus criminalStatus : CriminalStatus.values()) {
            criminalStatusComboBox.addItem(criminalStatus.name());
        }
    }


    private void addComponents() {
        add(criminalStatusLabel);
        add(criminalStatusComboBox);
    }

    public CriminalStatus getCriminalStatus () {
        return CriminalStatus.valueOf((String)criminalStatusComboBox.getSelectedItem());
    }
}
