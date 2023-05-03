package org.example.Lab_11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStoreApplication {
    private WebDriver driver;
    public BookStoreApplication(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage login() throws InterruptedException {
        WebElement login = driver.findElement(By.xpath("//div[@class=\"element-list collapse show\"]/ul/li[@id=\"item-0\"]"));
        login.click();
        Thread.sleep(1000);
        return new LoginPage(driver);
    }

    public boolean isOpen() throws InterruptedException {
        WebElement booksWrapper = driver.findElement(By.xpath("//div[@class=\"books-wrapper\"]"));
        Thread.sleep(1000);
        return  booksWrapper.isDisplayed();
    }
}
