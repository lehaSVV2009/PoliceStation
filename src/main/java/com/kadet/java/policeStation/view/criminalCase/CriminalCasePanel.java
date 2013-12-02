package com.kadet.java.policeStation.view.criminalCase;

import com.kadet.java.policeStation.entity.CriminalCase;
import com.kadet.java.policeStation.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Date: 28.11.13
 * Time: 21:32
 *
 * @author Кадет
 */
public class CriminalCasePanel extends JPanel implements ActionListener{

    private Window owner;

    private JLabel shortCriminalInfo;
    private JButton moreInfoButton;

    private CriminalCase criminalCase;
    private CriminalCaseWindow criminalCaseWindow;

    public CriminalCasePanel(Window owner, CriminalCase criminalCase) {
        this.owner = owner;
        this.criminalCase = criminalCase;
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

        this.criminalCaseWindow = new CriminalCaseWindow(owner, criminalCase);
    }

    private void addComponents () {
        add(shortCriminalInfo);
        add(moreInfoButton);
    }

    public void updateComponents () {
        shortCriminalInfo.setText(criminalCase.toString());
    }

    public void openCriminalWindow () {
        criminalCaseWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == moreInfoButton) {
            openCriminalWindow();
        }
    }

}
