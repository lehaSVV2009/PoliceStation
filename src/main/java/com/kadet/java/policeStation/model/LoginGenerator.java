package com.kadet.java.policeStation.model;

import com.kadet.java.policeStation.database.PolicemanDatabase;
import com.kadet.java.policeStation.entity.Policeman;

import java.util.Random;

/**
 * Date: 01.12.13
 * Time: 21:45
 *
 * @author Кадет
 */
public final class LoginGenerator {

    private PolicemanDatabase policemanDatabase = PolicemanDatabase.getInstance();

    private Random random;

    public LoginGenerator() {
        this.random = new Random();
    }

    private final static String PASSWORD_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";


    private final static int []DIGITS = {
            1,2,3,4,5,6,7,8,9,0
    };

    public String generateLogin (String fio) {
        String login
                = fio.replaceAll("\\s", "");
        for (Policeman policeman : policemanDatabase.getPolicemen()) {
            if(login.equals(policeman.getLogin())) {
                login = generateLogin(login + DIGITS[random.nextInt(DIGITS.length)]);
                break;
            }
        }
        return login;
    }

    public String generatePassword() {
        StringBuilder password
                = new StringBuilder();
        int passwordLength = random.nextInt(15) + 5;
        for (int passwordCharacterIndex = 0; passwordCharacterIndex < passwordLength; ++passwordCharacterIndex) {
            password.append(
                PASSWORD_CHARACTERS.charAt(
                        random.nextInt(PASSWORD_CHARACTERS.length()))
            );
        }
        return password.toString();
    }


}
