package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SportPage {
    private final SelenideElement cookie = $(".cookie"),
            searchClick = $(".header__search"),
            searchInput = $("#head-search-input"),
            productName = $(".product-list__name"),
            headerMenu = $(".header__shop-menu"),
            productList = $(".product-list__item-wrap"),
            cartButton = $("button.q-add-to-cart__button"),
            confirmFooter = $(".q-add-to-cart__confirm-footer"),
            basketTable = $(".basket__table"),
            basketDelete = $(".basket__delete"),
            emptyBasket = $("#basket-app"),
            menAlpineSkis = $("a[href*='universalnye-gornye-lyzhi/?sex%5B%5D=Uniseks&sex%5B%5D=Muzhskoy']"),
            filterBrand = $("#filter-block-brand-name"),
            filterBinding = $("#filter-block-kreplenie"),
            filterProfessionalism = $("#filter-block-uroven_masterstva"),
            filterHeight = $("#filter-block-multi_rostovka_lizi"),
            cartProduct = $("a.product-list__item-link"),
            buttonAppear = $x("//button[text()='В корзину']"),
            modalWindow = $("#modal-basket2141288"),
            popupForm = $(".popup-form__content_subscribe"),
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
            choiceProduct = $$("ul.shop-dd-menu__column li"),
            productListCollection = $$(".product-list__item-link"),
            catalogFavorite = $$(".catalog__favourite"),
            authForm = $$("ul.auth-form__tabs li");

    public SportPage openPage() {
        open("");
        return this;
    }

    public SportPage setCookie() {
        cookie.$(byText("Принять")).click();
        return this;
    }

    public SportPage checkProductListNameCollection(String value) {
        productListName
                .findBy(Condition.text(value));
        return this;
    }

    public SportPage setSearchInput(String value) {
        searchClick.click();
        searchInput.setValue(value).pressEnter();
        return this;
    }

    public SportPage checkProductListName(String value) {
        productName.shouldHave(text(value));
        return this;
    }

    public SportPage setHeaderShopMenu(String value) {
        headerMenu.find(byText(value)).hover();
        return this;
    }

    public SportPage setChoiceProductFromGroup(String value) {
        choiceProduct.find(Condition.text(value)).click();
        return this;
    }

    public SportPage checkProductFromGroup(String value) {
        productName.shouldHave(text(value));
        return this;
    }

    public SportPage setProductListItem(String value) {
        productList.find(byText(value)).click();
        return this;
    }

    public SportPage setCartButton() {
        cartButton.click();
        return this;
    }

    public SportPage setConfirmFooterCart() {
        confirmFooter.$(byText("В корзину")).click();
        return this;
    }

    public SportPage checkBasketTable(String value) {
        basketTable.shouldHave(text(value));
        return this;
    }

    public SportPage setDeleteProductFromBasket() {
        basketDelete.click();
        return this;
    }

    public SportPage checkEmptyBasket() {
        emptyBasket.shouldHave(text("В вашей корзине пусто"));
        return this;
    }

    public SportPage setMenAlpineSkisUniversal() {
        menAlpineSkis.click();
        return this;
    }

    public SportPage setFilterBrandProduct(String value) {
        filterBrand.$(byText(value)).click();
        return this;
    }

    public SportPage setFilterBindingProduct(String value) {
        filterBinding.$(byText(value)).click();
        return this;
    }

    public SportPage setFilterProfessionalism(String value) {
        filterProfessionalism.$(byText(value)).click();
        return this;
    }

    public SportPage setFilterHeight(String value) {
        filterHeight.$(byText(value)).click();
        return this;
    }

    public SportPage setProductItem() {
        productList.hover();
        return this;
    }

    public SportPage setButtonAppear() {
        buttonAppear.click();
        return this;
    }

    public SportPage setModalWindow() {
        modalWindow.$(byText("В корзину")).click();
        return this;
    }

    public SportPage setPopupForm() {
        popupForm.$(byText("В корзину")).click();
        return this;
    }

    public SportPage setMenSneakers() {
        menSneakers.click();
        return this;
    }

    public SportPage setProductListItemLinkThird() { // два, но один элемент соллекции, а другой селенид элемент
        productListCollection.get(2).hover();
        return this;
    }

    public SportPage setCatalogFavorite() {
        catalogFavorite.get(2).scrollIntoView(true).click();
        return this;
    }
@Step("Кликнуть справа вверху на избранное")
    public SportPage setHeaderFavorite() {
        headerFavorite.click();
        return this;
    }

    public SportPage checkBrandSneakers() {
        brand.shouldHave(text("Adidas"));
        return this;
    }

    public SportPage setAuthLink() {
        authLink.$(byText("Вход")).click();
        return this;
    }

    public SportPage setAuthForm() {
        authForm.findBy(text("По e-mail")).click();
        return this;
    }

    public SportPage setAuthEmail(String value) {
        authEmail.sendKeys(value);
        return this;
    }

    public SportPage setAuthPass(String value) {
        authPass.sendKeys(value);
        return this;
    }

    public SportPage setAuthFormModal() {
        authFormModal.find(byText("Войти")).click();
        return this;
    }

    public SportPage checkTextError() {
        textError.shouldHave(text("Неверный пароль. Попробуйте ещё раз"));
        return this;
    }

    public SportPage setLinkPlus() {
        linkPlus.click();
        return this;
    }

    public SportPage checkAmount() {
        basketAmount.shouldHave(Condition.value("2"));
        return this;
    }
}
