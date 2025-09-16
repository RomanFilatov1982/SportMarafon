package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProductDetailPage extends LayoutPage{
    SelenideElement cartButton = $("button.q-add-to-cart__button"),
    confirmFooter = $(".q-add-to-cart__confirm-footer");

    @Step("Кликнуть на кнопку \"Добавить в корзину\"")
    public ProductDetailPage setCartButton() {
        cartButton.click();
        return this;
    }

    @Step("В появившейся диалоговой панели кликнуть на кнопку \"В корзину\"")
    public BasketPage setConfirmFooterCart() {
        confirmFooter.$(byText("В корзину")).click();
        return new BasketPage();
    }
}
