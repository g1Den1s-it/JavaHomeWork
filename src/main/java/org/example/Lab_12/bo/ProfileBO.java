package org.example.Lab_12.bo;

import org.example.Lab_12.po.BooksStore;
import org.example.Lab_12.po.ProfilePage;
import org.testng.Assert;

public class ProfileBO {
    private ProfilePage profilePage;
    private BooksStore booksStore;

    public ProfileBO checkGetBooks() throws InterruptedException {
        profilePage = new ProfilePage();

        Assert.assertTrue(profilePage.isProfilePage());
        booksStore = profilePage.bookStore();
        booksStore.addBooksList();
        profilePage = booksStore.profile();
        Assert.assertTrue(profilePage.isProfilePage());
        Assert.assertTrue(profilePage.isListBooks());
        return this;
    }
}
