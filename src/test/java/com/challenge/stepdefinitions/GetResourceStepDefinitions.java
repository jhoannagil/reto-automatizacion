package com.challenge.stepdefinitions;


import com.challenge.questions.TheResponseBody;
import com.challenge.questions.TheStatusCode;
import com.challenge.tasks.ConsultarRecurso;
import com.challenge.utils.constants.Endpoints;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;




public class GetResourceStepDefinitions {

    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
    
    @Given("que el usuario consume el api con el metodo get")
    public void que_el_usuario_consume_el_api_con_el_metodo_get() {

        String URL_BASE = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("base.url");
        System.out.println("URL BASE ES: " + URL_BASE);

        OnStage.theActorCalled("Jhoanna")
               .whoCan(CallAnApi.at(URL_BASE));
        SerenityRest.useRelaxedHTTPSValidation();  
        
        String endpoint = Endpoints.RECURSO_POST_POR_ID.getUrl().replace("{id}", "1");

        theActorInTheSpotlight().attemptsTo(
            ConsultarRecurso.conElRecurso(endpoint)
        );
    }

    @Then("el usuario visualiza que el código de respuesta del get es {int}")
    public void el_usuario_visualiza_que_el_codigo_de_respuesta_del_get_es(Integer codigoEsperado) {
        theActorInTheSpotlight().should(
            seeThat("El código de estado de la respuesta", TheStatusCode.value(), equalTo(codigoEsperado))
        );
    }

    @Then("el usuario valida que el id sea igual a {int}")
    public void el_usuario_valida_que_el_id_sea_igual_a(Integer idEsperado) {
        OnStage.theActorInTheSpotlight().should(
            seeThat("el ID obtenido del servicio", TheResponseBody.id(), equalTo(idEsperado))
        );
    }
}