package Lab_11;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.example.Lab_11.bo.LoginBO;
import org.example.Lab_11.bo.ProfileBO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EndToEndTest {

    private static WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void simpleTest() throws InterruptedException {
        // 1 - go to https://demoqa.com

        // 2 - click Book Store Application
        // 2.1 - go to Login
        // 2.2 - click New User
        // 2.3 - register new user

        // 3 - sign in
        // 3.1 verify loggin in

        // 4 add books to collection
        // 4.1 verify in my collection

        LoginBO loginBO = new LoginBO(driver);
        loginBO.checkSignUpUser();

        ProfileBO profileBO = new ProfileBO(loginBO.checkSignInUser());
        profileBO.checkGetBooks();
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
