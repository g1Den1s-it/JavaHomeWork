package org.example.Lab_11.bo;

import org.example.Lab_11.po.BooksStore;
import org.example.Lab_11.po.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProfileBO {
    private WebDriver driver;
    private ProfilePage profilePage;
    private BooksStore booksStore;
    public ProfileBO(LoginBO loginBO) {
        driver = loginBO.getDriver();
    }
    public ProfileBO checkGetBooks() throws InterruptedException {
        profilePage = new ProfilePage(driver);

        Assert.assertTrue(profilePage.isProfilePage());
        booksStore = profilePage.bookStore();
        booksStore.addBooksList();
        profilePage = booksStore.profile();
        Assert.assertTrue(profilePage.isProfilePage());
        Assert.assertTrue(profilePage.isListBooks());
        return this;
    }
}
