package com.agentic.windows_automation_ai.actions;

import java.util.Map;

import com.agentic.windows_automation_ai.utils.CommonUtils;
import com.agentic.windows_automation_ai.utils.ExcelReader;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class WellInfoActions extends BaseActions {

    private String uniqueWellName;

    public WellInfoActions(WindowsDriver driver) {
        super(driver);
    }

    public void verifyWindow() {
        WindowsElement header =
                byName("WellInfoWindowHeader");

        String title = header.getAttribute("Name");
        if (!"Well and Treatment Information - F3".equals(title)) {
            throw new RuntimeException("Unexpected window: " + title);
        }
    }

    public void fillWellInformation() {

        Map<String, String> data = ExcelReader.read("TestData");

        // Company
        byAccessibilityId("CompanyDropdownLocator").click();
        byName(data.get("CompanyName")).click();

        // Field Name
        WindowsElement fieldInput =
                byAccessibilityId("FieldNameInputLoctor");
        fieldInput.clear();
        fieldInput.sendKeys(data.get("FieldName"));

        // Pad Name (unique)
        String uniquePadName =
                ExcelReader.generateAndPersistUniqueValue("TestData", "PadName");

        WindowsElement padInput =
                byAccessibilityId("PadNameInputLocator");
        padInput.clear();
        padInput.sendKeys(uniquePadName);

        // Well Name (unique)
        uniqueWellName =
                ExcelReader.generateAndPersistUniqueValue("TestData", "WellName");

        WindowsElement wellInput =
                byAccessibilityId("WellNameInputLocator");
        wellInput.clear();
        wellInput.sendKeys(uniqueWellName);

        // APIs
        byAccessibilityId("WellAPI1Locator").sendKeys(data.get("API1"));
        byAccessibilityId("WellAPI2Locator").sendKeys(data.get("API2"));
        byAccessibilityId("WellAPI3Locator").sendKeys(data.get("API3"));
        byAccessibilityId("WellAPI4Locator").sendKeys(data.get("API4"));
        byAccessibilityId("WellAPI5Locator").sendKeys(data.get("API5"));

        // Location
        byAccessibilityId("WellLocationLocator").sendKeys(data.get("WellLocation"));

        // County
        byAccessibilityId("CountyDropdownLocator").click();
        byName(data.get("County")).click();

        // Service Company
        byAccessibilityId("ServiceCompanyDropdownLocator").click();
        byName(data.get("ServiceCompany")).click();
    }

    public void saveAndWait() {

        byName("SaveButton").click();

        CommonUtils.waitForSaveToComplete(
                driver,
                "Uploading Data",
                uniqueWellName,
                60
        );
    }

    public void next() {
        byAccessibilityId("NextButtonLocator").click();
    }
}
