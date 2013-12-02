package com.kadet.java.policeStation.view.criminal;

import com.kadet.java.policeStation.entity.Criminal;
import com.kadet.java.policeStation.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 27.11.13
 * Time: 9:57
 * To change this template use File | Settings | File Templates.
 */
public class CriminalPanel extends JPanel implements ActionListener{

    private Window owner;

    private JLabel shortCriminalInfo;
    private JButton moreInfoButton;

    private Criminal criminal;
    private CriminalWindow criminalWindow;

    public CriminalPanel(Window owner, Criminal criminal) {
        this.owner = owner;
        this.criminal = criminal;
        initialize();
        initializeComponents();
        addComponents();
        updateComponents();
    }

    private void initialize () {
        setLayout(new FlowLayout());
    }

    private void initializeComponents () {
        this.shortCriminalInfo = new JLabel();

        this.moreInfoButton = new JButton(Messages.MORE_BUTTON);
        moreInfoButton.addActionListener(this);

        this.criminalWindow = new CriminalWindow(owner, criminal);
    }

    private void addComponents () {
        add(shortCriminalInfo);
        add(moreInfoButton);
    }

    public void updateComponents () {
        shortCriminalInfo.setText(criminal.toString());
    }

    public void openCriminalWindow () {
        criminalWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == moreInfoButton) {
            openCriminalWindow();
        }
    }


}
