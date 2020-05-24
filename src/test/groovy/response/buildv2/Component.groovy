package response.buildv2

class Component {

    private String id
    private String name
    private String contextPath
    private int port
    private String healthCheck
    private String createdAt
    private Artifact artifact

    Component(String id, String name, String contextPath, int port, String healthCheck, String createdAt, Artifact artifact) {
        this.id = id
        this.name = name
        this.contextPath = contextPath
        this.port = port
        this.healthCheck = healthCheck
        this.createdAt = createdAt
        this.artifact = artifact
    }
}
