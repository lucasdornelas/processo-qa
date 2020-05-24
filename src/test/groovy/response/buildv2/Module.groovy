package response.buildv2

class Module {

    private String id
    private String name
    private String gitRepositoryAddress
    private String helmRepository
    private String createdAt
    private List<Component> components

    Module(String id, String name, String gitRepositoryAddress, String helmRepository, String createdAt, List<Component> components) {
        this.id = id
        this.name = name
        this.gitRepositoryAddress = gitRepositoryAddress
        this.helmRepository = helmRepository
        this.createdAt = createdAt
        this.components = components
    }
}
