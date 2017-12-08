package edesur.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    public HelloService() {
    }

    @GET
    @Path("{name}")
    @Produces("application/json")
    public String helloYou(@PathParam("name")String nombre) {
        logger.info("GET Hello {}", nombre);
        return "Hello " + nombre;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloPost(HelloRequest request) {
        logger.info("POST Hello {} {}", request.getNombre(), request.getApellido());
        HelloResponse response = new HelloResponse();
        response.setMensaje("Hola " + request.getNombre() + " " + request.getApellido());
        response.setInEnglish("Hello Mr. " + request.getNombre() + " " + request.getApellido());
        return Response.ok(response).build();
    }
}
