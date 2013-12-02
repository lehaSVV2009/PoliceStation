package com.kadet.java.policeStation.util;

/**
 * Date: 01.12.13
 * Time: 21:35
 *
 * @author Кадет
 */
public final class SexUtil {

    public static final String getSexFromBoolean (boolean sex) {
        return sex ? Messages.SEX[0] : Messages.SEX[1];
    }

}
