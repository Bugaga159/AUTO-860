package cloud.autotests.tests;

import cloud.autotests.config.Project;
import cloud.autotests.config.dnsShop.App;
import cloud.autotests.helpers.AllureAttachments;
import cloud.autotests.helpers.DriverSettings;
import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
        RestAssured.baseURI = App.config.apiUrl();
        RestAssured.filters(new AllureRestAssured());
    }

    @AfterEach
    public void addAttachments() {
        if (System.getProperty("api") == null) {
            String sessionId = DriverUtils.getSessionId();
            AllureAttachments.addScreenshotAs("Last screenshot");
            AllureAttachments.addPageSource();
            AllureAttachments.addBrowserConsoleLogs();

            Selenide.closeWebDriver();

            if (Project.isVideoOn()) {
                AllureAttachments.addVideo(sessionId);
            }
        }
    }
}
