package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.SportPage;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header {

    private final SelenideElement HEADER_MENU = $(".header__shop-menu");
    private final SelenideElement MENALPINSKIS = $("a[data-id='7614']");
    private final ElementsCollection PRODUCT_LIST = $$("ul.shop-dd-menu__column li");

    public MenuItem chooseMenuItem(String value) {
        SelenideElement menuItemElement = HEADER_MENU.find(byText(value));
        menuItemElement.hover();
        return new MenuItem(menuItemElement.parent());
    }

    public void selectProduct(String value) {
       PRODUCT_LIST.find(Condition.text(value)).click();
    }

    public void selectMenAlpineSkisUniversal() {
        MENALPINSKIS.click();
    }
    public class MenuItem {

        SelenideElement root;
        public MenuItem(SelenideElement root) {
            this.root = root;
        }

        public void chooseSubMenu(String value) {
            SelenideElement menuHeader = root.find(byText(value));
            SelenideElement list = menuHeader.parent();
            list.find(byTagName("li"));
        }
    }
}
