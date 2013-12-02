package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.entity.Sheriff;
import com.kadet.java.swing.pagination.PolicemenDatabaseClickPage;
import com.kadet.java.swing.pagination.PaginationPanel;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:12
 * To change this template use File | Settings | File Templates.
 */
public class PolicemenDatabaseWindow extends AbstractWindow {

    private final int itemsPerPage = 4;
    private PaginationPanel paginationPanel;

    private Sheriff currentSheriff;

    public PolicemenDatabaseWindow(Window parent) {
        super(parent);
        updateComponents();
    }

    @Override
    protected void initializeComponents() {

        this.paginationPanel = new PaginationPanel(this, itemsPerPage);
    }

    private void removeComponents() {
        remove(paginationPanel);
    }

    @Override
    protected void addComponents() {
        add(paginationPanel);
    }

    public void updateComponents() {
        removeComponents();

        paginationPanel.setClickPageStrategy(
                new PolicemenDatabaseClickPage(currentSheriff, paginationPanel)
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

    public void setCurrentSheriff(Sheriff currentSheriff) {
        this.currentSheriff = currentSheriff;
    }
}
