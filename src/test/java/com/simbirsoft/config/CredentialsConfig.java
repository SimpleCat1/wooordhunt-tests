package com.simbirsoft.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${testType}.properties", "classpath:config/local.properties"})
public interface CredentialsConfig extends Config {
    String login();
    String password();
    String login1();
    String password1();
    String remoteUrl();
    String remote();
}
