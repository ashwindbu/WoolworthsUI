package Helper;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverFactory {

    private DriverFactory() {
    }

    //TODO: Convert all chrome option arguments to externalised config parameters
    private static ChromeOptions setChromeOptions(String configPath) {
        String driverType = Config.read(configPath, "DriverType").toLowerCase();
        String platform = Config.read(configPath, "Platform").toLowerCase();

        //local driver type only
        String binaryLocation = Config.read(configPath, "BinaryPath");
        String driverPath = Config.read(configPath, "DriverPath");

        ChromeOptions co = new ChromeOptions();

        if (driverType.equals("local")) {
            co.setBinary(binaryLocation);
            //co.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            System.setProperty("webdriver.chrome.driver", driverPath);
        }

        //Set Capabilities
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        if (platform.equals("windows")) {
            cap.setPlatform(Platform.WINDOWS);
        } else {
            cap.setPlatform(Platform.LINUX);
        }
        return co;
    }

    public static WebDriver GetLocalDriver(String configPath) {

        String browserType = Config.read(configPath, "Driver").toLowerCase();

        WebDriver driver = null;
        if (browserType.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver(setChromeOptions(configPath));

        }
        return driver;
    }

    public static RemoteWebDriver GetRemoteDriver(String configPath) {

        return null;

    }
}