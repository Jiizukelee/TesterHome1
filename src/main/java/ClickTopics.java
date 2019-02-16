import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickTopics {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        //启动chrome浏览器
        driver = new ChromeDriver();
    }
    @Test
    public void test()throws InterruptedException {
        //在浏览器中键入网址
        driver.get("https://testerhome.com/");
        //帖子们的定位方式
        By topics = By.className("title");
        //定位图片
        WebElement topicsElement = driver.findElement(topics);
        //点击图片
        topicsElement.click();
        Thread.sleep(5000);
        System.out.println("passed!");
    }
    @AfterMethod
    public void teardown(){
        //启动chrome浏览器
        driver.quit();
    }
}
