package com.kadet.java.policeStation.view.criminalCase;

import com.kadet.java.policeStation.database.CriminalDatabase;
import com.kadet.java.policeStation.entity.Criminal;
import com.kadet.java.policeStation.util.Messages;
import com.kadet.java.policeStation.view.AbstractWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Date: 28.11.13
 * Time: 23:05
 *
 * @author Кадет
 */
public class AddCriminalToCriminalCaseDialog extends AbstractWindow implements ActionListener {

    private JComboBox<String> criminalNames;
    private JButton addCriminal;

    private List<Criminal> criminals;
    private CriminalDatabase criminalDatabase = CriminalDatabase.getInstance();

    public AddCriminalToCriminalCaseDialog(Window parent, List<Criminal> criminals) {
        super(parent);
        this.criminals = criminals;
    }

    @Override
    protected void initializeComponents() {
        this.criminalNames = new JComboBox<String>();

        this.addCriminal = new JButton(Messages.ADD_CRIMINAL_TO_CRIMINAL_CASE_BUTTON);
        addCriminal.addActionListener(this);
    }

    @Override
    protected void addComponents() {
        add(criminalNames);
        add(addCriminal);
    }

    private void removeComponents () {
        remove(criminalNames);
        remove(addCriminal);
    }

    private void clearCriminalNames () {
        criminalNames.removeAllItems();
    }

    @Override
    public void updateComponents () {
        removeComponents();
        clearCriminalNames();
        List<Criminal> criminals
                = criminalDatabase.getCriminals();
        for (Criminal criminal : criminals) {
            criminalNames.addItem(criminal.getFio());
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Criminal criminal = criminalDatabase.getCriminals().get(criminalNames.getSelectedIndex());
        if (!criminals.contains(criminal)) {
            criminals.add(criminal);
        }
        setVisible(false);
    }
}
