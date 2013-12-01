package com.kadet.java.policeStation.util;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public final class DataStrings {

    public static final int FIRST_YEAR = 1900;
    public static final int LAST_YEAR = (int) (System.currentTimeMillis() / 1000 / 3600 / 24 / 365.25 + 1970);

    public static final int FIRST_DAY = 1;
    public static final int LAST_DAY = 31;

    public static final int MAX_CRIMINAL_CASES_VALUE = 10;
}
