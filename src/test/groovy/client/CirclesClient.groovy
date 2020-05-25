package client

import io.restassured.response.Response
import request.circle.Circle

import static io.restassured.RestAssured.given

class CirclesClient extends Client {

    public static final String HEADER_CONTENT_TYPE_VALUE = "application/json"

    private final String BASE_URL_CIRCLE_PATH = "prop.server.api.host"
    private final String URL_CIRCLES_PATH = "prop.server.path.moove.circles"
    private URL url


    CirclesClient() {
        super
        url = getUrl(BASE_URL_CIRCLE_PATH, URL_CIRCLES_PATH)
    }

    Response fetchCircles(String accessToken, Circle circleBody) {
        return given()
                .header("Content-Type", HEADER_CONTENT_TYPE_VALUE)
                .header("Authorization", "Bearer " + accessToken)
                .body(circleBody)
                .post(url).andReturn()
    }
}