package com.kadet.java.swing.textfields;

import com.kadet.java.policeStation.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Date: 01.12.13
 * Time: 11:55
 *
 * @author Кадет
 */
public abstract class EditableLabel extends JPanel implements MouseListener, ActionListener{

    private Window owner;

    private Object editableObject;

    private State labelState;
    private State textFieldState;

    private State state;

    private String labelText;
    private JLabel label;

    private static final int DEFAULT_TEXTFIELD_LENGTH = 30;
    private JTextField textField;

    private JButton saveChangesButton;

    public EditableLabel(Window owner, String text, Object editableObject) {
        this.editableObject = editableObject;
        this.owner = owner;
        this.labelText = text;
        initialize();
        initializeComponents();
        addStartComponents();
    }

    private void initialize () {
        setLayout(new FlowLayout());
    }

    private void initializeComponents () {

        this.label = new JLabel();
        label.addMouseListener(this);
        label.setText(labelText);

        this.textField = new JTextField(DEFAULT_TEXTFIELD_LENGTH);

        this.saveChangesButton = new JButton(Messages.SAVE_CHANGES);
        saveChangesButton.addActionListener(this);


        this.labelState = new LabelState(this);
        this.textFieldState = new TextFieldState(this);

        this.state = labelState;

    }

    private void addStartComponents() {
        add(label);
    }

    public void updateComponents () {
        state.updateComponents();
    }

    public void removeTextFieldComponents () {
        remove(textField);
        remove(saveChangesButton);
    }

    public void removeLabel () {
        remove(label);
    }

    public void updateLabelText () {
        this.labelText = textField.getText();
    }

    public void updateLabel () {
        label.setText(labelText);
    }

    public void updateTextFieldComponents () {
        textField.setText(labelText);
    }

    public void addLabel () {
        add(label);
    }

    public void addTextFieldComponents  () {
        add(textField);
        add(saveChangesButton);
    }

    public void updateOwner () {
        owner.revalidate();
        owner.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            updateComponents();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    abstract protected void editObject (Object editableObject, String editedText);

    @Override
    public void actionPerformed(ActionEvent e) {
        editObject(
                editableObject,
                textField.getText()
        );
        updateComponents();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getLabelState() {
        return labelState;
    }

    public State getTextFieldState() {
        return textFieldState;
    }
}
