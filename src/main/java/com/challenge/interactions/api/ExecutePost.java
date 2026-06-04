package com.challenge.interactions.api;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import static net.serenitybdd.screenplay.Tasks.instrumented;

//Interacción personalizada para realizar las peticiones POST hacia la API

public class ExecutePost extends RestInteraction {

    private final String recurso;
    private final Object body;

    public ExecutePost(String recurso, Object body) {
        this.recurso = recurso;
        this.body = body;
    }
    public ExecutePost(String recurso) {
        this.recurso = recurso;
        this.body = null;
    }
    
    @Override
    @Step("{0} ejecuta una petición POST al recurso #recurso")
    public <T extends Actor> void performAs(T actor) {
        rest()
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(body == null ? "" : body)
                .post(CallAnApi.as(actor).resolve(recurso));
    }

    public static ExecutePost alRecurso(String recurso, Object body) {
        return instrumented(ExecutePost.class, recurso, body);
    }
}