package com.salesforce.objectrepositorylibrary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.salesforce.genericlibrary.BrowserUtility;
import com.salesforce.genericlibrary.FileDataUtility;
import com.salesforce.genericlibrary.WebDriverUtility;

public class OpportunityPage {
	
	WebDriverUtility webdriver = new WebDriverUtility();
	FileDataUtility fileData = new FileDataUtility();
	private String parentWindow;
	
	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement opportunityLink;
	
	@FindBy(name="new")
	private WebElement createOpportunityButton;
	
	@FindBy(id="p3")
	private WebElement opportunityRecordTypeDropdown;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueOpportunityButton;
	
	@FindBy(id="opp3")
	private WebElement opportunityNameTextbox;
	
	@FindBy(xpath="//img[@title='Account Name Lookup (New Window)']")
	private WebElement accountLookupButton;
	
	@FindBy(xpath="//img[@title='End User Contact Lookup (New Window)']")
	private WebElement enduserLookupButton;
	
	@FindBy(id="lksrch")
	private WebElement lookupTextbox;
	
	@FindBy(name="go")
	private WebElement lookupGoButton;
	
	@FindBy(id="lkenhmdSEARCH_ALL")
	private WebElement lookupAllFiledsRadioButton;
	
	@FindBy(xpath="//table[@class='list']/tbody/tr[2]/th/a")
	private WebElement searchResult;
	
	@FindBy(id="opp5")
	private WebElement opportunityTypeDropdown;
	
	@FindBy(id="00N30000001O7vL")
	private WebElement solutionTypeDropdown;
	
	@FindBy(id="00N70000001l7vP")
	private WebElement solutionNameDropdown;
	
	@FindBy(id="opp11")
	private WebElement stageDropdown;
	
	@FindBy(xpath="//span[@class='dateFormat']/a")
	private WebElement bookDateLink;
	
	@FindBy(xpath="//td[@id='topButtonRow']/input[@name='save_new']")
	private WebElement saveAndProductButton;
	
	@FindBy(id="p1")
	private WebElement selectCatalog;
	
	@FindBy(name="save")
	private WebElement catalogSaveButton;
	
	@FindBy(xpath="//div[@id='ext-gen12']/div[2]/table/tbody/tr/td[1]/div/input")
	private WebElement selectProductCheckbox;
	
	@FindBy(name="edit")
	private WebElement productSelectButton;
	
	@FindBy(xpath="//input[contains(@id,'UnitPrice')]")
	private WebElement unitPriceTextbox;
	
	@FindBy(xpath="//input[contains(@id,'Quantity')]")
	private WebElement quantityTextbox;
	
	@FindBy(xpath="//select[contains(@id,'unselected')]")
	private WebElement multiSelectServiceDropdown;
	
	@FindBy(xpath="//table[@class='genericTable brandSecondaryBrd multiLineItem']/tbody/tr[1]/td/input[1]")
	private WebElement priceSaveButton;
	
	public void navigateOpportunityPage()
	{
		opportunityLink.click();
	}
	
	public WebElement selectOpportunityRecordType()
	{
		return opportunityRecordTypeDropdown;
	}
	
	public void clickAccountLookupButton()
	{
		accountLookupButton.click();
	}
	
	public WebElement selectOpportunityType()
	{
		return opportunityTypeDropdown;
	}
	
	public WebElement selectSolutionType()
	{
		return solutionTypeDropdown;
	}
	
	public WebElement selectSolutionName()
	{
		return solutionNameDropdown;
	}
	
	public WebElement selectStage()
	{
		return stageDropdown;
	}
	
	public void clickBookDate()
	{
		 bookDateLink.click();
	}
	
	public void clickEnduserLookupButton()
	{
		enduserLookupButton.click();
	}
	
	public WebElement lookupTextbox()
	{
		return lookupTextbox;
	}
	
	public WebElement selectMultiSelectDropdown()
	{
		return multiSelectServiceDropdown;
	}
	
/*	public  void clickLookupGoButton()
	{
		 goButton.click();
	}
	*/
	public void clickSaveAndProductButton()
	{
		 saveAndProductButton.click();
	}
	
	
	
	
	/**
	 * 
	 * @param element - The WebElement which needs to be selected
	 * @param typeOfSelection - The value to be selected from the drop down in terms of VisibleText or Index or Value
	 * @param opportunityType - Type of opportunity like Channel, Standard, SMB, APOS
	 */
	
	public void opportunitySelection(WebElement element, String typeOfSelection, String opportunityType)
	{
		navigateOpportunityPage();
		createOpportunityButton.click();
		webdriver.selectDropdown(element, typeOfSelection, opportunityType);
		continueOpportunityButton.click();
	}
	
	public void createStandardOpportunity() throws Throwable //String oppoName
	{
			/*navigateOpportunityPage();
			createOpportunityButton.click();
			webdriver.selectDropdown(opportunityRecordTypeDropdown, "VisibleText", "Standard Opportunity");
			continueOpportunityButton.click();
			createOpportunity(opportunityRecordTypeDropdown, "VisibleText", "Standard Opportunity");*/
		
		String opportunityName = fileData.getExcelSheetData("Sheet2", 1, 1);
		String accountName = fileData.getExcelSheetData("Sheet2", 2, 1);
		String enduserName = fileData.getExcelSheetData("Sheet2", 3, 1);
		double unitPrice = Double.parseDouble(fileData.getExcelSheetData("Sheet2", 4, 1));
		int quantity = Integer.parseInt(fileData.getExcelSheetData("Sheet2", 5, 1));
		HashSet<Object> set = new HashSet<Object>();
		for(int i=6; i<fileData.getLastCellValue("Sheet2");i++)
		{
			String services = fileData.getExcelSheetData("Sheet2", i, 1);
			set.add(services);
			System.out.println("Service collection :"+set);
		}
			opportunityNameTextbox.sendKeys(opportunityName);
			 parentWindow = webdriver.getParentWindow();
			 clickAccountLookupButton();
			 lookupWindow(accountName);
			 	webdriver.selectDropdown(selectOpportunityType(), "Index", "1");
				webdriver.selectDropdown(selectSolutionType(), "Index", "1");
				webdriver.selectDropdown(selectSolutionName(), "Index", "1");
				webdriver.selectDropdown(selectStage(), "VisibleText", "Discover - 10%");
				clickBookDate();
			clickEnduserLookupButton();
				lookupWindow(enduserName);
				clickSaveAndProductButton();
				selectCatalog(unitPrice,quantity);
				webdriver.multiSelectdropdown(selectMultiSelectDropdown(),set);
				BrowserUtility.driver.findElement(By.xpath("//td[@class='multiSelectPicklistCell']/a/img[contains(@id,'right_arrow')]")).click();
			 
	}
	
	public void lookupWindow(String data) throws Throwable
	{
		Thread.sleep(2000);
		webdriver.switchToSearchWindow("searchFrame");
		lookupTextbox.sendKeys(data);
		lookupGoButton.click();
		webdriver.switchToResultWindow("resultsFrame");
		searchResult.click();
		BrowserUtility.driver.switchTo().window(parentWindow);
	}
	
	public void selectCatalog(double price, int quantity) throws Throwable
	{
		//System.out.println("select catalog "+ service);
		webdriver.selectDropdown(selectCatalog, "VisibleText", "ABU/APJ Standard Catalog");
		catalogSaveButton.click();
		selectProductCheckbox.click();
		productSelectButton.click();
		unitPriceTextbox.clear();
		unitPriceTextbox.sendKeys(Double.toString(price));
		quantityTextbox.sendKeys(Integer.toString(quantity));
		
		
	// priceSaveButton.click();
	}
}
