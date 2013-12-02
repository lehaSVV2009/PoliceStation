package com.kadet.java.policeStation.model;

import com.kadet.java.policeStation.entity.Criminal;
import com.kadet.java.policeStation.entity.CriminalCase;
import com.kadet.java.policeStation.entity.Policeman;
import com.kadet.java.policeStation.entity.Resume;
import com.kadet.java.policeStation.view.FirePolicemanPanel;
import com.kadet.java.policeStation.view.ResumePanel;
import com.kadet.java.policeStation.view.criminal.CriminalPanel;
import com.kadet.java.policeStation.view.criminalCase.CriminalCasePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 02.12.13
 * Time: 12:23
 *
 * @author Кадет
 */
public final class EntitiesToViewConverter {

    public final static List<Component> getFirePolicemenPanelsFromPolicemen (List<Policeman> policemen, Window parent) {
        List<Component> panels = new ArrayList<Component>();
        for (Policeman policeman : policemen) {
            panels.add(
                new FirePolicemanPanel(parent, policeman)
            );
        }
        return panels;
    }

    public final static List<Component> getResumePanelsFromResumes (List<Resume> resumes, Window parent) {
        List<Component> panels = new ArrayList<Component>();
        for (Resume resume : resumes) {
            panels.add(
                    new ResumePanel(parent, resume)
            );
        }
        return panels;
    }

    public final static List<Component> getCriminalPanelsFromCriminal (List<Criminal> criminals, Window parent) {
        List<Component> panels = new ArrayList<Component>();
        for (Criminal criminal : criminals) {
            panels.add(
                    new CriminalPanel(parent, criminal)
            );
        }
        return panels;
    }


    public final static List<Component> getCriminalCasePanelsFromCriminalCase (List<CriminalCase> criminalCases, Window parent) {
        List<Component> panels = new ArrayList<Component>();
        for (CriminalCase criminalCase : criminalCases) {
            panels.add(
                    new CriminalCasePanel(parent, criminalCase)
            );
        }
        return panels;
    }



}
