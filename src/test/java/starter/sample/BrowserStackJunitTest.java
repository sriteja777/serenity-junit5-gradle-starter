package starter.sample;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.net.URL;


public class BrowserStackJunitTest {

    public AndroidDriver driver;
    public String userName;
    public String accessKey;
    public UiAutomator2Options options;
    public static final String USER_DIR = "user.dir";

    public BrowserStackJunitTest() {

    }

    @BeforeAll
    public static void setUpAll() throws Exception {
        System.out.println("[setupAll]  started");

    }

    @AfterAll
    public static void afterAll() throws Exception {
        System.out.println("[afterAll]  started");

    }

    @BeforeEach
    public void setup() throws Exception {
        System.out.println("[setup]  started");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setCapability("sdkDriverHandling", false);
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("sdkDriverHandling",false);
//
//        try {

            SafariOptions chromeOptions = new SafariOptions();
////            chromeOptions.addArguments("start-maximized");
            chromeOptions.setCapability("sdkDriverHandling", false);
            WebDriver dri = new SafariDriver(chromeOptions);
//
////            WebDriver dri = new RemoteWebDriver(
////                    new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", userName , accessKey)), capabilities);
//            dri.get("https://www.google.com");
//            Thread.sleep(5000);
//            dri.quit();
//            dri.quit();
//        } catch (Exception e) {
//            e.printStackTrace();  // handle the exception
//        }




        options = new UiAutomator2Options();
//        options.setApp("/Users/sriteja/repos/gradle-junit5/WikipediaSample.apk");
        options.setApp("bs://17e6879eb165e10628f623f85d313c505051f18a");
//        options.setCapability("sdkDriverHandling", false);
//        options.setCa
        options.setDeviceName("Samsung Galaxy S23");
        userName = "sritejasugoor_y15tfc";
        accessKey = "usKZYJCP5arxQjNEW16b";
//        driver = new AndroidDriver(options);
        driver = new AndroidDriver(new URL(String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", userName , accessKey)), options);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

        System.out.println("[setup]  failed");

    }

    @AfterEach
    public void tearDown() throws Exception {
        // Invoke driver.quit() to indicate that the test is completed.
        // Otherwise, it will appear as timed out on BrowserStack.
        driver.quit();
    }

    private String getUserDir() {
        return System.getProperty(USER_DIR);
    }
}
