package Homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class TestCases {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
//        Thread.sleep(250);
       driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();

        WebElement blueCircle=driver.findElement(By.id("draggable"));
        WebElement blueTarget=driver.findElement(By.xpath("//div[@class='test1']"));
        WebElement orangeTarget=driver.findElement(By.xpath("//div[@class='test2']"));
        WebElement target=driver.findElement(By.xpath("//div[@class='demo-section k-content']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(blueCircle).moveToElement(target).perform();
        blueTarget=driver.findElement(By.xpath("//div[@class='test1']"));
        orangeTarget=driver.findElement(By.xpath("//div[@class='test2']"));

        Assert.assertTrue(blueTarget.isDisplayed());
        Assert.assertTrue(orangeTarget.isDisplayed());
        Assert.assertTrue(blueTarget.getText().equals("(Drop here)"));
        Assert.assertTrue(orangeTarget.getText().equals("(Drop here)"));


    }

    @Test
    public void test2(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();
        WebElement blueCircle=driver.findElement(By.id("draggable"));
        WebElement blueTarget=driver.findElement(By.xpath("//div[@class='test1']"));
        WebElement orangeTarget=driver.findElement(By.xpath("//div[@class='test2']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(blueCircle).moveToElement(blueTarget).perform();
        blueTarget=driver.findElement(By.xpath("//div[@class='test1']"));
        orangeTarget=driver.findElement(By.xpath("//div[@class='test2']"));
        Assert.assertTrue(blueTarget.getText().equals("Now you can drop it."));
        Assert.assertTrue(orangeTarget.getText().equals("(Drop here)"));


    }

    @Test
    public void test3(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();
        WebElement blueCircle=driver.findElement(By.id("draggable"));
        WebElement blueTarget=driver.findElement(By.xpath("//div[@class='test1']"));
        WebElement orangeTarget=driver.findElement(By.xpath("//div[@class='test2']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(blueCircle).moveToElement(orangeTarget).perform();
        blueTarget=driver.findElement(By.xpath("//div[@class='test1']"));
        orangeTarget=driver.findElement(By.xpath("//div[@class='test2']"));
        Assert.assertTrue(blueTarget.getText().equals("(Drop here)"));
        Assert.assertTrue(orangeTarget.getText().equals("Now you can drop it."));
    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        driver.findElement(By.xpath("//iframe[@id='flow_close_btn_iframe']")).click();
   //     driver.switchTo().defaultContent();
        Thread.sleep(500);
        WebElement first$000=driver.findElement(By.xpath("//li[@data-id='1']//a"));
        WebElement target=driver.findElement(By.xpath("//p[@style='font-size:17px;font-weight:400;']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(first$000).moveToElement(target).perform();
        WebElement text=driver.findElement(By.id("e1"));
        String expected="Please select another block";
        Assert.assertEquals(text.getText(),expected);
        actions.release().perform();

        WebElement first5000=driver.findElement(By.xpath("(//li[@class='block13 ui-draggable']//a)[1]"));
        WebElement drop=driver.findElement(By.xpath("//td//table//td//div[@id='shoppingCart4']//ol[@id='amt7']"));
        actions.dragAndDrop(first5000,drop).perform();

        Thread.sleep(2000);
        WebElement display1=driver.findElement(By.xpath("//div[@id='t7']"));
        WebElement display2=driver.findElement(By.xpath("//div[@id='t8']"));
        System.out.println(display1.getText());
        System.out.println(display2.getText());
        Assert.assertTrue(display1.getText().equals("5000"));
        Assert.assertTrue(display2.getText().equals("0"));

        WebElement second5000=driver.findElement(By.xpath("(//li[@class='block13 ui-draggable']//a)[2]"));
        WebElement drop2=driver.findElement(By.xpath("//td//table//td//div[@id='shoppingCart4']//ol[@id='amt8']"));
        actions.dragAndDrop(second5000,drop2).perform();

        Thread.sleep(2000);
        display1=driver.findElement(By.xpath("//div[@id='t7']"));
        display2=driver.findElement(By.xpath("//div[@id='t8']"));
        System.out.println(display1.getText());
        System.out.println(display2.getText());

        Assert.assertTrue(display1.getText().equals("5000"));
        Assert.assertTrue(display2.getText().equals("5000"));

        Thread.sleep(2000);
        WebElement bank=driver.findElement(By.xpath("(//li[@class='block14 ui-draggable']//a)"));
        WebElement bankDrop=driver.findElement(By.xpath("//td//table//td//div[@id='shoppingCart1']//ol[@id='bank']"));
        actions.dragAndDrop(bank,bankDrop).perform();

        WebElement diss=driver.findElement(By.xpath("(//li[contains(.,'BANK')])[2]"));
        Assert.assertTrue(diss.isDisplayed());

        WebElement sales=driver.findElement(By.xpath("(//li[@class='block15 ui-draggable']//a)"));
        WebElement salesDrop=driver.findElement(By.xpath("//td//div[@id='shoppingCart3']//ol[@id='loan']"));
        actions.dragAndDrop(sales,salesDrop).perform();

        WebElement diss2=driver.findElement(By.xpath("(//li[contains(.,'SALES')])[2]"));
        Assert.assertTrue(diss2.isDisplayed());

    }

    @Test
    public void test5(){
        driver.get("http://www.popuptest.com/popuptest4.html");
        WebElement webSite=driver.findElement(By.xpath("//a[contains(.,'Mouseover PopUp')]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(webSite).release().perform();

        String mainId=driver.getWindowHandle();


        Set<String > ids=driver.getWindowHandles();
        int counter=0;
        String date="";
        List<String > list=new ArrayList<>();
        for(String id:ids){
            counter++;
            if(!mainId.equals(id)){
                driver.switchTo().window(id);
                 date=driver.getTitle();
                     list.add(driver.getCurrentUrl());

            }
        }
        Assert.assertTrue(counter==3);

        Assert.assertTrue(date.contains("PopupTest Wednesday May, 20 2020"));

        boolean bool=true;

        for(int i=0;i<list.size();i++){
            if(!(list.get(i).contains("popup9") || list.get(i).contains("popup10"))){
                bool=false;
            }
        }
        Assert.assertTrue(bool==true);

    }

    @Test
    public void test6() throws InterruptedException {
        driver.get("http://seleniumpractise.blogspot.com/2017/");
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com']")).click();

        String parentPageId=driver.getWindowHandle();
        Set<String> ids=driver.getWindowHandles();

        for(String id:ids){
            if(!id.equals(parentPageId)){
                driver.switchTo().window(id);
            }
        }


        driver.findElement(By.xpath("//input[@id='u_0_m']")).sendKeys("Techtorial");
        driver.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys("Academy");
        driver.findElement(By.xpath("//input[@id='u_0_r']")).sendKeys("2223334455");
        driver.findElement(By.xpath("//input[@id='u_0_w']")).sendKeys("techtorial123");
        WebElement month=driver.findElement(By.xpath("//select[@id='month']"));
        Select select=new Select(month);
        select.selectByVisibleText("Apr");

        WebElement days=driver.findElement(By.xpath("//select[@id='day']"));
        Select select1=new Select(days);
        select1.selectByValue("20");

        WebElement years=driver.findElement(By.xpath("//select[@id='year']"));
        Select select2=new Select(years);
        select2.selectByValue("2002");

        driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']//input[@id='u_0_8']")).click();

        driver.close();
        driver.switchTo().window(parentPageId);

        System.out.println(driver.getTitle());

    }

    @AfterClass
    public void after() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}
