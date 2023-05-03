package org.example.Lab_12.po;

import static org.example.Lab_12.WebDriverSupplier.driver;

import org.example.Lab_12.wrapper.Decorator;
import org.example.Lab_12.wrapper.FooterElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static final String URL = "https://demoqa.com";

    //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]"));
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[6]")
    private WebElement bookStoreApplication;

    @FindBy(xpath = "//footer")
    private FooterElement footerElement;

    public HomePage() {
        if (!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }

        PageFactory.initElements(new Decorator(driver), this);
    }

    public BookStoreApplication bookStore(){

        bookStoreApplication.click();
        return new BookStoreApplication();
    }
    public String FooterDiv() throws InterruptedException {
        Thread.sleep(1000);
        return footerElement.waitForFooterVisible();
    }
}
