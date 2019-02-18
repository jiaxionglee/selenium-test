package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by jiaxiong on 2019-02-17 14:35
 */
public class SerachResultPage extends NavBarPage {

    @FindBy(css = ".topic a")
    private List<WebElement> topics;

    public SerachResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getTopics(){
        return topics;
    }

}
