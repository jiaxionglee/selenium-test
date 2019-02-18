package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by jiaxiong on 2019-02-18 14:34
 */
public class TeamPage extends NavBarPage {

    private WebDriver driver;

    @FindBy(css = ".team-name[href='/hogwarts']")
    private WebElement teamName;

    public TeamPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public TeamDetailPage gotoTeamDetail(){
        teamName.click();
        return new TeamDetailPage(driver);
    }
}
