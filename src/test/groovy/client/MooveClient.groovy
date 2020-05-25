package client

import com.fasterxml.jackson.databind.ObjectMapper
import fixture.circle.CircleFixture
import io.restassured.response.Response

import static io.restassured.RestAssured.given

class MooveClient extends Client {

    public static final String HEADER_CONTENT_TYPE_VALUE = "application/json"

    private final String BASE_URL_CIRCLE_PATH = "prop.server.api.host"
    private final String URL_AUTH_PATH = "prop.server.path.moove.circles"

    private URL url


    MooveClient() {
        super
        url = getUrl(BASE_URL_CIRCLE_PATH, URL_AUTH_PATH)
    }

    Response fetchCircles(String accessToken) {
        return given()
                .header("Content-Type", HEADER_CONTENT_TYPE_VALUE)
                .header("Authorization", "Bearer " + accessToken)
                .body(new CircleFixture().build())
                .post(url).andReturn()
    }
}
