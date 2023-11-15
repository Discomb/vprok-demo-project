package ru.vprok.config;

@org.aeonbits.owner.Config.Sources({
        "classpath:${env}.properties"
})
public interface Config extends org.aeonbits.owner.Config {

    @Key("browser.name")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browser.version")
    @DefaultValue("117")
    String getBrowserVersion();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browser.baseUrl")
    @DefaultValue("https://vprok.ru")
    String getBaseUrl();

    @Key("remote.url")
    @DefaultValue("")
    String getRemoteUrl();

    @Key("remote.auth")
    @DefaultValue("")
    String getRemoteAuth();
}
