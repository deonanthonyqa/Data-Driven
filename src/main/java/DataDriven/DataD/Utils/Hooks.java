package DataDriven.DataD.Utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import DataDriven.DataD.testBase.Base;


public class Hooks {
	
	  @AfterSuite
	  public void tearDown() {
	  
		  System.out.println("calling tearDown After Suite");
		  if(Base.getDriver()!=null) {
			  Base.getDriver().quit();
		  }
		  System.out.println("Execution close ");
	  }
		

}
