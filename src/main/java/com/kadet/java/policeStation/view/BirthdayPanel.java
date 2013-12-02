package com.kadet.java.policeStation.view;

import com.kadet.java.policeStation.util.DataStrings;
import com.kadet.java.policeStation.util.Messages;

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
public class BirthdayPanel extends AbstractPanel {

    private String labelText;
    private JLabel birthdayLabel;

    private JComboBox<String> dayOfBirth;
    private JComboBox<String> monthOfBirth;
    private JComboBox<String> yearOfBirth;

    public BirthdayPanel(Window parent, String labelText) {
        super(parent);
        this.labelText = labelText;
    }

    protected void initializeComponents() {

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


    protected void addComponents() {
        add(birthdayLabel);
        add(dayOfBirth);
        add(monthOfBirth);
        add(yearOfBirth);
    }

    @Override
    protected void updateComponents() {
        //To change body of implemented methods use File | Settings | File Templates.
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
