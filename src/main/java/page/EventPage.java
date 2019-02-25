package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jiaxiong on 2019-02-17 15:14
 */
public class EventPage {

    private WebDriver driver;

    public EventPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitTitleContains(long time, String partTitle) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.titleContains(partTitle));
    }
}
