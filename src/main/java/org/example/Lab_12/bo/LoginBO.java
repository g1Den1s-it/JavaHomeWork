package org.example.Lab_12.bo;


import org.example.Lab_12.po.BookStoreApplication;
import org.example.Lab_12.po.HomePage;
import org.example.Lab_12.po.LoginPage;
import org.example.Lab_12.po.SignUpPage;
import org.testng.Assert;
public class LoginBO {
    private HomePage homePage;
    private BookStoreApplication bookStoreApplication;
    private LoginPage loginPage;
    private SignUpPage signUpPage;

    public LoginBO checkSignUpUser() throws InterruptedException {
        homePage = new HomePage();
        homePage.FooterDiv();
        Thread.sleep(1000);

        // 2 - click Book Store Application
        bookStoreApplication = homePage.bookStore();
        Assert.assertTrue(bookStoreApplication.isOpen());


        // 2.1 - go to Login
        loginPage = bookStoreApplication.login();

        Assert.assertTrue(loginPage.isLoginPage());

        signUpPage = loginPage.signUp();

        signUpPage.putFirstName("qwerty");
        signUpPage.putLastName("ytrewq");
        signUpPage.putUsername("qwerty09");
        signUpPage.putPassword("3mgT1R5#rtTz");
        //signUpPage.register();
        return this;
    }
    public LoginBO checkSignInUser() throws InterruptedException {
        loginPage = signUpPage.login();

        loginPage.putUsername();
        loginPage.putPassword();
        loginPage.login();
        Assert.assertTrue(loginPage.isAuthorizated());

        return this;
    }

    public void fail() {
        Assert.fail();
    }
}

