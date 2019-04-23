package com.planittesting.jupiterTraining.tests;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;
import com.planittesting.jupiterTraining.model.pages.CartPage;
import com.planittesting.jupiterTraining.model.pages.ShopPage;

public class ShopPageTests extends BaseTest {

	@Test
	public void addProductToCartTest() {

		ShopPage shopPage = new ShopPage(driver);
		shopPage.clickShoplink();
		String price = shopPage.getProductPrice("Stuffed Frog");
		shopPage.clickProduct("Stuffed Frog");
		shopPage.clickProduct("Teddy Bear");
		CartPage cartPage = shopPage.clickCartButton();
		JSONObject cart = cartPage.getCartProducts();
		System.out.println("product:" + cart);

		assertEquals(cart.getJSONObject("Stuffed Frog").get("price"), price);
		assertEquals(cart.getJSONObject("Stuffed Frog").get("quantity"), "1");
		assertEquals(cart.getJSONObject("Stuffed Frog").get("subtotal"), price);
	}

}
