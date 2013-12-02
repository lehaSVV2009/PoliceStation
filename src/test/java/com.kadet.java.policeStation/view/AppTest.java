package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.database.*;
import com.kadet.java.policeStation.entity.*;
import com.kadet.java.policeStation.model.MessageSender;
import com.kadet.java.policeStation.util.Messages;
import com.kadet.java.swing.pagination.Pagination;
import com.kadet.java.swing.textfields.editableLabel.EditableLabel;
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
                        "lehaSVV2009test@gmail.com",
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
                        "lehaSVV2009test@gmail.com",
                        new Date(),
                        true,
                        "",
                        ""
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
