package response.buildv2

class Deployment {

    private String id
    private String createdAt
    private String deployedAt
    private String buildId
    private String status
    private Circle circle

    Deployment(String id, String createdAt, String deployedAt, String buildId, String status, Circle circle) {
        this.id = id
        this.createdAt = createdAt
        this.deployedAt = deployedAt
        this.buildId = buildId
        this.status = status
        this.circle = circle
    }
}
