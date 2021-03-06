package com.kadet.java.policeStation.view.criminal;

import com.kadet.java.policeStation.entity.Criminal;
import com.kadet.java.swing.textfields.editableLabel.EditableLabel;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 */
public class CriminalWindow extends JDialog {

    private final static int WIDTH = 800;
    private final static int HEIGHT = 800;

    private Criminal criminal;
    private EditableLabel fioLabel;
    private JLabel criminalInfo;

    public CriminalWindow(Window parent, Criminal criminal) {
        super(parent);
        this.criminal = criminal;
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
                Criminal criminal = (Criminal)editableObject;
                criminal.setFio(editedText);
            }
        };

        criminalInfo = new JLabel();
    }

    private void addComponents () {
        add(fioLabel);

        add(criminalInfo);
    }

    public void updateComponents () {

        fioLabel.setText(criminal.getFio());
        fioLabel.setEditableObject(criminal);

        criminalInfo.setText(criminal.toString());
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
