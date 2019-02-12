package org.orgin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtil.class);

    public static Properties loadPropertise(String fileName) {
        Properties properties = null;
        InputStream inputStream = null;
        try {
            Thread currentThread = Thread.currentThread();
            ClassLoader contextClassLoader = currentThread.getContextClassLoader();
            inputStream = contextClassLoader.getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new FileNotFoundException("fileName:" + fileName);
            }
            properties = new Properties();
            properties.load(inputStream);
        } catch (Exception e) {
            LOGGER.error("PropertiesUtil.loadPropertise.failure, e:{}", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    LOGGER.error("PropertiesUtil.loadPropertise.close.inputStream.error, e:{}", e);
                }
            }
        }
        return properties;
    }

    public static String getAttribute(Properties properties, String key) {
        return getAttribute(properties, key, "");
    }

    public static String getAttribute(Properties properties, String key, String defaultValue) {
        String value = defaultValue;
        if (properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }

}
