package com.bazarbozorg.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLoggerFactory {
    public static Logger getLogger(Class<?> clazz) {
        String packageName = clazz.getPackage().getName();
        return LoggerFactory.getLogger(packageName);
    }
}
