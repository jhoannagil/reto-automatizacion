package com.challenge.interactions.api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Delete implements Interaction {

    private final String endpoint;

    public Delete(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                net.serenitybdd.screenplay.rest.interactions.Delete.from(endpoint)
        );
    }

    public static Delete from(String endpoint) {
        return Tasks.instrumented(Delete.class, endpoint);
    }
}
