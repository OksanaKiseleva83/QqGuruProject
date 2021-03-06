package testsUI.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.Selenide;
//import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.openqa.selenium.remote.DesiredCapabilities.chrome;


public class SelenideBaseTest {

    /**
     * конструктор по-умолчанию
     */
    public SelenideBaseTest() {
        super();
        return;
    }

    @BeforeEach
    public void setUp() {

        final DesiredCapabilities capabilities = chrome();
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en_EN", "--disable-notifications", "--window-size=1920,1080", "--disable-system-timezone-automatic-detection", "--local-timezone");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setPlatform(Platform.WINDOWS);
    }

    @AfterEach
    public void after() {
        Selenide.clearBrowserCookies();
        closeWebDriver();
    }


}
