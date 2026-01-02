package com.agentic.windows_automation_ai.drivers;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.agentic.windows_automation_ai.utils.EnvConfig;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class WinDriver {

    private static WindowsDriver<WindowsElement> driver;

    public static WindowsDriver<WindowsElement> startApp(String appPath) {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            // ✅ Required capabilities
            caps.setCapability("platformName", "Windows");
            caps.setCapability("deviceName", "WindowsPC");

            // ✅ Use ONLY app (no appTopLevelWindow)
            caps.setCapability("app", appPath);

            // ✅ Wait for app UI to be ready
            caps.setCapability("ms:waitForAppLaunch", "25");

            driver = new WindowsDriver<>(
                    new URL(EnvConfig.get("winappdriver.url")),
                    caps
            );
            
         // Bring app to foreground
            driver.manage().window().maximize();

            return driver;

        } catch (Exception e) {
        	e.printStackTrace();
            throw new RuntimeException("Failed to start application", e);
        }
    }

    public static WindowsDriver<WindowsElement> getDriver() {
        return driver;
    }
}
