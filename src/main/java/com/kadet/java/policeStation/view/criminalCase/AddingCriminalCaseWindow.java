package com.kadet.java.policeStation.view.criminalCase;

import com.kadet.java.policeStation.database.CriminalCaseDatabase;
import com.kadet.java.policeStation.entity.Criminal;
import com.kadet.java.policeStation.entity.CriminalCase;
import com.kadet.java.swing.textfields.HintTextField;
import com.kadet.java.policeStation.util.Messages;
import com.kadet.java.policeStation.view.AbstractWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public class AddingCriminalCaseWindow extends AbstractWindow implements ActionListener {

    private final static int DEFAULT_TEXTFIELD_LENGTH = 30;

    private HintTextField descriptionTextField;

    private List<Criminal> criminals;
    private List<JLabel> criminalNames;
    private JButton addCriminalButton;

    private JButton addCriminalCaseButton;

    private boolean isAddCriminal = false;

    private AddCriminalToCriminalCaseDialog addCriminalToCriminalCaseDialog;

    private CriminalCaseDatabase criminalCaseDatabase = CriminalCaseDatabase.getInstance();

    public AddingCriminalCaseWindow(Window parent) {
        super(parent);
    }

    @Override
    protected void initializeComponents() {
        this.descriptionTextField = new HintTextField(DEFAULT_TEXTFIELD_LENGTH, Messages.DESCRIPTION_LABEL);

        this.criminalNames = new ArrayList<JLabel>();
        this.criminals = new ArrayList<Criminal>();

        this.addCriminalButton = new JButton(Messages.ADD_CRIMINAL_TO_CRIMINAL_CASE_BUTTON);
        addCriminalButton.addActionListener(this);

        this.addCriminalCaseButton = new JButton(Messages.ADD_CRIMINAL_CASE_BUTTON);
        addCriminalCaseButton.addActionListener(this);

        this.addCriminalToCriminalCaseDialog = new AddCriminalToCriminalCaseDialog(this, criminals);
    }

    @Override
    protected void addComponents() {
        add(descriptionTextField);

        for (JLabel criminalName : criminalNames) {
            add(criminalName);
        }

        add(addCriminalButton);

        add(addCriminalCaseButton);
    }

    private void removeComponents () {
        remove(descriptionTextField);
        for (JLabel criminalName : criminalNames) {
            remove(criminalName);
        }
        remove(addCriminalButton);

        remove(addCriminalCaseButton);
    }

    private void clearCriminalNames () {
        criminalNames.clear();
    }

    public void updateComponents() {

        removeComponents();
        clearCriminalNames();

        for (Criminal criminal : criminals) {
            criminalNames.add(
                    new JLabel(criminal.getFio()));
        }

        addComponents();
    }

    @Override
    public void setVisible(boolean b) {
        isAddCriminal = false;
        if (b == true) {
            updateComponents();
        }
        super.setVisible(b);
        if (b == false && !isAddCriminal) {
            getParent().setVisible(true);
        }
    }

    private CriminalCase createCriminalCase () {
        CriminalCase criminalCase = new CriminalCase(
                criminals,
                descriptionTextField.getText(),
                new Date()
        );
        for (Criminal criminal : criminals) {
            criminal.addCriminalCase(criminalCase);
        }
        return criminalCase;
    }

    private void addCriminalCase (CriminalCase criminalCase) {
        criminalCaseDatabase.addCriminalCase(criminalCase);
    }

    private void openAddCriminalToCriminalCaseDialog () {
        isAddCriminal = true;
        setVisible(false);
        addCriminalToCriminalCaseDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addCriminalButton) {

            openAddCriminalToCriminalCaseDialog();

        } else if (source == addCriminalCaseButton) {

            CriminalCase criminalCase
                    = createCriminalCase();
            addCriminalCase(criminalCase);
            JOptionPane.showMessageDialog(this, Messages.ADD_CRIMINAL_CASE_SUCCESS);
            setVisible(false);

        }
    }

}
