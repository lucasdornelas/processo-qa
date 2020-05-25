package specs

import client.AuthClient
import client.CirclesClient
import fixture.request.circle.CircleFixture
import io.restassured.response.Response
import response.circle.Circle
import response.token.Token
import spock.lang.Shared
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat

class ValidatesPostCircles extends Specification {

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

        assertThat(circlesResponse.getStatusCode()).isEqualTo(200)

        and:('E valido o body do response')

        Circle circleResponseBody = circlesResponse.jsonPath().getObject('', Circle)

        assertThat(circleResponseBody.getName()).isEqualTo("My circle")
        assertThat(circleResponseBody.getId()).isNotNull()
        assertThat(circleResponseBody.getCreatedAt()).isNotNull()
        assertThat(circleResponseBody.getMatcherType()).isEqualTo("REGULAR")
        assertThat(circleResponseBody.getDeployment()).isNull()
        assertThat(circleResponseBody.getImportedAt()).isNull()
        assertThat(circleResponseBody.getImportedKvRecords()).isNull()

        assertThat(circleResponseBody.getAuthor().getId()).isEqualTo("5e397f95-11af-4512-a0d7-c68b840e818b")
        assertThat(circleResponseBody.getAuthor().getName()).isEqualTo("processoqa")
        assertThat(circleResponseBody.getAuthor().getEmail()).isEqualTo("processoqa@zup.com.br")
        assertThat(circleResponseBody.getAuthor().getPhotoUrl()).isNullOrEmpty()
        assertThat(circleResponseBody.getAuthor().getCreatedAt()).isNotNull()

        assertThat(circleResponseBody.getRules().getType()).isEqualTo("CLAUSE")
        assertThat(circleResponseBody.getRules().getLogicalOperator()).isEqualTo("OR")

        assertThat(circleResponseBody.getRules().getClauses().get(0).getType()).isEqualTo("RULE")
        assertThat(circleResponseBody.getRules().getClauses().get(0).getContent().getKey()).isEqualTo("username")

        assertThat(circleResponseBody.getRules().getClauses().get(0).getContent().getKey()).isEqualTo("username")
        assertThat(circleResponseBody.getRules().getClauses().get(0).getContent().getCondition()).isEqualTo("EQUAL")
        assertThat(circleResponseBody.getRules().getClauses().get(0).getContent().getValue().get(0)).isEqualTo("rafael")
    }
}
