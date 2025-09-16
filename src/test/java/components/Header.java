package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header {

    private final SelenideElement HEADER_MENU = $(".header__shop-menu");

    private final ElementsCollection PRODUCT_LIST = $$("ul.shop-dd-menu__column li");

    public MenuItem chooseMenuItem(String value) {
        SelenideElement menuItemElement = HEADER_MENU.find(byText(value)); // ищем в верхнем меню (HEADER_MENU) элемент по тексту
        menuItemElement.hover();  // наводим мышку, чтобы открыть подменю (hover = действие "навести")
        return new MenuItem(menuItemElement.parent()); // возвращаем новый объект MenuItem,
        // в качестве "корня" берём родителя найденного элемента
    }

    public void selectProduct(String value) {
        PRODUCT_LIST.find(Condition.text(value)).click();
    }




}

