package com.example.UntitledTestSuite.helpers;

import com.example.UntitledTestSuite.ApplicationManager;
import com.example.UntitledTestSuite.base.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostHelper extends HelperBase {
    public PostHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createPost() {
/*
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Новые посты'])[1]/preceding::*[name()='svg'][2]")).click();
*/
        /*driver.get("https://www.tumblr.com/new");*/
/*
        driver.get("https://www.tumblr.com/new/text");
*/
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/div[4]/div/div/div[1]/div[1]/textarea")).sendKeys("тестирую");
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[4]/div/div/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div/button"))).click();

    }

    public void deleteLastPost() {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='angrykingdomprincess'])[1]/following::*[name()='svg'][1]")).click();
        /*driver.findElement(By.name("Удалить")).click();*/
        driver.findElement(By.xpath("/html/body/div/div/div[4]/div/div/div/div[4]")).click();
        driver.findElement(By.xpath("//*[@id='glass-container']/div[2]/div[2]/div[2]/button[2]/span")).click();
    }

    public int getPostCount() {
        /*driver.get("https://www.tumblr.com/blog/angrykingdomprincess");*/
        int text = Integer.parseInt(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/aside/div[1]/aside/ul/li[2]/a/span[2]")).getText());
        return text;
    }
}