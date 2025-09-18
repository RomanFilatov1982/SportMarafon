package tests;

import data.TestDataValue;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;

@Tag("sport_marafon")
public class Sport extends TestBase {
    MainPage sportPage = new MainPage();

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
        sportPage.openPage()
                .searchInput(searchQuery)
                .checkProductListNameCollection(productName);
    }

    @Test
    @DisplayName("Выбор товара из группы")
    void choiceForMountaineering() {
        sportPage.openPage()
                .chooseCategoryMenuItem("Альпинизм")
                .chooseSubMenu("Ледово-снежное снаряжение", "Кошкоботы")
                .checkProductFromGroup("Кошки Petzl D-Lynx Orange");
    }

    @Test
    @DisplayName("Добавить товар в корзину из карточки товара")
    void addProductToBasketFromCard1() {
        sportPage.openPage()
                .acceptCookie()
                .chooseCategoryMenuItem("Туризм")
                .chooseSubMenu("Спальные мешки", "Гамаки")
                .selectProductListItem("Гамак для снаряжения Naturehike Equipment Blue")
                .clickOnTheAddButtonInTheCard()
                .clickOnTheAddToCartButtonInTheDialogBox()
                .checkBasketTable("Гамак для снаряжения Naturehike Equipment Blue (Blue, 1sz )");
    }

    @Test
    @DisplayName("Добавить товар в корзину из карточки")
    void addProductToBasketFromCard() {
        sportPage.openPage()
                .acceptCookie()
                .chooseCategoryMenuItem("Туризм")
                .chooseSubMenu("Палатки", "Гамаки")
                .selectProductListItem("Гамак для снаряжения Naturehike Equipment Blue")
                .clickOnTheAddButtonInTheCard()
                .clickOnTheAddToCartButtonInTheDialogBox()
                .checkBasketTable("Гамак для снаряжения Naturehike Equipment Blue (Blue, 1sz )");
    }

    @Test
    @DisplayName("Удалить товар из корзины")
    void removeProductFromBasket() {
        sportPage.openPage()
                .acceptCookie()
                .chooseCategoryMenuItem("Туризм")
                .chooseSubMenu("Палатки", "Гамаки")
                .selectProductListItem("Гамак для снаряжения Naturehike Equipment Blue")
                .clickOnTheAddButtonInTheCard()
                .clickOnTheAddToCartButtonInTheDialogBox()
                .deleteProductFromBasket()
                .checkEmptyBasket();
    }

    @Test
    @DisplayName("Добавить товар в корзину используя фильтр")
    void addProductToBasketUseFilter() {
        sportPage.openPage()
                .acceptCookie()
                .chooseCategoryMenuItem("Горные лыжи")
                .chooseSubMenu("Мужские лыжи", "Универсальные")
                .selectInFilterBrandAProduct("Salomon")
                .selectInFilterBindingAProduct("В комплекте")
                .selectInFilterAProfessionalism("Средний/Продвинутый")
                .selectInFilterAHeight("170 - 174")
                .hoverYourMouseOverTheProductCard()
                .clickOnTheButtonThatAppears()
                .clickOnTheButtonInThePopupForm()
                .confirmBasketModal()
                .checkBasketTable("Горные лыжи Salomon E S/Max 8 Xt с креплениями M10 GW L80 Oi (Multi, 163 )");
    }

    @Test
    @DisplayName("Добавить товар в избранное")
    void addingProductToFavorites() {
        sportPage.openPage()
                .acceptCookie()
                .chooseCategoryMenuItem("Бег")
                .chooseSubMenu("Для мужчин", "Беговые кроссовки")
                .hoverYourMouseOverTheThirdCard()
                .addProductToFavorites()
                .clickOnTheFavoriteIcon()
                .checkProductListName("Кроссовки Reebok Floatzig X1 Синий/Зеленый/Голубой");
    }

    @Test
    @DisplayName("Поиск товара по бренду используя фильтр")
    void searchForProductByBrand() {
        sportPage.openPage()
                .acceptCookie()
                .chooseCategoryMenuItem("Бег")
                .chooseSubMenu("Для мужчин", "Беговые кроссовки")
                .selectInFilterBrandAProduct("Adidas")
                .checkBrandSneakers("Adidas");
    }

    @Test
    @DisplayName("Вход в личный кабинет незарегистрированного пользователя")
    void loginToYourPersonalAccount() {
        TestDataValue testDataValue = new TestDataValue();
        sportPage.openPage()
                .clickAuthLink()
                .сlickОnTheLoginByEmailTab()
                .enterEmail(testDataValue.userEmail)
                .enterPassword(testDataValue.userPassword)
                .setAuthFormModal()
                .checkTextError();
    }

    @Test
    @DisplayName("Увеличить количество товара в корзине")
    void changeQuantityInBasket() {
        sportPage.openPage()
                .acceptCookie()
                .chooseCategoryMenuItem("Туризм")
                .chooseSubMenu("Палатки", "Гамаки")
                .selectProductListItem("Гамак для снаряжения Naturehike Equipment Blue")
                .clickOnTheAddButtonInTheCard()
                .clickOnTheAddToCartButtonInTheDialogBox()
                .addAmountPlus()
                .checkAmount();
    }
}
