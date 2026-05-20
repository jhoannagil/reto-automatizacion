package com.challenge.interactions.api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Put implements Interaction {

    private final String endpoint;

    public Put(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                net.serenitybdd.screenplay.rest.interactions.Put.to(endpoint)
        );
    }

    public static Put to(String endpoint) {
        return Tasks.instrumented(Put.class, endpoint);
    }
}
