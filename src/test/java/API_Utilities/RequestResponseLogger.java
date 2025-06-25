package API_Utilities;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RequestResponseLogger implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        Response response = ctx.next(requestSpec, responseSpec);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));

        // Save request
        String requestFile = "logs/request_" + timestamp + ".json";
        String requestBody = requestSpec.getBody() != null ? requestSpec.getBody().toString() : "NO_BODY";

        // Save response
        String responseFile = "logs/response_" + timestamp + ".json";
        String responseBody = response.asPrettyString();

        try {
            Files.createDirectories(Paths.get("logs"));
            try (FileWriter reqWriter = new FileWriter(requestFile)) {
                reqWriter.write("URI: " + requestSpec.getURI() + "\nMethod: " + requestSpec.getMethod() + "\nBody:\n" + requestBody);
            }

            try (FileWriter respWriter = new FileWriter(responseFile)) {
                respWriter.write("Status Code: " + response.getStatusCode() + "\nBody:\n" + responseBody);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
