package org.sync.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReadWrite {
	public static Map<String, String> getTestData(int sheetNum) throws IOException {
		HashMap<String, String> testData = new HashMap<String, String>();
		XSSFWorkbook workbook = null;
		try {
			FileInputStream fis = new FileInputStream("./files/testData.xlsx");
	    	workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(sheetNum);
			int lastRowNumber = sheet.getLastRowNum();

			for (int i = 0; i < lastRowNumber; i++) {
				Row row = sheet.getRow(i);
				Cell keyCell = row.getCell(0);
				String key = keyCell.getStringCellValue().trim();
				Cell valueCell = row.getCell(1);
				String value = valueCell.getStringCellValue().trim();
				testData.put(key, value);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		workbook.close();
		return testData;
		
	}

	public static void writeExcel(HashMap<String, List<String>> data, String sheetname) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(sheetname);

		List<String> getList = new ArrayList<String>();

		Set<String> keyid = data.keySet();
		int rowid = 0;
		Row row = sheet.getRow(rowid);
		for (String key : keyid) {
			row = sheet.createRow(rowid++);
			Cell keyCell = row.createCell(0);
			keyCell.setCellValue(key);

			getList = data.get(key);
			int cellid = 1;
			Iterator<String> it = getList.iterator();
			while (it.hasNext()) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue(it.next());
			}
		}

		FileOutputStream fis2 = new FileOutputStream(new File(
				System.getProperty("user.dir") + "\\src\\test\\java\\org\\sync\\qa\\resources\\userdata.xlsx"));
		workbook.write(fis2);
		fis2.close();
		System.out.println("testData successfully update");
		workbook.close();
	}

	public static void main(String[] args) throws IOException {
		HashMap<String, List<String>> empinfo = new HashMap<>();

		String[] empID = { "t01", "t02", "t03" };
		String[] empName = { "test01", "test02", "test03" };
		String[] empDesignation = { "testlead", "sr.tester", "jr.tester" };
		List<String> empId = Arrays.asList(empID);
		List<String> name = Arrays.asList(empName);
		List<String> designation = Arrays.asList(empDesignation);

		empinfo.put("Emp Id", empId);
		empinfo.put("Emp Name", name);
		empinfo.put("Designation", designation);

		writeExcel(empinfo, "Sheet2");
	}
}
