package com.agentic.windows_automation_ai.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

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

}
