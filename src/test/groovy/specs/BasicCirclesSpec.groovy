package specs

import client.AuthClient
import client.MooveClient
import io.restassured.response.Response
import response.circle.Circle
import response.token.Token
import spock.lang.Specification

class BasicCirclesSpec extends Specification {

    def "Retorna um objeto token ultilizado para realizar a auticacao nos micro servicos"() {

        given: "Dado que tenho um usuario e um password valido"

        AuthClient authClient = new AuthClient()
        Response authResponse = authClient.fetchAuth()
        Token token = authResponse.jsonPath().getObject('', Token)

        when: "Chamo o endpoint POST para obter um token valido"

        MooveClient mooveClient = new MooveClient()
        Response mooveResponse = mooveClient.fetchCircles(token.accessToken)

        then: "Vejo que o Status Code do response e 200"

        Circle circle = mooveResponse.jsonPath().getObject('', Circle)

        and:('E valido o body do response')

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
