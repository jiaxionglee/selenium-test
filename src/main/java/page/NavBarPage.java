package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * Created by jiaxiong on 2019-02-17 14:14
 */
public class NavBarPage {

    private WebDriver driver;

    @FindBy(tagName = "input")
    private WebElement searchElement;

    public NavBarPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void searchKeyword(String value){
        //清除默认值
        searchElement.clear();
        searchElement.sendKeys(value);
        //打印日志
        Reporter.log("搜索关键字："+value,true);
    }

    public SerachResultPage gotoSearchResult(String value){
        searchKeyword(value);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

        return new SerachResultPage(driver);
    }
}
