package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProductDetailPage extends LayoutPage<ProductDetailPage> {
    SelenideElement CART_BUTTON = $("button.q-add-to-cart__button"),
            CONFIRM_FOOTER = $(".q-add-to-cart__confirm-footer");

    @Step("Кликнуть на кнопку \"Добавить в корзину\"")
    public ProductDetailPage clickOnTheAddButtonInTheCard() {
        CART_BUTTON
                .should(Condition.visible, Duration.ofSeconds(10))
                .click();
        return this;
    }

    @Step("В появившейся диалоговой панели кликнуть на кнопку \"В корзину\"")
    public BasketPage clickOnTheAddToCartButtonInTheDialogBox() {
        CONFIRM_FOOTER
                .should(Condition.visible, Duration.ofSeconds(10))
                .$(byText("В корзину"))
                .click();
        return new BasketPage();
    }

}
