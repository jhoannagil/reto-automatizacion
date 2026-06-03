package com.challenge.stepdefinitions;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.challenge.questions.TheResponseBody;
import com.challenge.questions.TheStatusCode;
import com.challenge.tasks.ConsultarRecurso;
import com.challenge.utils.config.EnvironmentConfig;
import com.challenge.utils.constants.Endpoints;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;


public class GetResourceStepDefinitions {

    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        EnvironmentConfig.setVariables(environmentVariables);  
    }
    
    @Given("que el usuario consume el api con el metodo get")
    public void que_el_usuario_consume_el_api_con_el_metodo_get() {

        String urlBase = EnvironmentConfig.urlBase();

        OnStage.theActorCalled("Jhoanna")
               .whoCan(CallAnApi.at(urlBase));
        SerenityRest.useRelaxedHTTPSValidation();  
    }

    @When("el usuario consulta el registro con id {int}")
    public void consultarRegistro(int id) {
        String endpoint = Endpoints.RECURSO_POST_POR_ID.getUrl()
                .replace("{id}", String.valueOf(id));

        theActorInTheSpotlight().attemptsTo(
            ConsultarRecurso.conElRecurso(endpoint)
        );
    }


    @Then("el usuario visualiza que el codigo de respuesta del get es {int}")
    public void el_usuario_visualiza_que_el_codigo_de_respuesta_del_get_es(Integer codigoEsperado) {
        theActorInTheSpotlight().should(
            seeThat("El codigo de estado de la respuesta", TheStatusCode.value(), equalTo(codigoEsperado))
        );
    }

    @Then("el usuario valida que el id sea igual a {int}")
    public void el_usuario_valida_que_el_id_sea_igual_a(Integer idEsperado) {
        OnStage.theActorInTheSpotlight().should(
            seeThat("el ID obtenido del servicio", TheResponseBody.id(), equalTo(idEsperado))
        );
    }
}