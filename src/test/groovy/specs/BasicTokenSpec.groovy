package specs

import client.AuthClient
import io.restassured.response.Response
import response.token.Token
import spock.lang.Specification

class BasicTokenSpec extends Specification {

    def "Retorna um objeto token ultilizado para realizar a auticacao nos micro servicos"() {

        given: "Dado que tenho um usuario e um password valido"

        AuthClient authClient = new AuthClient()

        when: "Chamo o endpoint POST para obter um token valido"

        Response response = authClient.fetchAuth()

        then: "Vejo que o Status Code do response e 200"

        response.getStatusCode() == 200

        and:('E valido o body do response')
        Token token = response.jsonPath().getObject('', Token)

        with(token) {
            getAccessToken() != null
            getExpiresIn() != null
            getRefreshExpiresIn() != null
            getRefreshToken() != null
            getTokenType() != null
            getNotBeforePolicy() != null
            getSessionState() != null
            getScope() != null
        }
    }
}
