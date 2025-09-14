package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import components.Header;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SportPage {
    Header header = new Header();
    private final SelenideElement cookie = $(".cookie"),
            searchClick = $(".header__search"),
            searchInput = $("#head-search-input"),
            productName = $(".product-list__name"),

    productList = $(".product-list__item-wrap"),
            cartButton = $("button.q-add-to-cart__button"),
            confirmFooter = $(".q-add-to-cart__confirm-footer"),
            basketTable = $(".basket__table"),
            basketDelete = $(".basket__delete"),
            emptyBasket = $("#basket-app"),

            filterBrand = $("#filter-block-brand-name"),
            filterBinding = $("#filter-block-kreplenie"),
            filterProfessionalism = $("#filter-block-uroven_masterstva"),
            filterHeight = $("#filter-block-multi_rostovka_lizi"),
            cartProduct = $("a.product-list__item-link"),
            buttonAppear = $x("//button[text()='В корзину']"),
            popupForm = $(".popup-form__content_subscribe"),
            modalWindow = $("#modal-basket2141288"),
            menSneakers = $("a[href*='muzhskie-begovye-krossovki']"),
            headerFavorite = $(".header__favorite"),
            brand = $("[href*='brands/adidas']"),
            authLink = $(".js-user-link-container"),
            authEmail = $("#authElse"),
            authPass = $("#authPass"),
            authFormModal = $(".auth-form__modal"),
            textError = $(".auth-form__field-footer-text_error"),
            linkPlus = $(".basket__qt-link_plus"),
            basketAmount = $(".basket__qt-field");
    private final ElementsCollection productListName = $$(".product-list__name"),

            productListCollection = $$(".product-list__item-link"),
            catalogFavorite = $$(".catalog__favourite"),
            authForm = $$("ul.auth-form__tabs li");

    @Step("Открыть главную страницу")
    public SportPage openPage() {
        open("");
        return this;
    }

    @Step("Принять куки")
    public SportPage setCookie() {
        cookie.$(byText("Принять")).click();
        return this;
    }

    @Step("Проверить найденный товар в соответствии с запросом")
    public SportPage checkProductListNameCollection(String value) {
        productListName.findBy(Condition.text(value));

        return this;
    }

    @Step("Ввести поисковый запрос")
    public SportPage setSearchInput(String value) {
        searchClick.click();
        searchInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Проверить, что товар отображается в избранном")
    public SportPage checkProductListName(String value) {
        productName.shouldHave(text(value));
        return this;
    }

    @Step("Навести курсор мышки на группу товаров")
    public SportPage chooseCategoryMenuItem(String value) {
        header.chooseMenuItem(value);
        return this;
    }

    @Step("Выбрать из списка нужную категорию товара")
    public SportPage setChoiceProductFromGroup(String value) {
        header.selectProduct(value);
        return this;
    }

    @Step("Проверить, что товары отобразились из нужной категории")
    public SportPage checkProductFromGroup(String value) {
        productName.shouldHave(text(value));
        return this;
    }

    @Step("Кликнуть на нужную карточку товара")
    public SportPage setProductListItem(String value) {
        productList.find(byText(value)).click();
        //productName.shouldHave(text(value));
        return this;
    }

    @Step("Кликнуть на кнопку \"Добавить в корзину\"")
    public SportPage setCartButton() {
        cartButton.click();
        return this;
    }

    @Step("В появившейся диалоговой панели кликнуть на кнопку \"В корзину\"")
    public SportPage setConfirmFooterCart() {
        confirmFooter.$(byText("В корзину")).click();
        return this;
    }

    @Step("Проверить, что товар отображается в корзине")
    public SportPage checkBasketTable(String value) {
        basketTable.shouldHave(text(value));
        return this;
    }

    @Step("Кликнуть на кнопку(X) удалить")
    public SportPage setDeleteProductFromBasket() {
        basketDelete.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Проверить, что товар отсутствует в корзине и появилось сообщение")
    public SportPage checkEmptyBasket() {
        emptyBasket.shouldHave(text("В вашей корзине пусто"));
        return this;
    }

    @Step("Выбрать из списка нужную категорию товара")
    public SportPage setMenAlpineSkisUniversal() {
        header.selectMenAlpineSkisUniversal();
        return this;
    }

    @Step("В фильтре выбрать бренд товара")
    public SportPage setFilterBrandProduct(String value) {
        filterBrand.$(byText(value)).click();
        return this;
    }

    @Step("В фильтре выбрать наличие крепления")
    public SportPage setFilterBindingProduct(String value) {
        filterBinding.$(byText(value)).click();
        return this;
    }

    @Step("В фильтре выбрать уровень мастерства")
    public SportPage setFilterProfessionalism(String value) {
        filterProfessionalism.$(byText(value)).click();
        return this;
    }

    @Step("В фильтре выбрать ростовку(см)")
    public SportPage setFilterHeight(String value) {
        filterHeight.$(byText(value)).click();
        return this;
    }

    @Step("Навести курсор мыши на карточку товара")
    public SportPage setProductItem() {
        productList.hover();
        return this;
    }

    @Step("Кликнуть на кнопку \"В корзину\"")
    public SportPage setButtonAppear() {
        buttonAppear.click();
        return this;
    }

    @Step("В попапп форме кликнуть на кнопку \"В корзину\"")
    public SportPage setPopupForm() {
        popupForm.$(byText("В корзину")).click();
        return this;
    }

    @Step("В появившемся модальном окне кликнуть \"В корзину\"")
    public SportPage setModalWindow() {
        modalWindow.$(byText("В корзину")).click();
        return this;
    }

    @Step("Выбрать из списка нужную категорию товара")
    public SportPage setMenSneakers() {
        menSneakers.click();
        return this;
    }

    @Step("Навести курсор мыши на третью карточку товара")
    public SportPage setProductListItemLinkThird() { // два, но один элемент коллекции, а другой селенид элемент
        productListCollection.get(2).hover();
        return this;
    }

    @Step("Добавить товар в избранное")
    public SportPage setCatalogFavorite() {
        catalogFavorite.get(2).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Кликнуть справа вверху на избранное")
    public SportPage setHeaderFavorite() {
        headerFavorite.click();
        return this;
    }

    @Step("Проверить, что на странице отображаются товары в соответствии с фильтром")
    public SportPage checkBrandSneakers() {
        brand.shouldHave(text("Adidas"));
        return this;
    }

    @Step("Справа вверху кликнуть на ссылку \"Вход\"")
    public SportPage setAuthLink() {
        authLink.$(byText("Вход")).click();
        return this;
    }

    @Step("В форме авторизации кликнуть на вкладку вход \"По e-mail\"")
    public SportPage setAuthForm() {
        authForm.findBy(text("По e-mail")).click();
        return this;
    }

    @Step("Ввести e-mail")
    public SportPage setAuthEmail(String value) {
        authEmail.sendKeys(value);
        return this;
    }

    @Step("Ввести пароль")
    public SportPage setAuthPass(String value) {
        authPass.sendKeys(value);
        return this;
    }

    @Step("Кликнуть на кнопку \"Войти\"")
    public SportPage setAuthFormModal() {
        authFormModal.find(byText("Войти")).click();
        return this;
    }

    @Step("Проверить сообщение об ошибке")
    public SportPage checkTextError() {
        textError.shouldHave(text("Неверный пароль. Попробуйте ещё раз"));
        return this;
    }

    @Step("Кликнуть на кнопку + (увеличить количество товара)")
    public SportPage setLinkPlus() {
        linkPlus.click();
        return this;
    }

    @Step("Проверить, что количество товара увеличилось")
    public SportPage checkAmount() {
        basketAmount.shouldHave(Condition.value("2"));
        return this;
    }
}
