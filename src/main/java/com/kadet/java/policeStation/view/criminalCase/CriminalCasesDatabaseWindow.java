package com.kadet.java.policeStation.view.criminalCase;

import com.kadet.java.policeStation.view.AbstractWindow;
import com.kadet.java.swing.pagination.CriminalCaseDatabaseClickPage;
import com.kadet.java.swing.pagination.PaginationPanel;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
public class CriminalCasesDatabaseWindow extends AbstractWindow {

    private final int itemsPerPage = 4;
    private PaginationPanel paginationPanel;

    public CriminalCasesDatabaseWindow(Window window) {
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
                new CriminalCaseDatabaseClickPage(paginationPanel)
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
