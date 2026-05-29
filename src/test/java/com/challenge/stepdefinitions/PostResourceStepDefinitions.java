package com.challenge.stepdefinitions;

import com.challenge.models.request.PostRequest;
import com.challenge.questions.TheStatusCode;
import com.challenge.tasks.CrearRecurso;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class PostResourceStepDefinitions {

    private EnvironmentVariables environmentVariables;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("que el usuario quiere crear un nuevo registro en la API")
    public void que_el_usuario_quiere_crear_un_nuevo_registro_en_la_api() {
        String urlBase = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("base.url");
        
        OnStage.theActorCalled("Jhoanna").whoCan(CallAnApi.at(urlBase));
    }

    @When("el usuario envía los datos para crear el registro")
    public void el_usuario_envia_los_datos_para_crear_el_registro() {
        // Usamos el patrón Builder de Lombok para crear los datos a enviar
        PostRequest datosAEnviar = PostRequest.builder()
                .title("Automatizacion con Jhoanna")
                .body("Este es un post de prueba creado con Screenplay")
                .userId(1)
                .build();

        // Llamamos a nuestra tarea pasándole la ruta y los datos
        theActorInTheSpotlight().attemptsTo(
            CrearRecurso.conDatos("/posts", datosAEnviar)
        );
    }

    @Then("el usuario visualiza que el código de respuesta es {int}")
    public void el_usuario_visualiza_que_el_codigo_de_respuesta_es(Integer codigoEsperado) {
        theActorInTheSpotlight().should(
            seeThat("El código de estado de la respuesta", TheStatusCode.value(), equalTo(codigoEsperado))
        );
    }

    @Then("verifica que el registro se creó con la información enviada")
    public void verifica_que_el_registro_se_creo_con_la_informacion_enviada() {
        // En el próximo paso crearemos la pregunta (Question) para validar el Body
        // Por ahora lo dejaremos vacío para comprobar que el POST pasa.
    }
}
