package com.example.UntitledTestSuite.helpers;

import com.example.UntitledTestSuite.ApplicationManager;
import com.example.UntitledTestSuite.base.HelperBase;

public class NavigationHelper extends HelperBase {
    private String baseURL;
    public NavigationHelper(ApplicationManager applicationManager, String baseURL) {
        super(applicationManager);
        this.baseURL = baseURL;
    }

    public void openDashBoard() {
        driver.get("https://www.tumblr.com/dashboard");
    }

    public void openLogoutPage(){
        driver.get("https://www.tumblr.com/logout");
    }
    public void openLoginPage() {
        driver.get("https://www.tumblr.com/login");
    }

    public void openPostPage() {
        driver.get("https://www.tumblr.com/angrykingdomprincess");
    }
    public void openBlogPage() {
        driver.get("https://www.tumblr.com/blog/angrykingdomprincess");
    }
    public void openNewPost() {
        driver.get("https://www.tumblr.com/new");
    }
    public void openNewTextPost() {
        driver.get("https://www.tumblr.com/new/text");
    }

    public void OpenSettings() {
        driver.get("https://www.tumblr.com/settings/account");
    }
}
