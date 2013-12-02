package com.kadet.java.policeStation.model;

import com.kadet.java.policeStation.util.Messages;

/**
 * Date: 01.12.13
 * Time: 22:10
 *
 * @author Кадет
 */
public class MessageGenerator {


    public String generateSuccessGettingJobMessage (String name, String login, String password) {
        StringBuilder message = new StringBuilder();
        message.append(Messages.GREETING)
                .append(name)
                .append('\n')
                .append(Messages.CONGRATULATIONS_MESSAGE)
                .append('\n')
                .append(Messages.YOUR_LOGIN)
                .append(login)
                .append('\n')
                .append(Messages.YOUR_PASSWORD)
                .append(password)
                .append('\n')
                .append(Messages.GOOD_LUCK_IN_NEW_JOB);
        return message.toString();
    }

    public String generateFailedGettingJobMessage (String name) {
        StringBuilder message = new StringBuilder();
        message.append(Messages.GREETING)
                .append(name)
                .append('\n')
                .append(Messages.REGRETS)
                .append('\n')
                .append(Messages.TRY_LATER);
        return message.toString();
    }

    public String generateForgetPasswordMessage (String name, String login, String newPassword) {
        StringBuilder message = new StringBuilder();
        message.append(Messages.GREETING)
                .append(name)
                .append('\n')
                .append(Messages.YOUR_LOGIN)
                .append(login)
                .append('\n')
                .append(Messages.YOUR_NEW_PASSWORD)
                .append(newPassword)
                .append('\n')
                .append(Messages.GOOD_LUCK);
        return message.toString();
    }

}
