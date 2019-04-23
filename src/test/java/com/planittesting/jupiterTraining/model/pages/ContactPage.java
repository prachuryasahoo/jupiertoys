package com.planittesting.jupiterTraining.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage {

	//WebDriver driver;


	

	public ContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void enterEmail(String string) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(string);

	}
  
	public boolean isErrorPresentForEmail() {
		return driver.findElements(By.id("email-err")).size()>0;
	}
	
	public String getEmailErrorMessage() {
		// TODO Auto-generated method stub
		String elements = driver.findElement(By.id("email-err")).getText();
		if (elements.isEmpty()) {
			return "Error doesnt exist";
		}
		return elements;
	}

	public void clickSubmit() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//a[text()='Submit']")).click();

	}

	public String getForeNameErrorMessage() {
		String elements = driver.findElement(By.id("forename-err")).getText();
		if (elements.isEmpty()) {
			return "Error doesnt exist";
		}
		return elements;
	}
	
	public Object gettextErrorMessage() {
		String elements = driver.findElement(By.id("message-err")).getText();
		if (elements.isEmpty()) {
			return "Error doesnt exist";
		}
		return elements;
	}
	
	public String getSubmissionMessage() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-success")));
		return element.getText();

	}

	

	public void enterForeName(String forename) {
		driver.findElement(By.id("forename")).sendKeys(forename);
		// TODO Auto-generated method stub

	}

	public void enterSurName(String surname) {
		driver.findElement(By.id("surname")).sendKeys(surname);
		// TODO Auto-generated method stub

	}

	public void enterEmailAddress(String emailAddress) {
		driver.findElement(By.id("email")).sendKeys(emailAddress);
		// TODO Auto-generated method stub

	}

	public void enterTelephoneNumber(String num) {
		driver.findElement(By.id("telephone")).sendKeys(num);
		// TODO Auto-generated method stub

	}

	public void enterMessage(String message) {
		driver.findElement(By.id("message")).sendKeys(message);
		// TODO Auto-generated method stub

	}

	
	
	

}
