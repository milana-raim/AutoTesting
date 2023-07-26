package com.example.UntitledTestSuite.tests;

import com.example.UntitledTestSuite.models.AccountData;
import com.example.UntitledTestSuite.base.TestBase;
import org.junit.*;

public class TestPost extends TestBase {
    AccountData account = new AccountData("milarosary@gmail.com","Hellotesting09");
    @Test
    public void newPost() throws Exception {
        applicationManager.getNavigation().openLoginPage();
        applicationManager.getAuth().login(account);
        applicationManager.getNavigation().openDashBoard();
        applicationManager.getNavigation().openBlogPage();
        int then = applicationManager.getPost().getPostCount();
        /*applicationManager.getNavigation().openDashBoard();*/
        applicationManager.getNavigation().openNewTextPost();
        applicationManager.getPost().createPost();
        applicationManager.getNavigation().openNewPost();
        applicationManager.getNavigation().openBlogPage();

        int now = applicationManager.getPost().getPostCount();
        /*Thread.sleep(5000);*/
        applicationManager.getNavigation().openLogoutPage();

        Assert.assertEquals(then + 1, now);
    }
}