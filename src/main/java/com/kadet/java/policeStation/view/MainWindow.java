package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.database.PolicemanDatabase;
import com.kadet.java.policeStation.entity.Sheriff;
import com.kadet.java.policeStation.entity.Policeman;
import com.kadet.java.policeStation.model.LoginGenerator;
import com.kadet.java.policeStation.model.MessageGenerator;
import com.kadet.java.policeStation.model.MessageSender;
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

    private PolicemanDatabase policemanDatabase = PolicemanDatabase.getInstance();

    private PolicemanWindow policemanWindow;
    private SheriffWindow sheriffWindow;
    private AddingResumeWindow addingResumeWindow;

    private HintTextField loginTextfield;
    private HintTextField passwordTextfield;
    private JButton logInButton;

    private JButton getJobButton;

    private JButton forgetPassword;

    private LoginGenerator loginGenerator;
    private MessageGenerator messageGenerator;
    private MessageSender messageSender;

    public MainWindow() throws HeadlessException {
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
        initializeForgetPasswordComponents();
        initializeRegistrationComponents();
        initializeSubWindows();

        this.loginGenerator = new LoginGenerator();
        this.messageGenerator = new MessageGenerator();
        this.messageSender = new MessageSender();
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

    private void initializeForgetPasswordComponents () {
        forgetPassword = new JButton(Messages.FORGET_PASSWORD_BUTTON);
        forgetPassword.addActionListener(this);
    }

    private void initializeSubWindows () {
        this.addingResumeWindow = new AddingResumeWindow(this);
        this.policemanWindow = new PolicemanWindow(this);
        this.sheriffWindow = new SheriffWindow(this);
    }

    private void addComponents () {
        addLogInPanel();
        addGetJobPanel();
        addForgetPasswordPanel();
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

    private void addForgetPasswordPanel () {
        JPanel forgetPasswordPanel = new JPanel();
        forgetPasswordPanel.add(forgetPassword);
        add(forgetPasswordPanel, BorderLayout.SOUTH);
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
            setVisible(false);
            sheriffWindow.setPoliceman(enteredPoliceman);
            sheriffWindow.setVisible(true);
        } else {
            setVisible(false);
            policemanWindow.setPoliceman(enteredPoliceman);
            policemanWindow.setVisible(true);
        }
    }

    public void forgetPassword (String email) {
        List<Policeman> policemen
                = policemanDatabase.getPolicemen();
        for (Policeman policeman : policemen) {
            if (email.equals(policeman.getEmail())) {
                sendForgetPasswordMessage(policeman);
                return;
            }
        }
        showMessage(Messages.THERE_ARE_NO_SUCH_POLICEMAN);
    }

    private String generateForgetPasswordMessage (String name, String login, String newPassword)  {
        return
            messageGenerator.generateForgetPasswordMessage(
                name,
                login,
                newPassword
            );
    }


    private void sendForgetPasswordMessage (Policeman policeman) {
        String newPassword = loginGenerator.generatePassword();
        boolean status = messageSender.sendMessageToEmail(
                generateForgetPasswordMessage(policeman.getFio(), policeman.getLogin(), newPassword),
                policeman.getEmail(),
                Messages.NEW_PASSWORD_TOPIC
        );
        if (status) {
            policeman.setPassword(newPassword);
            showMessage(Messages.LOGIN_AND_PASSWORD_ARE_SEND_SUCCESS);
        } else {
            showMessage(Messages.LOGIN_AND_PASSWORD_ARE_SEND_ERROR);
        }
    }

    public void getJob () {
        this.setVisible(false);
        addingResumeWindow.setVisible(true);
    }

    private void showMessage (String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void openInputEmailDialog () {
        String email = JOptionPane.showInputDialog(this, Messages.INPUT_YOUR_EMAIL);
        if (email == null || "".equals(email) || email.contains(" ")) {
            showMessage(Messages.BAD_INPUT_DATE);
            return;
        }
        forgetPassword(email);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == getJobButton) {

            getJob();

        } else if (source == logInButton) {

            String login = loginTextfield.getText();
            String password = passwordTextfield.getText();
            logIn(login, password);

        } else if (source == forgetPassword) {

            openInputEmailDialog();

        }
    }

}
