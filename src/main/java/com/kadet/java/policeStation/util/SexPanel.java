package com.kadet.java.policeStation.util;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 28.11.13
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 */
public class SexPanel extends JPanel {

    private Window parent;

    private String labelText;
    private JLabel sexLabel;

    private JComboBox<String> sex;

    public SexPanel(Window parent, String labelText) {
        this.labelText = labelText;
        this.parent = parent;
        initialize();
        initializeComponents();
        addComponents();
    }

    private void initialize() {
        setLayout(new FlowLayout());
    }

    private void initializeComponents() {
        sexLabel = new JLabel(Messages.SEX_LABEL);
        sex = new JComboBox<String>(Messages.SEX);
    }


    private void addComponents() {
        add(sexLabel);
        add(sex);
    }

    public boolean getSex () {
        return sex.getSelectedIndex() == 0 ? true : false;
    }
}
