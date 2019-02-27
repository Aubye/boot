package org.orgin.utils;

import org.apache.commons.collections.MapUtils;

import java.util.Map;

public class MapUtil {

    public static boolean isEmpty(Map map) {
        return MapUtils.isEmpty(map);
    }

    public static boolean isNotEmpty(Map map) {
        return MapUtils.isNotEmpty(map);
    }

}
