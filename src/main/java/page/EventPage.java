package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by jiaxiong on 2019-02-17 15:14
 */
public class EventPage {

    private WebDriver driver;

    public EventPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}
