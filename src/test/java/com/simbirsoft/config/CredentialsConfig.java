package com.simbirsoft.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${testType}.properties", "classpath:config/local.properties"})
//последовательно идет по коду, и выбирает ресур, тот , которые подошел, если не указал, то берет следующий.Очень удобно
//Запускает и через зеленую стрелку и через консоль и по одиночке и с указаение .properties файла
public interface CredentialsConfig extends Config {
    String login();
    String password();
    String login1();
    String password1();
    String remoteUrl();
    String remote();
}
