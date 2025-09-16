package components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.ProductListPage;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;


public class MenuItem {
    SelenideElement root;

    public MenuItem(SelenideElement root) {  // конструктор: сохраняем "корневой элемент" для работы с этим меню
        this.root = root;
    }

    public ProductListPage chooseSubMenu(String sectionHeader, String subItemText) {
        // ищем в root элемент по тексту (название секции верхнего уровня, например "Одежда")
        SelenideElement menuHeader = root.find(byText(sectionHeader));
        // берём родителя родителя этого элемента (обычно это <ul> со списком пунктов)
        SelenideElement list = menuHeader.parent().parent();
        // собираем все <li> в списке
        ElementsCollection listItemCollection = list.findAll(byTagName("li"));
        // флаг — находимся ли мы внутри нужной секции
        boolean inSection = false;
        for (SelenideElement item : listItemCollection) {
            // достаём <a> (ссылку) из элемента меню
            SelenideElement link = item.find(byTagName("a"));
            // проверяем, является ли элемент "заголовком секции"
            if (item.getAttribute("class").contains("shop-dd-menu__head")) {
                // если это заголовок секции, и текст совпадает с value
                if (link.getText().equalsIgnoreCase(sectionHeader)) {
                    // включаем флаг: теперь мы в этой секции
                    inSection = true;
                } else {
                    // иначе — вышли из секции
                    inSection = false;
                }
            }
            // если ещё не вошли в секцию — пропускаем
            if (!inSection) {
                continue;
            }
            // если текст ссылки совпадает с section — кликаем
            if (link.getText().equalsIgnoreCase(subItemText)) {
                link.click();
                return new ProductListPage();
            }
        }
        return null; // todo заменить на исключение
    }
}

