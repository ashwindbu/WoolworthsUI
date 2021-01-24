package Helper;

import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    private WebDriver driver;
    private String cPath;

    public BaseTest(String configPath) {
        cPath = configPath;
        String driverType = Config.read(configPath, "DriverType").toLowerCase();
        if (driverType.equals("remote")) {
            driver = DriverFactory.GetRemoteDriver(cPath);
        } else {
            driver = DriverFactory.GetLocalDriver(cPath);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
