package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().browserVersionDetectionCommand("google-chrome --version | cut -d ' ' -f 3");
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver()
                .driverVersion("116.0.5845.96") // Set the desired ChromeDriver version
                .cachePath("'https://googlechromelabs.github.io/chrome-for-testing/last-known-good-versions-with-downloads.json'") // Set the path where ChromeDriver will be downloaded
                .setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);
        String appUrl = "https://www.saucedemo.com/";
        driver.get(appUrl);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

          String c = "ini xpath";
          Thread.sleep(3000);
          driver.findElement(By.xpath(c)).click();
          Select a = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
          a .selectByVisibleText("locator");

         String b = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
 
         System.out.println(b);

         driver.findElement(By.xpath("//h1[@class='entry-title']")).isDisplayed();
          driver.quit();

        Thread.sleep(5000);

        driver.quit();
    }

}
