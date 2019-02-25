package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by jiaxiong on 2019-02-24 14:22
 */
public class CommunitPage extends NavBarPage {

    @FindBy(css = "#hot_teams .row div .media-body a")
    private List<WebElement> communityList;

    @FindBy(css = ".title")
    private List<WebElement> topics;

    public CommunitPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains("社团"));
    }

    public boolean clickCommunityByText(String communityName) {
        for (WebElement element : communityList) {
            if (element.getText().contains(communityName)) {
                element.click();
                return true;
            }
        }
        return false;
    }

    public void clickTopic() {
        topics.get(0).click();
    }
}
