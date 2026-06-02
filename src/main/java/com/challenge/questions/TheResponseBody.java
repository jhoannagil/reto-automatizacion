package com.challenge.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class TheResponseBody {

    public static Question<Integer> id() {
        return actor -> SerenityRest.lastResponse().jsonPath().getInt("id");
    }
    public static Question<String> field(String path) {
        return actor -> SerenityRest.lastResponse().jsonPath().getString(path);
    }
    public static Question<Integer> intField(String path) {
        return actor -> SerenityRest.lastResponse().jsonPath().getInt(path);
    }
}