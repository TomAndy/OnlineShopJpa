package com.mp.onlinestore.util;

import java.util.List;

public class StringUtils {

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty() ? true : false;
    }

    public static boolean isNullOrEmpty(List value) { return value == null || value.isEmpty() ? true : false;}

    public static boolean isNullOrZero(Long value) {
        return value == null || value == 0 ? true : false;
    }
    public static boolean isNullOrZero(Double value) {
        return value == null || value == 0 ? true : false;
    }

}
