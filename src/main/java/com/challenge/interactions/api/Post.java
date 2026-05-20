package com.challenge.interactions.api;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Post implements Interaction {

    private final String endpoint;

    public Post(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                net.serenitybdd.screenplay.rest.interactions.Post.to(endpoint)
        );
    }

    public static Post to(String endpoint) {
        return Tasks.instrumented(Post.class, endpoint);
    }
}
