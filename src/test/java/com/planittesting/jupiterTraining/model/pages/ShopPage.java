package com.planittesting.jupiterTraining.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage extends BasePage {

	public ShopPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getProductPrice(String product) {
		return driver
				.findElement(By.xpath(
						"//li[@class='product ng-scope']/div/h4[contains(text(),'" + product + "')]/following::span"))
				.getText();
	}

	public void clickProduct(String product) {
		driver.findElement(
				By.xpath("//li[@class='product ng-scope']/div/h4[contains(text(),'" + product + "')]/following::a"))
				.click();
	}

}
