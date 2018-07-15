package com.salesforce.opportunity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.salesforce.genericlibrary.*;
import com.salesforce.objectrepositorylibrary.OpportunityPage;


public class CreateOpportunityTest extends BrowserUtility {
	
	FileDataUtility fileData = new FileDataUtility();
	BrowserUtility browser = new BrowserUtility();
	WebDriverUtility webdriver = new WebDriverUtility();
	
	@Test
	public void createStandardOpportunityTest() throws Throwable 
	{
		OpportunityPage oppoPage = PageFactory.initElements(driver, OpportunityPage.class);
		oppoPage.opportunitySelection(oppoPage.selectOpportunityRecordType(), "VisibleText", "Standard Opportunity");
		oppoPage.createStandardOpportunity();
		/*String opportunityName = fileData.getExcelSheetData("Sheet2", 1, 1);
		String accountName = fileData.getExcelSheetData("Sheet2", 2, 1);
		String enduserName = fileData.getExcelSheetData("Sheet2", 3, 1);
		double unitPrice = Double.parseDouble(fileData.getExcelSheetData("Sheet2", 4, 1));
		int quantity = Integer.parseInt(fileData.getExcelSheetData("Sheet2", 5, 1));
		HashSet<Object> set = new HashSet<Object>();
		for(int i=6; i<=fileData.getLastCellValue("Sheet2");i++)
		{
			String services = fileData.getExcelSheetData("Sheet2", i, 1);
			set.add(services);
		}*/
		
		//String service = fileData.getExcelSheetData("Sheet2", 6, 1);
		//System.out.println("Test method "+service);
		//oppoPage.createStandardOpportunity(opportunityName);
		//oppoPage.lookupWindow(accountName);
	/*	webdriver.selectDropdown(oppoPage.selectOpportunityType(), "Index", "1");
		webdriver.selectDropdown(oppoPage.selectSolutionType(), "Index", "1");
		webdriver.selectDropdown(oppoPage.selectSolutionName(), "Index", "1");
		webdriver.selectDropdown(oppoPage.selectStage(), "VisibleText", "Discover - 10%");*/
		/*oppoPage.clickBookDate();
		oppoPage.clickEnduserLookupButton();
		oppoPage.lookupWindow(enduserName);
		oppoPage.clickSaveAndProductButton();
		oppoPage.selectCatalog(unitPrice,quantity);
		webdriver.multiSelectdropdown(oppoPage.selectMultiSelectDropdown(),set);*/
		//browser.driver.findElement(By.xpath("//td[@class='multiSelectPicklistCell']/a/img[contains(@id,'right_arrow')]")).click();
		
	}
	
	/*@Test
	public void createChannelOpportunity()
	{
		OpportunityPage oppo = PageFactory.initElements(driver, OpportunityPage.class);
		oppo.createOpportunity(oppo.selectOpportunityType(), "VisibleText", "Channel Opportunity");
	}
	
	@Test
	public void createSMBOpportunity()
	{
		OpportunityPage oppo = PageFactory.initElements(driver, OpportunityPage.class);
		oppo.createOpportunity(oppo.selectOpportunityType(), "VisibleText", "SMB Opportunity");
	}
	
	@Test
	public void createAPOSOpportunity()
	{
		OpportunityPage oppo = PageFactory.initElements(driver, OpportunityPage.class);
		oppo.createOpportunity(oppo.selectOpportunityType(), "VisibleText", "APOS");
	}*/


}
