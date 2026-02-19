package module7.activity2;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;

import java.util.List;

import io.swagger.v3.oas.models.Components;

public class SwaggerConfig {
    public static OpenAPI getOpenAPI() {
        // Define schema for M7Exercise1
        Schema<?> profileSchema = new Schema<>()
            .addProperty("id", new Schema<Long>().example(1L))
            .addProperty("name", new Schema<String>().example("Jose Rizal"))
            .addProperty("group", new Schema<String>().example("Illustrados"))
            .addProperty("apiCallsMade", new Schema<String>().example("[\"GET: /profiles\"]"));

        Components components = new Components()
            .addSchemas("M7Exercise1", profileSchema);

        Paths paths = new Paths();

        // GET /profiles
        paths.addPathItem("/profiles", new PathItem()
            .get(new Operation()
                .summary("Get all profiles")
                .responses(new ApiResponses()
                    .addApiResponse("200", new ApiResponse()
                        .description("List of profiles")
                        .content(new Content().addMediaType("application/json",
                            new MediaType().schema(new Schema<List>().$ref("#/components/schemas/M7Exercise1"))))))));

        // POST /profiles
        paths.get("/profiles").post(new Operation()
            .summary("Create a new profile")
            .responses(new ApiResponses()
                .addApiResponse("201", new ApiResponse()
                    .description("Profile created")
                    .content(new Content().addMediaType("application/json",
                        new MediaType().schema(new Schema<>().$ref("#/components/schemas/M7Exercise1")))))));

        // PUT /profiles
        paths.get("/profiles").put(new Operation()
            .summary("Update a profile")
            .responses(new ApiResponses()
                .addApiResponse("200", new ApiResponse()
                    .description("Profile updated")
                    .content(new Content().addMediaType("application/json",
                        new MediaType().schema(new Schema<>().$ref("#/components/schemas/M7Exercise1")))))));

        // DELETE /profiles/{id}
        paths.addPathItem("/profiles/{id}", new PathItem()
            .delete(new Operation()
                .summary("Delete a profile by ID")
                .responses(new ApiResponses()
                    .addApiResponse("200", new ApiResponse()
                        .description("Profile deleted")))));

        return new OpenAPI()
            .info(new Info()
                .title("Profiles API")
                .version("1.0")
                .description("Simple REST API using Spark Java"))
            .components(components)
            .paths(paths);
    }
}

