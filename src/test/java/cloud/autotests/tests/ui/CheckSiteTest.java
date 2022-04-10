package cloud.autotests.tests.ui;

import cloud.autotests.helpers.DriverUtils;
import cloud.autotests.tests.TestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckSiteTest extends TestBase {

    @Test
    @Tag("UI")
    @Description("Проверка title сайта DNS")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open 'https://www.dns-shop.ru/'", () ->
                open("/"));

        step("Page title should have text 'DNS – интернет магазин цифровой " +
                "и бытовой техники по доступным ценам.'", () -> {
            String expectedTitle = "DNS – интернет магазин цифровой и бытовой техники по доступным ценам.";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Tag("UI")
    @Description("Проверка на отсутствие ошибок в консоли сайта")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open 'https://www.dns-shop.ru/'", () ->
            open("/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
