package org.example.Lab_12;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSupplier {
    public static WebDriver driver;

    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }
    public static void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
