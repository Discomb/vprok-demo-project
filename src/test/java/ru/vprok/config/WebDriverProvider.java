package ru.vprok.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;

public class WebDriverProvider {

    public void setupDriver() {

        Config config = ConfigFactory.create(Config.class, System.getProperties());

        String selenoidHome = config.getRemoteUrl();
        String selenoidCreds = config.getRemoteAuth();

        if (!(selenoidHome.isEmpty() || selenoidCreds.isEmpty())) {
            Configuration.remote = "https://" + selenoidCreds + "@" + selenoidHome + "/wd/hub";
        }

        baseUrl = config.getBaseUrl();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }
}
