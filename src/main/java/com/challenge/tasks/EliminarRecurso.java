package com.challenge.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import com.challenge.interactions.api.ExecuteDelete;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.annotations.Step;

public class EliminarRecurso implements Task {

    private final String resource;

    public EliminarRecurso(String resource) {
        this.resource = resource;
    }

    @Override
    @Step("{0} procede a eliminar el recurso #resource")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            ExecuteDelete.alRecurso(resource)
        );
    }

    public static EliminarRecurso delRecurso(String resource) {
        return instrumented(EliminarRecurso.class, resource);
    }
}