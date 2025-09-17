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
    SelenideElement productName = $(".product-list__name"),
    productList = $(".product-list__item-wrap"),
    filterBrand = $("#filter-block-brand-name"),
    filterBinding = $("#filter-block-kreplenie"),
    filterProfessionalism = $("#filter-block-uroven_masterstva"),
    filterHeight = $("#filter-block-multi_rostovka_lizi"),
            buttonAppear = $x("//button[text()='В корзину']"),
            popupForm = $(".popup-form__content_subscribe"),
            modalWindow = $("#modal-basket2141288"),
    brand = $("[href*='brands/adidas']");

    private final ElementsCollection productListCollection = $$(".product-list__item-link"),
            catalogFavorite = $$(".catalog__favourite");

    @Step("Проверить, что товары отобразились из нужной категории")
    public ProductListPage checkProductFromGroup(String value) {
        productName.shouldHave(text(value));
        return this;
    }

    @Step("Проверить, что товар отображается в избранном")
    public ProductListPage checkProductListName(String value) {
        productName.shouldHave(text(value));
        return this;
    }

    @Step("В фильтре выбрать бренд товара")
    public ProductListPage setFilterBrandProduct(String value) {
        filterBrand.$(byText(value)).click();
        return this;
    }

    @Step("В фильтре выбрать наличие крепления")
    public ProductListPage setFilterBindingProduct(String value) {
        filterBinding.$(byText(value)).click();
        return this;
    }

    @Step("В фильтре выбрать уровень мастерства")
    public ProductListPage setFilterProfessionalism(String value) {
        filterProfessionalism.$(byText(value)).click();
        return this;
    }

    @Step("В фильтре выбрать ростовку(см)")
    public ProductListPage setFilterHeight(String value) {
        filterHeight.$(byText(value)).click();
        return this;
    }

    @Step("Навести курсор мыши на карточку товара")
    public ProductListPage setProductItem() {
        productList.hover();
        return this;
    }

    @Step("Кликнуть на кнопку \"В корзину\"")
    public ProductListPage setButtonAppear() {
        buttonAppear.click();
        return this;
    }

    @Step("В попапп форме кликнуть на кнопку \"В корзину\"")
    public ProductListPage setPopupForm() {
        popupForm.$(byText("В корзину")).click();
        return this;
    }

    @Step("В появившемся модальном окне кликнуть \"В корзину\"")
    public BasketPage setModalWindow() {
        modalWindow.$(byText("В корзину")).click();
        return new BasketPage();
    }

    @Step("Навести курсор мыши на третью карточку товара")
    public ProductListPage setProductListItemLinkThird() { // два, но один элемент коллекции, а другой селенид элемент
        productListCollection.get(2).hover();
        return this;
    }

    @Step("Проверить, что на странице отображаются товары в соответствии с фильтром")
    public ProductListPage checkBrandSneakers() {
        brand.shouldHave(text("Adidas"));
        return this;
    }

    @Step("Добавить товар в избранное")
    public ProductListPage setCatalogFavorite() {
        catalogFavorite.get(2).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Кликнуть на нужную карточку товара")
    public ProductDetailPage setProductListItem(String value) {
        productList.find(byText(value)).click();
        //productName.shouldHave(text(value));
        return new ProductDetailPage();
    }


}
