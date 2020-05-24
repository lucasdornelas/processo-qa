package response.buildv2

class Content {

    private String id
    private Author author
    private String createdAt
    private List<Feature> features
    private String tag
    private String status
    private List<Deployment> deployments

    Content(String id, Author author, String createdAt, List<Feature> features, String tag, String status, List<Deployment> deployments) {
        this.id = id
        this.author = author
        this.createdAt = createdAt
        this.features = features
        this.tag = tag
        this.status = status
        this.deployments = deployments
    }
}
