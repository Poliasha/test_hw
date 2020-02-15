import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

    class TestClass {
        @DisplayName("Right Form")
        @Test
        void TestCardRightForm() throws InterruptedException {
            open("http://localhost:9999");
            SelenideElement form = $("form");
            form.$("[data-test-id=name] input").setValue("Шигарова Полина");
            form.$("[data-test-id=phone] input").setValue("+9653851551");
            form.$("[data-test-id=agreement]").click();
            form.$("[class=\"button button_view_extra button_size_m " +
                    "button_theme_alfa-on-white\"]").click();
            $("[data-test-id=order-success]").shouldHave(exactText("  Ваша заявка успешно отправлена! " +
                    "Наш менеджер свяжется с вами в ближайшее время."));
            Thread.sleep(5000);
        }

        @DisplayName("Wrong Name")
        @Test
        void TestCardWrongName() throws InterruptedException {
            open("http://localhost:9999");
            SelenideElement form = $("[class= \"form form_size_m " +
                    "form_theme_alfa-on-white\"]");
            form.$("[data-test-id=name] input").setValue("Shigarova Polina");
            form.$("[data-test-id=phone] input").setValue("+79947013020");
            form.$("[data-test-id=agreement]").click();
            form.$("[class=\"button button_view_extra button_size_m " +
                    "button_theme_alfa-on-white\"]").click();
            $(".input_invalid .input__sub").shouldHave(text("Имя и Фамилия указаные неверно. " +
                    "Допустимы только русские буквы, пробелы и дефисы."));
            Thread.sleep(5000);
        }
    }

