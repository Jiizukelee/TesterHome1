import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickBanner {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){

        //启动chrome浏览器
        driver = new ChromeDriver();
    }
    @Test
    public void test(){
        //在浏览器中键入网址
        driver.get("https://testerhome.com/");
        //图片定位方式
        By logoBy = By.cssSelector(".content img");
        //定位图片
        WebElement logoElement = driver.findElement(logoBy);
        //点击图片
        logoElement.click();
        System.out.println("passed!");
    }
    @AfterMethod
    public void teardown(){
        //启动chrome浏览器
        driver.quit();
    }
}
