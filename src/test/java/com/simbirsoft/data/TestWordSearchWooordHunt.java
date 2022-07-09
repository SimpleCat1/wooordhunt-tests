package com.simbirsoft.data;

import com.github.javafaker.Faker;

public class TestWordSearchWooordHunt extends TestData{
    public String textTheSearchWord = new Faker().animal().name();
    public String[] textTheSearchTwoWord = new String[]{new Faker().animal().name(), new Faker().animal().name()};
}
