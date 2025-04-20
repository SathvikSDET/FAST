package com.web;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.pages.LoginPage;

public class TestAuthenticationUi {
	
	WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://swift.techwithjatin.com/login");
        loginPage = new LoginPage(driver);
    }
    
    @Test
    public void testLogin() {
       
        loginPage.login("uday123", "uday123");
        String expectedUrl = "https://swift.techwithjatin.com/dashboard"; 
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Login failed, URL mismatch", expectedUrl, actualUrl);
    }


}
