package com.simbirsoft.data;

import com.simbirsoft.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

public class TestData {
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    public String urlSite = "https://wooordhunt.ru/";
    public String login = credentials.login();
    public String password = credentials.password();
}
