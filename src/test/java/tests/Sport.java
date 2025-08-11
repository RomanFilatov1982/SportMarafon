package tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestDataValue;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.SportPage;

import java.util.Collection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Sport extends TestBase {
    SportPage sportPage = new SportPage();
    @CsvSource(value = {
            "Сноуборд мужской, Сноуборд мужской Nidecker Beta",
            "Панама Buff, Панама Buff Booney Randall Brindle"
    })
    @ParameterizedTest(name = "Поиск товара {0} в строке поиска и проверка найденного товара {1}")
    @Test
    void searchProduct(String searchQuery, String productName) {
        sportPage.openPage()
                .setSearchInput(searchQuery)
                .checkProductListNameCollection(productName);
       /* $(".header__search").click();
        $("#head-search-input").setValue("Панама Buff").pressEnter();
        $$(".product-list__name").findBy(Condition.text("Панама Buff Booney Randall Brindle"));*/
        /*$(".header__search").click();
        $("#head-search-input").setValue("Сноуборд мужской Nidecker Beta").pressEnter();
        $(".product-list__name").shouldHave(text("Сноуборд мужской Nidecker Beta"));*/

    }

    @Test
    @DisplayName("Выбор товара из группы товаров")
    void choiceForMountaineering() {
        sportPage.openPage()
                .setHeaderShopMenu("Альпинизм")
                .setChoiceProductFromGroupgit("Кошкоботы")
                .checkProductFromGroup("Кошки Petzl D-Lynx Orange");

        /*$(".header__shop-menu").find(byText("Альпинизм")).hover();
        //$$("a.shop-menu__wrap li").find(byText("Альпинизм")).hover()
        $$("ul.shop-dd-menu__column li").findBy(text("Кошкоботы")).click();
        $(".product-list__name").shouldHave(text("Кошки Petzl D-Lynx Orange"));*/
    }

    @Test
    @DisplayName("Добавить продукт в корзину из карточки товара")
    void addProductToBasketFromCard() {
        sportPage.openPage()
                .setCookie()
                .setHeaderShopMenu("Туризм")
                .setChoiceProductFromGroup("Гамаки")
                .setProductListItem("Гамак под снаряжение Naturehike Equipment Green")
                .setCartButton()
                .setConfirmFooterCart()
                .checkBasketTable("Гамак под снаряжение Naturehike Equipment Green (Green, 1sz )");

       /* $(".cookie").$(byText("Принять")).click();
        $(".header__shop-menu").find(byText("Туризм")).hover();
        $$("ul.shop-dd-menu__column li").findBy(text("Гамаки")).click();
        $(".product-list__item-wrap").find(byText("Гамак под снаряжение Naturehike Equipment Green")).shouldBe(visible, Duration.ofSeconds(10)).click();
        $("button.q-add-to-cart__button").click();
        $(".q-add-to-cart__confirm-footer").$(byText("В корзину")).click();
        $(".basket__table").shouldHave(text("Гамак под снаряжение Naturehike Equipment Green (Green, 1sz )"));*/
    }

    @Test
    @DisplayName("Удалить продукт из корзины")
    void removeProductFromBasket() {
        sportPage.openPage()
                .setCookie()
                .setHeaderShopMenu("Туризм")
                .setChoiceProductFromGroup("Гамаки")
                .setProductListItem("Гамак под снаряжение Naturehike Equipment Green")
                .setCartButton()
                .setConfirmFooterCart()
                .setDeleteProductFromBasket()
                .checkEmptyBasket();

        /*$(".cookie").$(byText("Принять")).click();
        $(".header__shop-menu").find(byText("Туризм")).hover();
        $$("ul.shop-dd-menu__column li").findBy(text("Гамаки")).click();
        $(".product-list__item-wrap").find(byText("Гамак под снаряжение Naturehike Equipment Green")).shouldBe(visible, Duration.ofSeconds(10)).click();
        $("button.q-add-to-cart__button").click();
        $(".q-add-to-cart__confirm-footer").$(byText("В корзину")).click();
        $(".basket__delete").click();
        $("#basket-app").shouldHave(text("В вашей корзине пусто"));*/
    }

    @Test
    @DisplayName("Добавить продукт в корзину при помощи фильтра")
    void addProductToBasketUseFilter() {
        sportPage.openPage()
                .setCookie()
                .setHeaderShopMenu("Горные лыжи")
                .setMenAlpineSkisUniversal()
                .setFilterBrandProduct("Salomon")
                .setFilterBindingProduct("В комплекте")
                .setFilterProfessionalism("Средний/Продвинутый")
                .setFilterHeight("170 - 174")
                .setProductItemLink()
                .setButtonAppear()
                .setModalWindow()
                .setPopupForm()
                .checkBasketTable("Горные лыжи Salomon E S/Max 8 Xt с креплениями M10 GW L80 Oi (Multi, 163 )");

       /* $(".cookie").$(byText("Принять")).click();
        $(".header__shop-menu").find(byText("Горные лыжи")).hover();
        $("a[href*='universalnye-gornye-lyzhi/?sex%5B%5D=Uniseks&sex%5B%5D=Muzhskoy']").click();
        $("#filter-block-brand-name").$(byText("Salomon")).click();
        $("#filter-block-kreplenie").$(byText("В комплекте")).click();
        $("#filter-block-uroven_masterstva").$(byText("Средний/Продвинутый")).click();
        $("#filter-block-multi_rostovka_lizi").$(byText("170 - 174")).click();
        $(".product-list__item-link").hover();
        $x("//button[text()='В корзину']").click();
        $("div.col-6").$(byText("В корзину")).click();
        $(".popup-form__content_subscribe").$(byText("В корзину")).click();
        $(".basket__table").shouldHave(text("Горные лыжи Salomon E S/Max 8 Xt с креплениями M10 GW L80 Oi (Multi, 163 )"));*/
    }

    @Test
    @DisplayName("Добавить продукт в избранное")
    void addingProductToFavorites() {
        sportPage.openPage()
                .setHeaderShopMenu("Бег")
                .setMenSneakers()
                .setProductListItemLinkThird()
                .setCatalogFavorite()
                .setHeaderFavorite()
                .checkProductListName("Кроссовки Reebok Floatzig X1 Синий/Зеленый/Голубой");

        /*$(".cookie").$(byText("Принять")).click();
        $(".header__shop-menu").find(byText("Бег")).hover();
        $("a[href*='muzhskie-begovye-krossovki']").click();
        $$(".product-list__item-link").get(2).hover();
        $$(".catalog__favourite").get(2).click();
        $(".header__favorite").click();
        $(".product-list__name").shouldHave(text("Кроссовки Reebok Floatzig X1 Синий/Зеленый/Голубой"));*/
    }

    @Test
    @DisplayName("Поиск продукта по бренду используя фильтр")
    void searchForProductByBrand() {
        sportPage.openPage()
                .setHeaderShopMenu("Бег")
                .setMenSneakers()
                .setFilterBrandProduct("Adidas")
                .checkBrandSneakers();

        /*$(".cookie").$(byText("Принять")).click();
        $(".header__shop-menu").find(byText("Бег")).hover();
        $("a[href*='muzhskie-begovye-krossovki']").click();
        $("#filter-block-brand-name").find(byText("Adidas")).click();
        $("[href*='brands/adidas']").shouldHave(text("Adidas"));*/
    }

    @Test
    @DisplayName("Вход в личный кабинет незарегистрированного пользователя")
    void loginToYourPersonalAccount() {
        TestDataValue testDataValue = new TestDataValue();

        sportPage.openPage()
                .setAuthLink()
                .setAuthForm()
                .setAuthEmail(testDataValue.userEmail)
                .setAuthPass(testDataValue.userPassword)
                .setAuthFormModal()
                .checkTextError();

        /*$(".js-user-link-container").$(byText("Вход")).click();
        $$("ul.auth-form__tabs li").findBy(text("По e-mail")).click();
        $("#authElse").sendKeys("roman@bk.ru");
        $("#authPass").sendKeys("510874Roman");
        $(".auth-form__modal").find(byText("Войти")).click();
        $(".auth-form__field-footer-text_error").shouldHave(text("Неверный пароль. Попробуйте ещё раз"));*/
    }

    @Test
    @DisplayName("Увеличить количество товара в корзине")
    void changeQuantityInBasket() {
        sportPage.openPage()
                .setCookie()
                .setHeaderShopMenu("Туризм")
                .setChoiceProductFromGroup("Гамаки")
                .setProductListItem("Гамак под снаряжение Naturehike Equipment Green")
                .setCartButton()
                .setConfirmFooterCart()
                .setLinkPlus()
                .checkAmount();

       /* $(".cookie").$(byText("Принять")).click();
        $(".header__shop-menu").find(byText("Туризм")).hover();
        $$("ul.shop-dd-menu__column li").findBy(text("Гамаки")).click();
        $(".product-list__item-wrap").find(byText("Гамак под снаряжение Naturehike Equipment Green")).shouldBe(visible, Duration.ofSeconds(10)).click();
        $("button.q-add-to-cart__button").click();
       *//* $(".q-add-to-cart__confirm-footer").$(byText("Продолжить покупки")).click();
        $(".header__shop-menu").find(byText("Горные лыжи")).hover();
        $("a[href*='universalnye-gornye-lyzhi/?sex%5B%5D=Uniseks&sex%5B%5D=Muzhskoy']").click();
        $("#filter-block-brand-name").$(byText("Salomon")).click();
        $("#filter-block-kreplenie").$(byText("В комплекте")).click();
        $("#filter-block-uroven_masterstva").$(byText("Средний/Продвинутый")).click();
        $("#filter-block-multi_rostovka_lizi").$(byText("170 - 174")).click();
        $(".product-list__image-wrap").click();
        $("button.q-add-to-cart__button").click();*//*
        $(".q-dialog__footer").find(byText("В корзину")).click();
        $(".basket__qt-link_plus").click();
        //$$(".basket__qt-link.basket__qt-link_plus").get(1).click();
        $(".basket__qt-field").shouldHave(text("2"));*/
    }

}
