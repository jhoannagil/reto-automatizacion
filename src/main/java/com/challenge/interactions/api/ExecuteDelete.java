package com.challenge.interactions.api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteDelete implements Interaction {

    private final String endpoint;

    public ExecuteDelete(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    @Step("{0} ejecuta una petición DELETE al recurso #endpoint")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Delete.from(endpoint));
    }

    public static ExecuteDelete alRecurso(String endpoint) {
        return instrumented(ExecuteDelete.class, endpoint);
    }
}