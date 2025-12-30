//package com.agentic.windows_automation_ai.base;
//
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import com.agentic.windows_automation_ai.driver.DriverManager;
//import com.agentic.windows_automation_ai.manager.WinAppDriverManager;
//
//public class BaseTest {
//
//    @BeforeTest
//    public void startWinAppDriver() {
//        WinAppDriverManager.startWinAppDriver();
//    }
//
//    @AfterTest
//    public void tearDown() {
//        DriverManager.quitDriver();
//        WinAppDriverManager.stopWinAppDriver();
//    }
//}
