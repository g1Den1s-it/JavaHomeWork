package org.example.Lab_12.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.Lab_12.WebDriverSupplier.driver;

public class FooterElement extends Element{
    public FooterElement(WebElement webElement) {
        super(webElement);
    }


    public String waitForFooterVisible(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer")));
        return element.getText();
    }
}
