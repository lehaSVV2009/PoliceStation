package com.kadet.java.swing.pagination;

import com.kadet.java.policeStation.database.CriminalCaseDatabase;
import com.kadet.java.policeStation.model.EntitiesToViewConverter;

/**
 * Date: 02.12.13
 * Time: 15:32
 *
 * @author Кадет
 */
public class LastCriminalCases implements ClickPageStrategy {
    private PaginationPanel paginationPanel;

    private final static int LAST = 5;

    private CriminalCaseDatabase criminalCaseDatabase = CriminalCaseDatabase.getInstance();

    public LastCriminalCases(PaginationPanel paginationPanel) {
        this.paginationPanel = paginationPanel;
    }

    @Override
    public void clickPage(int currentPage, int itemsPerPage) {

        paginationPanel.updateComponents(
                criminalCaseDatabase.getLastCriminalCases(LAST).size(),
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
