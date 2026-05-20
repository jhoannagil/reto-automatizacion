package com.challenge.questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;



public class ValidarRespuestaGet implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
       
        Object idObtenido = LastResponse.received().answeredBy(actor).path("id");

           if (idObtenido == null) {
            return null;
        }

        return Integer.valueOf(idObtenido.toString());
    }

       public static ValidarRespuestaGet elIdEs() {
        return new ValidarRespuestaGet();
    }
}