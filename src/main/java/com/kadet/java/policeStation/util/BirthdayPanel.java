package com.kadet.java.policeStation.util;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 28.11.13
 * Time: 20:04
 * To change this template use File | Settings | File Templates.
 */
public class BirthdayPanel extends JPanel {

    private Window parent;

    private String labelText;
    private JLabel birthdayLabel;

    private JComboBox<String> dayOfBirth;
    private JComboBox<String> monthOfBirth;
    private JComboBox<String> yearOfBirth;

    public BirthdayPanel(Window parent, String labelText) {
        this.labelText = labelText;
        this.parent = parent;
        initialize();
        initializeComponents();
        addComponents();
    }

    private void initialize() {
        setLayout(new FlowLayout());
    }

    private void initializeComponents() {

        birthdayLabel = new JLabel(labelText);

        dayOfBirth = new JComboBox<String>();
        for (int day = DataStrings.FIRST_DAY; day <= DataStrings.LAST_DAY; ++day) {
            dayOfBirth.addItem(String.valueOf(day));
        }

        monthOfBirth = new JComboBox<String>(Messages.MONTHS);

        yearOfBirth = new JComboBox<String>();
        for (int year = DataStrings.FIRST_YEAR; year <= DataStrings.LAST_YEAR; ++year) {
            yearOfBirth.addItem(String.valueOf(year));
        }
    }


    private void addComponents() {
        add(birthdayLabel);
        add(dayOfBirth);
        add(monthOfBirth);
        add(yearOfBirth);
    }

    public Date getBirthday () {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(
                Integer.parseInt((String)yearOfBirth.getSelectedItem()),
                monthOfBirth.getItemCount(),
                Integer.parseInt((String)dayOfBirth.getSelectedItem())
        );
        return new Date(calendar.getTimeInMillis());
    }

}
