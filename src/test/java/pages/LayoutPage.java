package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import components.Header;
import components.MenuItem;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LayoutPage<T> {
    private final SelenideElement cookie = $(".cookie"),
            headerFavorite = $(".header__favorite"),
            searchClick = $(".header__search"),
            searchInput = $("#head-search-input"),
            authLink = $(".js-user-link-container"),
            authEmail = $("#authElse"),
            authPass = $("#authPass"),
            authFormModal = $(".auth-form__modal"),
            textError = $(".auth-form__field-footer-text_error");
    private final ElementsCollection productListName = $$(".product-list__name"),
            authForm = $$("ul.auth-form__tabs li");
    Header header = new Header();

    @Step("Навести курсор мышки на группу товаров")
    public MenuItem chooseCategoryMenuItem(String value) {
        return header.chooseMenuItem(value);
    }

    @Step("Кликнуть справа вверху на избранное")
    public ProductListPage setHeaderFavorite() {
        headerFavorite.click();
        return new ProductListPage();
    }

    @Step("Принять куки")
    public T setCookie() {
        cookie.$(byText("Принять")).click();
        return (T) this;
    }

    @Step("Проверить найденный товар в соответствии с запросом")
    public T checkProductListNameCollection(String value) {
        productListName.findBy(Condition.text(value));
        return (T) this;
    }

    @Step("Ввести поисковый запрос")
    public T setSearchInput(String value) {
        searchClick.click();
        searchInput.setValue(value).pressEnter();
        return (T) this;
    }

    @Step("Справа вверху кликнуть на ссылку \"Вход\"")
    public T setAuthLink() {
        authLink.$(byText("Вход")).click();
        return (T) this;
    }

    @Step("В форме авторизации кликнуть на вкладку вход \"По e-mail\"")
    public T setAuthForm() {
        authForm.findBy(text("По e-mail")).click();
        return (T) this;
    }

    @Step("Ввести e-mail")
    public T setAuthEmail(String value) {
        authEmail.sendKeys(value);
        return (T) this;
    }

    @Step("Ввести пароль")
    public T setAuthPass(String value) {
        authPass.sendKeys(value);
        return (T) this;
    }

    @Step("Кликнуть на кнопку \"Войти\"")
    public T setAuthFormModal() {
        authFormModal.find(byText("Войти")).click();
        return (T) this;
    }

    @Step("Проверить сообщение об ошибке")
    public T checkTextError() {
        textError.shouldHave(text("Неверный пароль. Попробуйте ещё раз"));
        return (T) this;
    }
}
