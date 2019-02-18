package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by jiaxiong on 2019-02-18 15:06
 */
public class TeamDetailPage extends NavBarPage {

    private WebDriver driver;

    @FindBy(css = ".title")
    private List<WebElement> topics;

    public TeamDetailPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPage clickTopic(){
        topics.get(0).click();
        return new LoginPage(driver);
    }

}
