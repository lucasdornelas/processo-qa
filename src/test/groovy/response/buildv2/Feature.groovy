package response.buildv2

class Feature {

    private String id
    private String name
    private String branchName
    private String authorId
    private String authorName
    private List<Module> modules
    private String createdAt
    private List<String> branches

    Feature(String id, String name, String branchName, String authorId, String authorName, List<Module> modules, String createdAt, List<String> branches) {
        this.id = id
        this.name = name
        this.branchName = branchName
        this.authorId = authorId
        this.authorName = authorName
        this.modules = modules
        this.createdAt = createdAt
        this.branches = branches
    }
}
