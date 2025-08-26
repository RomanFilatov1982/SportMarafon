package tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestDataValue;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.SportPage;

import java.util.Collection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("sportMarafon")
public class Sport extends TestBase {
    SportPage sportPage = new SportPage();

    @CsvSource(value = {
            "Сноуборд мужской, Сноуборд мужской Nidecker Beta",
            "Панама Buff, Панама Buff Booney Randall Brindle"
    })

    @ParameterizedTest(name = "Поиск товара {0} в строке поиска и проверка найденного товара {1}")
    @Owner("filatovri")
    @Story("")
    @Feature("")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing", url = "https://sport-marafon.ru/")
    void searchProduct(String searchQuery, String productName) {
            sportPage.openPage();
            sportPage.setSearchInput(searchQuery);
            sportPage.checkProductListNameCollection(productName);
       /* $(".header__search").click();
        $("#head-search-input").setValue("Панама Buff").pressEnter();
        $$(".product-list__name").findBy(Condition.text("Панама Buff Booney Randall Brindle"));*/
        /*$(".header__search").click();
        $("#head-search-input").setValue("Сноуборд мужской Nidecker Beta").pressEnter();
        $(".product-list__name").shouldHave(text("Сноуборд мужской Nidecker Beta"));*/

    }

    @Test
    @DisplayName("Выбор товара из группы")
    void choiceForMountaineering() {
            sportPage.openPage();
            sportPage.setHeaderShopMenu("Альпинизм");
            sportPage.setChoiceProductFromGroup("Кошкоботы");
            sportPage.checkProductFromGroup("Кошки Petzl D-Lynx Orange");
        /*$(".header__shop-menu").find(byText("Альпинизм")).hover();
        //$$("a.shop-menu__wrap li").find(byText("Альпинизм")).hover()
        $$("ul.shop-dd-menu__column li").findBy(text("Кошкоботы")).click();
        $(".product-list__name").shouldHave(text("Кошки Petzl D-Lynx Orange"));*/
    }

    @Test
    @DisplayName("Добавить товар в корзину из карточки")
    void addProductToBasketFromCard() {
            sportPage.openPage();
            sportPage.setCookie();
            sportPage.setHeaderShopMenu("Туризм");
            sportPage.setChoiceProductFromGroup("Гамаки");
            sportPage.setProductListItem("Гамак для снаряжения Naturehike Equipment Blue");
            sportPage.setCartButton();
            sportPage.setConfirmFooterCart();
            sportPage.checkBasketTable("Гамак для снаряжения Naturehike Equipment Blue (Blue, 1sz )");
       /* $(".cookie").$(byText("Принять")).click();
        $(".header__shop-menu").find(byText("Туризм")).hover();
        $$("ul.shop-dd-menu__column li").findBy(text("Гамаки")).click();
        $(".product-list__item-wrap").find(byText("Гамак под снаряжение Naturehike Equipment Green")).shouldBe(visible, Duration.ofSeconds(10)).click();
        $("button.q-add-to-cart__button").click();
        $(".q-add-to-cart__confirm-footer").$(byText("В корзину")).click();
        $(".basket__table").shouldHave(text("Гамак под снаряжение Naturehike Equipment Green (Green, 1sz )"));*/
    }

    @Test
    @DisplayName("Удалить товар из корзины")
    void removeProductFromBasket() {
            sportPage.openPage();
            sportPage.setCookie();
            sportPage.setHeaderShopMenu("Туризм");
            sportPage.setChoiceProductFromGroup("Гамаки");
            sportPage.setProductListItem("Гамак для снаряжения Naturehike Equipment Blue");
            sportPage.setCartButton();
            sportPage.setConfirmFooterCart();
            sportPage.setDeleteProductFromBasket();
            sportPage.checkEmptyBasket();
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
    @DisplayName("Добавить товар в корзину используя фильтр")
    void addProductToBasketUseFilter() {
            sportPage.openPage();
            sportPage.setCookie();
            sportPage.setHeaderShopMenu("Горные лыжи");
            sportPage.setMenAlpineSkisUniversal();
            sportPage.setFilterBrandProduct("Salomon");
            sportPage.setFilterBindingProduct("В комплекте");
            sportPage.setFilterProfessionalism("Средний/Продвинутый");
            sportPage.setFilterHeight("170 - 174");
            sportPage.setProductItem();
            sportPage.setButtonAppear();
            sportPage.setPopupForm();
            sportPage.setModalWindow();
            sportPage.checkBasketTable("Горные лыжи Salomon E S/Max 8 Xt с креплениями M10 GW L80 Oi (Multi, 163 )");
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
    @DisplayName("Добавить товар в избранное")
    void addingProductToFavorites() {
            sportPage.openPage();
            sportPage.setCookie();
            sportPage.setHeaderShopMenu("Бег");
            sportPage.setMenSneakers();
            sportPage.setProductListItemLinkThird();
            sportPage.setCatalogFavorite();
            sportPage.setHeaderFavorite();
            sportPage.checkProductListName("Кроссовки Reebok Floatzig X1 Синий/Зеленый/Голубой");
        /*$(".cookie").$(byText("Принять")).click();
        $(".header__shop-menu").find(byText("Бег")).hover();
        $("a[href*='muzhskie-begovye-krossovki']").click();
        $$(".product-list__item-link").get(2).hover();
        $$(".catalog__favourite").get(2).click();
        $(".header__favorite").click();
        $(".product-list__name").shouldHave(text("Кроссовки Reebok Floatzig X1 Синий/Зеленый/Голубой"));*/
    }

    @Test
    @DisplayName("Поиск товара по бренду используя фильтр")
    void searchForProductByBrand() {
            sportPage.openPage();
            sportPage.setCookie();
            sportPage.setHeaderShopMenu("Бег");
            sportPage.setMenSneakers();
            sportPage.setFilterBrandProduct("Adidas");
            sportPage.checkBrandSneakers();
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
            sportPage.openPage();
            sportPage.setAuthLink();
            sportPage.setAuthForm();
            sportPage.setAuthEmail(testDataValue.userEmail);
            sportPage.setAuthPass(testDataValue.userPassword);
            sportPage.setAuthFormModal();
            sportPage.checkTextError();
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
            sportPage.openPage();
            sportPage.setCookie();
            sportPage.setHeaderShopMenu("Туризм");
            sportPage.setChoiceProductFromGroup("Гамаки");
            sportPage.setProductListItem("Гамак для снаряжения Naturehike Equipment Blue");
            sportPage.setCartButton();
            sportPage.setConfirmFooterCart();
            sportPage.setLinkPlus();
            sportPage.checkAmount();
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
        //
    }
}
