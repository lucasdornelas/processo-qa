package response.builds

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Content {

    private String id
    private Author author
    private String createdAt
    private List<Feature> features
    private String tag
    private String status
    private List<Deployment> deployments

    String getId() {
        return id
    }

    Author getAuthor() {
        return author
    }

    String getCreatedAt() {
        return createdAt
    }

    List<Feature> getFeatures() {
        return features
    }

    String getTag() {
        return tag
    }

    String getStatus() {
        return status
    }

    List<Deployment> getDeployments() {
        return deployments
    }
}
