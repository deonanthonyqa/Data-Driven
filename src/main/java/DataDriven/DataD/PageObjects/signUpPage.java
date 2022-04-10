package DataDriven.DataD.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Quotes;

import DataDriven.DataD.Utils.*;
import DataDriven.DataD.testBase.Base;

public class signUpPage {

	

	@FindBy(name = "firstname")
	public WebElement txtBoxFirstName;
	
	@FindBy(name = "lastname")
	WebElement txtBoxLasttName;
	
	@FindBy(id="sex-0")
	WebElement rbMale;
	
	@FindBy(id="sex-1")
	WebElement rbFemale;
	
	@FindBy(id="tool-0")
	WebElement cbManualTester;
	
	@FindBy(id="tool-1")
	WebElement cbAutoTester;
	
	@FindBy(id="photo")
	WebElement btnUpload;
	
	@FindBy(xpath="//a[@href='https://github.com/stanfy/behave-rest/blob/master/features/conf.yaml']")
	WebElement linkDownload;
	
	@FindBy(id="submit")
	WebElement btnButton;
	
	private CommonMethods cm = new CommonMethods();
	
	public signUpPage() {
		PageFactory.initElements(Base.getDriver(), this);
	}
	
	
	public void addFirstName(String fname) {
		cm.sendKeys(txtBoxFirstName, fname);
		
	}
	
	public void addLastName(String lname) {
		cm.sendKeys(txtBoxLasttName, lname);
		
	}
	
	public void clickRbGender(String gender) {
		switch(gender.toLowerCase())
		{
		case "male":
			cm.click(rbMale);
			break;
		case("female"):
			cm.click(rbFemale);
			break;
		}
		
	}
	

	
	public void clickCbManTester() {
		cm.click(cbManualTester);
		
	}
	
	
	public void clickCbAutoTester() {
		cm.click(cbAutoTester);
		
	}
	
	public void clickLinkDownload() {
		cm.click(linkDownload);
	}
	
	public void clickBtnButton() {
		cm.click(btnButton);
	}
	
	
	public void clickRbYOE(String YOE) {
		WebElement yoe= Base.getDriver().findElement(By.xpath("//input[@id='exp-"+YOE+"']"));
		cm.click(yoe);
	}
	
}
