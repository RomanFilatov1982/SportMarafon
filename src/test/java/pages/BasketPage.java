package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage extends LayoutPage<BasketPage> {

    private final SelenideElement BASKET_TABLE = $(".basket__table"),
            BASKET_DELETE = $(".basket__delete"),
            EMPTY_BASKET = $("#basket-app"),
            LINK_PLUS = $(".basket__qt-link_plus"),
            BASKET_AMOUNT = $(".basket__qt-field");

    @Step("Проверить, что товар отображается в корзине")
    public BasketPage checkBasketTable(String value) {
        BASKET_TABLE
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .shouldHave(text(value));
        return this;
    }


    @Step("Кликнуть на кнопку(X) удалить")
    public BasketPage deleteProductFromBasket() {
        BASKET_DELETE.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Проверить, что товар отсутствует в корзине и появилось сообщение")
    public BasketPage checkEmptyBasket() {
        EMPTY_BASKET.shouldHave(text("В вашей корзине пусто"));
        return this;
    }

    @Step("Кликнуть на кнопку + (увеличить количество товара)")
    public BasketPage addAmountPlus() {
        LINK_PLUS.click();
        return this;
    }

    @Step("Проверить, что количество товара увеличилось")
    public BasketPage checkAmount() {
        BASKET_AMOUNT.shouldHave(Condition.value("2"));
        return this;
    }
}
