package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.entity.Sheriff;
import com.kadet.java.policeStation.util.Messages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:11
 * To change this template use File | Settings | File Templates.
 */
public class SheriffWindow extends PolicemanWindow implements ActionListener{

    private JButton resumeDatabaseButton;
    private JButton policemanDatabaseButton;

    private ResumeDatabaseWindow resumeDatabaseWindow;
    private PolicemenDatabaseWindow policemenDatabaseWindow;

    public SheriffWindow(JFrame frame) {
        super(frame);
    }

    protected void initialize () {
        super.initialize();
    }

    protected void initializeComponents () {
        super.initializeComponents();

        this.resumeDatabaseButton = new JButton(Messages.RESUME_DATABASE_BUTTON);
        resumeDatabaseButton.addActionListener(this);

        this.policemanDatabaseButton = new JButton(Messages.POLICEMEN_DATABASE_BUTTON);
        policemanDatabaseButton.addActionListener(this);

        this.resumeDatabaseWindow = new ResumeDatabaseWindow(this);

        this.policemenDatabaseWindow = new PolicemenDatabaseWindow(this);
    }

    protected void addComponents () {
        add(resumeDatabaseButton);
        add(policemanDatabaseButton);
        super.addComponents();
    }


    private void openPolicemenDatabaseWindow () {
        setVisible(false);
        policemenDatabaseWindow.setCurrentSheriff((Sheriff)policeman);
        policemenDatabaseWindow.setVisible(true);
    }

    public void openResumeDatabaseWindow () {
        setVisible(false);
        resumeDatabaseWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object source = e.getSource();
        if (source == resumeDatabaseButton) {

            openResumeDatabaseWindow();

        } else if (source == policemanDatabaseButton) {

            openPolicemenDatabaseWindow();

        }
    }
}
