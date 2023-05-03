package org.example.Lab_12.po;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.Lab_12.WebDriverSupplier.driver;

public class BookStoreApplication {
    public BookStoreApplication() {
        PageFactory.initElements(driver, this);
    }

    //driver.findElement(By.xpath("//div[@class=\"element-list collapse show\"]/ul/li[@id=\"item-0\"]"));
    @FindBy(xpath = "//div[@class=\"element-list collapse show\"]/ul/li[@id=\"item-0\"]")
    private WebElement login;

    //driver.findElement(By.xpath("//div[@class=\"books-wrapper\"]"));
    @FindBy(xpath = "//div[@class=\"books-wrapper\"]")
    private WebElement booksWrapper;

    public LoginPage login() throws InterruptedException {
        login.click();
        Thread.sleep(1000);
        return new LoginPage();
    }

    public boolean isOpen() throws InterruptedException {
        Thread.sleep(1000);
        return  booksWrapper.isDisplayed();
    }
}
