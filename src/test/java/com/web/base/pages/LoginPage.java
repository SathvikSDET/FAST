package com.web.base.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.web.base.PomHelperWeb;
import com.utils.LogManagerHelper;

public class LoginPage extends PomHelperWeb {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    // Method to enter username
    public void enterUsername(String user) {
        LogManagerHelper.info("Entering username: " + user);
        username.clear();
        username.sendKeys(user);
    }

    // Method to enter password
    public void enterPassword(String pass) {
        LogManagerHelper.info("Entering password");
        password.clear();
        password.sendKeys(pass);
    }

    // Method to click login button
    public void clickLogin() {
        LogManagerHelper.info("Clicking Login button");
        loginButton.click();
    }

    // Method to perform login
    public void login(String user, String pass) {
        LogManagerHelper.info("Performing login with username: " + user);
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
        LogManagerHelper.info("Login action performed");
    }
}
