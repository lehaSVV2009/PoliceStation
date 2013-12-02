package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.entity.Policeman;
import com.kadet.java.policeStation.util.Messages;
import com.kadet.java.swing.textfields.editableLabel.EditableLabel;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 25.11.13
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
public class AccountSettingsWindow extends JDialog {

    private final static int WIDTH = 800;
    private final static int HEIGHT = 800;

    private Policeman policeman;

    private EditableLabel fioLabel;
    private EditableLabel emailLabel;
    private JLabel birthdayLabel;
    private JLabel statusLabel;
    private JLabel sexLabel;
    private JLabel loginLabel;
    private EditableLabel passwordLabel;

    public AccountSettingsWindow(JDialog parent) {
        super(parent);
        initialize();
        initializeComponents();
        addComponents();
    }

    private void initialize () {
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new FlowLayout());
    }

    private void initializeComponents () {
        fioLabel = new EditableLabel(this) {
            @Override
            protected void editObject(Object editableObject, String editedText) {
                ((Policeman)editableObject).setFio(editedText);
            }
        };
        emailLabel = new EditableLabel(this) {
            @Override
            protected void editObject(Object editableObject, String editedText) {
                ((Policeman)editableObject).setEmail(editedText);
            }
        };
        birthdayLabel = new JLabel();
        statusLabel = new JLabel();
        sexLabel = new JLabel();
        loginLabel = new JLabel();
        passwordLabel = new EditableLabel(this) {
            @Override
            protected void editObject(Object editableObject, String editedText) {
                ((Policeman)editableObject).setPassword(editedText);
            }
        };
    }

    private void addComponents () {
        add(fioLabel);
        add(emailLabel);
        add(birthdayLabel);
        add(statusLabel);
        add(sexLabel);
        add(loginLabel);
        add(passwordLabel);
    }

    private void updateComponents () {
        if (policeman != null) {
            fioLabel.setEditableObject(policeman);
            fioLabel.setText(policeman.getFio());

            emailLabel.setEditableObject(policeman);
            emailLabel.setText(policeman.getEmail());

            birthdayLabel.setText(policeman.getBirthday().toString());

            statusLabel.setText(policeman.getStatus().toString());

            sexLabel.setText(policeman.isMale() ? Messages.SEX[0] : Messages.SEX[1]);

            loginLabel.setText(policeman.getLogin());

            passwordLabel.setEditableObject(policeman);
            passwordLabel.setText(policeman.getPassword());
        }
    }

    public void setPoliceman(Policeman policeman) {
        this.policeman = policeman;
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
}
