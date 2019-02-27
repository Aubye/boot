package org.orgin.utils;

import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class ClassUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    private static final String BLANK = "%20";
    private static final String BLANK_SPACE = " ";
    private static final String CLASS_SEPARATION = ".";
    private static final String FILE_REPLACEMENT = "/";
    private static final String CLASS_SUFFIX = ".class";
    private static final String FILE_PROTOCOL = "file";
    private static final String JAR_PROTOCOL = "jar";
    private static final Integer BEGIN_INDEX = 0;

    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className) {
        return loadClass(className, false);
    }

    public static Class<?> loadClass(String className, boolean isInitialized) {
        Class<?> cls;
        try {
            cls = Class.forName(className, isInitialized, getClassLoader());
        } catch (ClassNotFoundException e) {
            LOGGER.error("ClassUtil.loadClass.error, e:{}", e);
            throw new RuntimeException(e);
        }
        return cls;
    }

    public static Set<Class<?>> getClassSet(String packageName) {
        Set<Class<?>> classSet = Sets.newConcurrentHashSet();
        try {
            ClassLoader classLoader = getClassLoader();
            Enumeration<URL> urls = classLoader.getResources(packageName.replace(CLASS_SEPARATION, FILE_REPLACEMENT));
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    String protocol = url.getProtocol();
                    if (protocol.equals(FILE_PROTOCOL)) {
                        String packagePath = url.getPath().replaceAll(BLANK, BLANK_SPACE);
                        addClass(classSet, packagePath, packageName);
                    } else if (protocol.equals(JAR_PROTOCOL)) {
                        URLConnection urlConnection = url.openConnection();
                        JarURLConnection jarURLConnection = (JarURLConnection) urlConnection;
                        if (jarURLConnection != null) {
                            JarFile jarFile = jarURLConnection.getJarFile();
                            if (jarFile != null) {
                                Enumeration<JarEntry> jarEntries = jarFile.entries();
                                while (jarEntries.hasMoreElements()) {
                                    JarEntry jarEntry = jarEntries.nextElement();
                                    String jarEntryName = jarEntry.getName();
                                    if (jarEntryName.endsWith(CLASS_SUFFIX)) {
                                        String className = jarEntryName.substring(BEGIN_INDEX, jarEntryName.lastIndexOf(CLASS_SEPARATION)).replaceAll(FILE_REPLACEMENT, CLASS_SEPARATION);
                                        doAddClass(classSet, className);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("ClassUtil.getClassSet.error, e:{}", e);
            throw new RuntimeException(e);
        }
        return classSet;
    }
    
    private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
        File[] files = new File(packagePath).listFiles(file -> (file.isFile() && file.getName().endsWith(CLASS_SUFFIX)) || file.isDirectory());
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                if (file.isFile()) {
                    String className = fileName.substring(BEGIN_INDEX, fileName.lastIndexOf(CLASS_SEPARATION));
                    if (StringUtil.isNotEmpty(className)) {
                        className = packageName + CLASS_SEPARATION + className;
                        doAddClass(classSet, className);
                    }
                } else {
                    String subPackagePath =  fileName;
                    if (StringUtil.isNotEmpty(subPackagePath)) {
                        subPackagePath = packagePath + FILE_REPLACEMENT + subPackagePath;
                    }
                    String subPackageName = fileName;
                    if (StringUtil.isNotEmpty(subPackageName)) {
                        subPackageName = packageName + FILE_REPLACEMENT + subPackageName;
                    }
                    addClass(classSet, subPackagePath, subPackageName);
                }
            }
        }
    }

    private static void doAddClass(Set<Class<?>> classSet, String className) {
        Class<?> cls = loadClass(className, false);
        classSet.add(cls);
    }

}
