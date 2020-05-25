package specs

import client.AuthClient
import io.restassured.response.Response
import response.token.Token
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat

class ValidatesPostToken extends Specification {

    def "Returns an object token used to perform automation on microservices"() {

        given: "I have a valid username and password"

        AuthClient authClient = new AuthClient()

        when: "I make request to POST endpoint to get a valid token"

        Response authResponse = authClient.fetchAuth()

        then: "Show Status Code 200 OK"

        assertThat(authResponse.getStatusCode()).isEqualTo(200)

        and: "validate all the body responds"

        Token tokenResponseBody = authResponse.jsonPath().getObject('', Token)

        def expectedExpiresIn = 3600
        def expectedRefreshExpiresIn = 1800
        def expectedTokenType = "bearer"
        def expectedNotBeforePolicy = 0
        def expectedScope= "profile email"

        assertThat(tokenResponseBody.getAccessToken()).isNotEmpty()
        assertThat(tokenResponseBody.getExpiresIn()).isEqualTo(expectedExpiresIn)
        assertThat(tokenResponseBody.getRefreshExpiresIn()).isEqualTo(expectedRefreshExpiresIn)
        assertThat(tokenResponseBody.getRefreshToken()).isNotEmpty()
        assertThat(tokenResponseBody.getTokenType()).isEqualTo(expectedTokenType)
        assertThat(tokenResponseBody.getNotBeforePolicy()).isEqualTo(expectedNotBeforePolicy)
        assertThat(tokenResponseBody.getSessionState()).isNotNull()
        assertThat(tokenResponseBody.getScope()).isEqualTo(expectedScope)
    }
}
