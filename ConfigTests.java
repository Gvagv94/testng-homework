import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class ConfigTests {
    SoftAssert softAssert = new SoftAssert();
        @BeforeMethod
        public void SelenideConfig() {
            Configuration.timeout = 2000;
            Configuration.browser = "Chrome";
            Configuration.browserSize = "1920x1080";
            Configuration.reopenBrowserOnFail = true;
            ScreenShooter.captureSuccessfulTests = false;

        }

    @AfterClass
    public void teardown() {
        softAssert.assertAll();
    }
    }
