package response.builds

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Deployment {

    private String id
    private String createdAt
    private String deployedAt
    private String buildId
    private String status
    private Circle circle

    String getId() {
        return id
    }

    String getCreatedAt() {
        return createdAt
    }

    String getDeployedAt() {
        return deployedAt
    }

    String getBuildId() {
        return buildId
    }

    String getStatus() {
        return status
    }

    Circle getCircle() {
        return circle
    }
}
