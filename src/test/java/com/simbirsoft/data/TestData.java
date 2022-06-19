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
    public String[] textTheSearchTwoWord = new String[]{  new Faker().animal().name(),  new Faker().animal().name()};
    public String gender = "Male";
    public String birthday = "4 April,2022";
    public int monthText = 3;
    public int dayInt = 4;
    public int yearInt = 2022;
    public String emailText = "email@email.ru";
    public String mobileNumberText = "8888888888";
    public String subjectText = "a";
    public String subjectSelectionText = "Math";
    public String hobie = "Sports";
    public String currentAddressText = "address";
    public String state = "Uttar Pradesh";
    public String city = "Lucknow";
    public String filePathGif = "img/weegschaal-emoticon-sterrenbeeld.gif";
    public String fileNameGif = "weegschaal-emoticon-sterrenbeeld.gif";
}
