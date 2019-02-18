package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by jiaxiong on 2019-02-18 15:22
 */
public class LoginPage extends NavBarPage {

    @FindBy(css = ".alert-danger")
    private WebElement alert;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getText(){
        return alert.getText();
    }

}
