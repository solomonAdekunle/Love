package TestUtil;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.TestBase;

public class UtilityRough extends TestBase{
	// test suite is runnable
			public static boolean isSuiteRunnable(String suiteName, Xls_Reader xls){
				int rows = xls.getRowCount(Constant.SUITE_SHEET);
				
				for(int rNum=2;rNum<=rows;rNum++){
					String data = xls.getCellData(Constant.SUITE_SHEET, Constant.SUITENAME_COL, rNum);
					if(data.equals(suiteName)){
						String runmode = xls.getCellData(Constant.SUITE_SHEET, Constant.RUNMODE_COL, rNum);
						if(runmode.equals("Y"))
							return true;
						else
							return false;
					}
				}
				
				return false;
			}
			
			public static boolean isTestCaseRunnable(String testCase, Xls_Reader xls){
				int rows = xls.getRowCount(Constant.TESTCASES_SHEET);
				for(int rNum=2;rNum<=rows;rNum++){
					String testNameXls = xls.getCellData(Constant.TESTCASES_SHEET, Constant.TESTCASES_COL, rNum);
					if(testNameXls.equalsIgnoreCase(testCase)){
					String runmode = xls.getCellData(Constant.TESTCASES_SHEET, Constant.RUNMODE_COL, rNum);
					if(runmode.equalsIgnoreCase(Constant.RUNMODE_YES))
						return true;
					else
						return false;
				    }
				}
				return false;// default		
			}
			// return the test data from a test in a 2 dim array
			public static Object[][] getData(Xls_Reader xls , String testCaseName){
				// if the sheet is not present
				if(! xls.isSheetExist(testCaseName)){
					xls=null;
					return new Object[1][0];
				}
				
				
				int rows=xls.getRowCount(testCaseName);
				int cols=xls.getColumnCount(testCaseName);
				//System.out.println("Rows are -- "+ rows);
				//System.out.println("Cols are -- "+ cols);
				
			    Object[][] data =new Object[rows-1][cols-3];
				for(int rowNum=2;rowNum<=rows;rowNum++){
					for(int colNum=0;colNum<cols-3;colNum++){
						//System.out.print(xls.getCellData(testCaseName, colNum, rowNum) + " -- ");
						data[rowNum-2][colNum] = xls.getCellData(testCaseName, colNum, rowNum);
					}
					//System.out.println();
				for(int rNum=rowNum;rNum<(rowNum+rNum);rNum++){
					Hashtable<String,String> table = new Hashtable<String,String>();
					for(int cNum=0;cNum<cNum;cNum++){
						//System.out.println(xls.getCellData(Constants.DATA_SHEET, cNum, rNum));
						//data[r][cNum]=xls.getCellData(Constants.DATA_SHEET, cNum, rNum);
						table.put(xls.getCellData(Constant.DATA_SHEET, cNum, cols), xls.getCellData(Constant.DATA_SHEET, cNum, rNum));
					}
					data[rows][0]=table;
					rows++;
							
				}
				}
				return data;
			}
			//store screenshot
			public static void takeScreenshot(String fileName) {
				File scrFile=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
			    try {
					FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName+".jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}

	}




