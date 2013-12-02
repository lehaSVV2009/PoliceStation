package com.kadet.java.policeStation.model;

import com.kadet.java.policeStation.entity.Policeman;
import com.kadet.java.policeStation.view.FirePolicemanPanel;

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

}
