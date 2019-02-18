package utils;

import org.openqa.selenium.WebDriver;

/**
 * Created by jiaxiong on 2019-02-17 15:35
 */
public class SwitchUtil {

    public static void switchToWindow(String title, WebDriver driver){
        for (String handle:driver.getWindowHandles()){
            if (driver.getTitle().contains(title)){
                return;
            }
            driver.switchTo().window(handle);
        }
    }
}
