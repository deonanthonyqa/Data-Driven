package DataDriven.DataD.Utils;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	String Filepath;
	Sheet sh;
	public ExcelUtils(String Filepath,String SheetName) {
		//Filepath = System.getProperty("user.dir")+ReadConfigFile.getSingletonConfigDetails().getPropertiesValue("testDataLocation");
		File TestDataFile = new File(Filepath);
		Workbook wb = null;
		try {
			wb = new XSSFWorkbook(TestDataFile);
			sh = wb.getSheet(SheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//get row data in hashmap format
	public HashMap<String,String> getTestDataInMap(int rownNum){
		
		//sh.getRow(0).getCell(0);
		HashMap<String , String> hm = new HashMap<String , String>();
		
		for(int i=0;i<sh.getRow(0).getLastCellNum();i++) {
		
		try {	
			sh.getRow(rownNum).getCell(i).setCellType(CellType.STRING);
		
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rownNum).getCell(i).toString());
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		}
		return hm;
	}
	

	
	public int getRowCount() {
		return sh.getLastRowNum();
	}
	
	public int getColCount() {
		return sh.getRow(0).getLastCellNum();
	}
	
}
