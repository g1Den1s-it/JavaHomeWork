package org.example.Lab_12.po;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Lab_12.WebDriverSupplier.driver;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //driver.findElement(By.xpath("//*[@id=\"userName\"]"));
    @FindBy(xpath = "//*[@id=\"userName\"]")
    private WebElement usernameInput;

    //driver.findElement(By.xpath("//*[@id=\"password\"]"));
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordInput;

    //driver.findElement(By.xpath("//*[@id=\"login\"]"));
    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement loginButton;

    //driver.findElement(By.xpath("//*[@id=\"userName-value\"]"));
    @FindBy(xpath = "//*[@id=\"userName-value\"]")
    private WebElement username;

    //driver.findElement(By.xpath("//*[@id=\"newUser\"]"));
    @FindBy(xpath = "//*[@id=\"newUser\"]")
    private WebElement signUp;

    //driver.findElement(By.xpath("//div[@class=\"login-wrapper\"]"));
    @FindBy(xpath = "//div[@class=\"login-wrapper\"]")
    private WebElement login;

    public void putUsername() throws InterruptedException {

        usernameInput.sendKeys("gDen");
        Thread.sleep(1000);
    }

    public void putPassword() throws InterruptedException {
        passwordInput.sendKeys("wMD@1zY289sN");
        Thread.sleep(1000);
    }

    public void login() throws InterruptedException {
        loginButton.click();
        Thread.sleep(1000);
    }
    public boolean isAuthorizated() throws InterruptedException {
        Thread.sleep(1000);
        return  username.isDisplayed();
    }
    public SignUpPage signUp(){
        signUp.click();
        return new SignUpPage();
    }
    public ProfilePage profile(){
        return new ProfilePage();
    }

    public boolean isLoginPage() throws InterruptedException {
        Thread.sleep(1000);
        return login.isDisplayed();
    }
}
