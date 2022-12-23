import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class TestNGParametrization {

        @BeforeMethod
        public void Configuration () {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";

    }


        @Parameters({"FirstName", "LastName", "MobileNumber"})
        @Test
      public void Parametrization(@Optional("gv") String FN, String LN, String MN) {
        open("https://demoqa.com/automation-practice-form");
        $(By.id("firstName")).sendKeys(FN);
        $(By.id("lastName")).sendKeys(LN);
        $(byAttribute("for", "gender-radio-1")).click();
        $(By.id("userNumber")).sendKeys(MN);
    }

        @Test(dataProvider = "RegistrationDataProvider", dataProviderClass = Data.class)
        public void Parametrization1 (String FN, String LN, String MN) {
        open("https://demoqa.com/automatio-practice-form");
        $(By.id("firstName")).sendKeys(FN);
        $(By.id("lastName")).sendKeys(LN);
        $(byAttribute("for", "gender-radio-1")).click();
        $(By.id("userNumber")).sendKeys(MN);
        assertEquals(FN, $("#firstName").getValue());

    }
}