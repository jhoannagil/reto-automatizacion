package com.challenge.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.challenge.models.request.PostRequest;
import com.challenge.questions.TheResponseBody;
import com.challenge.questions.TheStatusCode;
import com.challenge.tasks.CrearRecurso;
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
import java.util.List;
import java.util.Map;


public class PostResourceStepDefinitions {

    private EnvironmentVariables environmentVariables;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        EnvironmentConfig.setVariables(environmentVariables);
    }


    @Given("que el usuario quiere crear un nuevo registro en la API")
    public void que_el_usuario_quiere_crear_un_nuevo_registro_en_la_api() {
        String urlBase = EnvironmentConfig.urlBase();
        
        OnStage.theActorCalled("Jhoanna").whoCan(CallAnApi.at(urlBase));
        SerenityRest.useRelaxedHTTPSValidation(); 
    }

    @When("el usuario envía los datos para crear el registro")
    public void el_usuario_envia_los_datos_para_crear_el_registro(List<Map<String, String>> datos) {
        
        PostRequest datosAEnviar = PostRequest.builder()
                .title(datos.get(0).get("title"))
                .body(datos.get(0).get("body"))
                .userId(Integer.parseInt(datos.get(0).get("userId")))
                .build();

        String endpoint = Endpoints.RECURSO_POSTS.getUrl();

        theActorInTheSpotlight().attemptsTo(
            CrearRecurso.conDatos(endpoint, datosAEnviar)
        );
    }

    @Then("el usuario visualiza que el código de respuesta es {int}")
    public void el_usuario_visualiza_que_el_codigo_de_respuesta_es(Integer codigoEsperado) {
        theActorInTheSpotlight().should(
            seeThat("El código de estado de la respuesta", TheStatusCode.value(), equalTo(codigoEsperado))
        );
    }
    @Then("verifica que el registro se creo con la informacion enviada")
    public void verifica_que_el_registro_se_creo_con_la_informacion_enviada(List<Map<String, String>> datos) {
        theActorInTheSpotlight().should(     
            seeThat("El título en la respuesta", 
                TheResponseBody.field("title"), equalTo(datos.get(0).get("title"))),
                
            seeThat("El body en la respuesta", 
                TheResponseBody.field("body"), equalTo(datos.get(0).get("body"))),
                
            seeThat("El userId en la respuesta", 
                TheResponseBody.intField("userId"), equalTo(Integer.parseInt(datos.get(0).get("userId"))))
        );
    }

}
