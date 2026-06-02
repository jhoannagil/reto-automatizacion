package com.challenge.interactions.api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;


import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.annotations.Step;

public class ExecutePut extends RestInteraction {

    private final String recurso;
    private final Object body;

    public ExecutePut(String recurso, Object body) {
        this.recurso = recurso;
        this.body = body;
    }

    @Override
    @Step("{0} ejecuta una petición PUT al recurso #recurso")
    public <T extends Actor> void performAs(T actor) {
        rest()
            .header("Content-Type", "application/json; charset=UTF-8")
            .body(body)
            .put(CallAnApi.as(actor).resolve(recurso));
    }

    public static ExecutePut alRecurso(String recurso, Object body) {
        return instrumented(ExecutePut.class, recurso, body);
    }
}
