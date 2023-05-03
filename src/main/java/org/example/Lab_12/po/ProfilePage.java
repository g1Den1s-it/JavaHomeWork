package org.example.Lab_12.po;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.Lab_12.WebDriverSupplier.driver;

public class ProfilePage {
    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    //driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]"));
    @FindBy(xpath = "//div[@class=\"profile-wrapper\"]")
    private WebElement profile;
    //driver.findElement(By.id("gotoStore"));
    @FindBy(id = "gotoStore")
    private WebElement bookToStore;
    //driver.findElements(By.xpath("//div[@class=\"rt-tr-group\"]"));
    @FindBy(xpath = "//div[@class=\"rt-tr-group\"]")
    private List<WebElement> booksList;

    public boolean isProfilePage(){
        return profile.isDisplayed();
    }

    public BooksStore bookStore() throws InterruptedException {
        bookToStore.click();
        Thread.sleep(1000);
        return new BooksStore();
    }

    public boolean isListBooks() {
        boolean isBooksDisplayed = true;
        for(WebElement book : booksList){
           if(!book.isDisplayed()){
               isBooksDisplayed = false;
           }
        }
        return isBooksDisplayed;
    }
}
