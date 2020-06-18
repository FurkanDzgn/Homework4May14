package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Home2 {

    @Test
    public void TestCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.navigate().to("https://www.cars.com/");
        driver.manage().window().maximize();

        Thread.sleep(1000);
        WebElement cars=driver.findElement(By.xpath("//select[@name='stockType']"));
        Select select=new Select(cars);
        select.selectByVisibleText("Certified Cars");

        Thread.sleep(1000);
        WebElement allCars=driver.findElement(By.name("makeId"));
        Select select1=new Select(allCars);
        select1.selectByValue("20070");

        Thread.sleep(1000);
        WebElement models=driver.findElement(By.name("modelId"));
        Select select2=new Select(models);
        select2.selectByVisibleText("- ES 350");

        Thread.sleep(1000);
        WebElement prices=driver.findElement(By.cssSelector("select[name=priceMax]"));
        Select select3=new Select(prices);
        select3.selectByValue("50000");

        Thread.sleep(1000);
        WebElement miles=driver.findElement(By.name("radius"));
        Select select4=new Select(miles);
        select4.selectByVisibleText("50 Miles from");

        Thread.sleep(1000);
        WebElement zipCode=driver.findElement(By.xpath("//input[@aria-label='Enter a Zip Code']"));
        zipCode.clear();
        zipCode.sendKeys("60016");

        Thread.sleep(1000);
        driver.findElement(By.className("NZE2g")).submit();

        Thread.sleep(1000);
        List<WebElement> carsLexus=driver.findElements(By.xpath("//div[@class='listing-row__details']"));

        int size=carsLexus.size();
        System.out.println("Get count of all the cars which is displayed on first page --> "+size);

        Assert.assertTrue(size<=20);

        Thread.sleep(1000);
        List<WebElement> carNames=driver.findElements(By.xpath("//div[@class='listing-row__details']//h2[contains(text(),'Lexus ES 350')]"));
            for(WebElement name:carNames){
       //    System.out.println(name.getText());
             Assert.assertTrue(name.getText().contains("Lexus ES 350"));
              }

        Thread.sleep(1000);
        List<WebElement> getMiles=driver.findElements(By.xpath("//div[@class='listing-row__details']//span[@class='listing-row__mileage']"));
        for(WebElement mile:getMiles){
      //      System.out.println(mile.getText());
            String str=mile.getText().substring(0,mile.getText().indexOf("m")).trim();
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.replace(stringBuilder.indexOf(","),stringBuilder.indexOf(",")+1,".");
//            stringBuilder.deleteCharAt(stringBuilder.charAt(','));
//            stringBuilder.insert(2,'.');
            double mil=Double.parseDouble(stringBuilder.toString());
        //    System.out.println(stringBuilder);
            Assert.assertTrue(mil<=70.000);
        }

        Thread.sleep(1000);
        WebElement sortBy=driver.findElement(By.xpath("//div[@class='select']//select[@class='select-sort-options']"));
        Select select5=new Select(sortBy);
        select5.selectByValue("price-highest");

        Thread.sleep(1000);
        List<WebElement> getPrices=driver.findElements(By.xpath("//div[@class='listing-row__details']//span[contains(text(),'$')]"));
        for(WebElement pric:getPrices){
      //      System.out.println(pric.getText());
            String str=pric.getText().substring(1);
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.replace(stringBuilder.indexOf(","),stringBuilder.indexOf(",")+1,".");
            double price=Double.parseDouble(stringBuilder.toString());
                Assert.assertTrue(price<=50.000);
        }

    }
}
