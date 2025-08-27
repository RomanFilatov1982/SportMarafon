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
    }

    @Test
    @DisplayName("Выбор товара из группы")
    void choiceForMountaineering() {
        sportPage.openPage();
        sportPage.setHeaderShopMenu("Альпинизм");
        sportPage.setChoiceProductFromGroup("Кошкоботы");
        sportPage.checkProductFromGroup("Кошки Petzl D-Lynx Orange");
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
    }
}
