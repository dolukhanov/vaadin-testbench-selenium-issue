package com.example.seleniumtest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GooglePageTestPass
{

    private WebDriver driver;

    @BeforeEach
    public void setup()
    {
        // Headless
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--headless" );
        driver = new ChromeDriver( options );
    }

    @Test
    public void testGooglePageLoad()
    {
        // Navigate to Google
        driver.get( "https://www.google.com" );

        // Verify the title contains "Google"
        assertTrue( driver.getTitle().contains( "Google" ), "Page title should contain 'Google'" );

        // Verify the current URL is Google
        assertTrue( driver.getCurrentUrl().contains( "google.com" ), "URL should contain 'google.com'" );
    }

    @AfterEach
    public void tearDown()
    {
        if ( driver != null )
        {
            driver.quit();
        }
    }
} 