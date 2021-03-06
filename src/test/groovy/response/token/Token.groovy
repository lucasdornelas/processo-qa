package response.token

import com.fasterxml.jackson.annotation.JsonProperty

class Token {

    @JsonProperty("access_token")
    private String  accessToken

    @JsonProperty("expires_in")
    private int expiresIn

    @JsonProperty("refresh_expires_in")
    private int refreshExpiresIn

    @JsonProperty("refresh_token")
    private String refreshToken

    @JsonProperty("token_type")
    private String  tokenType

    @JsonProperty("not-before-policy")
    private int  notBeforePolicy

    @JsonProperty("session_state")
    private String  sessionState

    @JsonProperty("scope")
    private String scope

    String getAccessToken() {
        return accessToken
    }

    int getExpiresIn() {
        return expiresIn
    }

    int getRefreshExpiresIn() {
        return refreshExpiresIn
    }

    String getRefreshToken() {
        return refreshToken
    }

    String getTokenType() {
        return tokenType
    }

    int getNotBeforePolicy() {
        return notBeforePolicy
    }

    String getSessionState() {
        return sessionState
    }

    String getScope() {
        return scope
    }
}
