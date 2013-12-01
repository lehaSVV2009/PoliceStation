package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.database.*;
import com.kadet.java.policeStation.entity.*;
import com.kadet.java.swing.pagination.Pagination;
import com.kadet.java.swing.textfields.EditableLabel;
import org.junit.Test;

import javax.swing.*;
import java.util.Date;

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
        appTest.startFrameWithEditableLabel();
//        appTest.startMainWindow();
//        appTest.testPagination();
    }

    private void startMainWindow () {

        criminalDatabase = CriminalDatabase.getInstance();
        Criminal kadet = new Criminal(
                "Kadet",
                new Date(),
                true,
                CriminalStatus.FREED
        );
        criminalDatabase.addCriminal(kadet);
        criminalCaseDatabase = CriminalCaseDatabase.getInstance();
        criminalCaseDatabase.addCriminalCase(
                new CriminalCase(
                        kadet,
                        "description",
                        new Date()
                )
        );
        policemanDatabase = PolicemanDatabase.getInstance();
        policemanDatabase.addPoliceman(
                new Policeman(
                        Status.BAD,
                        "F I O",
                        new Date(),
                        true,
                        "qwe",
                        "qwe"
                )
        );
        resumeDatabase = ResumeDatabase.getInstance();
        mainWindow = new MainWindow(
                resumeDatabase,
                policemanDatabase
        );
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
        frame.setContentPane(new EditableLabel(frame, "text", kadet) {
            @Override
            protected void editObject(Object editableObject, String editedText) {
                ((Criminal)editableObject).setFio(editedText);
                System.out.println(((Criminal) editableObject).getFio());
            }
        });
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
