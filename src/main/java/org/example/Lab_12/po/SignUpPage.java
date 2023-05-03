package org.example.Lab_12.po;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Lab_12.WebDriverSupplier.driver;

public class SignUpPage {
    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    //driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private  WebElement firstNameInput;

    //driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
    @FindBy(xpath = "//*[@id=\"lastname\"]")
    private WebElement lastNameInput;

    //driver.findElement(By.xpath("//*[@id=\"userName\"]"));
    @FindBy(xpath = "//*[@id=\"userName\"]")
    private WebElement usernameInput;

    //driver.findElement(By.xpath("//*[@id=\"password\"]"));
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordInput;

    //driver.findElement(By.id("register"));
    @FindBy(id = "register")
    private WebElement register;

    //driver.findElement(By.xpath("//*[@id=\"gotologin\"]"));
    @FindBy(xpath = "//*[@id=\"gotologin\"]")
    private WebElement backToLogin;


    public void putFirstName(String name) throws InterruptedException {
        Thread.sleep(300);
        firstNameInput.sendKeys(name);
    }
    public  void putLastName(String lastName) throws InterruptedException {
        Thread.sleep(300);
        lastNameInput.sendKeys(lastName);
    }
    public void putUsername(String name) throws InterruptedException {
        Thread.sleep(300);
        usernameInput.sendKeys(name);
    }
    public void putPassword(String password) throws InterruptedException {
        Thread.sleep(300);
        passwordInput.sendKeys(password);
    }
    public void register() throws InterruptedException {
        Thread.sleep(300);
        register.click();
    }
    public LoginPage login(){
        backToLogin.click();
        return new LoginPage();
    }
}
