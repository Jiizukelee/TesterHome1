import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SearchWordMaxmize {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //启动chrome浏览器
        driver = new ChromeDriver(options);
    }
    @Test
    public void test()throws InterruptedException {
        //在浏览器中键入网址
        driver.get("https://testerhome.com/");
        //搜索框的定位方式
        By searchBy = By.tagName("input");
        //定位搜索框
        WebElement searchElement = driver.findElement(searchBy);
        //输入值
        searchElement.clear();
        searchElement.sendKeys("测试");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build();
        Thread.sleep(5000);
        System.out.println("passed!");
    }
    @AfterMethod
    public void teardown(){
        //启动chrome浏览器
        driver.quit();
    }
}
