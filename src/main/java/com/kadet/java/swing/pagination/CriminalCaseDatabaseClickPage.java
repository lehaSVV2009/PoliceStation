package com.kadet.java.swing.pagination;

import com.kadet.java.policeStation.database.CriminalCaseDatabase;
import com.kadet.java.policeStation.model.EntitiesToViewConverter;

/**
 * Date: 02.12.13
 * Time: 15:09
 *
 * @author Кадет
 */
public class CriminalCaseDatabaseClickPage implements ClickPageStrategy {

    private PaginationPanel paginationPanel;

    private CriminalCaseDatabase criminalCaseDatabase = CriminalCaseDatabase.getInstance();

    public CriminalCaseDatabaseClickPage(PaginationPanel paginationPanel) {
        this.paginationPanel = paginationPanel;
    }

    @Override
    public void clickPage(int currentPage, int itemsPerPage) {

        paginationPanel.updateComponents(
                criminalCaseDatabase.getCriminalCasesNumber(),
                itemsPerPage,
                currentPage,
                EntitiesToViewConverter.getCriminalCasePanelsFromCriminalCase(
                        criminalCaseDatabase.subList(
                                (currentPage - 1) * itemsPerPage,
                                currentPage * itemsPerPage),
                        paginationPanel.getOwner()
                )
        );

    }
}
