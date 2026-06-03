package com.challenge.tasks;


import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import com.challenge.interactions.api.ExecutePost;

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

        actor.attemptsTo(
            ExecutePost.alRecurso(recurso, body)
        );
    }

    public static CrearRecurso conDatos(String recurso, Object body) {
        return instrumented(CrearRecurso.class, recurso, body);
    }
}
