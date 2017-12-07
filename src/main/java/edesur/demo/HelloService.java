package edesur.demo;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
@Api(value = "/hello", description = "El clásico Hello World")
public class HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    public HelloService() {
    }

    @GET
    @Path("/{nombre}")
    @Produces("application/json")
    @ApiOperation(value = "Say Hello to You", notes = "Algunas notas del método", response = String.class)
    public String helloYou(String nombre) {
        logger.info("GET Hello \"{}\"", nombre);
        return "Hello " + nombre;
    }
}
