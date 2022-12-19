import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


    public class RadioButtonTests extends ConfigTests {
        SoftAssert softAssert = new SoftAssert();
        @BeforeMethod
        public void Configuration () {
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.reportsFolder="src/main/resources/RadioButtonFailedTests/";
        }

        @Test()
        public void RadioButton() {
            open("/radio-button");
            SelenideElement radioButton = $("#yesRadio");
            radioButton.selectRadio("Yes");
            softAssert.assertFalse(radioButton.is(Condition.selected));
            softAssert.assertAll();


        }

        @Test()
        public void RadioButtonNo() {
            open("/radio-button");
            SelenideElement radioButton = $("#noRadio");
            softAssert.assertFalse(radioButton.is(Condition.enabled));
            softAssert.assertAll();


        }

    }
