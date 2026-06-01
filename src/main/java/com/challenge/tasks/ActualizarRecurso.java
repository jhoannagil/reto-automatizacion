package com.challenge.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.challenge.interactions.api.Put;

public class ActualizarRecurso implements Task {
      private final String endpoint;
    private final Object body;

    public ActualizarRecurso(String endpoint, Object body) {
        this.endpoint = endpoint;
        this.body = body;
    }

   
    @Override
    @Step("{0} envía la información al recurso #recurso")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Put.alRecurso(endpoint, body)
        );
    }

     public static ActualizarRecurso conDatos(String endpoint, Object body) {
        return instrumented(ActualizarRecurso.class, endpoint, body);
    }



    
    
}
