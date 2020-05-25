package response.builds

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Artifact {

    private String id
    private String artifact
    private String version
    private String createdAt

    String getId() {
        return id
    }

    String getArtifact() {
        return artifact
    }

    String getVersion() {
        return version
    }

    String getCreatedAt() {
        return createdAt
    }
}
