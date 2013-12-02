package com.kadet.java.policeStation.view;

import javax.swing.*;
import java.awt.*;

/**
 * Date: 02.12.13
 * Time: 1:42
 *
 * @author Кадет
 */
public abstract class AbstractPanel extends JPanel {

    private Window owner;

    public AbstractPanel(Window owner) {
        this.owner = owner;
        initialize();
        initializeComponents();
        addComponents();
    }

    protected void initialize () {
        setLayout(new FlowLayout());
    }

    abstract protected void initializeComponents ();

    abstract protected void addComponents ();

    abstract protected void updateComponents ();

    protected void updateOwner() {
        owner.setVisible(true);
        owner.revalidate();
        owner.repaint();
    }


}
