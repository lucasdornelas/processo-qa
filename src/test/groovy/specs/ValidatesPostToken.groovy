package specs

import client.AuthClient
import io.restassured.response.Response
import response.token.Token
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat

class ValidatesPostToken extends Specification {

    def "Retorna um objeto token ultilizado para realizar a auticacao nos micro servicos"() {

        given: "Dado que tenho um usuario e um password valido"

        AuthClient authClient = new AuthClient()

        when: "Chamo o endpoint POST para obter um token valido"

        Response authResponse = authClient.fetchAuth()

        then: "Vejo que o Status Code do response e 200"

        assertThat(authResponse.getStatusCode()).isEqualTo(200)

        and: "E valido o body do response"
        Token tokenResponseBody = authResponse.jsonPath().getObject('', Token)

        assertThat(tokenResponseBody.getAccessToken()).isNotEmpty()
        assertThat(tokenResponseBody.getExpiresIn()).isEqualTo(3600)
        assertThat(tokenResponseBody.getRefreshExpiresIn()).isEqualTo(1800)
        assertThat(tokenResponseBody.getRefreshToken()).isNotEmpty()
        assertThat(tokenResponseBody.getTokenType()).isEqualTo("bearer")
        assertThat(tokenResponseBody.getNotBeforePolicy()).isEqualTo(0)
        assertThat(tokenResponseBody.getSessionState()).isNotNull()
        assertThat(tokenResponseBody.getScope()).isEqualTo("profile email")
    }
}
