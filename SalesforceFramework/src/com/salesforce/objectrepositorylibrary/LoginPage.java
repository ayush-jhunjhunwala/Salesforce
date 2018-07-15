package com.salesforce.objectrepositorylibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.salesforce.genericlibrary.BrowserUtility;


public class LoginPage extends BrowserUtility {
		
	@FindBy(id="username")
	private WebElement userEditbox;
	
	@FindBy(id="password")
	private WebElement passwordEditBox;
	
	@FindBy(id="Login")
	private WebElement loginButton;
	
	
	public void login(String username, String password)
	{
		userEditbox.sendKeys(username);
		passwordEditBox.sendKeys(password);
		loginButton.click();
	}

}
