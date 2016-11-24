package com.singuloid.coretextutil;

import java.util.List;

/**
 * Author: guoshicaho
 * Date: 11/23/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/23/16
 * LastUpdateBy: guoshicaho
 */
public class CoreNullnessUtils {
    public static <T> T firstNonNull(T... objs) {
        for (T obj : objs) {
            if (obj != null) {
                return obj;
            }
        }
        throw new NullPointerException();
    }

    public static <T> boolean isNotNull(T obj) {
        return obj != null;
    }

    public static <T> boolean isNull(T obj) {
        return !isNotNull(obj);
    }

    public static boolean isNotNullOrEmpty(List list) {
        return !isNullOrEmpty(list);
    }

    public static boolean isNullOrEmpty(List list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0; // string.isEmpty() in Java 6
    }

    public static boolean isNotNullOrEmpty(String string) {
        return !isNullOrEmpty(string);
    }

    public static String firstNonNull(String... objs) {
        for (String obj : objs) {
            if (obj != null) {
                return obj;
            }
        }
        throw new NullPointerException();
    }

}
