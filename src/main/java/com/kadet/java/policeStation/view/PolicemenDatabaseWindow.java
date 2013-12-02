package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.database.PolicemanDatabase;
import com.kadet.java.policeStation.entity.Policeman;
import com.kadet.java.policeStation.entity.Sheriff;
import com.kadet.java.policeStation.model.EntitiesToViewConverter;
import com.kadet.java.swing.pagination.FirePolicemenClickPage;
import com.kadet.java.swing.pagination.PaginationPanel;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:12
 * To change this template use File | Settings | File Templates.
 */
public class PolicemenDatabaseWindow extends AbstractWindow {

//    private List<FirePolicemanPanel> firePolicemanPanels;

    private final int itemsPerPage = 4;
    private PaginationPanel paginationPanel;

    private final PolicemanDatabase policemanDatabase = PolicemanDatabase.getInstance();

    private Sheriff currentSheriff;

    public PolicemenDatabaseWindow(Window parent) {
        super(parent);
        updateComponents();
    }

    @Override
    protected void initializeComponents() {

        this.paginationPanel = new PaginationPanel(this, itemsPerPage);
//        this.firePolicemanPanels = new ArrayList<FirePolicemanPanel>();
        /*paginationPanel = new PaginationPanel(this, itemsPerPage) {
            @Override
            public void clickPage(int currentPage, int itemsPerPage) {

                List<Policeman> without = new ArrayList<Policeman>();

                updateComponents(

                        policemanDatabase.getPolicemenNumberWithoutSomebody(without),
                        itemsPerPage,
                        currentPage,
                        EntitiesToViewConverter.getFirePolicemenPanelsFromPolicemen(
                                policemanDatabase.subListWithoutSomebody((currentPage - 1) * itemsPerPage, currentPage * itemsPerPage, without),
                                PolicemenDatabaseWindow.this
                        )
                );
            }
        };
*/
    }

    private void removeComponents() {
        remove(paginationPanel);
    /*    for (FirePolicemanPanel panel : firePolicemanPanels) {
            remove(panel);
        }
        firePolicemanPanels.clear();
    */
    }

    @Override
    protected void addComponents() {
        add(paginationPanel);
//        for (FirePolicemanPanel panel : firePolicemanPanels) {
//            add(panel);
//        }
    }

    public void updateComponents() {
        removeComponents();

        paginationPanel.setClickPageStrategy(
                new FirePolicemenClickPage(currentSheriff, paginationPanel)
        );
        paginationPanel.clickPage(PaginationPanel.START_PAGE, itemsPerPage);
        /*List<Policeman> policemen = policemanDatabase.getPolicemen();
        for (Policeman policeman : policemen) {
            if (policeman != currentSheriff) {
                FirePolicemanPanel firePolicemanPanel
                        = new FirePolicemanPanel(this, policeman);
                firePolicemanPanels.add(firePolicemanPanel);
            }
        }*/
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
