package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class MainPage extends LayoutPage<MainPage>{

    //todo перенести в layoutpage
    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("");
        return this;
    }
}
