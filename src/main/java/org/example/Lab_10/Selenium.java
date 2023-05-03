package org.example.Lab_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.http.WebSocket;
import java.util.List;

public class Selenium {
//    Setup ChromeDriver using driver file and properties.
//    Setup ChromeDriver using DriverManager.
//    My first UI test:
//    go to the page from your variant
//    choose any 5 different elements;
//    Use different WebElement methods to communicate with those elements. (one element - at least one interaction)
//    Make a testNG test case to check visibility of your elements.

    public static void main(String[] args) throws InterruptedException {
        //    Setup ChromeDriver using driver file and properties.
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");


        //    Setup ChromeDriver using DriverManager.
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");

        WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]"));

        usernameInput.sendKeys("gDen");
        passwordInput.sendKeys("wMD@1zY289sN");
        loginButton.click();


        //1 element
        Thread.sleep(2000);
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"searchBox\"]"));
        searchInput.sendKeys("Learning JavaScript Design Patterns");
        Thread.sleep(1000);
        searchInput.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;

        //2 element
        Thread.sleep(2000);
        WebElement nextBotton = driver.findElement(By.xpath("//div[@class=\"-next\"]/button[@class=\"-btn\"]"));
        nextBotton.sendKeys(Keys.RETURN);

        //3 element
        Thread.sleep(2000);
        WebElement previosBotton = driver.findElement(By.xpath("//div[@class=\"-previous\"]/button[@class=\"-btn\"]"));
        previosBotton.sendKeys(Keys.RETURN);

        // 4 element
        Thread.sleep(2000);
        List<WebElement> booksList = driver.findElements(By.xpath("//*[@id=\"delete-record-undefined\"]"));
        booksList.get(0).click();
        WebElement ok = driver.findElement(By.xpath("//*[@id=\"closeSmallModal-ok\"]"));
        Thread.sleep(1000);
        ok.click();

        // 5 element
        Thread.sleep(2000);
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        logout.sendKeys(Keys.RETURN);

        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
