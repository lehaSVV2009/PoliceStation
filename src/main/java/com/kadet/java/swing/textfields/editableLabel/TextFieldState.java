package com.kadet.java.swing.textfields.editableLabel;

/**
 * Date: 01.12.13
 * Time: 12:40
 *
 * @author Кадет
 */
public class TextFieldState implements State {

    private EditableLabel editableLabel;

    public TextFieldState(EditableLabel editableLabel) {
        this.editableLabel = editableLabel;
    }

    @Override
    public void executeChanges() {
        removeComponents();
        editableLabel.setState(
                editableLabel.getLabelState()
        );
        editableLabel.updateLabelText();
        editableLabel.updateLabel();
        addComponents();
        editableLabel.updateOwner();
    }

    @Override
    public void removeComponents() {
        editableLabel.removeTextFieldComponents();
    }

    @Override
    public void addComponents() {
        editableLabel.addLabel();
    }

    @Override
    public void updateComponents() {
        editableLabel.updateTextFieldComponents();
        editableLabel.updateOwner();
    }
}
