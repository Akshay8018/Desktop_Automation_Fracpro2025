package com.agentic.windows_automation_ai.utils;

import java.io.InputStream;
import java.util.Properties;

public class EnvConfig {

    private static Properties props = new Properties();

    static {
        try {
            InputStream input = EnvConfig.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }

            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
