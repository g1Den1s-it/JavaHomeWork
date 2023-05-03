package Lab_13;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import org.apache.log4j.BasicConfigurator;
import org.example.Lab_12.WebDriverSupplier;
import org.example.Lab_12.bo.LoginBO;
import org.example.Lab_13.SuiteListener;
import org.example.Lab_13.TestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SuiteListener.class, TestListener.class, UniversalVideoListener.class})
public class SignUpLoginTestLister {

    @BeforeTest
    public void setup(){
        BasicConfigurator.configure();
        WebDriverSupplier.setup();
    }
    @Video
    @Test
    public void simpleTest() throws InterruptedException {

        LoginBO loginBO = new LoginBO();
        loginBO.checkSignUpUser();
        loginBO.checkSignInUser();

//        ProfileBO profileBO = new ProfileBO();
//        profileBO.checkGetBooks();
    }
    @Video
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
