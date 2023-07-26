package com.example.UntitledTestSuite.helpers;

import com.example.UntitledTestSuite.ApplicationManager;
import com.example.UntitledTestSuite.base.HelperBase;
import com.example.UntitledTestSuite.models.AccountData;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {
    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(AccountData account) {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(account.getLogin());
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(account.getPassword());
        driver.findElement(By.xpath("//section[@id='Вперед!']/div/div/div[2]/div/section/div[2]/form/button/span")).click();
    }
    public String getEmail(){
        String email = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/main/div/div/section[1]/div[2]/div[1]/div[1]")).getText();
        return email;
    }

}
