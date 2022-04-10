package cloud.autotests.tests.ui;

import cloud.autotests.tests.TestBase;
import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AddGoodsToBasket extends TestBase {

    @Test
    @Tag("UI")
    @Description("Проверка на добавление товара в корзину и количество товара в корзине равное 1")
    @DisplayName("Добавить товар в пустую корзину через поиск")
    void addGoodsToEmptyBasket() {
        step("Open 'https://www.dns-shop.ru/'", () -> {
            open("/");
        });
        step("Ввод текста 'Iphone' в поле поиска и нажать Enter", () -> {
            $(".btn-additional").click();
            $(".logo").click();
            $("#header-search [name='q']").setValue("Iphone").pressEnter();
        });
        step("Кликнуть 'Купить' у первого товара", () -> {
            $(byText("Купить")).click();
        });
        step("Количество в корзине = '1' в меню", () -> {
            $(".cart-link__badge").shouldHave(text("1"));
        });
        step("Кликнуть на корзину", () -> {
            $("a.cart-link").click();
        });
        step("Количество в корзине = '1'", () -> {
            $$(".cart-items__product").shouldHave(CollectionCondition.size(1));
        });
    }

    @Test
    @Tag("UI")
    @Description("Проверка на добавление товара в корзину и количество товара в корзине равное 2")
    @DisplayName("Добавить товар в не пустую корзину через поиск")
    void addGoodsToFullBasket() {
        step("Open 'https://www.dns-shop.ru/'", () -> {
            open("/");
        });
        step("Ввод текста 'Iphone' в поле поиска и нажать Enter", () -> {
            $(".btn-additional").click();
            $(".logo").click();
            $("#header-search [name='q']").setValue("Iphone").pressEnter();
        });
        step("Кликнуть 'Купить' у первого товара", () -> {
            $(byText("Купить")).click();
        });
        step("Ввод текста 'кофеварка' в поле поиска и нажать Enter", () -> {
            $("#header-search [name='q']").setValue("кофеварка").pressEnter();
        });
        step("Кликнуть 'Купить' у первого товара", () -> {
            $(byText("Купить")).click();
        });
        step("Количество в корзине = '2' в меню", () -> {
            $(".cart-link__badge").shouldHave(text("2"));
        });
        step("Кликнуть на корзину", () -> {
            $("a.cart-link").click();
        });
        step("Количество в корзине = '2'", () -> {
            $$(".cart-items__product").shouldHave(CollectionCondition.size(2));
        });
    }

    @Test
    @Tag("UI")
    @Description("Проверка на добавление товара в корзину и количество товара в корзине равное 1")
    @DisplayName("Добавить товар в пустую корзину через поиск")
    void addGoodsToEmptyBasketFromMenu() {
        step("Open 'https://www.dns-shop.ru/'", () -> {
            open("/");
        });
        step("Выбрать 'Смартфоны' в боковом меню", () -> {
            $(".btn-additional").click();
            $(".logo").click();
            $(byText("Смартфоны и гаджеты")).hover();
            $(byText("Смартфоны")).click();

        });
        step("Кликнуть 'Купить' у первого товара", () -> {
            $(byText("Купить")).click();
        });
        step("Количество в корзине = '1' в меню", () -> {
            $(".cart-link__badge").shouldHave(text("1"));
        });
        step("Кликнуть на корзину", () -> {
            $("a.cart-link").click();
        });
        step("Количество в корзине = '1'", () -> {
            $$(".cart-items__product").shouldHave(CollectionCondition.size(1));
        });
    }
}