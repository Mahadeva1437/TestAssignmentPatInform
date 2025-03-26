package com.qa.pages;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class patInfoPage extends BasePage {

	public patInfoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@class='searchField']")
	WebElement searchField;

	@FindBy(xpath = "//button[text()='I have read and agree to the terms']")
	WebElement alertPopUp;

	@FindBy(xpath = "//button[@class='margin-right']")
	WebElement searchButton;

	@FindBy(xpath = "//table[@class='results']/tbody/tr[1]/td[3]/ul/li[1]")
	WebElement linkClick;

	@FindBy(xpath = "//table[@class='results']/tbody/tr[1]/td[3]/ul/li[1]")
	List<WebElement> elements;

	@FindBy(xpath = "//b[text()='Filing date']/../following-sibling::td")
	List<WebElement> elementsDates;

	public void endtoendcases(String key) throws InterruptedException {
		

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		searchField.sendKeys(key);

		// Wait for the alert popup to be clickable and then click
		wait.until(ExpectedConditions.elementToBeClickable(alertPopUp)).click();
 		// Wait for the search button to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

		// Wait for the link to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(linkClick)).click();

		System.out.println(linkClick.getText());
		Thread.sleep(3000);
		List<WebElement> elements = driver
				.findElements(By.xpath("//b[text()='Publication date']/../following-sibling::td"));
		List<WebElement> elementsDates = driver
				.findElements(By.xpath("//b[text()='Filing date']/../following-sibling::td"));

//Loop through the elements to print the values in the desired format
		for (int i = 0; i < Math.min(Math.min(elements.size(), elementsDates.size()), 1); i++) {
			// Extract the text content from both elements
			String publicationDate = elements.get(i).getText();
			String filingDate = elementsDates.get(i).getText();

			// Calculate the year difference for the "X years ago" part
			int publicationYear = Integer.parseInt(publicationDate.split("-")[0]);
			int filingYear = Integer.parseInt(filingDate.split("-")[0]);

			// Print the formatted result
			System.out.println("Filing date: " + filingDate + " (" + filingYear + " years ago)");
			System.out.println("Publication date: " + publicationDate + " (" + publicationYear + " years ago)");

		}

	}

	

}
