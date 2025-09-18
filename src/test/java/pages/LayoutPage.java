package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import components.Header;
import components.MenuItem;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LayoutPage<T> {
    private final SelenideElement COOKIE = $(".cookie"),
            HEADER_FAVORITE = $(".header__favorite"),
            HEADER_SEARCH = $(".header__search"),
            SEARCH_INPUT = $("#head-search-input"),
            AUTH_LINK = $(".js-user-link-container"),
            AUTH_EMAIL = $("#authElse"),
            AUTH_PASS = $("#authPass"),
            AUTH_FORM_MODAL = $(".auth-form__modal"),
            TEXT_ERROR = $(".auth-form__field-footer-text_error");
    private final ElementsCollection PRODUCT_LIST_NAME = $$(".product-list__name"),
            AUTH_FORM = $$("ul.auth-form__tabs li");
    Header header = new Header();

    @Step("Навести курсор мышки на группу товаров")
    public MenuItem chooseCategoryMenuItem(String value) {
        return header.chooseMenuItem(value);
    }

    @Step("Кликнуть справа вверху на избранное")
    public ProductListPage clickOnTheFavoriteIcon() {
        HEADER_FAVORITE.click();
        return new ProductListPage();
    }

    @Step("Принять куки")
    public T acceptCookie() {
        COOKIE.$(byText("Принять")).click();
        return (T) this;
    }

    @Step("Проверить найденный товар в соответствии с запросом")
    public T checkProductListNameCollection(String value) {
        PRODUCT_LIST_NAME.findBy(Condition.text(value));
        return (T) this;
    }

    @Step("Ввести поисковый запрос")
    public T searchInput(String value) {
        HEADER_SEARCH.click();
        SEARCH_INPUT.setValue(value).pressEnter();
        return (T) this;
    }

    @Step("Справа вверху кликнуть на ссылку \"Вход\"")
    public T clickAuthLink() {
        AUTH_LINK.$(byText("Вход")).click();
        return (T) this;
    }

    @Step("В форме авторизации кликнуть на вкладку вход \"По e-mail\"")
    public T сlickОnTheLoginByEmailTab() {
        AUTH_FORM.findBy(text("По e-mail")).click();
        return (T) this;
    }

    @Step("Ввести e-mail")
    public T enterEmail(String value) {
        AUTH_EMAIL.sendKeys(value);
        return (T) this;
    }

    @Step("Ввести пароль")
    public T enterPassword(String value) {
        AUTH_PASS.sendKeys(value);
        return (T) this;
    }

    @Step("Кликнуть на кнопку \"Войти\"")
    public T setAuthFormModal() {
        AUTH_FORM_MODAL.find(byText("Войти")).click();
        return (T) this;
    }

    @Step("Проверить сообщение об ошибке")
    public T checkTextError() {
        TEXT_ERROR.shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(Condition.or("текст ошибки",
                        text("Неверный пароль. Попробуйте ещё раз"),
                        text("Ошибка сервера") ));
        return (T) this;
    }
}
