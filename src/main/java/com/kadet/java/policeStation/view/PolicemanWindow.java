package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.database.CriminalCaseDatabase;
import com.kadet.java.policeStation.database.PolicemanDatabase;
import com.kadet.java.policeStation.entity.CriminalCase;
import com.kadet.java.policeStation.entity.Policeman;
import com.kadet.java.policeStation.util.DataStrings;
import com.kadet.java.policeStation.util.Messages;
import com.kadet.java.policeStation.view.criminalCase.AddingCriminalCaseWindow;
import com.kadet.java.policeStation.view.criminal.AddingCriminalWindow;
import com.kadet.java.policeStation.view.criminal.CriminalsDatabaseWindow;
import com.kadet.java.policeStation.view.criminalCase.CriminalCasesDatabaseWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
public class PolicemanWindow extends AbstractWindow implements ActionListener{


    protected Policeman policeman;

    /**
     * Окно просмотра данных полицейского
     */
    private AccountSettingsWindow accountSettingsInfo;

    /**
     * Окно просмотра базы преступников
     */
    private CriminalsDatabaseWindow criminalsWindow;

    /**
     * Окно просмотра базы уголовных дел
     */
    private CriminalCasesDatabaseWindow criminalCasesWindow;

    /**
     * Окно создания уголовного дела
     */
    private AddingCriminalCaseWindow addingCriminalCaseWindow;

    /**
     * Окно добваления нового преступника
     */
    private AddingCriminalWindow addingCriminalWindow;

    private boolean isNotExit = false;

    private JButton accountSettingsButton;
    private JButton criminalsDatabaseButton;
    private JButton criminalCasesDatabaseButton;
    private JButton resignButton;
    private JButton createCriminalCaseButton;
    private JButton addCriminalButton;

    private JPanel criminalCasesPanel;
    private List<JTextArea> criminalCasesTextAreas;


    private CriminalCaseDatabase criminalCaseDatabase = CriminalCaseDatabase.getInstance();
    private PolicemanDatabase policemanDatabase = PolicemanDatabase.getInstance();

    public PolicemanWindow(Window window) {
        super(window);
    }

    protected void initializeComponents () {

        this.accountSettingsButton
                = new JButton(Messages.ACCOUNT_SETTINGS_BUTTON);
        accountSettingsButton.addActionListener(this);

        this.criminalsDatabaseButton
                = new JButton(Messages.CRIMINALS_DATABASE_BUTTON);
        criminalsDatabaseButton.addActionListener(this);

        this.criminalCasesDatabaseButton
                = new JButton(Messages.CRIMINAL_CASES_DATABASE_BUTTON);
        criminalCasesDatabaseButton.addActionListener(this);

        this.resignButton
                = new JButton(Messages.RESIGN_BUTTON);
        resignButton.addActionListener(this);

        this.createCriminalCaseButton
                = new JButton(Messages.CREATE_CRIMINAL_CASE_BUTTON);
        createCriminalCaseButton.addActionListener(this);

        this.addCriminalButton
                = new JButton(Messages.ADD_CRIMINAL_BUTTON);
        addCriminalButton.addActionListener(this);

        this.criminalCasesPanel = new JPanel();
        this.criminalCasesTextAreas = new ArrayList<JTextArea>();


        this.accountSettingsInfo = new AccountSettingsWindow(this);

        this.criminalsWindow = new CriminalsDatabaseWindow(this);

        this.criminalCasesWindow = new CriminalCasesDatabaseWindow(this);

        this.addingCriminalWindow = new AddingCriminalWindow(this);

        this.addingCriminalCaseWindow = new AddingCriminalCaseWindow(this);
    }

    protected void removeComponents () {
        remove(accountSettingsButton);
        remove(criminalsDatabaseButton);
        remove(criminalCasesDatabaseButton);
        remove(resignButton);
        remove(createCriminalCaseButton);
        remove(addCriminalButton);
        remove(criminalCasesPanel);
        clearCriminalCasesTextAreas();
    }

    protected void clearCriminalCasesTextAreas () {
        while (criminalCasesTextAreas.size() != 0) {
            criminalCasesTextAreas.remove(0);
        }
    }

    protected void addComponents () {

        add(accountSettingsButton);
        add(criminalsDatabaseButton);
        add(criminalCasesDatabaseButton);
        add(resignButton);
        add(createCriminalCaseButton);
        add(addCriminalButton);

        criminalCasesPanel = new JPanel();
        for (JTextArea textArea : criminalCasesTextAreas) {
            criminalCasesPanel.add(textArea);
        }
        add(criminalCasesPanel);
    }

    public void updateComponents () {
        removeComponents();
        List<CriminalCase> lastCriminalCases
                = criminalCaseDatabase.getLastCriminalCases(DataStrings.MAX_CRIMINAL_CASES_VALUE);
        for (CriminalCase criminalCase : lastCriminalCases) {
            JTextArea textArea = new JTextArea(criminalCase.toString());
            criminalCasesTextAreas.add(textArea);
        }
        addComponents();
    }

    public void setPoliceman(Policeman policeman) {
        this.policeman = policeman;
    }

    public void openAccountSettingsWindow () {
        isNotExit = true;
        setVisible(false);
        accountSettingsInfo.setPoliceman(policeman);
        accountSettingsInfo.setVisible(true);
    }

    public void openAddingCriminalWindow () {
        isNotExit = true;
        setVisible(false);
        addingCriminalWindow.setVisible(true);
    }

    public void openCriminalsDatabaseWindow () {
        isNotExit = true;
        setVisible(false);
        criminalsWindow.setVisible(true);
    }

    public void openCriminalCaseDatabaseWindow () {
        isNotExit = true;
        setVisible(false);
        criminalCasesWindow.setVisible(true);
    }

    public void openAddCriminalCaseWindow () {
        isNotExit = true;
        setVisible(false);
        addingCriminalCaseWindow.setVisible(true);
    }

    public void resign () {
        boolean result = policemanDatabase.remove(policeman);
        isNotExit = false;
        if (result) {
            JOptionPane.showMessageDialog(this, Messages.RESIGN_SUCCESS);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, Messages.RESIGN_ERROR);
            setVisible(false);
        }
    }

    @Override
    public void setVisible(boolean b) {
        if (b == true) {
            updateComponents();
        }
        super.setVisible(b);
        if (b == false && !isNotExit) {
            getParent().setVisible(true);
        } else {
            isNotExit = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == accountSettingsButton) {

            openAccountSettingsWindow();

        } else if (source == criminalsDatabaseButton) {

            openCriminalsDatabaseWindow();

        } else if (source == criminalCasesDatabaseButton) {

            openCriminalCaseDatabaseWindow();

        } else if (source == resignButton) {

            resign();

        } else if (source == createCriminalCaseButton){

            openAddCriminalCaseWindow();

        } else if (source == addCriminalButton) {

            openAddingCriminalWindow();

        }
    }
}