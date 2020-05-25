package client


import io.restassured.response.Response

import static io.restassured.RestAssured.given

class BuildsClient extends Client {

    public static final String HEADER_CONNECTION = "keep-alive"
    public static final String HEADER_APPLICATION_ID = "900c4342-df7e-488b-bf6f-1784ee7c0546"
    public static final String HEADER_ACCEPT = "application/json, text/plain, */*"
    public static final String HEADER_USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36"
    public static final String HEADER_ORIGIN = "https://darwin.continuousplatform.com"
    public static final String HEADER_SEC_FETCH_SITE = "same-site"
    public static final String HEADER_SEC_FETCH_MODE = "cors"
    public static final String HEADER_REFERER = "https://darwin.continuousplatform.com/circles/a8685f7b-ac6d-498b-8b89-8206c03e9322/edit"
    public static final String HEADER_ACCEPT_ENCODING = "gzip, deflate, br"
    public static final String HEADER_ACCEPT_LANGUAGE = "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6"

    private final String BASE_URL_CIRCLE_PATH = "prop.server.api.host"
    private final String URL_BUILDS_PATH = "prop.server.path.moove.builds"

    private URL url


    BuildsClient() {
        super
        url = getUrl(BASE_URL_CIRCLE_PATH, URL_BUILDS_PATH)
    }

    Response fetchBuilds(String accessToken,String tagName, String status, String page) {
        return given()
                .header("Connection", HEADER_CONNECTION)
                .header("x-application-id", HEADER_APPLICATION_ID)
                .header("Accept", HEADER_ACCEPT)
                .header("authorization", "Bearer " + accessToken)
                .header("User-Agent", HEADER_USER_AGENT)
                .header("Origin", HEADER_ORIGIN)
                .header("Sec-Fetch-Site", HEADER_SEC_FETCH_SITE)
                .header("Sec-Fetch-Mode", HEADER_SEC_FETCH_MODE)
                .header("Referer", HEADER_REFERER)
                .header("Accept-Encoding", HEADER_ACCEPT_ENCODING)
                .header("Accept-Language", HEADER_ACCEPT_LANGUAGE)
                .queryParam("tagName", tagName)
                .queryParam("page", page)
                .queryParam("status", status)
                .get(url).andReturn()
    }
}
