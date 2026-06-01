package com.challenge.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.challenge.models.request.PutRequest;
import com.challenge.questions.TheStatusCode;
import com.challenge.tasks.ActualizarRecurso;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;

public class PutResourceStepDefinition {

    private EnvironmentVariables environmentVariables;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

      @Given("que el usuario quiere actualizar un registro en la API")
    public void que_el_usuario_quiere_actualizar_un_registro_en_la_api() {
        String urlBase = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("base.url");
        
        OnStage.theActorCalled("Jhoanna").whoCan(CallAnApi.at(urlBase));
    }

            @When("el usuario envía los datos actualizados del registro")
        public void el_usuario_envía_los_datos_actualizados_del_registro() {
           PutRequest datosActualizados = PutRequest.builder()
            .title("Actualización de Jhoa PUT")
            .body("Esta es una prueba put de actualización")
            .userId(1)
            .build();

    theActorInTheSpotlight().attemptsTo(
        ActualizarRecurso.conDatos("/posts/1", datosActualizados)
    );
        }
        @When("el usuario visualiza que el código de respuesta del put es {int}")
        public void el_usuario_visualiza_que_el_código_de_respuesta_del_put_es(Integer codigoEsperado) {
            theActorInTheSpotlight().should(
            seeThat("El código de estado de la respuesta", TheStatusCode.value(), equalTo(codigoEsperado))
        );
       
        }
        @Then("verifica que el registro se actualizó con la información enviada")
        public void verifica_que_el_registro_se_actualizó_con_la_información_enviada() {
             theActorInTheSpotlight().should(
            seeThat("El título actualizado en la respuesta", 
                actor -> SerenityRest.lastResponse().jsonPath().getString("title"), 
                equalTo("Actualización de Jhoa PUT"))
        );
}
    
    
    
}
