package com.app.platform.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public final class NumberUtil {

    private static final int SCALE = 2;
    private static final int SCALE_FOUR = 4;

    private NumberUtil() {

    }

    /**
     * 四舍五入，保留两位小数
     *
     * @param value
     * @return
     */
    public static Double scale2(Double value) {
        return null != value ? new BigDecimal(value).setScale(SCALE, RoundingMode.HALF_UP).doubleValue() : null;
    }

    public static Double scale4(Double value) {
        return null != value ? new BigDecimal(value).setScale(SCALE_FOUR, RoundingMode.HALF_UP).doubleValue() : null;
    }

    public static Integer getRandomNum(Integer bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    public static Integer getFixedLengthRandomNum(Integer length) {
        return ThreadLocalRandom.current().nextInt((int) Math.pow(10, length - 1), (int) Math.pow(10, length));
    }
}
