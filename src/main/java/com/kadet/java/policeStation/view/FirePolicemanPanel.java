package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.database.PolicemanDatabase;
import com.kadet.java.policeStation.entity.Policeman;
import com.kadet.java.policeStation.util.Messages;
import com.kadet.java.policeStation.util.SexUtil;
import com.kadet.java.swing.textfields.editableLabel.EditableLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Date: 02.12.13
 * Time: 1:40
 *
 * @author Кадет
 */
public class FirePolicemanPanel extends AbstractPanel implements ActionListener {

    private Policeman policeman;

    private JLabel fioLabel;
    private JLabel birthdayLabel;
    private JLabel statusLabel;
    private JLabel sexLabel;
    private JLabel loginLabel;

    private JButton fireButton;

    private PolicemanDatabase policemanDatabase = PolicemanDatabase.getInstance();

    public FirePolicemanPanel(Window parent, Policeman policeman) {
        super(parent);
        this.policeman = policeman;
        updateComponents();
    }

    @Override
    protected void initializeComponents() {

        this.fioLabel = new JLabel();
        this.birthdayLabel = new JLabel();
        this.statusLabel = new JLabel();
        this.sexLabel = new JLabel();
        this.loginLabel = new JLabel();

        this.fireButton = new JButton(Messages.FIRE_POLICEMAN_BUTTON);
        fireButton.addActionListener(this);
    }

    @Override
    protected void addComponents() {
        add(fioLabel);
        add(birthdayLabel);
        add(statusLabel);
        add(sexLabel);
        add(loginLabel);

        add(fireButton);
    }

    @Override
    protected void updateComponents() {
        fioLabel.setText(policeman.getFio());

        birthdayLabel.setText(policeman.getBirthday().toString());

        statusLabel.setText(policeman.getStatus().name());

        sexLabel.setText(
                SexUtil.getSexFromBoolean(policeman.isMale()));

        loginLabel.setText(policeman.getLogin());
    }

    private boolean firePoliceman (Policeman policeman) {
        return policemanDatabase.remove(policeman);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (firePoliceman(policeman)) {
            JOptionPane.showMessageDialog(this, Messages.FIRE_POLICEMAN_SUCCESS);
            updateOwner();
        } else {
            JOptionPane.showMessageDialog(this, Messages.FIRE_POLICEMAN_FAILED);
        }
    }
}
