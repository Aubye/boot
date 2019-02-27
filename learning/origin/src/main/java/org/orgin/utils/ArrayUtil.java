package org.orgin.utils;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtil {

    public static <T> boolean isEmpty(final T[] array) {
        return ArrayUtils.isEmpty(array);
    }

    public static <T> boolean isNotEmpty(final T[] array) {
        return ArrayUtils.isNotEmpty(array);
    }

}
