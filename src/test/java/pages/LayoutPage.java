package pages;

import com.codeborne.selenide.SelenideElement;
import components.Header;
import components.MenuItem;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LayoutPage<T> {
    SelenideElement headerFavorite = $(".header__favorite");
    Header header = new Header();

@Step("Навести курсор мышки на группу товаров")
    public MenuItem chooseCategoryMenuItem(String value) {
        return header.chooseMenuItem(value);
    }

    @Step("Кликнуть справа вверху на избранное")
    public ProductListPage setHeaderFavorite() {
        headerFavorite.click();
        return new ProductListPage();
    }

}
