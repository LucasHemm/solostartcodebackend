package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.*;
import facades.GameFacade;
import facades.JokeFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("game")
public class GameResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final GameFacade FACADE =  GameFacade.getGameFacade(EMF);
    //comment to test for workflow on github

    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPerson(@PathParam("name") String name) throws Exception {
        AgifyDTO agifyDTO = FACADE.createAgifyDTo(FACADE.fetchData("https://api.agify.io?name="+name));
        System.out.println(agifyDTO);
        GenderizeDTO genderizeDTO = FACADE.createGenderizeDTO(FACADE.fetchData("https://api.genderize.io?name="+name));
        System.out.println(genderizeDTO);
        PersonDTO personDTO = new PersonDTO(name,agifyDTO,genderizeDTO);
        FACADE.create(personDTO);
        return Response.ok().entity(personDTO).build();
    }
//test test
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllPersons() {
        return Response.ok().entity(FACADE.getAll()).build();
    }
}
