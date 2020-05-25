package response.buildv2

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Module {

    private String id
    private String name
    private String gitRepositoryAddress
    private String helmRepository
    private String createdAt
    private List<Component> components

    String getId() {
        return id
    }

    String getName() {
        return name
    }

    String getGitRepositoryAddress() {
        return gitRepositoryAddress
    }

    String getHelmRepository() {
        return helmRepository
    }

    String getCreatedAt() {
        return createdAt
    }

    List<Component> getComponents() {
        return components
    }
}
