package webTest_lab_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class webTest {
    private WebDriver driver;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeDriverManager.getInstance().setup();
        driver = driver = new ChromeDriver();
    }

    @Test
    public void simpleTest() throws InterruptedException {

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
        Assert.assertTrue(searchInput.isDisplayed());

        //2 element
        Thread.sleep(2000);
        WebElement nextBotton = driver.findElement(By.xpath("//div[@class=\"-next\"]/button[@class=\"-btn\"]"));
        Assert.assertTrue(nextBotton.isDisplayed());

        //3 element
        Thread.sleep(2000);
        WebElement previosBotton = driver.findElement(By.xpath("//div[@class=\"-previous\"]/button[@class=\"-btn\"]"));
        Assert.assertTrue(previosBotton.isDisplayed());

        // 4 element
        Thread.sleep(2000);
        List<WebElement> booksList = driver.findElements(By.xpath("//*[@id=\"delete-record-undefined\"]"));
        booksList.forEach(b-> {Assert.assertTrue(b.isDisplayed());});

        // 5 element
        Thread.sleep(2000);
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        Assert.assertTrue(logout.isDisplayed());
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
