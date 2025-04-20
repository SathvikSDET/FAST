package com.web.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.WebExceptions;

public class PomHelperWeb {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public PomHelperWeb(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public WebElement findElement(WebElement element) throws WebExceptions {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			throw new WebExceptions(WebExceptions.ExceptionType.ELEMENT_NOT_FOUND,
					"Element not found or not visible: " + element);
		}
	}

}
