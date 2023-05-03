package org.example.Lab_11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private static final String URL = "https://demoqa.com";
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        if (!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }
    }
    public BookStoreApplication bookStore(){
        WebElement bookStoreApplication = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]"));
        bookStoreApplication.click();
        return new BookStoreApplication(driver);
    }
}
