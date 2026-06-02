package com.challenge.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Map;

import com.challenge.models.request.PutRequest;
import com.challenge.questions.TheStatusCode;
import com.challenge.tasks.ActualizarRecurso;
import com.challenge.utils.constants.Endpoints;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Entonces;
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

            @When("el usuario envia los datos actualizados del registro")
        public void el_usuario_envia_los_datos_actualizados_del_registro(List<Map<String, String>> datos) {
           PutRequest datosActualizados = PutRequest.builder()
            .title(datos.get(0).get("title"))
            .body(datos.get(0).get("body"))
            .userId(Integer.parseInt(datos.get(0).get("userId")))
            .build();

             String endpoint = Endpoints.RECURSO_POST_POR_ID.getUrl().replace("{id}", "1");

    theActorInTheSpotlight().attemptsTo(
        ActualizarRecurso.conDatos(endpoint, datosActualizados)
    );
        }
        @When("el usuario visualiza que el codigo de respuesta del put es {int}")
        public void el_usuario_visualiza_que_el_codigo_de_respuesta_del_put_es(Integer codigoEsperado) {
            theActorInTheSpotlight().should(
            seeThat("El codigo de estado de la respuesta", TheStatusCode.value(), equalTo(codigoEsperado))
        );
       
        }

        @Then("verifica que el registro se actualizo con la informacion enviada")
        public void verifica_que_el_registro_se_actualizo_con_la_informacion_enviada(List<Map<String, String>> datos) {
           theActorInTheSpotlight().should(
            seeThat("El titulo actualizado en la respuesta", 
                actor -> SerenityRest.lastResponse().jsonPath().getString("title"), 
                equalTo(datos.get(0).get("title"))),

            seeThat("El body actualizado en la respuesta", 
                actor -> SerenityRest.lastResponse().jsonPath().getString("body"), 
                equalTo(datos.get(0).get("body"))),
              
            seeThat("El userId actualizado en la respuesta", 
                actor -> SerenityRest.lastResponse().jsonPath().getInt("userId"), 
                equalTo(Integer.parseInt(datos.get(0).get("userId"))))
            );
        }
    
}
    
    
    
