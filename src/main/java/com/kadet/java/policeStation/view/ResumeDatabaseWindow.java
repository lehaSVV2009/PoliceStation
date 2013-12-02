package com.kadet.java.policeStation.view;

import com.kadet.java.swing.pagination.PaginationPanel;
import com.kadet.java.swing.pagination.ResumeDatabaseClickPage;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public class ResumeDatabaseWindow extends AbstractWindow {

    private PaginationPanel paginationPanel;
    private final int itemsPerPage = 4;

    public ResumeDatabaseWindow(Window parent) {
        super(parent);
    }

    @Override
    protected void initializeComponents() {
        this.paginationPanel = new PaginationPanel(this, itemsPerPage);
    }

    private void removeComponents () {
        remove(paginationPanel);
    }

    @Override
    protected void addComponents() {
        add(paginationPanel);
    }

    public void updateComponents () {
        removeComponents();
        paginationPanel.setClickPageStrategy(
                new ResumeDatabaseClickPage(paginationPanel)
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
