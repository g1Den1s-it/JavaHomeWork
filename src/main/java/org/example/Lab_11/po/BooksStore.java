package org.example.Lab_11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BooksStore {
    private WebDriver driver;
    public BooksStore(WebDriver driver) {
        this.driver = driver;
    }

    public void addBooksList() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> bookList = driver.findElements(By.xpath("//span[@class=\"mr-2\"]/a"));
        for(WebElement book : bookList){
            Thread.sleep(2000);
            book.click();
            WebElement addToYouCollection = driver.findElement(By.xpath("//div[@class=\"text-right fullButton\"]/button"));
            WebElement backToBookStore = driver.findElement(By.xpath("//div[@class=\"text-left fullButton\"]/button"));
            addToYouCollection.click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
            backToBookStore.click();
        }
    }
    public ProfilePage profile() throws InterruptedException {
        WebElement profile = driver.findElement(By.xpath("//div[@class=\"element-list collapse show\"]/ul/li[@id=\"item-3\"]"));
        profile.click();
        Thread.sleep(1000);
        return new ProfilePage(driver);
    }
}
