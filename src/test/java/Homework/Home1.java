package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Home1 {

    @Test
    public void TestCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/" );
        driver.manage().window().maximize();

        WebElement options1=driver.findElement(By.xpath("//select[@name='stockType']"));
        Select select1=new Select(options1);
        select1.selectByValue("28444");
        Thread.sleep(1000);

        WebElement options2=driver.findElement(By.name("makeId"));
        Select select2=new Select(options2);
        select2.selectByVisibleText("Toyota");
        Thread.sleep(1000);

        WebElement options3=driver.findElement(By.name("modelId"));
        Select select3=new Select(options3);
        select3.selectByVisibleText("Corolla");
        Thread.sleep(1000);

        WebElement options4=driver.findElement(By.name("priceMax"));
        Select select4=new Select(options4);
        select4.selectByValue("30000");
        Thread.sleep(1000);

        WebElement options5=driver.findElement(By.name("radius"));
        Select select5=new Select(options5);
        select5.selectByVisibleText("40 Miles from");
        WebElement checkStep2 = driver.findElement(By.xpath("//option[@value='40']"));
        Assert.assertEquals(true , checkStep2.isSelected());
        Thread.sleep(1000);

        WebElement zipCode=driver.findElement(By.xpath("//input[@aria-label='Enter a Zip Code']"));
        zipCode.clear();
        zipCode.sendKeys("60018");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div//input[@type='submit']")).submit();
        Thread.sleep(1000);

        WebElement title=driver.findElement(By.xpath("//header//div//ul//li//label[contains(text(),'Certified Used')]"));
        String title1=title.getText();
//      System.out.println(title1);
//        String actualTitle=driver.getTitle();
//        System.out.println(driver.getCurrentUrl());
//        System.out.println(actualTitle);

        String expectedTitle="Certified Used";
        Assert.assertEquals(title1,expectedTitle);

        boolean result=driver.findElement(By.xpath("//h1[@class='srp-header']")).isDisplayed();
        boolean expectedResult=true;
        Assert.assertTrue(result==expectedResult);

        Thread.sleep(1000);//form//ul//ul//div//div//select[@name='rd']
        WebElement miles=driver.findElement(By.xpath("//option[@value='40']"));
        boolean mil=miles.isSelected();
        boolean milExp=true;
        Assert.assertTrue(mil==milExp,"miles");

        Thread.sleep(1000);
        WebElement certified=driver.findElement(By.id("stkTypId-28444"));
        boolean certi=certified.isSelected();
        boolean certiExp=true;
        Assert.assertTrue(certi==certiExp);

        Thread.sleep(1000);
        WebElement toyata=driver.findElement(By.id("mkId-20088"));
        boolean toy=toyata.isSelected();
        boolean toyExp=true;
        Assert.assertTrue(toy==toyExp);

        Thread.sleep(1000);
        WebElement coralla=driver.findElement(By.id("mdId-20861"));
        boolean cor=coralla.isSelected();
        boolean corExp=true;
        Assert.assertTrue(cor==corExp);

    }
}
