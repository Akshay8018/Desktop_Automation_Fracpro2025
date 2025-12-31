package com.agentic.windows_automation_ai.actions;

import com.agentic.windows_automation_ai.utils.CommonUtils;
import com.agentic.windows_automation_ai.utils.ExcelReader;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public abstract class BaseActions {

    protected WindowsDriver driver;

    public BaseActions(WindowsDriver driver) {
        this.driver = driver;
    }

    protected WindowsElement byName(String locatorKey) {
        return CommonUtils.waitForElementByName(
                driver,
                ExcelReader.getLocator(locatorKey),
                30
        );
    }

    protected WindowsElement byAccessibilityId(String locatorKey) {
        return CommonUtils.waitForElementByAccessibilityId(
                driver,
                ExcelReader.getLocator(locatorKey),
                30
        );
    }
}