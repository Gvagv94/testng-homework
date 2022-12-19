import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeMethod;

public class ConfigTests {
        @BeforeMethod
        public void SelenideConfig() {
            Configuration.timeout = 2000;
            Configuration.browser = "Chrome";
            Configuration.browserSize = "1920x1080";
            Configuration.reopenBrowserOnFail = true;
            ScreenShooter.captureSuccessfulTests = false;

        }
    }
