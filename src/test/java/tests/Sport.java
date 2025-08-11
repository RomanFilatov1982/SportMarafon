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
import static io.qameta.allure.Allure.step;

public class Sport extends TestBase {
    SportPage sportPage = new SportPage();

    @CsvSource(value = {
            "Сноуборд мужской, Сноуборд мужской Nidecker Beta",
            "Панама Buff, Панама Buff Booney Randall Brindle"
    })
    @ParameterizedTest(name = "Поиск товара {0} в строке поиска и проверка найденного товара {1}")
    @Test
    void searchProduct(String searchQuery, String productName) {
        step("Открыть главную страницу", () -> {
            sportPage.openPage();
        });
        step("Ввести поисковый запрос", () -> {
            sportPage.setSearchInput(searchQuery);
        });
        step("Проверить найденный товар в соответствии с запросом", () -> {
            sportPage.checkProductListNameCollection(productName);
        });
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
        step("Открыть главную страницу", () -> {
            sportPage.openPage();
        });
        step("Навести курсор мышки на группу товаров", () -> {
            sportPage.setHeaderShopMenu("Альпинизм");
        });
        step("Выбрать из списка нужную категорию товара", () -> {
            sportPage.setChoiceProductFromGroup("Кошкоботы");
        });
        step("Проверить, что товары отобразились из нужной категории", () -> {
            sportPage.checkProductFromGroup("Кошки Petzl D-Lynx Orange");
        });
        /*$(".header__shop-menu").find(byText("Альпинизм")).hover();
        //$$("a.shop-menu__wrap li").find(byText("Альпинизм")).hover()
        $$("ul.shop-dd-menu__column li").findBy(text("Кошкоботы")).click();
        $(".product-list__name").shouldHave(text("Кошки Petzl D-Lynx Orange"));*/
    }

    @Test
    @DisplayName("Добавить продукт в корзину из карточки товара")
    void addProductToBasketFromCard() {
        step("Открыть главную страницу", () -> {
            sportPage.openPage();
        });
        step("Принять куки", () -> {
            sportPage.setCookie();
        });
        step("Навести курсор мыши на группу товаров", () -> {
            sportPage.setHeaderShopMenu("Туризм");
        });
        step("Выбрать из списка нужную категорию товара", () -> {
            sportPage.setChoiceProductFromGroup("Гамаки");
        });
        step("Кликнуть на нужную карточку товара", () -> {
            sportPage.setProductListItem("Гамак под снаряжение Naturehike Equipment Green");
        });
        step("Кликнуть на кнопку \"Добавить в корзину\"", () -> {
            sportPage.setCartButton();
        });
        step("В появившейся диалоговой панели кликнуть на кнопку \"В корзину\"", () -> {
            sportPage.setConfirmFooterCart();
        });
        step("Проверить, что товар отображается в корзине", () -> {
            sportPage.checkBasketTable("Гамак под снаряжение Naturehike Equipment Green (Green, 1sz )");
        });
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
        step("Открыть главную страницу", () -> {
            sportPage.openPage();
        });
        step("Принять куки", () -> {
            sportPage.setCookie();
        });
        step("Навести курсор мыши на группу товаров", () -> {
            sportPage.setHeaderShopMenu("Туризм");
        });
        step("Выбрать из списка нужную категорию товара", () -> {
            sportPage.setChoiceProductFromGroup("Гамаки");
        });
        step("Кликнуть на нужную карточку товара", () -> {
            sportPage.setProductListItem("Гамак под снаряжение Naturehike Equipment Green");
        });
        step("Кликнуть на кнопку \"Добавить в корзину\"", () -> {
            sportPage.setCartButton();
        });
        step("В появившейся диалоговой панели кликнуть на кнопку \"В корзину\"", () -> {
            sportPage.setConfirmFooterCart();
        });
        step("Кликнуть на кнопку(X) удалить", () -> {
            sportPage.setDeleteProductFromBasket();
        });
        step("Проверить, что товар отсутствует в корзине и появилось сообщение", () -> {
            sportPage.checkEmptyBasket();
        });
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
        step("Открыть главную страницу", () -> {
            sportPage.openPage();
        });
        step("Принять куки", () -> {
            sportPage.setCookie();
        });
        step("Навести курсор мыши на группу товаров", () -> {
            sportPage.setHeaderShopMenu("Горные лыжи");
        });
        step("Выбрать из списка нужную категорию товара", () -> {
            sportPage.setMenAlpineSkisUniversal();
        });
        step("В фильтре выбрать бренд товара", () -> {
            sportPage.setFilterBrandProduct("Salomon");
        });
        step("В фильтре выбрать наличие крепления", () -> {
            sportPage.setFilterBindingProduct("В комплекте");
        });
        step("В фильтре выбрать уровень мастерства", () -> {
            sportPage.setFilterProfessionalism("Средний/Продвинутый");
        });
        step("В фильтре выбрать ростовку(см)", () -> {
            sportPage.setFilterHeight("170 - 174");
        });
        step("Навести курсор мыши на карточку товара", () -> {
            sportPage.setProductItemLink();
        });
        step("Кликнуть на кнопку \"В корзину\"", () -> {
            sportPage.setButtonAppear();
        });
        step("В появившемся модальном окне кликнуть \"В корзину\"", () -> {
            sportPage.setModalWindow();
        });
        step("В попапп форме кликнуть на кнопку \"В корзину\"", () -> {
            sportPage.setPopupForm();
        });
        step("Проверить, что добавленный товар отображается в корзине", () -> {
            sportPage.checkBasketTable("Горные лыжи Salomon E S/Max 8 Xt с креплениями M10 GW L80 Oi (Multi, 163 )");
        });
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
        step("Открыть главную страницу", () -> {
            sportPage.openPage();
        });
        step("Навести курсор мыши на группу товаров", () -> {
            sportPage.setHeaderShopMenu("Бег");
        });
        step("Выбрать из списка нужную категорию товара", () -> {
            sportPage.setMenSneakers();
        });
        step("Навести курсор мыши на третью карточку товара", () -> {
            sportPage.setProductListItemLinkThird();
        });
        step("Добавить товар в избранное", () -> {
            sportPage.setCatalogFavorite();
        });
        step("Кликнуть справа вверху на избранное", () -> {
            sportPage.setHeaderFavorite();
        });
        step("Проверить, что товар отображается в избранном", () -> {
            sportPage.checkProductListName("Кроссовки Reebok Floatzig X1 Синий/Зеленый/Голубой");
        });
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
        step("Открыть главную страницу", () -> {
            sportPage.openPage();
        });
        step("Навести курсор мыши на группу товаров", () -> {
            sportPage.setHeaderShopMenu("Бег");
        });
        step("Выбрать из списка нужную категорию товара", () -> {
            sportPage.setMenSneakers();
        });
        step("В фильтре выбрать бренд ", () -> {
            sportPage.setFilterBrandProduct("Adidas");
        });
        step("Проверить, что на странице отображаются товары в соответствии с фильтром", () -> {
            sportPage.checkBrandSneakers();
        });
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
        step("Открыть главную страницу", () -> {
            sportPage.openPage();
        });
        step("Справа вверху кликнуть на ссылку \"Вход\"", () -> {
            sportPage.setAuthLink();
        });
        step("В форме авторизации кликнуть на вкладку вход \"По e-mail\"", () -> {
            sportPage.setAuthForm();
        });
        step("Ввести e-mail", () -> {
            sportPage.setAuthEmail(testDataValue.userEmail);
        });
        step("Ввести пароль", () -> {
            sportPage.setAuthPass(testDataValue.userPassword);
        });
        step("Кликнуть на кнопку \"Войти\"", () -> {
            sportPage.setAuthFormModal();
        });
        step("Проверить сообщение об ошибке", () -> {
            sportPage.checkTextError();
        });
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
        step("Открыть главную страницу", () -> {
            sportPage.openPage();
        });
        step("Принять куки", () -> {
            sportPage.setCookie();
        });
        step("Навести курсор мыши на группу товаров", () -> {
            sportPage.setHeaderShopMenu("Туризм");
        });
        step("Выбрать из списка нужную категорию товара", () -> {
            sportPage.setChoiceProductFromGroup("Гамаки");
        });
        step("Кликнуть на нужную карточку товара", () -> {
            sportPage.setProductListItem("Гамак под снаряжение Naturehike Equipment Green");
        });
        step("Кликнуть на кнопку \"Добавить в корзину\"", () -> {
            sportPage.setCartButton();
        });
        step("В появившейся диалоговой панели кликнуть на кнопку \"В корзину\"", () -> {
            sportPage.setConfirmFooterCart();
        });
        step("Кликнуть на кнопку + (увеличить количество товара)", () -> {
            sportPage.setLinkPlus();
        });
        step("Проверить, что количество товара увеличилось", () -> {
            sportPage.checkAmount();
        });

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
