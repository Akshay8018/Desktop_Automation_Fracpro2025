package com.agentic.windows_automation_ai.utils;

import java.util.Map;

public class DataValidator {

    public static void require(Map<String, String> data, String... keys) {

        for (String key : keys) {
            if (!data.containsKey(key)) {
                throw new RuntimeException(
                        "Missing required key in Excel: " + key);
            }

            if (data.get(key) == null || data.get(key).trim().isEmpty()) {
                throw new RuntimeException(
                        "Empty value for required key in Excel: " + key);
            }
        }
    }
}
