package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.database.ResumeDatabase;
import com.kadet.java.policeStation.entity.Resume;
import com.kadet.java.policeStation.util.*;
import com.kadet.java.swing.textfields.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 */
public class AddingResumeWindow extends JDialog implements ActionListener {

    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;

    private final static int DEFAULT_TEXTFIELD_LENGTH = 20;

    private HintTextField fioTextField;

    private HintTextField emailTextField;

    private BirthdayPanel birthdayPanel;

    private SexPanel sexPanel;

    private JButton getJobButton;

    private ResumeDatabase resumeDatabase = ResumeDatabase.getInstance();

    public AddingResumeWindow(JFrame parent) {
        super(parent);
        initialize();
        initializeComponents();
        addComponents();
    }

    private void initialize() {
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }

    private void initializeComponents() {

        fioTextField = new HintTextField(DEFAULT_TEXTFIELD_LENGTH, Messages.FIO_LABEL);

        emailTextField = new HintTextField(DEFAULT_TEXTFIELD_LENGTH, Messages.EMAIL_LABEL);

        birthdayPanel = new BirthdayPanel(this, Messages.BIRTHDAY_LABEL);

        sexPanel = new SexPanel(this, Messages.SEX_LABEL);

        getJobButton = new JButton(Messages.GET_JOB_BUTTON);
        getJobButton.addActionListener(this);
    }


    private void addComponents() {
        addFIOPanel();
        addEmailPanel();
        addBirthdayPanel();
        addSexPanel();
        addGetJobPanel();
    }

    private void addFIOPanel() {
        JPanel fioPanel = new JPanel();
        fioPanel.add(fioTextField);
        add(fioPanel);
    }

    private void addEmailPanel () {
        JPanel emailPanel = new JPanel();
        emailPanel.add(emailTextField);
        add(emailPanel);
    }

    private void addBirthdayPanel() {
        add(birthdayPanel);
    }

    private void addSexPanel() {
        add(sexPanel);
    }

    private void addGetJobPanel() {
        JPanel getJobPanel = new JPanel();
        getJobPanel.add(getJobButton);
        add(getJobPanel);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b == false) {
            getParent().setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == getJobButton) {
            sendResume();
            JOptionPane.showMessageDialog(getParent(), Messages.RESUME_SEND_SUCCESS);
            setVisible(false);
        }
    }

    private void sendResume () {
        Resume resume = createResume();
        resumeDatabase.addResume(resume);
    }

    private Resume createResume () {
        Date birthday = birthdayPanel.getBirthday();
        Resume resume = new Resume(
                fioTextField.getText(),
                emailTextField.getText(),
                birthday,
                sexPanel.getSex()
        );
        return resume;
    }
}
