package org.example.Lab_11.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void putFirstName(String name) throws InterruptedException {
        Thread.sleep(1000);
        WebElement firstNameInput = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
        firstNameInput.sendKeys(name);
    }
    public  void putLastName(String lastName) throws InterruptedException {
        Thread.sleep(1000);
        WebElement lastNameInput = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
        lastNameInput.sendKeys(lastName);
    }
    public void putUsername(String name) throws InterruptedException {
        Thread.sleep(1000);
        WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        usernameInput.sendKeys(name);
    }
    public void putPassword(String password) throws InterruptedException {
        Thread.sleep(1000);
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInput.sendKeys(password);
    }
    public void register() throws InterruptedException {
        Thread.sleep(1000);
        WebElement register = driver.findElement(By.id("register"));
        register.click();
    }
    public LoginPage login(){
        WebElement backToLogin = driver.findElement(By.xpath("//*[@id=\"gotologin\"]"));
        backToLogin.click();
        return new LoginPage(driver);
    }
}
