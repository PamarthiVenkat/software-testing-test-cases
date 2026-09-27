package tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://letcode.in/window");

        driver.findElement(By.id("multi")).click();

        String parentWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {

            System.out.println("Window ID: " + window);

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                System.out.println("Title: " + driver.getTitle());
                System.out.println("URL: " + driver.getCurrentUrl());
            }
        }

        driver.switchTo().window(parentWindow);

        System.out.println("Parent Title: " + driver.getTitle());

        driver.quit();
    }
}
