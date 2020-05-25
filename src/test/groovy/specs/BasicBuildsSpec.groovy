package specs

import client.AuthClient
import client.BuildsClient
import client.CirclesClient
import fixture.circle.CircleFixture
import io.restassured.response.Response
import response.buildv2.Builds
import response.circle.Circle
import response.token.Token
import spock.lang.Shared
import spock.lang.Specification

class BasicBuildsSpec extends Specification {

    @Shared
    private static Token token

    def setupSpec() {
        AuthClient authClient = new AuthClient()
        Response authResponse = authClient.fetchAuth()
        token = authResponse.jsonPath().getObject('', Token)

    }

    def "Retorna um objeto contendo as infortmacoes de um Circle Criado"() {

        given: "Dado que efetuei um request no endpoint POST para um criar um circle"

        def circleBody = new CircleFixture().build()
        CirclesClient circlesClient = new CirclesClient()
        Response circlesResponse = circlesClient.fetchCircles(token.accessToken, circleBody)

        when: "Chamo o endpoint GET para obter os builds que foram criados"

        BuildsClient buildsClient = new BuildsClient()


        Response buildsResponse = buildsClient.fetchBuilds(token.accessToken)

        then: "Vejo que o Status Code do response e 200"

        buildsResponse.getStatusCode() == 200

        and:('E valido o body do response')

        Builds builds = buildsResponse.jsonPath().getObject('', Builds)

    }
}
