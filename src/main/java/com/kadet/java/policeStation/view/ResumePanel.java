package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.database.PolicemanDatabase;
import com.kadet.java.policeStation.database.ResumeDatabase;
import com.kadet.java.policeStation.entity.Policeman;
import com.kadet.java.policeStation.entity.Resume;
import com.kadet.java.policeStation.entity.Status;
import com.kadet.java.policeStation.model.LoginGenerator;
import com.kadet.java.policeStation.model.MessageGenerator;
import com.kadet.java.policeStation.model.MessageSender;
import com.kadet.java.policeStation.util.Messages;
import com.kadet.java.policeStation.util.SexUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Date: 01.12.13
 * Time: 20:40
 *
 * @author Кадет
 */
public class ResumePanel extends AbstractPanel implements ActionListener {

    private LoginGenerator loginGenerator;
    private MessageGenerator messageGenerator;
    private MessageSender messageSender;

    private ResumeDatabase resumeDatabase = ResumeDatabase.getInstance();
    private PolicemanDatabase policemanDatabase = PolicemanDatabase.getInstance();
    private Resume resume;

    private JLabel fioLabel;
    private JLabel birthdayLabel;
    private JLabel emailLabel;
    private JLabel sexLabel;

    private JButton acceptButton;
    private JButton rejectButton;

    public ResumePanel(Window owner, Resume resume) {
        super(owner);
        this.resume = resume;
        updateComponents();
    }

    protected void initializeComponents () {
        loginGenerator = new LoginGenerator();
        messageGenerator = new MessageGenerator();
        messageSender = new MessageSender();

        fioLabel = new JLabel();
        birthdayLabel = new JLabel();
        emailLabel = new JLabel();
        sexLabel = new JLabel();

        acceptButton = new JButton(Messages.ACCEPT_BUTTON);
        acceptButton.addActionListener(this);

        rejectButton = new JButton(Messages.REJECT_BUTTON);
        rejectButton.addActionListener(this);
    }

    protected void addComponents () {
        add(fioLabel);
        add(birthdayLabel);
        add(emailLabel);
        add(sexLabel);

        add(acceptButton);
        add(rejectButton);
    }

    protected void updateComponents () {
        fioLabel.setText(resume.getName());
        birthdayLabel.setText(resume.getBirthday().toString());
        emailLabel.setText(resume.getEmail());
        sexLabel.setText(
                SexUtil.getSexFromBoolean(resume.isMan()));
    }

    private void removeResumeFromDatabase (Resume resume) {
        resumeDatabase.removeResume(resume);
    }

    public void acceptResume (Resume resume) {
        removeResumeFromDatabase(resume);
        Policeman policeman
                = transformResumeToPoliceman(resume);
        policemanDatabase.addPoliceman(policeman);
        sendMessageToEmail(
                messageGenerator.generateSuccessGettingJobMessage(
                        policeman.getFio(),
                        policeman.getLogin(),
                        policeman.getPassword()
                ),
                resume.getEmail()
        );
        updateOwner();
    }

    public void rejectResume (Resume resume) {
        removeResumeFromDatabase(resume);
        sendMessageToEmail(
                messageGenerator.generateFailedGettingJobMessage(
                        resume.getName()
                ),
                resume.getEmail()
        );
        updateOwner();
    }


    private Policeman transformResumeToPoliceman(Resume resume) {
        Policeman policeman = new Policeman(
                Status.YOUNG,
                resume.getName(),
                resume.getEmail(),
                resume.getBirthday(),
                resume.isMan(),
                loginGenerator.generateLogin(resume.getName()),
                loginGenerator.generatePassword()
        );
        return policeman;
    }

    private void sendMessageToEmail(String message, String email) {
        boolean status = messageSender.sendMessageToEmail(
                message,
                email,
                Messages.GETTING_THE_JOB_TOPIC
        );
        showMessage(status ? Messages.SEND_MESSAGE_SUCCESS : Messages.SEND_MESSAGE_ERROR);
    }

    private void showMessage (String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == acceptButton) {
            acceptResume(resume);
        } else if (source == rejectButton) {
            rejectResume(resume);
        }
    }
}
