package com.challenge.interactions.api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteGet extends RestInteraction {
    private final String recurso;

    public ExecuteGet(String recurso) {
        this.recurso = recurso;
    }

    @Override
    @Step("{0} ejecuta una petición GET al recurso #recurso")
    public <T extends Actor> void performAs(T actor) {
        rest().get(CallAnApi.as(actor).resolve(recurso));
    }

    public static ExecuteGet recurso(String recurso) {
        return instrumented(ExecuteGet.class, recurso);
    }
}
