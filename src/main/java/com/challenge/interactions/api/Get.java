package com.challenge.interactions.api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.serenitybdd.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Get extends RestInteraction {
    private final String recurso;

    public Get(String recurso) {
        this.recurso = recurso;
    }

    @Override
    @Step("{0} ejecuta una petición GET al recurso #recurso")
    public <T extends Actor> void performAs(T actor) {
        rest().get(recurso);
    }

    public static Get recurso(String recurso) {
        return instrumented(Get.class, recurso);
    }
}
