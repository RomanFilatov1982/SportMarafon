package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends LayoutPage{

    private final SelenideElement cookie = $(".cookie"),
            searchClick = $(".header__search"),
            searchInput = $("#head-search-input"),
            authLink = $(".js-user-link-container"),
            authEmail = $("#authElse"),
            authPass = $("#authPass"),
            authFormModal = $(".auth-form__modal"),
            textError = $(".auth-form__field-footer-text_error");


    private final ElementsCollection productListName = $$(".product-list__name"),

            authForm = $$("ul.auth-form__tabs li");
    //todo перенести в layoutpage
    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("");
        return this;
    }
    //todo перенести в layoutpage
    @Step("Принять куки")
    public MainPage setCookie() {
        cookie.$(byText("Принять")).click();
        return this;
    }
    //todo перенести в layoutpage
    @Step("Проверить найденный товар в соответствии с запросом")
    public MainPage checkProductListNameCollection(String value) {
        productListName.findBy(Condition.text(value));

        return this;
    }
    //todo перенести в layoutpage
    @Step("Ввести поисковый запрос")
    public MainPage setSearchInput(String value) {
        searchClick.click();
        searchInput.setValue(value).pressEnter();
        return this;
    }

   //todo перенести в layoutpage
    @Step("Справа вверху кликнуть на ссылку \"Вход\"")
    public MainPage setAuthLink() {
        authLink.$(byText("Вход")).click();
        return this;
    }
    //todo перенести в layoutpage
    @Step("В форме авторизации кликнуть на вкладку вход \"По e-mail\"")
    public MainPage setAuthForm() {
        authForm.findBy(text("По e-mail")).click();
        return this;
    }
    //todo перенести в layoutpage
    @Step("Ввести e-mail")
    public MainPage setAuthEmail(String value) {
        authEmail.sendKeys(value);
        return this;
    }
    //todo перенести в layoutpage
    @Step("Ввести пароль")
    public MainPage setAuthPass(String value) {
        authPass.sendKeys(value);
        return this;
    }
    //todo перенести в layoutpage
    @Step("Кликнуть на кнопку \"Войти\"")
    public MainPage setAuthFormModal() {
        authFormModal.find(byText("Войти")).click();
        return this;
    }
    //todo перенести в layoutpage
    @Step("Проверить сообщение об ошибке")
    public MainPage checkTextError() {
        textError.shouldHave(text("Неверный пароль. Попробуйте ещё раз"));
        return this;
    }
}
