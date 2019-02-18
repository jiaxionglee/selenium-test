package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * Created by jiaxiong on 2019-02-17 14:23
 */
public class HomePage extends NavBarPage {

    @FindBy(css = ".content img")
    private WebElement banner;

    public HomePage(WebDriver driver){
       super(driver);
    }

    public void clickBanner(){
        banner.click();
        Reporter.log("点击图片",true);
    }

}