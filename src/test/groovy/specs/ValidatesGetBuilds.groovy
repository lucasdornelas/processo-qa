package specs

import client.AuthClient
import client.BuildsClient
import fixture.response.build.BuildsFixture
import io.restassured.response.Response
import response.build.Builds
import response.token.Token
import spock.lang.Shared
import spock.lang.Specification
import static org.assertj.core.api.Assertions.assertThat;

class ValidatesGetBuilds extends Specification {

    @Shared
    private static Token token

    @Shared
    private static BuildsClient buildsClient

    def setupSpec() {
        AuthClient authClient = new AuthClient()
        Response authResponse = authClient.fetchAuth()
        token = authResponse.jsonPath().getObject('', Token)

        buildsClient = new BuildsClient()
    }

    def "Retorna um objeto contendo as informacoes dos um Builds Criados"() {

        given: "Dado que eu tenho um Token valido para efetuar um request e os filtros o status BUILT e page 0"

        String status = "BUILT"
        String page = "0"
        String tagName = ""

        when: "Chamo o endpoint GET para obter os builds que foram criados"

        Response buildsResponse = buildsClient.fetchBuilds(token.accessToken, tagName, status, page)

        then: "Vejo que o Status Code do response e 200"

        assertThat(buildsResponse.getStatusCode()).isEqualTo(200)

        and: ('E valido o body do response do endpopint builds')

        Builds buildsResponseBody = buildsResponse.jsonPath().getObject('', Builds)

        def pathJsonExpectedResponse = "src/test/resources/build_responses/build_page_zero_status_build.json"
        Builds expectedBuildResponse = new BuildsFixture().build(pathJsonExpectedResponse)

        assertThat(expectedBuildResponse).isEqualToComparingFieldByFieldRecursively(buildsResponseBody)
    }
}
