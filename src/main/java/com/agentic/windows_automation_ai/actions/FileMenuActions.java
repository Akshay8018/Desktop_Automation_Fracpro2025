package com.agentic.windows_automation_ai.actions;

import io.appium.java_client.windows.WindowsDriver;

public class FileMenuActions extends BaseActions {

    public FileMenuActions(WindowsDriver driver) {
        super(driver);
    }

    public void clickFileMenu() {
        byName("FileMenu");   // Excel locator key
    }

    public void clickNew() {
        byName("NewMenu").click();
    }

    public void createNewWell() {
        clickFileMenu();
        clickNew();
    }
}
