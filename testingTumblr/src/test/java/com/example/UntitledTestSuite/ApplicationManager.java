package com.example.UntitledTestSuite;

import com.example.UntitledTestSuite.helpers.LoginHelper;
import com.example.UntitledTestSuite.helpers.NavigationHelper;
import com.example.UntitledTestSuite.helpers.PostHelper;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.fail;

public class ApplicationManager {
    protected String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;
    public WebDriver driver;
    protected NavigationHelper navigation;
    protected LoginHelper auth;
    protected PostHelper post;

    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<ApplicationManager>();


    private ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Milana\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;

        navigation = new NavigationHelper(this, baseUrl);
        auth = new LoginHelper(this);
        post = new PostHelper(this);

        Thread destructorHook = addManagerDestructor(this);
    }
    public void stop()
    {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public LoginHelper getAuth() {
        return auth;
    }

    public PostHelper getPost() {
        return post;
    }

    public static ApplicationManager GetInstance()
    {
        if (app.get() == null){
            ApplicationManager newInstance = new ApplicationManager();
            app.set(newInstance);
        }
        return app.get();
    }
/*    protected void finalize() throws Throwable{
        try
        {
            driver.quit();
        }
        catch (Exception e) {
            //ignore
        }
    }*/

    public static Thread addDestructor(Runnable runnable) {
        Thread hook = new Thread(runnable);
        Runtime.getRuntime().addShutdownHook(hook);
        return hook;
    }

    public static boolean removeDestructor(Thread hook) {
        return Runtime.getRuntime().removeShutdownHook(hook);
    }

    public static Thread addManagerDestructor(ApplicationManager applicationManager) {
        return addDestructor(() -> {
            try {
                applicationManager.driver.quit();
            } catch (Exception ignored) {
            } finally {
                String verificationErrorString = applicationManager.verificationErrors.toString();
                if (!verificationErrorString.equals("")) {
                    Assert.fail(verificationErrorString);
                }
            }
        });
    }

}
