package com.agentic.windows_automation_ai.driver;

import io.appium.java_client.windows.WindowsDriver;

public class DriverManager {

    private static WindowsDriver driver;

    public static void setDriver(WindowsDriver winDriver) {
        driver = winDriver;
    }

    public static WindowsDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("WindowsDriver session closed");
        }
    }
}
