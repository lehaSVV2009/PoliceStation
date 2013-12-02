package com.kadet.java.swing.pagination;

import com.kadet.java.policeStation.database.CriminalDatabase;
import com.kadet.java.policeStation.model.EntitiesToViewConverter;

/**
 * Date: 02.12.13
 * Time: 15:09
 *
 * @author Кадет
 */
public class CriminalDatabaseClickPage implements ClickPageStrategy {

    private PaginationPanel paginationPanel;

    private CriminalDatabase criminalDatabase = CriminalDatabase.getInstance();

    public CriminalDatabaseClickPage(PaginationPanel paginationPanel) {
        this.paginationPanel = paginationPanel;
    }

    @Override
    public void clickPage(int currentPage, int itemsPerPage) {

        paginationPanel.updateComponents(
                criminalDatabase.getCriminalsNumber(),
                itemsPerPage,
                currentPage,
                EntitiesToViewConverter.getCriminalPanelsFromCriminal(
                        criminalDatabase.subList(
                                (currentPage - 1) * itemsPerPage,
                                currentPage * itemsPerPage),
                        paginationPanel.getOwner()
                )
        );

    }
}
