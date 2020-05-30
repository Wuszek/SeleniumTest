package com.kobiela;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class SeleniumBasics {

    public ChromeDriver webDriver;
    public WebDriverWait wait;

    @Before
    public void Setup(){
        BasicConfigurator.configure();
        // ChromeDriver path setup
        WebDriverManager.chromedriver().setup();
        // Browser start
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



        WebElement days = webDriver.findElement(By.name("days"));
        Select daysDropdown =  new Select(days);
        daysDropdown.selectByValue("5");

// Works slower than method below
//        Select monthsDropdown = new Select(webDriver.findElement(By.id("months")));
//        monthsDropdown.selectByVisibleText("April ");


        WebElement months = webDriver.findElement(By.xpath("/html//select[@id='months']"));
        months.sendKeys("apr");


        Select yearsDropdown = new Select(webDriver.findElement(By.id("years")));
        yearsDropdown.selectByIndex(27);


// My method

//        WebElement days = webDriver.findElement(By.xpath("/html//select[@id='days']"));
//        days.sendKeys("5");

//        WebElement months = webDriver.findElement(By.xpath("/html//select[@id='months']"));
//        months.sendKeys("apr");
//
//        WebElement years = webDriver.findElement(By.xpath("/html//select[@id='months']"));
//        years.sendKeys("1994");

        WebElement adress = webDriver.findElement(By.cssSelector("[name='address1']"));
        adress.sendKeys("Malinowa 77");

        WebElement city = webDriver.findElement(By.cssSelector("#city"));
        city.sendKeys("Denver");

        Select stateDropdown = new Select(webDriver.findElementByCssSelector("#id_state"));
        stateDropdown.selectByVisibleText("New York");

        Select countryDropdown = new Select(webDriver.findElementByCssSelector("#id_country"));
        countryDropdown.selectByVisibleText("United States");


        WebElement mobilePhone = webDriver.findElement(By.cssSelector("#phone_mobile"));
        mobilePhone.sendKeys("500 500 500");



    }

}
