package response.builds

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Component {

    private String id
    private String name
    private String contextPath
    private int port
    private String healthCheck
    private String createdAt
    private Artifact artifact

    String getId() {
        return id
    }

    String getName() {
        return name
    }

    String getContextPath() {
        return contextPath
    }

    int getPort() {
        return port
    }

    String getHealthCheck() {
        return healthCheck
    }

    String getCreatedAt() {
        return createdAt
    }

    Artifact getArtifact() {
        return artifact
    }
}
