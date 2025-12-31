package com.agentic.windows_automation_ai.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class CommonUtils {
	
	// ================= PASTE TABLE FROM CLIPBOARD =================
	public static void pasteTableFromClipboard() {
	    try {
	        Robot robot = new Robot();

	        Thread.sleep(800);
	        
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_HOME);
	        robot.keyRelease(KeyEvent.VK_HOME);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        Thread.sleep(400);

	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);

	        Thread.sleep(500);

	    } catch (Exception e) {
	        throw new RuntimeException(
	                "Failed to paste table data into desktop grid", e);
	    }
	}
	// ================= CLIPBOARD =================
    public static void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        Toolkit.getDefaultToolkit()
                .getSystemClipboard()
                .setContents(selection, null);
    }
    
    
 // ================= WAIT UTILITIES =================

    public static WindowsElement waitForElementByName(
            WindowsDriver driver,
            String name,
            int timeoutSeconds) {

        long endTime = System.currentTimeMillis() + (timeoutSeconds * 1000);

        while (System.currentTimeMillis() < endTime) {
            try {
                WindowsElement element =
                        (WindowsElement) driver.findElementByName(name);

                if (element.isDisplayed() && element.isEnabled()) {
                    return element;
                }
            } catch (Exception ignored) {
                // element not ready yet
            }

            sleep(500);
        }

        throw new RuntimeException(
                "Timeout waiting for element by Name: " + name);
    }


    public static WindowsElement waitForElementByAccessibilityId(
            WindowsDriver driver,
            String accessibilityId,
            int timeoutSeconds) {

        long endTime = System.currentTimeMillis() + (timeoutSeconds * 1000);

        while (System.currentTimeMillis() < endTime) {
            try {
                WindowsElement element =
                        (WindowsElement) driver.findElementByAccessibilityId(accessibilityId);

                if (element.isDisplayed() && element.isEnabled()) {
                    return element;
                }
            } catch (Exception ignored) {
                // element not ready yet
            }

            sleep(500);
        }

        throw new RuntimeException(
                "Timeout waiting for element by AccessibilityId: " + accessibilityId);
    }


    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }

}
