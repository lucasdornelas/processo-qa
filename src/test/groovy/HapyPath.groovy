import response.Token
import spock.lang.Specification

import java.nio.file.Paths

import static io.restassured.RestAssured.given

class HapyPath extends Specification {
    static Properties getProp() throws IOException {
        Properties props = new Properties()
        FileInputStream file = new FileInputStream(Paths.get("src/test/resources/test.properties").toString())
        props.load(file)
        return props
    }

    def "fetchToken"() {
        Properties prop = getProp();

        URL url = new URL(prop.getProperty("prop.server.host") + prop.getProperty("prop.server.path.openid-connect"));

        def body = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("username", System.getenv("USER"))
                .formParam("password", System.getenv("PASSWORD"))
                .formParam("grant_type", "password")
                .formParam("client_id", "darwin-client")
                .post(url).andReturn().jsonPath()

        def token = body.getObject('', Token)

        with(token) {
            token.access_token == null
        }

        given: "Dado que yo tengo una reserva con infant"

        when: "hago una llamada en el endpoint GET Boarding Pass con esta reserva"
        then: "Recibo las informaciones para se crear un Boarding Pass con barcode signed"

    }
}
