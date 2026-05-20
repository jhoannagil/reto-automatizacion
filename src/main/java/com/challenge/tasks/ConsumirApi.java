package com.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.annotations.Step;


import static net.serenitybdd.screenplay.Tasks.instrumented;




public class ConsumirApi implements Task {

    private final String recurso;

    public ConsumirApi(String recurso) {
        this.recurso = recurso;
    }

  

    @Override
    @Step("{0} realiza una petición GET al recurso #recurso")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(recurso));
    }

      public static ConsumirApi conElRecurso(String recurso) {
        return instrumented(ConsumirApi.class, recurso);
    }
}
