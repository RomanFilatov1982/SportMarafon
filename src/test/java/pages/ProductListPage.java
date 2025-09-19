package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProductListPage extends LayoutPage<ProductListPage> {
    private final SelenideElement PRODUCT_CATALOG = $("#main-catalog"),
            PRODUCT_LIST = $(".product-list__item-wrap"),
            FILTER_BRAND = $("#filter-block-brand-name"),
            FILTER_BINDING = $("#filter-block-kreplenie"),
            FILTER_PROFESSIONALISM = $("#filter-block-uroven_masterstva"),
            FILTER_HEIGHT = $("#filter-block-multi_rostovka_lizi"),
            BUTTON_APPEAR = $x("//button[text()='В корзину']"),
            POPUP_FORM = $(".popup-form__content_subscribe"),
            MODAL_CART_BUTTON = $(".popup-form__btn_cart");

    private final ElementsCollection PRODUCT_LIST_COLLECTION = $$(".product-list__item-link"),
            CATALOG_FAVORITE = $$(".catalog__favourite");

    @Step("Проверить, что товары отобразились из нужной категории")
    public ProductListPage checkProductFromGroup(String value) {
        PRODUCT_CATALOG.shouldHave(text(value));
        return this;
    }

    @Step("Проверить, что товар отображается в избранном")
    public ProductListPage checkProductListName(String value) {
        PRODUCT_CATALOG.shouldHave(text(value));
        return this;
    }

    @Step("В фильтре выбрать бренд товара")
    public ProductListPage selectInFilterBrandAProduct(String value) {
        FILTER_BRAND.$(byText(value)).click();
        return this;
    }

    @Step("В фильтре выбрать наличие крепления")
    public ProductListPage selectInFilterBindingAProduct(String value) {
        FILTER_BINDING.$(byText(value)).click();
        return this;
    }

    @Step("В фильтре выбрать уровень мастерства")
    public ProductListPage selectInFilterAProfessionalism(String value) {
        FILTER_PROFESSIONALISM.$(byText(value)).click();
        return this;
    }

    @Step("В фильтре выбрать ростовку(см)")
    public ProductListPage selectInFilterAHeight(String value) {
        FILTER_HEIGHT.$(byText(value)).click();
        return this;
    }

    @Step("Навести курсор мыши на карточку товара")
    public ProductListPage hoverYourMouseOverTheProductCard() {
        PRODUCT_LIST.hover();
        return this;
    }

    @Step("Кликнуть на кнопку \"В корзину\"")
    public ProductListPage clickOnTheButtonThatAppears() {
        BUTTON_APPEAR.click();
        return this;
    }

    @Step("В попапп форме кликнуть на кнопку \"В корзину\"")
    public ProductListPage clickOnTheButtonInThePopupForm() {
        POPUP_FORM.$(byText("В корзину")).click();
        return this;
    }

    @Step("В появившемся модальном окне кликнуть \"В корзину\"")
    public BasketPage confirmBasketModal() {
        MODAL_CART_BUTTON
                .should(Condition.visible, Duration.ofSeconds(10))
                .click();
        return new BasketPage();
    }

    @Step("Навести курсор мыши на третью карточку товара")
    public ProductListPage hoverYourMouseOverTheThirdCard() {
        PRODUCT_LIST_COLLECTION.get(2).hover();
        return this;
    }

    @Step("Проверить, что на странице отображаются товары в соответствии с фильтром")
    public ProductListPage checkBrandSneakers(String brand) {
        FILTER_BRAND.shouldHave(text(brand));
        return this;
    }

    @Step("Добавить товар в избранное")
    public ProductListPage addProductToFavorites() {
        CATALOG_FAVORITE.get(2).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Кликнуть на нужную карточку товара")
    public ProductDetailPage selectProductListItem(String value) {
        PRODUCT_LIST.find(byText(value)).click();
        //productName.shouldHave(text(value));
        return new ProductDetailPage();
    }
}
