package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {
    WebDriver driver;
    public TestCase1()
    {
        System.out.println("Constructor: TestCase1");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    public  void testCase01() throws InterruptedException{
        System.out.println("Testcase1 to automate amazon.in or amazon.com is returned if amazon is searched in Google");
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
         WebElement p=driver.findElement(By.name("q"));
         p.sendKeys("amazon");
         WebDriverWait w = new WebDriverWait(driver, 5);
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@role='presentation']/span)[1]")));
        p.submit();
        String pr=driver.findElement(By.xpath("(//span[@role='text'])[1]")).getText();
        System.out.println(pr);
        Thread.sleep(1000);
        System.out.println("End Test case: testCase01");

}

    

}
