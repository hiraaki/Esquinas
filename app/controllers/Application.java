package controllers;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import models.Bairro;
import models.Esquina;
import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Plot"));
    }
    //@BodyParser.Of(BodyParser.Json.class)
    public Result upload(){
        JsonNode json = request().body().asJson();
        if(json == null) {
            return badRequest("Expecting Json data");
        } else {
            int Nbairro = json.findPath("Bairro").asInt();
            if (Nbairro == 0) {
                return badRequest("Missing parameter [Bairro]");
            } else {
                /*List<Esquina> pontos= Ebean.find(Esquina.class)
                        .where()
                        .eq("rua1","ARQUITETURA")
                        .findList()
                ;*/
                List <Esquina> pontos = Ebean.find(Esquina.class)
                        .findList();

                return ok(Json.toJson(pontos));

            }
        }
    }
}
