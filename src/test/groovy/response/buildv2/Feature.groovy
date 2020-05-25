package response.buildv2

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Feature {

    private String id
    private String name
    private String branchName
    private String authorId
    private String authorName
    private List<Module> modules
    private String createdAt
    private List<String> branches

    String getId() {
        return id
    }

    String getName() {
        return name
    }

    String getBranchName() {
        return branchName
    }

    String getAuthorId() {
        return authorId
    }

    String getAuthorName() {
        return authorName
    }

    List<Module> getModules() {
        return modules
    }

    String getCreatedAt() {
        return createdAt
    }

    List<String> getBranches() {
        return branches
    }
}
