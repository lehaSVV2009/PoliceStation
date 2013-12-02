package com.kadet.java.swing.pagination;

import com.kadet.java.policeStation.database.ResumeDatabase;
import com.kadet.java.policeStation.model.EntitiesToViewConverter;

/**
 * Date: 02.12.13
 * Time: 14:46
 *
 * @author Кадет
 */
public class ResumeDatabaseClickPage implements ClickPageStrategy {

    private PaginationPanel paginationPanel;

    private ResumeDatabase resumeDatabase = ResumeDatabase.getInstance();

    public ResumeDatabaseClickPage(PaginationPanel paginationPanel) {
        this.paginationPanel = paginationPanel;
    }

    @Override
    public void clickPage(int currentPage, int itemsPerPage) {
        paginationPanel.updateComponents(
                resumeDatabase.getResumesNumber(),
                itemsPerPage,
                currentPage,
                EntitiesToViewConverter.getResumePanelsFromResumes(
                        resumeDatabase.subList(
                                (currentPage - 1) * itemsPerPage,
                                currentPage * itemsPerPage),
                        paginationPanel.getOwner()
                )
        );
    }
}
