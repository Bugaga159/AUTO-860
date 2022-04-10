package cloud.autotests.tests.ui;

import cloud.autotests.tests.TestBase;
import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AddGoodsToWishList extends TestBase {

    @Test
    @Tag("UI")
    @Description("Проверка на добавление товара в избранное и количество товара в избранное равное 1")
    @DisplayName("Добавить товар в избранное через поиск")
    void addGoodsToEmptyBasket() {
        step("Open 'https://www.dns-shop.ru/'", () -> {
            open("/");
        });

        step("Ввод текста 'Iphone' в поле поиска и нажать Enter", () -> {
            $(".btn-additional").click();
            $(".logo").click();
            $("#header-search [name='q']").setValue("Iphone").pressEnter();
        });

        step("Кликнуть 'Добавить в избранное' у первого товара", () -> {
            $(".wishlist-btn").click();
            $(byText("Понятно, закрыть")).shouldHave(visible);
            $(byText("Понятно, закрыть")).click();
        });

        step("Количество в избранное = '1' в меню", () -> {
            $(".wishlist-link__badge").shouldHave(text("1"));
        });

        step("Кликнуть на 'Избранное'", () -> {
            $("a.wishlist-link").click();
        });

        step("Количество в корзине = '1'", () -> {
            $$(".profile-wishlist__catalog-product").shouldHave(CollectionCondition.size(1));
        });
    }

}
