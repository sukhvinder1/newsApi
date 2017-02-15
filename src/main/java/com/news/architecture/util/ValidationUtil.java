package com.news.architecture.util;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Sukh on 2017-02-03.
 */
public class ValidationUtil {

    public static boolean isObjectNull(Object o) {
        if (o == null) {
            return true;
        }
        return false;
    }

    public static boolean isCollectionNullOrEmpty(Collection c) {
        if (c.size()==0 || c == null) {
            return true;
        }
        return false;
    }

    public static boolean isMapNullOrEmpty(Map m) {
        if (m.size()==0 || m == null) {
            return true;
        }
        return false;
    }
}
