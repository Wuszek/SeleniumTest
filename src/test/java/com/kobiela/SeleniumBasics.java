package com.kobiela;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class SeleniumBasics {

    public ChromeDriver webDriver;
    public WebDriverWait wait;

    @Before
    public void Setup(){
        // Ustawienie ścieżki do ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Uruchomienie przeglądarki
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();

        // Implicit wait
        this.webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // Explicit wait
        //this.wait = new WebDriverWait(this.webDriver, 10);

        this.webDriver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        // Wylacz przegladarke
        this.webDriver.quit();
    }


    @Test
    public void testSignUp() throws InterruptedException {

        WebElement signInButton = webDriver.findElement(By.linkText("Sign in"));
        signInButton.click();

        //TimeUnit.SECONDS.sleep(2);
        //wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("/html//input[@id='email_create']"), true));
        WebElement emailCreate = webDriver.findElement(By.xpath("/html//input[@id='email_create']"));

        emailCreate.click();
        emailCreate.sendKeys("test@testowisko.pl");


        WebElement createAccount = webDriver.findElement(By.cssSelector("#create-account_form span"));
        createAccount.click();
        //TimeUnit.SECONDS.sleep(5);


        WebElement Mr = webDriver.findElement(By.xpath("/html//form[@id='account-creation_form']/div[1]/div[1]/div[2]/label[@class='top']/div[@class='radio']//input[@name='id_gender']"));
        //wait.until(ExpectedConditions.elementSelectionStateToBe(Mr, true));
        Mr.click();

        WebElement firstName = webDriver.findElement(By.xpath("/html//input[@id='customer_firstname']"));
        firstName.sendKeys("Test");

        WebElement lastName = webDriver.findElement(By.xpath("/html//input[@id='customer_lastname']"));
        lastName.sendKeys("Testowski");

        WebElement passwd = webDriver.findElement(By.xpath("/html//input[@id='passwd']"));
        passwd.sendKeys("Test111");

        WebElement days = webDriver.findElement(By.xpath("/html//select[@id='days']"));
        days.sendKeys("5");

        WebElement months = webDriver.findElement(By.xpath("/html//select[@id='months']"));
        months.sendKeys("apr");

        WebElement years = webDriver.findElement(By.xpath("/html//select[@id='months']"));
        years.sendKeys("1994");

        WebElement adress = webDriver.findElement(By.cssSelector("[name='address1']"));
        adress.sendKeys("Malinowa 77");

        WebElement city = webDriver.findElement(By.cssSelector("#city"));
        city.sendKeys("Denver");

        WebElement state = webDriver.findElement(By.cssSelector("#id_state"));
        state.sendKeys("new y");

        WebElement mobilePhone = webDriver.findElement(By.cssSelector("#phone_mobile"));
        mobilePhone.sendKeys("500 500 500");



    }

}
