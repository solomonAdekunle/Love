package TestUtil;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base.TestBase;

public class Utility extends TestBase {

	// test suite is runnable
	public static boolean isSuiteRunnable(String suiteName, Xls_Reader xls) {
		int rows = xls.getRowCount(Constant.SUITE_SHEET);

		for (int rNum = 2; rNum <= rows; rNum++) {
			String data = xls.getCellData(Constant.SUITE_SHEET, Constant.SUITENAME_COL, rNum);
			if (data.equals(suiteName)) {
				String runmode = xls.getCellData(Constant.SUITE_SHEET, Constant.RUNMODE_COL, rNum);
				if (runmode.equals("Y"))
					return true;
				else
					return false;
			}
		}

		return false;
	}

	public static boolean isTestCaseRunnable(String testCase, Xls_Reader xls) {
		int rows = xls.getRowCount(Constant.TESTCASES_SHEET);
		for (int rNum = 2; rNum <= rows; rNum++) {
			String testNameXls = xls.getCellData(Constant.TESTCASES_SHEET, Constant.TESTCASES_COL, rNum);
			if (testNameXls.equalsIgnoreCase(testCase)) {
				String runmode = xls.getCellData(Constant.TESTCASES_SHEET, Constant.RUNMODE_COL, rNum);
				if (runmode.equalsIgnoreCase(Constant.RUNMODE_YES))
					return true;
				else
					return false;
			}
		}
		return false;// default
	}

	public static Object[][] getData(String testName, Xls_Reader xls) {
		int rows = xls.getRowCount(Constant.DATA_SHEET);
		System.out.println("Total rows - " + rows);

		// row number for testCase
		int testCaseRowNum = 1;
		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {
			String testNameXls = xls.getCellData(Constant.DATA_SHEET, 0, testCaseRowNum);
			if (testNameXls.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("Test Starts from row Number - " + testCaseRowNum);
		int dataStartRowNum = testCaseRowNum + 2;
		int colStartRowNum = testCaseRowNum + 1;

		// rows of data
		int testRows = 1;
		while (!xls.getCellData(Constant.DATA_SHEET, 0, dataStartRowNum + testRows).equals("")) {
			testRows++;
		}
		System.out.println("Total rows of data are - " + testRows);

		// cols of data
		int testCols = 0;
		while (!xls.getCellData(Constant.DATA_SHEET, testCols, colStartRowNum).equals("")) {
			testCols++;
		}
		Object[][] data = new Object[testRows][1];
		int r = 0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {
			Hashtable<String, String> table = new Hashtable<String, String>();
			for (int cNum = 0; cNum < testCols; cNum++) {
				// System.out.println(xls.getCellData(Constants.DATA_SHEET,
				// cNum, rNum));
				// data[r][cNum]=xls.getCellData(Constants.DATA_SHEET, cNum,
				// rNum);
				table.put(xls.getCellData(Constant.DATA_SHEET, cNum, colStartRowNum),
						xls.getCellData(Constant.DATA_SHEET, cNum, rNum));
			}
			data[r][0] = table;
			r++;
		}
		// 0,0 , 0,1
		// 1,0 , 1,1
		return data;

	}

	public static void writeXLSXFile(int row, int col, String newpass) throws IOException {
		try {
			FileInputStream file = new FileInputStream("SuperData\\CORE_SUITE.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(1);
			Cell cell = null;

			// Retrieve the row and check for null
			XSSFRow sheetrow = sheet.getRow(row);
			if (sheetrow == null) {
				sheetrow = sheet.createRow(row);
			}
			// Update the value of cell
			cell = sheetrow.getCell(col);
			if (cell == null) {
				cell = sheetrow.createCell(col);
			}
			cell.setCellValue(newpass);

			file.close();

			FileOutputStream outFile = new FileOutputStream(new File("SuperData\\CORE_SUITE.xlsx"));
			workbook.write(outFile);
			outFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void updateproperty(String key, String Value) throws ConfigurationException {
		System.out.println("Config cHECKING");
		String path = System.getProperty("user.dir") +"\\src\\test\\resource\\project.properties";
		PropertiesConfiguration config = new PropertiesConfiguration(path);
		config.setProperty(key, Value);
		config.save();
		System.out.println("Config Property Successfully Updated..");
	}

	// store screenshot
	public static void takeScreenshot(String fileName) {
		File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File(System.getProperty("user.dir") + "\\screenshots\\" + fileName + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
