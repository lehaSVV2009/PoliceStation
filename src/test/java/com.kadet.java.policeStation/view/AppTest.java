package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.database.*;
import com.kadet.java.policeStation.entity.*;
import com.kadet.java.policeStation.model.MessageSender;
import com.kadet.java.policeStation.util.Messages;
import com.kadet.java.swing.pagination.Pagination;
import com.kadet.java.swing.pagination.PaginationPanel;
import com.kadet.java.swing.textfields.editableLabel.EditableLabel;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Unit com.kadet.java.policeStation for simple App.
 */

public class AppTest {

    private MainWindow mainWindow;

    private CriminalDatabase criminalDatabase;
    private CriminalCaseDatabase criminalCaseDatabase;
    private PolicemanDatabase policemanDatabase;
    private ResumeDatabase resumeDatabase;

    public static void main(String[] args) {
        AppTest appTest = new AppTest();
//        appTest.testPaginationPanel();
        appTest.startMainWindow();
//        appTest.testPagination();
//        appTest.startMailSender();
//        appTest.startFrameWithEditableLabel();
    }

    private void startMainWindow () {

        resumeDatabase = ResumeDatabase.getInstance();
        resumeDatabase.addResume(
                new Resume(
                        "Alexey Soroka",
                        "lehaSVV2009test@gmail.com",
                        new Date(),
                        true
                )
        );
        criminalDatabase = CriminalDatabase.getInstance();
        Criminal criminal = new Criminal(
                "Zakranov Viktor Rodionovich",
                new Date(),
                true,
                CriminalStatus.WANTED
        );
        criminalDatabase.addCriminal(criminal);
        criminalCaseDatabase = CriminalCaseDatabase.getInstance();
        criminalCaseDatabase.addCriminalCase(
                new CriminalCase(
                        criminal,
                        "description",
                        new Date()
                )
        );
        policemanDatabase = PolicemanDatabase.getInstance();
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.BAD,
                        "Kuchin Alexey Eduardovich",
                        "lehaSVV2009@gmail.com",
                        new Date(),
                        true,
                        "qwe",
                        "qwe"
                )
        );
        policemanDatabase.addPoliceman(
                new Sheriff(
                        Status.GOOD,
                        "Zamanov Igor Valentinovich",
                        "lehaSVV2009@gmail.com",
                        new Date(),
                        true,
                        "",
                        ""
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "1qwe",
                        "1qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "2qwe",
                        "2qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "3qwe",
                        "3qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "4qwe",
                        "4qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "5qwe",
                        "5qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "6qwe",
                        "6qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "7qwe",
                        "7qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        resumeDatabase = ResumeDatabase.getInstance();
        mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }

    private void startFrameWithEditableLabel() {
        JFrame frame = new JFrame();
        Criminal kadet = new Criminal(
                "Kadet",
                new Date(),
                true,
                CriminalStatus.FREED
        );

        EditableLabel editableLabel = new EditableLabel(frame) {
            @Override
            protected void editObject(Object editableObject, String editedText) {
                ((Criminal)editableObject).setFio(editedText);
                System.out.println(((Criminal) editableObject).getFio());
            }
        };
        editableLabel.setEditableObject(kadet);
        editableLabel.setText(kadet.getFio());

        frame.setContentPane(editableLabel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startMailSender () {
        MessageSender messageSender = new MessageSender();
        messageSender.sendMessageToEmail(
                "message",
                "lehaSVV2009test@gmail.com",
                Messages.GETTING_THE_JOB_TOPIC
        );
    }

    private void testPaginationPanel () {
        final PolicemanDatabase policemanDatabase = PolicemanDatabase.getInstance();
        fillPolicemanDatabase();
        final JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 800));
        PaginationPanel panel = new PaginationPanel(frame, 4) {
            @Override
            public void clickPage(int currentPage, int itemsPerPage) {
        /*        updateComponents(
                        policemanDatabase.getPolicemen().size(),
                        itemsPerPage,
                        currentPage,
                        EntitiesToViewConverter.getFirePolicemenPanelsFromPolicemen(
                                policemanDatabase.subListWithoutSomebody((currentPage - 1) * itemsPerPage, currentPage * itemsPerPage),
                                frame
                        )
                );*/
            }
        };
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    @Test(expected = RuntimeException.class)
    public void checkSubListFromEmptyList () {
        PolicemanDatabase policemanDatabase = PolicemanDatabase.getInstance();
        List<Policeman> policemen = policemanDatabase.subListWithoutSomebody(100, 102, new ArrayList<Policeman>());
    }

    private void fillPolicemanDatabase () {
        PolicemanDatabase policemanDatabase = PolicemanDatabase.getInstance();
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "1qwe",
                        "1qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "2qwe",
                        "2qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "3qwe",
                        "3qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "4qwe",
                        "4qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "5qwe",
                        "5qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "6qwe",
                        "6qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.YOUNG,
                        "7qwe",
                        "7qwe",
                        new Date(),
                        true,
                        "login",
                        "password"
                )
        );

    }

    @Test()
    public void checkSubList () {
        PolicemanDatabase policemanDatabase = PolicemanDatabase.getInstance();
        fillPolicemanDatabase();
        List<Policeman> policemen = policemanDatabase.subListWithoutSomebody(0, 1, new ArrayList<Policeman>());
        assert policemen.size() == 1;
//        System.out.println("size - " + policemen.size());
    }


    @Test()
    public void start () {
        startMainWindow();
    }

    @Test(expected = NullPointerException.class)
    public void makeNullPointerException () {
        String str = null;
        str.charAt(0);
    }

    @Test(timeout = 1000)
    public void infinity () {
        System.out.println("1");
    }


    @Test()
    public void testPagination () {
        Pagination pagination = new Pagination(200, 20);
        assert pagination.getCurrentPage() == 1;
    }

}
