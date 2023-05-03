package Lab_12_test;

import org.example.Lab_12.bo.LoginBO;
import org.example.Lab_12.bo.ProfileBO;
import org.example.Lab_12.WebDriverSupplier;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SignUpLoginTest {


    private WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverSupplier.setup();
    }

    @Test
    public void simpleTest() throws InterruptedException {

        LoginBO loginBO = new LoginBO();
        loginBO.checkSignUpUser();

        ProfileBO profileBO = new ProfileBO();
        profileBO.checkGetBooks();
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        WebDriverSupplier.close();
    }
}
