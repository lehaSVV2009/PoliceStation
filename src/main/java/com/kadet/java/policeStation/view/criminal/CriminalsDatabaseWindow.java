package com.kadet.java.policeStation.view.criminal;

import com.kadet.java.policeStation.database.CriminalDatabase;
import com.kadet.java.policeStation.entity.Criminal;
import com.kadet.java.policeStation.view.AbstractWindow;
import com.kadet.java.swing.pagination.CriminalDatabaseClickPage;
import com.kadet.java.swing.pagination.PaginationPanel;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
public class CriminalsDatabaseWindow extends AbstractWindow {

    private final int itemsPerPage = 4;
    private PaginationPanel paginationPanel;


    public CriminalsDatabaseWindow(JDialog window) {
        super(window);
    }

    protected void initializeComponents () {
        this.paginationPanel = new PaginationPanel(this, itemsPerPage);
    }

    protected void addComponents () {
        add(paginationPanel);
    }

    private void removeComponents () {
        remove(paginationPanel);
    }

    public void updateComponents () {
        removeComponents();

        paginationPanel.setClickPageStrategy(
                new CriminalDatabaseClickPage(paginationPanel)
        );
        paginationPanel.clickPage(PaginationPanel.START_PAGE, itemsPerPage);

        addComponents();
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
