package com.challenge.tasks;

import com.challenge.interactions.api.Post;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearRecurso implements Task {

    private final String recurso;
    private final Object body;

    public CrearRecurso(String recurso, Object body) {
        this.recurso = recurso;
        this.body = body;
    }

    @Override
    @Step("{0} envía la información al recurso #recurso")
    public <T extends Actor> void performAs(T actor) {
        // Aquí la Tarea llama a la Interacción que acabas de crear
        actor.attemptsTo(
            Post.alRecurso(recurso, body)
        );
    }

    public static CrearRecurso conDatos(String recurso, Object body) {
        return instrumented(CrearRecurso.class, recurso, body);
    }
}
