package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

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
        step("Открыть главную страницу", () -> {
        open("");
        });
        return this;
    }

    public SportPage setCookie() {
        step("Принять куки", () -> {
        cookie.$(byText("Принять")).click();
        });
        return this;
    }

    public SportPage checkProductListNameCollection(String value) {
        step("Проверить найденный товар в соответствии с запросом", () -> {
        productListName
                .findBy(Condition.text(value));
        });
        return this;
    }

    public SportPage setSearchInput(String value) {
        step("Ввести поисковый запрос", () -> {
        searchClick.click();
        searchInput.setValue(value).pressEnter();
        });
        return this;
    }

    public SportPage checkProductListName(String value) {
        step("Проверить, что товар отображается в избранном", () -> {
        productName.shouldHave(text(value));
        });
        return this;
    }

    public SportPage setHeaderShopMenu(String value) {
        step("Навести курсор мышки на группу товаров", () -> {
        headerMenu.find(byText(value)).hover();
        });
        return this;
    }

    public SportPage setChoiceProductFromGroup(String value) {
        step("Выбрать из списка нужную категорию товара", () -> {
        choiceProduct.find(Condition.text(value)).click();
        });
        return this;
    }

    public SportPage checkProductFromGroup(String value) {
        step("Проверить, что товары отобразились из нужной категории", () -> {
        productName.shouldHave(text(value));
        });
        return this;
    }

    public SportPage setProductListItem(String value) {
        step("Кликнуть на нужную карточку товара", () -> {
        productList.find(byText(value)).click();
            productName.shouldHave(text(value));
        });
        return this;
    }

    public SportPage setCartButton() {
        step("Кликнуть на кнопку \"Добавить в корзину\"", () -> {
        cartButton.click();
        });
        return this;
    }

    public SportPage setConfirmFooterCart() {
        step("В появившейся диалоговой панели кликнуть на кнопку \"В корзину\"", () -> {
        confirmFooter.$(byText("В корзину")).click();
        });
        return this;
    }

    public SportPage checkBasketTable(String value) {
        step("Проверить, что товар отображается в корзине", () -> {
        basketTable.shouldHave(text(value));
        });
        return this;
    }

    public SportPage setDeleteProductFromBasket() {
        step("Кликнуть на кнопку(X) удалить", () -> {
        basketDelete.click();
        });
        return this;
    }

    public SportPage checkEmptyBasket() {
        step("Проверить, что товар отсутствует в корзине и появилось сообщение", () -> {
        emptyBasket.shouldHave(text("В вашей корзине пусто"));
        });
        return this;
    }

    public SportPage setMenAlpineSkisUniversal() {
        step("Выбрать из списка нужную категорию товара", () -> {
        menAlpineSkis.click();
        });
        return this;
    }

    public SportPage setFilterBrandProduct(String value) {
        step("В фильтре выбрать бренд товара", () -> {
        filterBrand.$(byText(value)).click();
        });
        return this;
    }

    public SportPage setFilterBindingProduct(String value) {
        step("В фильтре выбрать наличие крепления", () -> {
        filterBinding.$(byText(value)).click();
        });
        return this;
    }

    public SportPage setFilterProfessionalism(String value) {
        step("В фильтре выбрать уровень мастерства", () -> {
        filterProfessionalism.$(byText(value)).click();
        });
        return this;
    }

    public SportPage setFilterHeight(String value) {
        step("В фильтре выбрать ростовку(см)", () -> {
        filterHeight.$(byText(value)).click();
        });
        return this;
    }

    public SportPage setProductItem() {
        step("Навести курсор мыши на карточку товара", () -> {
        productList.hover();
        });
        return this;
    }

    public SportPage setButtonAppear() {
        step("Кликнуть на кнопку \"В корзину\"", () -> {
        buttonAppear.click();
        });
        return this;
    }

    public SportPage setPopupForm() {
        step("В попапп форме кликнуть на кнопку \"В корзину\"", () -> {
        popupForm.$(byText("В корзину")).click();
        });
        return this;
    }

    public SportPage setModalWindow() {
        step("В появившемся модальном окне кликнуть \"В корзину\"", () -> {
            modalWindow.$(byText("В корзину")).click();
        });
        return this;
    }

    public SportPage setMenSneakers() {
        step("Выбрать из списка нужную категорию товара", () -> {
        menSneakers.click();
        });
        return this;
    }

    public SportPage setProductListItemLinkThird() { // два, но один элемент коллекции, а другой селенид элемент
        step("Навести курсор мыши на третью карточку товара", () -> {
        productListCollection.get(2).hover();
        });
        return this;
    }

    public SportPage setCatalogFavorite() {
        step("Добавить товар в избранное", () -> {
        catalogFavorite.get(2).scrollIntoView(true).click();
        });
        return this;
    }
@Step("Кликнуть справа вверху на избранное")
    public SportPage setHeaderFavorite() {
    step("Кликнуть справа вверху на избранное", () -> {
        headerFavorite.click();
    });
        return this;
    }

    public SportPage checkBrandSneakers() {
        step("Проверить, что на странице отображаются товары в соответствии с фильтром", () -> {
        brand.shouldHave(text("Adidas"));
        });
        return this;
    }

    public SportPage setAuthLink() {
        step("Справа вверху кликнуть на ссылку \"Вход\"", () -> {
        authLink.$(byText("Вход")).click();
        });
        return this;
    }

    public SportPage setAuthForm() {
        step("В форме авторизации кликнуть на вкладку вход \"По e-mail\"", () -> {
        authForm.findBy(text("По e-mail")).click();
        });
        return this;
    }

    public SportPage setAuthEmail(String value) {
        step("Ввести e-mail", () -> {
        authEmail.sendKeys(value);
        });
        return this;
    }

    public SportPage setAuthPass(String value) {
        step("Ввести пароль", () -> {
        authPass.sendKeys(value);
        });
        return this;
    }

    public SportPage setAuthFormModal() {
        step("Кликнуть на кнопку \"Войти\"", () -> {
        authFormModal.find(byText("Войти")).click();
        });
        return this;
    }

    public SportPage checkTextError() {
        step("Проверить сообщение об ошибке", () -> {
        textError.shouldHave(text("Неверный пароль. Попробуйте ещё раз"));
        });
        return this;
    }

    public SportPage setLinkPlus() {
        step("Кликнуть на кнопку + (увеличить количество товара)", () -> {
        linkPlus.click();
        });
        return this;
    }

    public SportPage checkAmount() {
        step("Проверить, что количество товара увеличилось", () -> {
        basketAmount.shouldHave(Condition.value("2"));
        });
        return this;
    }
}
