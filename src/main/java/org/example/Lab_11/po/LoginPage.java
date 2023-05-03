package org.example.Lab_11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void putUsername() throws InterruptedException {
        WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        usernameInput.sendKeys("gDen");
        Thread.sleep(1000);
    }

    public void putPassword() throws InterruptedException {
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInput.sendKeys("wMD@1zY289sN");
        Thread.sleep(1000);
    }

    public void login() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        loginButton.click();
        Thread.sleep(1000);
    }
    public boolean isAuthorizated() throws InterruptedException {
        WebElement username =  driver.findElement(By.xpath("//*[@id=\"userName-value\"]"));
        Thread.sleep(1000);
        return  username.isDisplayed();
    }
    public SignUpPage signUp(){
        WebElement signUp = driver.findElement(By.xpath("//*[@id=\"newUser\"]"));
        signUp.click();
        return new SignUpPage(driver);
    }
    public ProfilePage profile(){
        return new ProfilePage(driver);
    }

    public boolean isLoginPage() throws InterruptedException {
        Thread.sleep(1000);
        WebElement login = driver.findElement(By.xpath("//div[@class=\"login-wrapper\"]"));
        return login.isDisplayed();
    }
}
