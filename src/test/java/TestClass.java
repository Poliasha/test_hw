import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class TestClass {
    @DisplayName("Successful test with correctly form")
    @Test
    void testCardCorrectlyForm() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Шигарова Полина");
        $("[data-test-id=phone] input").setValue("+79653851551");
        $("[data-test-id=agreement]").click();
        $("[class=\"button__content\"]").click();
        $("[data-test-id=order-success]").shouldHave(text("  Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время."));
    }

    @DisplayName("Should show error if name in english")
    @Test
    void shouldShowErrorIfNameInEnglish() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Shigarova Polina");
        $("[data-test-id=phone] input").setValue("+79653851551");
        $("[data-test-id=agreement]").click();
        $("[class=\"button__content\"]").click();
        $(".input_invalid .input__sub").shouldHave(text("Имя и Фамилия указаные неверно. " +
                "Допустимы только русские буквы, пробелы и дефисы."));
    }
}