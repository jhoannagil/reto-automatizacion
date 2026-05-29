package com.challenge.interactions.api;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Post extends RestInteraction {
    
    private final String recurso;
    private final Object body;

    public Post(String recurso, Object body) {
        this.recurso = recurso;
        this.body = body;
    }

    @Override
    @Step("{0} ejecuta una petición POST al recurso #recurso")
    public <T extends Actor> void performAs(T actor) {
        rest()
            .header("Content-Type", "application/json; charset=UTF-8")
            .body(body)
            .post(CallAnApi.as(actor).resolve(recurso));
    }

    public static Post alRecurso(String recurso, Object body) {
        return instrumented(Post.class, recurso, body);
    }
}