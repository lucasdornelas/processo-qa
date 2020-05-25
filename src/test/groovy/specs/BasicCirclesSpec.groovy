package specs

import client.AuthClient
import client.CirclesClient
import fixture.request.circle.CircleFixture
import io.restassured.response.Response
import response.circle.Circle
import response.token.Token
import spock.lang.Shared
import spock.lang.Specification

class BasicCirclesSpec extends Specification {

    @Shared
    private static Token token

    def setupSpec() {
        AuthClient authClient = new AuthClient()
        Response authResponse = authClient.fetchAuth()
        token = authResponse.jsonPath().getObject('', Token)

    }

    def "Retorna um objeto contendo as infortmacoes de um Circle Criado"() {

        given: "Dado que tenho um token valido e um body valido"

        def circleBody = new CircleFixture().build()

        when: "Chamo o endpoint POST para obter um criar um circle"

        CirclesClient circlesClient = new CirclesClient()
        Response circlesResponse = circlesClient.fetchCircles(token.accessToken, circleBody)

        then: "Vejo que o Status Code do response e 200"

        circlesResponse.getStatusCode() == 200

        and:('E valido o body do response')

        Circle circle = circlesResponse.jsonPath().getObject('', Circle)

        with(circle) {
            getId() != null
            getName() != null
            getAuthor() != null
            getCreatedAt() != null
            getMatcherType() != null
            getRules() != null
            getDeployment() == null
            getImportedAt() == null
            getImportedKvRecords() == null
        }
    }
}
