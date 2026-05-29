package com.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import com.challenge.interactions.api.ExecuteGet;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarRecurso implements Task {

    private final String recurso;

    public ConsultarRecurso(String recurso) {
        this.recurso = recurso;
    }

    @Override
    @Step("{0} realiza una petición GET al recurso #recurso")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGet.recurso(recurso));
    }

    public static ConsultarRecurso conElRecurso(String recurso) {
        return instrumented(ConsultarRecurso.class, recurso);
    }
}
