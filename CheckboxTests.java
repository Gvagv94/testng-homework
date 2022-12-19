import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckboxTests extends ConfigTests  {
        SoftAssert softAssert = new SoftAssert();
        @BeforeMethod
        public void Configuration() {
            Configuration.baseUrl = "http://the-internet.herokuapp.com";
            Configuration.reportsFolder="src/main/resources/CheckboxFailedTests/";
        }


        @Test(timeOut = 10000)
        public void CheckBoxes()  {
            open("/checkboxes");
            SelenideElement form = $(byTagName("form"));
            $(form).findAll("input").forEach(el->{
                if(el.has(checked)){
                    el.setSelected(false);
                }
                softAssert.assertFalse(el.is(Condition.checked));
            });
//            SelenideElement checkbox1 =  $("input[type=checkbox]",1);
//            checkbox1.setSelected(false);
//            softAssert.assertTrue(checkbox1.is(Condition.checked));
//            SelenideElement checkbox2 =  $("input[type=checkbox]",0);
//            checkbox2.setSelected(true);
//            softAssert.assertFalse(checkbox2.is(Condition.checked));
            softAssert.assertAll();

        }

    @Test()
    public void CheckUnCheckBoxes()  {
        open("/checkboxes");
        SelenideElement form = $(byTagName("form"));
        $(form).findAll("input").forEach(el->{
            if(!el.has(checked)){
                el.setSelected(true);
            }
            softAssert.assertFalse(!el.is(Condition.checked));
        });
        softAssert.assertAll();
    }


    }
