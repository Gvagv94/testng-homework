import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class CheckboxTests extends ConfigTests  {
        SoftAssert softAssert = new SoftAssert();
        @BeforeMethod
        public void Configuration() {
            Configuration.baseUrl = "http://the-internet.herokuapp.com";
            Configuration.reportsFolder="src/main/resources/CheckboxFailedTests/";
        }


//

    @Test(groups = {"FrontEnd"})
    public void uncheck() {
        open("/checkboxes");
        ElementsCollection checkbox1 = $$("input[type=checkbox]");
        checkbox1.forEach(el -> el.setSelected(false));
        softAssert.assertTrue(checkbox1.get(0).is(Condition.checked));
    }
    @Test(groups = {"BackEnd"})
    public void check() {
        open("/checkboxes");
        ElementsCollection checkbox2 =  $$("input[type=checkbox]");
        checkbox2.forEach(el -> el.setSelected(true));
        softAssert.assertFalse(checkbox2.get(1).is(Condition.checked));
        softAssert.assertAll();
    }

}

