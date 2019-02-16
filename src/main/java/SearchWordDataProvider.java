import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.text.html.HTMLDocument;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static utils.FileUtils.readCsvFile;

public class SearchWordDataProvider {
    private WebDriver driver;

    @DataProvider
    private Iterator<Object[]> iamDatas() throws Exception{
        return readCsvFile("D:\\Selenium自动化\\searchWords.csv");
    }
    @BeforeMethod
    private void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //启动chrome浏览器
        driver = new ChromeDriver(options);
    }
    @Test(dataProvider =  "iamDatas")
    private void test(String data)throws InterruptedException {
        //在浏览器中键入网址
        driver.get("https://testerhome.com/");
        //搜索框的定位方式
        By searchBy = By.tagName("input");
        //定位搜索框
        WebElement searchElement = driver.findElement(searchBy);
        //输入值
        searchElement.clear();
        searchElement.sendKeys(data);

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
        System.out.println("passed!");
    }
    @AfterMethod
    private void teardown(){
        //启动chrome浏览器
        driver.quit();
    }
}
