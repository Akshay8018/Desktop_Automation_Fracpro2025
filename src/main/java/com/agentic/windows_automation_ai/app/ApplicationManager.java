package com.agentic.windows_automation_ai.app;

import com.agentic.windows_automation_ai.driver.DriverManager;
import com.agentic.windows_automation_ai.drivers.WinDriver;
import com.agentic.windows_automation_ai.utils.EnvConfig;

import io.appium.java_client.windows.WindowsDriver;

public class ApplicationManager {

    // ✅ SINGLE ENTRY POINT — NO PARAMETERS
    public static WindowsDriver launchApp() {

        String appPath = EnvConfig.get("app.path");

        if (appPath == null || appPath.isEmpty()) {
            throw new RuntimeException(
                    "Application path not found in config.properties for key: app.path");
        }

        WindowsDriver driver = WinDriver.startApp(appPath);

        DriverManager.setDriver(driver);

        return driver;
    }
}
