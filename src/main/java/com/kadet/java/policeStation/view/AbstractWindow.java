package com.kadet.java.policeStation.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 27.11.13
 * Time: 13:34
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractWindow extends JDialog {

    private final static int WIDTH = 800;
    private final static int HEIGHT = 800;

    public AbstractWindow(Window parent) {
        super(parent);
        initalize();
        initializeComponents();
        addComponents();
    }

    protected void initalize () {
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }

    abstract protected void initializeComponents ();

    abstract protected void addComponents ();

    public void updateComponents () {

    }

}
