package com.agentic.windows_automation_ai;

import java.util.Map;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.agentic.windows_automation_ai.agents.AIFailureAnalyzer;
import com.agentic.windows_automation_ai.agents.AILocatorHealer;
import com.agentic.windows_automation_ai.app.ApplicationManager;
import com.agentic.windows_automation_ai.utils.CommonUtils;
import com.agentic.windows_automation_ai.utils.ExcelReader;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;




public class Fracpro2025Test extends CommonUtils {

    @Test
    public void selectCloudStorage() throws InterruptedException {
   
    	WindowsDriver<WindowsElement> driver = ApplicationManager.launchApp();
    	Thread.sleep(1000);
    	
    	Map<String, String> data = ExcelReader.read("TestData");
    	

        try {
        	
        WindowsElement fileTab = driver.findElementByName("File");
        fileTab.click();
    
        
        WindowsElement Newbutton = driver.findElementByName("New");
        Newbutton.click();
        Thread.sleep(1000);
        
           
        WindowsElement WindowHeader = driver.findElementByName("Well and Treatment Information - F3");
        WindowHeader.click();
        Thread.sleep(1000);
        
     // ✅ Validate window header (Window title)
        WindowsElement WindowHeaderName = driver.findElementByName("Well and Treatment Information - F3");

        String actualTitle = WindowHeaderName.getAttribute("Name");
        System.out.println("Window Title: " + actualTitle);

        Assert.assertEquals(actualTitle, "Well and Treatment Information - F3",
                "New window header is incorrect!");
        WindowsElement companyDropdown =
                driver.findElementByAccessibilityId(ExcelReader.getLocator("CompanyDropdownLocator"));

        companyDropdown.click();
        Thread.sleep(1000);

        WindowsElement companyDropdownOption =
                driver.findElementByName(data.get("CompanyName"));
        companyDropdownOption.click();
        Thread.sleep(1000); 
        
        WindowsElement FieldNameInput =
                driver.findElementByAccessibilityId(ExcelReader.getLocator("FieldNameInputLoctor"));

        FieldNameInput.clear();
        FieldNameInput.sendKeys(data.get("FieldName"));
        Thread.sleep(1000);
        
//        WindowsElement padNameInput =
//                driver.findElementByAccessibilityId(ExcelReader.getLocator("PadNameInputLocator"));
//   
//        padNameInput.clear();
//        padNameInput.sendKeys(data.get("PadName"));
//        Thread.sleep(1000);
//        
//        WindowsElement WellNameInput =
//                driver.findElementByAccessibilityId(ExcelReader.getLocator("WellNameInputLocator"));
//   
//        WellNameInput.clear();
//        WellNameInput.sendKeys(data.get("WellName"));
//        Thread.sleep(1000);
        
        
     // ===== PAD NAME =====
        String uniquePadName =
                ExcelReader.generateAndPersistUniqueValue("TestData", "PadName");

        WindowsElement padNameInput =
                driver.findElementByAccessibilityId(
                        ExcelReader.getLocator("PadNameInputLocator"));

        padNameInput.clear();
        padNameInput.sendKeys(uniquePadName);
        Thread.sleep(1000);


        // ===== WELL NAME =====
        String uniqueWellName =
                ExcelReader.generateAndPersistUniqueValue("TestData", "WellName");

        WindowsElement wellNameInput =
                driver.findElementByAccessibilityId(
                        ExcelReader.getLocator("WellNameInputLocator"));

        wellNameInput.clear();
        wellNameInput.sendKeys(uniqueWellName);
        Thread.sleep(1000);

        
        
        
        
        WindowsElement WellAPI1 =
                driver.findElementByAccessibilityId(ExcelReader.getLocator("WellAPI1Locator"));
   
        WellAPI1.clear();
        WellAPI1.sendKeys(data.get("API1"));
        Thread.sleep(1000);
        
        WindowsElement WellAPI2 =
                driver.findElementByAccessibilityId(ExcelReader.getLocator("WellAPI2Locator"));
   
        WellAPI2.clear();
        WellAPI2.sendKeys(data.get("API2"));
        Thread.sleep(1000);
        
        WindowsElement WellAPI3 =
                driver.findElementByAccessibilityId(ExcelReader.getLocator("WellAPI3Locator"));
   
        WellAPI3.clear();
        WellAPI3.sendKeys(data.get("API3"));
        Thread.sleep(1000);
        
        WindowsElement WellAPI4 =
                driver.findElementByAccessibilityId(ExcelReader.getLocator("WellAPI4Locator"));
   
        WellAPI4.clear();
        WellAPI4.sendKeys(data.get("API4"));
        Thread.sleep(1000);
        
        WindowsElement WellAPI5 =
                driver.findElementByAccessibilityId(ExcelReader.getLocator("WellAPI5Locator"));
   
        WellAPI5.clear();
        WellAPI5.sendKeys(data.get("API5"));
        Thread.sleep(1000);
        
        WindowsElement WellLocation =
                driver.findElementByAccessibilityId(ExcelReader.getLocator("WellLocationLocator"));
   
        WellLocation.clear();
        WellLocation.sendKeys(data.get("WellLocation"));
        Thread.sleep(1000);
        
        
        WindowsElement CountyDropdown =
                driver.findElementByAccessibilityId(ExcelReader.getLocator("CountyDropdownLocator"));

        CountyDropdown.click();
        Thread.sleep(1000);

        WindowsElement countryDropdownOption =
                driver.findElementByName(data.get("County"));
        countryDropdownOption.click();
        Thread.sleep(1000); 
        
        WindowsElement ServiceCompanyDropdown =
                driver.findElementByAccessibilityId(ExcelReader.getLocator("ServiceCompanyDropdownLocator"));

        ServiceCompanyDropdown.click();
        Thread.sleep(1000);

        WindowsElement ServiceCompanyDropdownOption =
                driver.findElementByName(data.get("ServiceCompany"));
        ServiceCompanyDropdownOption.click();
        Thread.sleep(1000); 
        
        WindowsElement SaveButton = driver.findElementByName("Save");
        SaveButton.click();
        Thread.sleep(10000);
        
        WindowsElement Nextbutton = driver.findElementByAccessibilityId(ExcelReader.getLocator("NextButtonLocator"));//1347);
        Nextbutton.click();
        Thread.sleep(1000);
               
        // ✅ Validate window header (Window title)
        WindowsElement WindowNewHeaderName = driver.findElementByName("Fracture Analysis Options - F4");
        WindowNewHeaderName.click();
        Thread.sleep(1000);
        

        String ActualTitle = WindowNewHeaderName.getAttribute("Name");
        System.out.println("Window Title: " + ActualTitle);

        Assert.assertEquals(ActualTitle, "Fracture Analysis Options - F4",
                "New window header is incorrect!");
        
        WindowsElement Nextbutton1 = driver.findElementByAccessibilityId(ExcelReader.getLocator("NextButtonLocator"));//1348
        Nextbutton1.click();
        Thread.sleep(1000);
        
        WindowsElement TreatmentScheduleTab = driver.findElementByName("Treatment Schedule");
        TreatmentScheduleTab.click();
        Thread.sleep(1000);
        
        String tableData = ExcelReader.getTreatmentScheduleClipboardData();
        CommonUtils.copyToClipboard(tableData);

        
        WindowsElement spreadsheet =driver.findElementByClassName("SPR32A80_SpreadSheet");
        spreadsheet.click();
        
         CommonUtils.pasteTableFromClipboard();
        
	     
        
        WindowsElement SaveBT = driver.findElementByName("Save");
        SaveBT.click();
        Thread.sleep(5000);
        
        driver.quit();
        Thread.sleep(1000);

        
    } catch (Exception failure) {

        String pageUI = driver.getPageSource();

        System.out.println("\n--- AI FAILURE ANALYZER OUTPUT ---");
        System.out.println(AIFailureAnalyzer.analyze(failure.getMessage(), pageUI));

        System.out.println("\n--- AI LOCATOR HEALER OUTPUT ---");
        String healed = AILocatorHealer.heal("Fracpro Application Loctor is Not Correct", pageUI);

        System.out.println("Healed locator: " + healed);

        if (healed.startsWith("AccessibilityId")) {
            try {
                WebElement fixed = driver.findElementByAccessibilityId(healed.substring(6));
                fixed.click();
            } catch (Exception ignore) {
                
            }
        }
    }
  }   
}

