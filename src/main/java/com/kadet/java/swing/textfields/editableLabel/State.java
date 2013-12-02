package com.kadet.java.swing.textfields.editableLabel;

/**
 * Date: 01.12.13
 * Time: 12:09
 *
 * @author Кадет
 */
public interface State {

    public void executeChanges();
    public void removeComponents ();
    public void addComponents ();
    public void updateComponents ();

}
