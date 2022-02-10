package Global;

import InitDriver.InitDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HookDriver {
    @Before
    public void initialBrowsers(){
        InitDriver.initBrowser();
    }
    @After
    public void quitBrowser(){
        InitDriver.quit();
    }
}
