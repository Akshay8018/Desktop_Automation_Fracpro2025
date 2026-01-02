package com.agentic.windows_automation_ai.app;

import com.agentic.windows_automation_ai.actions.FileMenuActions;
import com.agentic.windows_automation_ai.actions.TreatmentScheduleActions;
import com.agentic.windows_automation_ai.actions.WellInfoActions;

import io.appium.java_client.windows.WindowsDriver;

public class FracproApp {

    private WindowsDriver driver;

    private FileMenuActions fileMenuActions;
    private WellInfoActions wellInfoActions;
    private TreatmentScheduleActions treatmentScheduleActions;

    public void launch() {
        driver = ApplicationManager.launchApp();

        fileMenuActions = new FileMenuActions(driver);
        wellInfoActions = new WellInfoActions(driver);
        treatmentScheduleActions = new TreatmentScheduleActions(driver);
    }

    public FileMenuActions file() {
        return fileMenuActions;
    }

    public WellInfoActions wellInfo() {
        return wellInfoActions;
    }

    public TreatmentScheduleActions treatmentSchedule() {
        return treatmentScheduleActions;
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
