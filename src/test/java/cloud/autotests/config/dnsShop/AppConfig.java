package cloud.autotests.config.dnsShop;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/dns-shop/app.properties"
})
public interface AppConfig extends Config {

    String webUrl();
    String apiUrl();
    String userLogin();
    String userPassword();

}
