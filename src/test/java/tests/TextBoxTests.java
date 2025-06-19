package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterAll
    static void tearDown() {
        closeWebDriver();
    }


    @Test
    void textBoxPositiveTest() {
        open("/text-box");

        $("[id=userName]").setValue("Denisovich");
        $("[id=userEmail]").setValue("DenBel@yandex.ru");
        $("#currentAddress").setValue("Korolev");
        $("#permanentAddress").setValue("Gorod");
        $("#submit").click();

        $("#output").shouldBe(Condition.visible);
        $("#output #name").shouldHave(text("Denisovich"));
        $("#output #email").shouldHave(text("DenBel@yandex.ru"));
        $("#output #currentAddress").shouldHave(text("Korolev"));
        $("#output #permanentAddress").shouldHave(text("Gorod"));
    }

}
