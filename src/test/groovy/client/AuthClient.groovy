package client

import io.restassured.response.Response

import static io.restassured.RestAssured.given

class AuthClient extends Client {

    public static final String HEADER_CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded"
    private final String BASE_URL_PATH = "prop.server.keycloak.host"
    private final String URL_AUTH_PATH = "prop.server.path.auth"

    private URL url

    private String parameterUser
    private String parameterPassword
    private String parameterGrantType
    private String parameterClientId

    AuthClient() {
        super
        url = getUrl(BASE_URL_PATH, URL_AUTH_PATH)
        parameterUser = System.getenv("USER")
        parameterPassword = System.getenv("PASSWORD")

        parameterUser = "processoqa@zup.com.br"
        parameterPassword = "123mudar"
    }

    Response fetchAuth() {
        return given()
                .header("Content-Type", HEADER_CONTENT_TYPE_VALUE)
                .formParam("username", parameterUser)
                .formParam("password", parameterPassword)
                .formParam("grant_type", parameterGrantType)
                .formParam("client_id", parameterClientId)
                .post(url).andReturn()
    }
}
