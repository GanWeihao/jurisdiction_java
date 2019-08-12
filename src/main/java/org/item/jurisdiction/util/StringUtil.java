package org.item.jurisdiction.util;

public class StringUtil {
    public static Object isnull(Object obj) {
        if (obj != null) {
            return obj;
        }
        return "";
    }

    public static Object iszore(Object obj) {
        if (obj != null) {
            return obj;
        }
        return Integer.valueOf(0);
    }
}