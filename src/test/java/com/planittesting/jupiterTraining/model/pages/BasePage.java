package com.planittesting.jupiterTraining.model.pages;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;

	}

	public BasePage() {
	}

	String url = "http://jupiter.cloud.planittesting.com/";

	public CartPage clickCartButton() {
		driver.findElement(By.xpath("//a[@href='#/cart']")).click();
		return new CartPage(driver);
	}

	public ShopPage clickShoplink() {
		driver.findElement(By.cssSelector("#nav-shop a")).click();
		return new ShopPage(driver);
	}

	public ContactPage clickContactMenu() {
		// TODO Auto-generated method stub
		driver.findElement(By.cssSelector("#nav-contact a")).click();
		return new ContactPage(driver);

	}

}
