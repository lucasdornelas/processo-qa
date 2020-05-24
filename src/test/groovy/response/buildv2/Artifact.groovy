package response.buildv2

class Artifact {

    private String id
    private String artifact
    private String version
    private String createdAt

    Artifact(String id, String artifact, String version, String createdAt) {
        this.id = id
        this.artifact = artifact
        this.version = version
        this.createdAt = createdAt
    }
}
