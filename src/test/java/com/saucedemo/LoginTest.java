package com.saucedemo;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    @Test
    void testLoginAndSort() {
  
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("https://www.saucedemo.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            assertEquals("Swag Labs", driver.getTitle());

            wait.until(ExpectedConditions.elementToBeClickable(By.className("product_sort_container")));
            driver.findElement(By.className("product_sort_container")).click();
            driver.findElement(By.xpath("//option[@value='az']")).click();

        } finally {
       
            driver.quit();
        }
    }
}
