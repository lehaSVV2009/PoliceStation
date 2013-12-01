package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.database.PolicemanDatabase;
import com.kadet.java.policeStation.database.ResumeDatabase;
import com.kadet.java.policeStation.entity.Sheriff;
import com.kadet.java.policeStation.entity.Policeman;
import com.kadet.java.swing.textfields.HintTextField;
import com.kadet.java.policeStation.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */
public class MainWindow extends JFrame implements ActionListener{


    private final static int WIDTH = 800;
    private final static int HEIGHT = 800;

    private final static int DEFAULT_TEXTFIELD_LENGTH = 20;

    private ResumeDatabase resumeDatabase;
    private PolicemanDatabase policemanDatabase;

    private PolicemanWindow policemanWindow;
    private SheriffWindow sheriffWindow;
    private AddingResumeWindow addingResumeWindow;

    private HintTextField loginTextfield;
    private HintTextField passwordTextfield;
    private JButton logInButton;

    private JButton getJobButton;

    public MainWindow(ResumeDatabase resumeDatabase, PolicemanDatabase policemanDatabase) throws HeadlessException {
        this.resumeDatabase = resumeDatabase;
        this.policemanDatabase = policemanDatabase;
        initialize();
        initializeComponents();
        addComponents();
    }

    private void initialize () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }

    private void initializeComponents () {
        initializeLogInComponents();
        initializeRegistrationComponents();
        initializeSubWindows();
    }

    private void initializeLogInComponents () {
        loginTextfield = new HintTextField(DEFAULT_TEXTFIELD_LENGTH, Messages.LOGIN_LABEL);
        passwordTextfield = new HintTextField(DEFAULT_TEXTFIELD_LENGTH, Messages.PASSWORD_LABEL);
        logInButton = new JButton(Messages.LOG_IN_BUTTON);
        logInButton.addActionListener(this);
    }

    private void initializeRegistrationComponents () {
        getJobButton = new JButton(Messages.GET_JOB_BUTTON);
        getJobButton.addActionListener(this);
    }

    private void initializeSubWindows () {
        this.addingResumeWindow = new AddingResumeWindow(this);
        this.policemanWindow = new PolicemanWindow(this);
    }

    private void addComponents () {
        addLogInPanel();
        addGetJobPanel();
    }

    /**
     * Adding to frame components for authorization
     */
    private void addLogInPanel () {
        JPanel logInPanel = new JPanel();
        logInPanel.add(loginTextfield);
        logInPanel.add(passwordTextfield);
        logInPanel.add(logInButton);
        add(logInPanel, BorderLayout.CENTER);
    }

    private void addGetJobPanel() {
        JPanel getJobPanel = new JPanel();
        getJobPanel.add(getJobButton);
        add(getJobPanel, BorderLayout.WEST);
    }


    public void logIn(String login, String password) {
        Policeman enteredPoliceman = null;
        List<Policeman> policemen = policemanDatabase.getPolicemen();
        for (Policeman policeman : policemen) {
            if (login.equals(policeman.getLogin())
                    && password.equals(policeman.getPassword())) {
                enteredPoliceman = policeman;
            }
        }
        if (enteredPoliceman == null) {
            showMessage(Messages.LOGIN_AND_PASSWORD_ARE_NOT_CORRECT);
        } else if (enteredPoliceman instanceof Sheriff){
            System.out.println("This is sheriff");
        } else {
            setVisible(false);
            policemanWindow.setPoliceman(enteredPoliceman);
            policemanWindow.setVisible(true);
        }
    }

    public void getJob () {
        this.setVisible(false);
        addingResumeWindow.setVisible(true);
    }

    private void showMessage (String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == getJobButton) {
            getJob();
        }
        if (source == logInButton) {
            String login = loginTextfield.getText();
            String password = passwordTextfield.getText();
            logIn(login, password);
        }
    }

}
