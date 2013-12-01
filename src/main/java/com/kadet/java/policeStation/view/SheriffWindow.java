package com.kadet.java.policeStation.view;

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

    private ResumeDatabaseWindow resumeDatabaseWindow;
    private PolicemenDatabaseWindow policemenDatabaseWindow;

    public SheriffWindow(JFrame frame) {
        super(frame);
    }

    public void openPolicemenDatabaseWindow () {

    }

    public void openResumeDatabaseWindow () {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
