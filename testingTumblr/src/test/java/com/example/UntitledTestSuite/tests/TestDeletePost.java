package com.example.UntitledTestSuite.tests;

import com.example.UntitledTestSuite.models.AccountData;
import com.example.UntitledTestSuite.base.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class TestDeletePost extends TestBase {
    AccountData account = new AccountData("milarosary@gmail.com","Hellotesting09");
    @Test
    public void deletePost() throws Exception {
        applicationManager.getNavigation().openLoginPage();
        applicationManager.getAuth().login(account);
        applicationManager.getNavigation().openDashBoard();
        applicationManager.getNavigation().openBlogPage();
        int then = applicationManager.getPost().getPostCount();
        applicationManager.getNavigation().openPostPage();
        applicationManager.getPost().deleteLastPost();
        applicationManager.getNavigation().openBlogPage();
        int now = applicationManager.getPost().getPostCount();
        applicationManager.getNavigation().openLogoutPage();
        /*Thread.sleep(5000);*/
        /*applicationManager.getNavigation().openLogoutPage();*/
        Assert.assertEquals(then - 1, now);
    }
}
