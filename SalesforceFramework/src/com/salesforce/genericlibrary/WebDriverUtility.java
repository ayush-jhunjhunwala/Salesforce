package com.salesforce.genericlibrary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void maximizeBowser()
	{
		BrowserUtility.driver.manage().window().maximize();
	}
	
	public void waitTillPageLoad(int time)
	{
		BrowserUtility.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	
	public void waitTillElementLoad(WebElement element, int time)
	{
		WebDriverWait wait = new WebDriverWait(BrowserUtility.driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * 
	 * @param element -- select the drop down WebElement
	 * @param typeOfSelection provide the selection like Index(String), Value(String), VisibleText(String)
	 * @param data provide the value for each selection
	 */
	
	public WebElement selectDropdown(WebElement element, String typeOfSelection, String data)
	{
		
		Select select = new Select(element);
		
		switch(typeOfSelection)
		{
		case "Index" : select.selectByIndex(Integer.parseInt(data));
		break;
		
		case "Value" : select.selectByValue(data);
		break;
		
		case "VisibleText" : select.selectByVisibleText(data);
		break;
		}
		
		return element;
	}
	
	public WebElement multiSelectdropdown(WebElement element, HashSet<Object> set1)
	{
		
		//System.out.println("Web Driver "+ data);
		Select select = new Select(element);
		List<WebElement> list = select.getOptions();
		
		for(Object s: set1)
		{
			Object value = s;
			System.out.println("Dropdown value :"+value);
			for(WebElement wb1 : list)
			{
				String text = wb1.getText();
				System.out.println(text);
				if(text.equals(value))
					{
						select.selectByVisibleText((String) value);
						break;
					}

				}
		}
		return element;
	}
		
		
	/*	for(WebElement wb : list)
		{
			String actualValue = wb.getText();
			System.out.println(actualValue);
			if(actualValue.equals(data))
			{
				switch(selection)
				{
					case "VisibleText" : select.getAllSelectedOptions();
					break;
					case "Index" : select.getAllSelectedOptions();
					break;
					case "Value" : select.getAllSelectedOptions();
					break;
				}
			//	System.out.println("if method "+actualValue);
				break;
			}
			
		}
		return element;*/
		
	
	
	public String getParentWindow()
	{
		return BrowserUtility.driver.getWindowHandle();
	}
	
	/**
	 * 
	 * @param frameName - pass the frame related unique identifier like name or id and should be a String
	 */
	public void switchToSearchWindow(String frame)
	{
		
		String parentWindow = getParentWindow();
		Set<String> allWindowID = BrowserUtility.driver.getWindowHandles();
		Iterator<String> it = allWindowID.iterator();
		
		while(it.hasNext())
		{
			String childWindow = it.next();
			if(!parentWindow.equals(childWindow))
			{
				BrowserUtility.driver.switchTo().window(childWindow);
				BrowserUtility.driver.switchTo().frame(frame);
			}
		}
	}
	
	/**
	 * 
	 * @param frameName - pass the frame related unique identifier like name or id and should be a String
	 */
	
	public void switchToResultWindow(String frame)
	{
		BrowserUtility.driver.switchTo().defaultContent();
		BrowserUtility.driver.switchTo().frame(frame);
	}

	public void doubleClick(WebElement element)//String selection
	{
		Actions action = new Actions(BrowserUtility.driver);
		/*(switch(selection)
		{
		case "doubleclick" : action.doubleClick(element).build().perform();
		break;
		} */
		
		action.doubleClick(element).perform();
	}
}
