package org.orgin.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class StringUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtil.class);

    public static boolean isEmpty(String str) {
        if (str != null) {
             str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        if (str != null) {
             str = str.trim();
        }
        return StringUtils.isNotEmpty(str);
    }
}
