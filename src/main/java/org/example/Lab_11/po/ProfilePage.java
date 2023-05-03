package org.example.Lab_11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProfilePage(){
        WebElement profile = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]"));
        return profile.isDisplayed();
    }

    public BooksStore bookStore() throws InterruptedException {
        WebElement bookToStore = driver.findElement(By.id("gotoStore"));
        bookToStore.click();
        Thread.sleep(1000);
        return new BooksStore(driver);
    }

    public boolean isListBooks() {
        List<WebElement> booksList = driver.findElements(By.xpath("//div[@class=\"rt-tr-group\"]"));
        boolean isBooksDisplayed = true;
        for(WebElement book : booksList){
           if(!book.isDisplayed()){
               isBooksDisplayed = false;
           }
        }
        return isBooksDisplayed;
    }
}
