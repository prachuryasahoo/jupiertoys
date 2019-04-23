package com.planittesting.jupiterTraining.model.pages;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
	
	JSONObject product= new JSONObject();
	

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public JSONObject getCartProducts() {
		readCartTable();
		return product;
	}
	
	private int getIndexOf(String name) {
		List<WebElement> headers = driver.findElements(By.xpath("//table//th"));
		
		return headers.indexOf(driver.findElement(By.xpath("//table/thead//th[text()='"+name+"']")))+1;
	}
	
	private void readCartTable() {
		
		List<WebElement> records = driver.findElements(By.xpath("//table/tbody/tr"));
		
		for(int i=0;i<records.size();i++) {
			WebElement record = records.get(i);
			String productName=record.findElement(By.xpath("td["+getIndexOf("Item")+"]")).getText();
			String price=record.findElement(By.xpath("td["+getIndexOf("Price")+"]")).getText();
			
			String quantity=record.findElement(By.xpath("td["+getIndexOf("Quantity")+"]/input")).getAttribute("value");
			String subtotal=record.findElement(By.xpath("td["+getIndexOf("Subtotal")+"]")).getText();
			
			JSONObject values = new JSONObject();
			
			values.put("price", price);
			values.put("quantity", quantity);
			values.put("subtotal", subtotal);
			
			
			
			product.put(productName, values);
		}
	}
}
