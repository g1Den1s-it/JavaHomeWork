package org.example.Lab_12.po;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.Lab_12.WebDriverSupplier.driver;

public class BooksStore {
    public BooksStore() {
        PageFactory.initElements(driver, this);
    }

    //driver.findElements(By.xpath("//span[@class=\"mr-2\"]/a"));
    @FindBy(xpath = "//span[@class=\"mr-2\"]/a")
    private List<WebElement> bookList;
    //driver.findElement(By.xpath("//div[@class=\"text-right fullButton\"]/button"));
    @FindBy(xpath = "//div[@class=\"text-right fullButton\"]/button")
    private WebElement addToYouCollection;
    //driver.findElement(By.xpath("//div[@class=\"text-left fullButton\"]/button"));
    @FindBy(xpath = "//div[@class=\"text-left fullButton\"]/button")
    private WebElement backToBookStore;
    //driver.findElement(By.xpath("//div[@class=\"element-list collapse show\"]/ul/li[@id=\"item-3\"]"));
    @FindBy(xpath = "//div[@class=\"element-list collapse show\"]/ul/li[@id=\"item-3\"]")
    private WebElement profile;

    public void addBooksList() throws InterruptedException {
        Thread.sleep(2000);
        for(WebElement book : bookList){
            Thread.sleep(2000);
            book.click();
            addToYouCollection.click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
            backToBookStore.click();
        }
    }
    public ProfilePage profile() throws InterruptedException {

        profile.click();
        Thread.sleep(1000);
        return new ProfilePage();
    }
}
