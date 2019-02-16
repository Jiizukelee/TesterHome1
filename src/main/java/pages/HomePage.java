package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    //搜索框
    @FindBy(tagName = "input")
    WebElement searchElement;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void inputKeyword(String keyword){
        searchElement.clear();
        searchElement.sendKeys(keyword);
    }

}
