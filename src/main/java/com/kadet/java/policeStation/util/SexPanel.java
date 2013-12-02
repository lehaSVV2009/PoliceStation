package com.kadet.java.policeStation.util;

import com.kadet.java.policeStation.view.AbstractPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 28.11.13
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 */
public class SexPanel extends AbstractPanel {

    private String labelText;
    private JLabel sexLabel;

    private JComboBox<String> sex;

    public SexPanel(Window parent, String labelText) {
        super(parent);
        this.labelText = labelText;
        updateComponents();
    }

    protected void initialize() {
        setLayout(new FlowLayout());
    }

    protected void initializeComponents() {
        sexLabel = new JLabel();
        sex = new JComboBox<String>(Messages.SEX);
    }


    protected void addComponents() {
        add(sexLabel);
        add(sex);
    }

    @Override
    protected void updateComponents() {
        sexLabel.setText(labelText);
    }

    public boolean getSex () {
        return sex.getSelectedIndex() == 0 ? true : false;
    }
}
