package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.database.ResumeDatabase;
import com.kadet.java.policeStation.entity.Resume;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public class ResumeDatabaseWindow extends AbstractWindow {

    private List<ResumePanel> resumePanels;

    private ResumeDatabase resumeDatabase = ResumeDatabase.getInstance();

    public ResumeDatabaseWindow(Window parent) {
        super(parent);
    }

    @Override
    protected void initializeComponents() {
        this.resumePanels = new ArrayList<ResumePanel>();
    }

    private void removeComponents () {
        for (ResumePanel panel : resumePanels) {
            remove(panel);
        }
        resumePanels.clear();
    }

    @Override
    protected void addComponents() {
        for (ResumePanel panel : resumePanels) {
            add(panel);
        }
    }

    public void updateComponents () {
        removeComponents();
        List<Resume> resumes = resumeDatabase.getResumes();
        for (Resume resume : resumes) {
            ResumePanel resumePanel
                    = new ResumePanel(this, resume);
            resumePanels.add(resumePanel);
        }
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
