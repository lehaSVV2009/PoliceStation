package com.kadet.java.policeStation.view.criminal;

import com.kadet.java.policeStation.database.CriminalDatabase;
import com.kadet.java.policeStation.entity.Criminal;
import com.kadet.java.policeStation.view.CriminalStatusPanel;
import com.kadet.java.swing.textfields.HintTextField;
import com.kadet.java.policeStation.util.Messages;
import com.kadet.java.policeStation.util.SexPanel;
import com.kadet.java.policeStation.view.AbstractWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
public class AddingCriminalWindow extends AbstractWindow implements ActionListener {

    private final static int DEFAULT_TEXTFIELD_LENGTH = 30;

    private HintTextField fioTextField;

    private SexPanel sexPanel;

    private CriminalStatusPanel criminalStatusPanel;

    private JButton addCriminalButton;

    private CriminalDatabase criminalDatabase = CriminalDatabase.getInstance();

    private CriminalWindow criminalWindow;

    private boolean isCriminalCreated;

    public AddingCriminalWindow(Window parent) {
        super(parent);
    }

    @Override
    protected void initializeComponents() {
        fioTextField = new HintTextField(DEFAULT_TEXTFIELD_LENGTH, Messages.FIO_LABEL);

        sexPanel = new SexPanel(this, Messages.SEX_LABEL);

        criminalStatusPanel = new CriminalStatusPanel(this, Messages.CRIMINAL_STATUS_LABEL);

        addCriminalButton = new JButton(Messages.ADD_CRIMINAL_BUTTON);
        addCriminalButton.addActionListener(this);
    }

    @Override
    protected void addComponents() {
        add(fioTextField);
        add(sexPanel);
        add(criminalStatusPanel);
        add(addCriminalButton);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b == false && !isCriminalCreated) {
            getParent().setVisible(true);
        }
    }

    private void addCriminal (Criminal criminal) {
        criminalDatabase.addCriminal(criminal);
    }

    private void openCriminalWindow (Criminal criminal) {
        isCriminalCreated = true;
        setVisible(false);
        criminalWindow = new CriminalWindow(getOwner(), criminal);
        criminalWindow.setVisible(true);
        isCriminalCreated = false;
    }

    private Criminal createCriminal () {
        Criminal criminal = new Criminal(
                fioTextField.getText(),
                new Date(),
                sexPanel.getSex(),
                criminalStatusPanel.getCriminalStatus()
        );
        return criminal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addCriminalButton) {
            Criminal criminal
                    = createCriminal();
            addCriminal(criminal);
            JOptionPane.showMessageDialog(this, Messages.ADD_CRIMINAL_SUCCESS);
            openCriminalWindow(criminal);
        }
    }
}
