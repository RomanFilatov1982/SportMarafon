package components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.ProductListPage;
import utils.ElementNotFoundException;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;


public class MenuItem {
    SelenideElement root;

    public MenuItem(SelenideElement root) {  // конструктор: сохраняем "корневой элемент" для работы с этим меню
        this.root = root;
    }

    @Step("Выбрать в секции категорию товара")
    public ProductListPage chooseSubMenu(String sectionHeader, String subItemText) {

        SelenideElement menuHeader = root.find(byText(sectionHeader));
        SelenideElement list = menuHeader.parent().parent();
        ElementsCollection listItemCollection = list.findAll(byTagName("li"));
        boolean inSection = false;
        for (SelenideElement item : listItemCollection) {
            if (item.getAttribute("class").contains("shop-dd-menu__head")) {
                if (item.getText().equalsIgnoreCase(sectionHeader)) {
                    inSection = true;
                } else {
                    inSection = false;
                }
            }
            if (!inSection) {
                continue;
            }
            if (item.getText().equalsIgnoreCase(subItemText)) {
                item.click();
                return new ProductListPage();
            }
        }
        throw new ElementNotFoundException(String.format("Не нашли пункт меню: %s > %s", sectionHeader, subItemText));
    }
}

