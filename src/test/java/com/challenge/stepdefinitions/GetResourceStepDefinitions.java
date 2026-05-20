package com.challenge.stepdefinitions;

import com.challenge.questions.ValidarRespuestaGet;
import com.challenge.tasks.ConsumirApi;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
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
        
        OnStage.theActorCalled("Jhoanna")
               .whoCan(CallAnApi.at(URL_BASE));
        SerenityRest.useRelaxedHTTPSValidation();       
        theActorInTheSpotlight().attemptsTo(
            ConsumirApi.conElRecurso("/posts/1")
        );
    }

    @Then("el usuario visualiza una respuesta exitosa por parte del api")
    public void el_usuario_visualiza_una_respuesta_exitosa_por_parte_del_api() {
        theActorInTheSpotlight().should(
            ResponseConsequence.seeThatResponse("El servidor respondió con éxito",
                response -> response.statusCode(200))
        );
    }

    @Then("el usuario valida que el id sea igual a {int}")
    public void el_usuario_valida_que_el_id_sea_igual_a(Integer idEsperado) {
        
        OnStage.theActorInTheSpotlight().should(
        seeThat("el ID obtenido del servicio", ValidarRespuestaGet.elIdEs(), equalTo(idEsperado)
        )
    );

    }
}