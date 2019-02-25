package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by jiaxiong on 2019-02-17 15:35
 */
public class SwitchUtil {

    public static boolean switchToWindow(WebDriver driver, long time) {

        // 获取当前页面句柄
        String handle = driver.getWindowHandle();
        // 获取所有页面的句柄
        Set<String> handles = driver.getWindowHandles();
        //显示等待·不生效
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.numberOfWindowsToBe(handles.size()));

        //切换窗口
        for (String temphandle : driver.getWindowHandles()) {
            if (!temphandle.equals(handle)) {
                driver.switchTo().window(temphandle);
                return true;
            }
        }
        return false;
    }

}
