package com.kadet.java.policeStation.view.criminalCase;

import com.kadet.java.policeStation.entity.CriminalCase;
import com.kadet.java.policeStation.view.AbstractWindow;
import com.kadet.java.swing.textfields.editableLabel.EditableLabel;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public class CriminalCaseWindow extends AbstractWindow{

    private EditableLabel description;

    private JLabel criminals;
    private JLabel lastChange;

    private CriminalCase criminalCase;

    public CriminalCaseWindow(Window parent, CriminalCase criminalCase) {
        super(parent);
        this.criminalCase = criminalCase;
    }

    @Override
    protected void initializeComponents() {

        description = new EditableLabel(this) {
            @Override
            protected void editObject(Object editableObject, String editedText) {
                CriminalCase criminalCase = (CriminalCase)editableObject;
                criminalCase.setDescription(editedText);
                criminalCase.setLastChange(new Date());
            }
        };

        criminals = new JLabel();

        lastChange = new JLabel();
    }

    @Override
    protected void addComponents() {
        add(description);

        add(criminals);

        add(lastChange);
    }


    public void updateComponents () {

        description.setEditableObject(criminalCase);
        description.setText(criminalCase.getDescription());

        criminals.setText(criminalCase.getCriminals().toString());

        lastChange.setText(criminalCase.getLastChange().toString());
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
