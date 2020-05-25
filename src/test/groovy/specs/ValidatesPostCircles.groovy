package specs

import client.AuthClient
import client.CirclesClient
import fixture.request.circle.CircleFixture
import fixture.request.circle.RulesFixture
import io.restassured.response.Response
import request.circle.Rules
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

    def "Returns an object containing information about Created Circle"() {

        given: "That I have a valid token and a valid body"

        def circleBody = new CircleFixture().build()

        when: "I make a request for POST endpoint to create a circle"

        CirclesClient circlesClient = new CirclesClient()
        Response circlesResponse = circlesClient.fetchCircles(token.accessToken, circleBody)

        then: "Show Status Code 200 OK"

        assertThat(circlesResponse.getStatusCode()).isEqualTo(200)

        and: "validate all the body responds"

        Circle circleResponseBody = circlesResponse.jsonPath().getObject('', Circle)

        def expectedCircleName = "My circle"
        def expectedMatcherType = "REGULAR"
        def expectedAuthorId = "5e397f95-11af-4512-a0d7-c68b840e818b"
        def expectedAuthorName = "processoqa"
        def expectedAuthorEmail = "processoqa@zup.com.br"
        def expectedRulesType = "CLAUSE"
        def expectedRulesLogicalOperator = "OR"
        def expectedClausesType = "RULE"
        def expectedClausesName = "username"
        def expectedContentName = "username"
        def expectedContentCondition = "EQUAL"
        def expectedContentValue = "rafael"

        assertThat(circleResponseBody.getName()).isEqualTo(expectedCircleName)
        assertThat(circleResponseBody.getId()).isNotNull()
        assertThat(circleResponseBody.getCreatedAt()).isNotNull()
        assertThat(circleResponseBody.getMatcherType()).isEqualTo(expectedMatcherType)
        assertThat(circleResponseBody.getDeployment()).isNull()
        assertThat(circleResponseBody.getImportedAt()).isNull()
        assertThat(circleResponseBody.getImportedKvRecords()).isNull()

        assertThat(circleResponseBody.getAuthor().getId()).isEqualTo(expectedAuthorId)
        assertThat(circleResponseBody.getAuthor().getName()).isEqualTo(expectedAuthorName)
        assertThat(circleResponseBody.getAuthor().getEmail()).isEqualTo(expectedAuthorEmail)
        assertThat(circleResponseBody.getAuthor().getPhotoUrl()).isNullOrEmpty()
        assertThat(circleResponseBody.getAuthor().getCreatedAt()).isNotNull()

        assertThat(circleResponseBody.getRules().getType()).isEqualTo(expectedRulesType)
        assertThat(circleResponseBody.getRules().getLogicalOperator()).isEqualTo(expectedRulesLogicalOperator)

        assertThat(circleResponseBody.getRules().getClauses().get(0).getType()).isEqualTo(expectedClausesType)
        assertThat(circleResponseBody.getRules().getClauses().get(0).getContent().getKey()).isEqualTo(expectedClausesName)

        assertThat(circleResponseBody.getRules().getClauses().get(0).getContent().getKey()).isEqualTo(expectedContentName)
        assertThat(circleResponseBody.getRules().getClauses().get(0).getContent().getCondition()).isEqualTo(expectedContentCondition)
        assertThat(circleResponseBody.getRules().getClauses().get(0).getContent().getValue().get(0)).isEqualTo(expectedContentValue)
    }

    def "Returns error when request use an invalid payload"() {

        given: "I have a valid token and a body containing an invalid rule"

        def invalidRuleType = "INVALIDA_TYPE"
        Rules rules = new RulesFixture().withType(invalidRuleType).build()
        def circleBody = new CircleFixture().withRules(rules).build()

        when: "I make a request for POST endpoint to create a circle"

        CirclesClient circlesClient = new CirclesClient()
        Response circlesResponse = circlesClient.fetchCircles(token.accessToken, circleBody)

        then: "Show Status Code 400 Bad Request"

        assertThat(circlesResponse.getStatusCode()).isEqualTo(400)

        and: "validate error messages"

        def errorResponseBody = circlesResponse.jsonPath().get()

        def expectedErrorCode = "PAYLOAD_INVALID"
        def expectedErrorMessage = "payload.invalid"

        assertThat(errorResponseBody.code).isEqualTo(expectedErrorCode)
        assertThat(errorResponseBody.message).isEqualTo(expectedErrorMessage)
    }

    def "Returns an error containing when a payload with inconsistent data is used" () {

        given: "I have a valid token and a body containing an invalid authorId"

        def invalidAuthorId = "5e397f95-11af-4512-a0d7"
        def circleBody = new CircleFixture().withAuthorId(invalidAuthorId).build()

        when: "I make a request for POST endpoint to create a circle"

        CirclesClient circlesClient = new CirclesClient()
        Response circlesResponse = circlesClient.fetchCircles(token.accessToken, circleBody)

        then: "Show Status Code 404 Not Found"

        assertThat(circlesResponse.getStatusCode()).isEqualTo(404)

        and: "validate all the error body"

        def errorResponseBody = circlesResponse.jsonPath().get()

        def expectedResource = "user"

        assertThat(errorResponseBody.resource).isEqualTo(expectedResource)
        assertThat(errorResponseBody.value).isEqualTo(invalidAuthorId)
    }

    def "Returns an error when an invalid token is used"() {

        given: "I have a valid token and a valid body"

        def circleBody = new CircleFixture().build()

        when: "I make a request for POST endpoint to create a circle"

        CirclesClient circlesClient = new CirclesClient()

        String invalidToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiA"
        Response circlesResponse = circlesClient.fetchCircles(invalidToken, circleBody)

        then: "Show Status Code 401 Unauthorized"

        assertThat(circlesResponse.getStatusCode()).isEqualTo(401)

        and: "validate all the error body"

        def errorResponseBody = circlesResponse.jsonPath().get()

        def expectedErrorMessage = "Key not authorised"
        assertThat(errorResponseBody.error).isEqualTo(expectedErrorMessage)
    }
}
