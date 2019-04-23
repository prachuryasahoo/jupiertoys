package com.planittesting.jupiterTraining.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.planittesting.jupiterTraining.model.pages.ContactPage;
import com.planittesting.jupiterTraining.model.pages.HomePage;

public class ContactPageTests extends BaseTest {

	@Test
	public void VerifyEmailValidation() {

		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.clickContactMenu();
		contactPage.enterEmail("abc");
		assertTrue(contactPage.isErrorPresentForEmail());
		assertEquals("Please enter a valid email", contactPage.getEmailErrorMessage());
		contactPage.enterEmail("abc@gmail.com");
		assertFalse(contactPage.isErrorPresentForEmail());

	}

	@Test
	public void ValidateMandatoryFields() {

		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.clickContactMenu();
		contactPage.clickSubmit();
		assertEquals("Forename is required", contactPage.getForeNameErrorMessage());
		assertEquals("Email is required", contactPage.getEmailErrorMessage());
		assertEquals("Message is required", contactPage.gettextErrorMessage());

	}

	@Test
	public void ValidateAllFields() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.clickContactMenu();
		contactPage.enterForeName("testforename");
		contactPage.enterSurName("testsurname");
		contactPage.enterEmailAddress("test@gmail.com");
		contactPage.enterTelephoneNumber("0123456789");
		contactPage.enterMessage("test details");
		contactPage.clickSubmit();
		assertTrue(contactPage.getSubmissionMessage().contains(", we appreciate your feedback"));

	}

}
