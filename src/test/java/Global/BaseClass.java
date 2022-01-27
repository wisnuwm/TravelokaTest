package Global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    public static WebDriver driver;
    public BaseClass() {
        if(driver == null){
            driver = new ChromeDriver(StaticHelper.GenerateDriverChrome());
        }
    }
}
