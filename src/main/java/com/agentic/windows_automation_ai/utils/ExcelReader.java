package com.agentic.windows_automation_ai.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	// ================= TEST DATA EXCEL =================
	private static final String TESTDATA_FILE_PATH = "D:\\FRACPRODeskAppPOC\\windows-automation-ai\\resources\\TestData.xlsx";

	// ================= TREATMENT SCHEDULE SHEET =================
	private static final String TREATMENT_SCHEDULE_SHEET = "TreatmentSchedule";

	// ================= LOCATOR CACHE =================
	private static Map<String, String> locatorCache;

	// ================= KEY–VALUE DATA =================
	public static Map<String, String> read(String sheetName) {

		Map<String, String> data = new HashMap<>();

		try (FileInputStream fis = new FileInputStream(TESTDATA_FILE_PATH)) {

			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				throw new RuntimeException("Sheet not found in TestData Excel: " + sheetName);
			}

			for (Row row : sheet) {
				String key = row.getCell(0).getStringCellValue().trim();
				String value = row.getCell(1).toString().trim();
				data.put(key, value);
			}

		} catch (Exception e) {
			throw new RuntimeException("Failed to read Key-Value TestData Excel", e);
		}

		return data;
	}

	// ================= TREATMENT SCHEDULE TABLE (SAME EXCEL) =================
	public static String getTreatmentScheduleClipboardData() {

		StringBuilder tableData = new StringBuilder();

		try (FileInputStream fis = new FileInputStream(TESTDATA_FILE_PATH)) {

			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(TREATMENT_SCHEDULE_SHEET);

			if (sheet == null) {
				throw new RuntimeException("Sheet not found in TestData.xlsx: " + TREATMENT_SCHEDULE_SHEET);
			}

			for (Row row : sheet) {

				if (row == null) {
					continue;
				}

				for (int i = 0; i < row.getLastCellNum(); i++) {

					Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

					tableData.append(cell.toString());

					if (i < row.getLastCellNum() - 1) {
						tableData.append("\t");
					}
				}
				tableData.append("\n");
			}

		} catch (Exception e) {
			throw new RuntimeException("Failed to read Treatment Schedule from TestData.xlsx", e);
		}

		return tableData.toString();
	}

	// ================= LOCATOR DATA =================
	public static Map<String, String> readLocators() {

		if (locatorCache != null) {
			return locatorCache;
		}

		Map<String, String> locators = new HashMap<>();

		try (FileInputStream fis = new FileInputStream(TESTDATA_FILE_PATH)) {

			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet("Locators");

			if (sheet == null) {
				throw new RuntimeException("Sheet 'Locators' not found in TestData.xlsx");
			}

			for (Row row : sheet) {
				String key = row.getCell(0).getStringCellValue().trim();
				String value = row.getCell(1).toString().trim();
				locators.put(key, value);
			}

		} catch (Exception e) {
			throw new RuntimeException("Failed to read Locators sheet from Excel", e);
		}

		locatorCache = locators;
		return locators;
	}

	public static String getLocator(String key) {

		String value = readLocators().get(key);

		if (value == null || value.isEmpty()) {
			throw new RuntimeException("Locator not found in Excel for key: " + key);
		}

		return value;
	}

	// ================= UNIQUE VALUE GENERATOR & PERSIST =================
	public static String generateAndPersistUniqueValue(String sheetName, String key) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		Workbook workbook = null;

		try {
			fis = new FileInputStream(TESTDATA_FILE_PATH);
			workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				throw new RuntimeException("Sheet not found: " + sheetName);
			}

			for (Row row : sheet) {

				if (row == null || row.getCell(0) == null) {
					continue;
				}

				String excelKey = row.getCell(0).toString().trim();

				if (!excelKey.equals(key)) {
					continue;
				}

				Cell valueCell = row.getCell(1);
				String baseValue = valueCell.toString().replaceAll("\\d*$", "");

				int randomNum = new java.util.Random().nextInt(1000);
				String uniqueValue = baseValue + randomNum;

				// Update Excel
				valueCell.setCellValue(uniqueValue);

				fos = new FileOutputStream(TESTDATA_FILE_PATH);
				workbook.write(fos);

				System.out.println("🔁 Updated Excel: " + key + " = " + uniqueValue);

				return uniqueValue;
			}

			throw new RuntimeException("Key not found in Excel: " + key);

		} catch (Exception e) {
			throw new RuntimeException("Failed to generate and persist unique value for key: " + key, e);
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (Exception ignore) {
			}
		}
	}

}
