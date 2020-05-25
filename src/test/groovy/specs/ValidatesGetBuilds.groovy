package specs

import client.AuthClient
import client.BuildsClient
import fixture.response.builds.BuildsFixture
import io.restassured.response.Response
import response.builds.Builds
import response.token.Token
import spock.lang.Shared
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat

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

    def "Returns an object containing information about Builds Circle"() {

        given: "I have a valid Token to make a request with the filters status = BUILT and page = 0"

        String status = "BUILT"
        String page = "0"
        String tagName = ""

        when: "I call the GET endpoint to obtain information from the builds"

        Response buildsResponse = buildsClient.fetchBuilds(token.accessToken, tagName, status, page)

        then: "Show Status Code 200 OK"

        assertThat(buildsResponse.getStatusCode()).isEqualTo(200)

        and: "validate all the body responds"

        Builds buildsResponseBody = buildsResponse.jsonPath().getObject('', Builds)

        def pathJsonExpectedResponse = "src/test/resources/build_responses/build_page_zero_status_build.json"
        Builds expectedBuildResponse = new BuildsFixture().build(pathJsonExpectedResponse)

        assertThat(expectedBuildResponse).isEqualToComparingFieldByFieldRecursively(buildsResponseBody)
    }

    def "Returns an error when an invalid token is used"() {

        given: "I have a valid token and a valid body"

        String status = "BUILT"
        String page = "0"
        String tagName = ""

        when: "I make a request for GET endpoint return builds information"

        String invalidToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiA"
        Response buildsResponse = buildsClient.fetchBuilds(invalidToken, tagName, status, page)

        then: "Show Status Code 401 Unauthorized"

        assertThat(buildsResponse.getStatusCode()).isEqualTo(401)

        and: "validate all the error body"

        def errorResponseBody = buildsResponse.jsonPath().get()

        def expectedErrorMessage = "Key not authorised"
        assertThat(errorResponseBody.error).isEqualTo(expectedErrorMessage)
    }
}
