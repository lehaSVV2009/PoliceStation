package com.kadet.java.swing.textfields.editableLabel;

/**
 * Date: 01.12.13
 * Time: 12:40
 *
 * @author Кадет
 */
public class LabelState implements State {

    private EditableLabel editableLabel;

    public LabelState(EditableLabel editableLabel) {
        this.editableLabel = editableLabel;
    }

    @Override
    public void executeChanges() {
        removeComponents();
        editableLabel.setState(
                editableLabel.getTextFieldState());
        editableLabel.updateTextFieldComponents();
        addComponents();
        editableLabel.updateOwner();
    }

    @Override
    public void removeComponents() {
        editableLabel.removeLabel();
    }

    @Override
    public void addComponents() {
        editableLabel.addTextFieldComponents();
    }

    @Override
    public void updateComponents() {
        editableLabel.updateLabel();
        editableLabel.updateOwner();
    }
}
