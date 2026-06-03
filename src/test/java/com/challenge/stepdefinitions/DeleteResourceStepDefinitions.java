package com.challenge.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.challenge.questions.TheStatusCode;
import com.challenge.tasks.EliminarRecurso;
import com.challenge.utils.config.EnvironmentConfig;
import com.challenge.utils.constants.Endpoints;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;

public class DeleteResourceStepDefinitions {

    private EnvironmentVariables environmentVariables;


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        EnvironmentConfig.setVariables(environmentVariables);  
    }

      
    @Given("que el usuario quiere eliminar un registro en la API")
    public void que_el_usuario_quiere_eliminar_un_registro_en_la_api() {
       String urlBase = EnvironmentConfig.urlBase();
        
        OnStage.theActorCalled("Jhoanna").whoCan(CallAnApi.at(urlBase));
        SerenityRest.useRelaxedHTTPSValidation(); 
    }


    @When("el usuario elimina el registro con id {int}")
    public void el_usuario_elimina_el_registro_con_id(Integer id) {
         String endpoint = Endpoints.RECURSO_POST_POR_ID.getUrl().replace("{id}", id.toString());

        theActorInTheSpotlight().attemptsTo(
            EliminarRecurso.delRecurso(endpoint)
        );
    }

    @Then("el usuario visualiza que el codigo de respuesta del delete es {int}")
    public void el_usuario_visualiza_que_el_codigo_de_respuesta_del_delete_es(Integer codigoEsperado) {
       theActorInTheSpotlight().should(
            seeThat("El codigo de estado de la respuesta", TheStatusCode.value(), equalTo(codigoEsperado))
        );
    }

}
