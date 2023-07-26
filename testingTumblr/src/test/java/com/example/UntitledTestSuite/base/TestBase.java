package com.example.UntitledTestSuite.base;

import com.example.UntitledTestSuite.ApplicationManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.fail;

public class TestBase{

protected ApplicationManager applicationManager;

    @Before
    public void setUp() throws Exception {
        applicationManager = ApplicationManager.GetInstance();
    }

/*    @After
    public void tearDown() throws Exception {
        applicationManager.stop();
    }*/


}
