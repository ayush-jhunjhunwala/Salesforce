package com.salesforce.objectrepositorylibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {

	@FindBy(id="userNavButton")
	private WebElement userLabel;
	
	@FindBy(linkText="Logout")
	private WebElement logoutButton;
	
	public void clickUserLabel()
	{
		userLabel.click();
	}
	
	public void clickLogoutButton()
	{
		userLabel.click();
		logoutButton.click();
	}
}

