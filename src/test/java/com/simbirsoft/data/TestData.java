package com.simbirsoft.data;

import com.github.javafaker.Faker;
import com.simbirsoft.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

public class TestData {
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    public String urlSite = "https://wooordhunt.ru/";
    public String login = credentials.login();
    public String password = credentials.password();
    public String textAreaOneAuthorization = "Вы успешно вошли на сайт как зарегистрированный пользователь," +
            " и теперь вам доступны все функции сайта. ";
    public String textAreaTwoAuthorization = "Свои персональные данные вы можете посмотреть в Личном кабинете.\n" +
            "\n" +
            "Мы старались сделать всё максимально удобно, но возможно, вам потребуется некоторое время для того," +
            " чтобы здесь освоиться. Мы уверены, что у вас всё получится, но если у вас останутся какие-то вопросы" +
            " или появятся предложения, то смело пишите нам на info@wooordhunt.ru";
    public String textAreaHeaderSupport = "Справочная информация";
    public String textTheSearchWord = new Faker().animal().name();
    public String[] textTheSearchTwoWord = new String[]{new Faker().animal().name(), new Faker().animal().name()};
    public String textInHeadingExercisesTab = "Упражнения для запоминания английских слов";
    public String textInHeadingDifferentTab = "Дополнительные материалы";
}
