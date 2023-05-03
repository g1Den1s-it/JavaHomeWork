package Lab_14;

import org.apache.log4j.BasicConfigurator;
import org.example.Lab_12.WebDriverSupplier;
import org.example.Lab_12.bo.LoginBO;
import org.example.Lab_14.AllureListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class SignUpLoginTestAllure {

    @BeforeTest
    public void setup(){
        BasicConfigurator.configure();
        WebDriverSupplier.setup();
    }

    @Test
    public void simpleTest() throws InterruptedException {

        LoginBO loginBO = new LoginBO();
        loginBO.checkSignUpUser();
        loginBO.checkSignInUser();

//        ProfileBO profileBO = new ProfileBO();
//        profileBO.checkGetBooks();
    }

    @Test
    public void endToEndFailTEst(){
        LoginBO loginBO = new LoginBO();
        loginBO.fail();
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        WebDriverSupplier.close();
    }
}
