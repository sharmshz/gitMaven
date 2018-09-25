package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.BaseClass;

public class TestUtil extends BaseClass {

	public static Workbook wb=null;
	public static Sheet sh=null;
	public static FileInputStream fis=null;

	public static long IMPLICIT_WAIT = 30;
	public static long PAGELOAD_TIMEOUT = 30;

	public static void SwitchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {

		try {
			File file = new File("E:\\SeleniumEclipse\\MavenProject\\src\\test\\resources\\Data_Sheet.xlsx");
			 fis = new FileInputStream(file);
			wb = WorkbookFactory.create(fis);
			sh = wb.getSheet(sheetName);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int lastrow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();

		Object[][] data = new Object[lastrow][lastcell];

		for (int i = 0; i < lastrow; i++) {
			for (int k = 0; k < lastcell; k++) {
				data[i][k] = sh.getRow(i + 1).getCell(k).toString();
			}

		}
		return data;

	}

}
