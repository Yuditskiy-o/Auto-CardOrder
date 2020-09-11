package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.cssSelector;

public class ApplicationFormTest {

    @Test
    void shouldSubmitRequestIfDataFullyValid() {
        open("http://localhost:9999");
        SelenideElement form = $("[action]");
        form.$(cssSelector("[type='text']")).sendKeys("Олег Юдыцкий");
        form.$(cssSelector("[type='tel']")).sendKeys("+79137049918");
        form.$(cssSelector("[data-test-id=agreement]")).click();
        form.$(cssSelector("[type='button']")).click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
