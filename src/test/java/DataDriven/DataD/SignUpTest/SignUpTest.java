package DataDriven.DataD.SignUpTest;

import DataDriven.DataD.Utils.ExcelUtils;
import DataDriven.DataD.testBase.Base;
import DataDriven.DataD.Utils.CommonMethods;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.testng.annotations.Test;

import DataDriven.DataD.PageObjects.*;

import DataDriven.DataD.Utils.Log;


public class SignUpTest extends Base{
	
	ExcelUtils excel = new ExcelUtils(System.getProperty("user.dir")+"\\TestResources\\SignUpTest.xlsx","SignUp");
	CommonMethods cm = new CommonMethods();
	
	
	
	@Test
	void signUpFormValid_001()
	{
		HashMap<String, String> testData = excel.getTestDataInMap(1);
		logger = extent.createTest("signUpFormValid_001");
		signUpPage sp = new signUpPage();
		sp.addFirstName(testData.get("Test_Data1"));
		logger.info("First name is enter");
		sp.addLastName(testData.get("Test_Data2"));
		logger.info("Second name is enter");
		sp.clickRbGender(testData.get("Test_Data3"));
		logger.info("Gender is selected");
		sp.clickCbAutoTester();
		sp.clickRbYOE(testData.get("Test_Data4"));
		logger.info("Clicked for year");
		sp.clickLinkDownload();
		assertTrue(cm.getTitleofPage().equals(testData.get("Test_Data5")));
		Log.info("TestComplete");
	}
	
	
	
}
