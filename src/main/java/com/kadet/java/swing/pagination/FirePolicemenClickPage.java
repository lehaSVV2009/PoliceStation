package com.kadet.java.swing.pagination;

import com.kadet.java.policeStation.database.PolicemanDatabase;
import com.kadet.java.policeStation.entity.Policeman;
import com.kadet.java.policeStation.entity.Sheriff;
import com.kadet.java.policeStation.model.EntitiesToViewConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 02.12.13
 * Time: 14:14
 *
 * @author Кадет
 */
public class FirePolicemenClickPage implements ClickPageStrategy {

    private Sheriff sheriff;

    private PaginationPanel paginationPanel;

    private PolicemanDatabase policemanDatabase = PolicemanDatabase.getInstance();

    public FirePolicemenClickPage(Sheriff sheriff, PaginationPanel paginationPanel) {
        this.sheriff = sheriff;
        this.paginationPanel = paginationPanel;
    }

    @Override
    public void clickPage(int currentPage, int itemsPerPage) {
        List<Policeman> without = new ArrayList<Policeman>();
        without.add(sheriff);

        paginationPanel.updateComponents(
                policemanDatabase.getPolicemenNumberWithoutSomebody(without),
                itemsPerPage,
                currentPage,
                EntitiesToViewConverter.getFirePolicemenPanelsFromPolicemen(
                        policemanDatabase.subListWithoutSomebody((currentPage - 1) * itemsPerPage, currentPage * itemsPerPage, without),
                        paginationPanel.getOwner()
                )
        );
        System.out.println("clicked : " + currentPage);
    }

}
