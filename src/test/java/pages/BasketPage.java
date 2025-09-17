package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage extends LayoutPage<BasketPage> {

    SelenideElement basketTable = $(".basket__table"),
    basketDelete = $(".basket__delete"),
            emptyBasket = $("#basket-app"),
            linkPlus = $(".basket__qt-link_plus"),
            basketAmount = $(".basket__qt-field");
    @Step("Проверить, что товар отображается в корзине")
    public BasketPage checkBasketTable(String value) {
        basketTable.shouldHave(text(value));
        return this;
    }

    @Step("Кликнуть на кнопку(X) удалить")
    public BasketPage setDeleteProductFromBasket() {
        basketDelete.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Проверить, что товар отсутствует в корзине и появилось сообщение")
    public BasketPage checkEmptyBasket() {
        emptyBasket.shouldHave(text("В вашей корзине пусто"));
        return this;
    }

    @Step("Кликнуть на кнопку + (увеличить количество товара)")
    public BasketPage setLinkPlus() {
        linkPlus.click();
        return this;
    }

    @Step("Проверить, что количество товара увеличилось")
    public BasketPage checkAmount() {
        basketAmount.shouldHave(Condition.value("2"));
        return this;
    }
}
