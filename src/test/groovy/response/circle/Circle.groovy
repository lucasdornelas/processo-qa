package response.circle

class Circle {

    public String id
    public String name
    public Author author
    public String createdAt
    public String matcherType
    public Rules rules
    public String deployment
    public String importedAt
    public String importedKvRecords

    Circle(String id, String name, Author author, String createdAt, String matcherType, Rules rules, String deployment, String importedAt, String importedKvRecords) {
        this.id = id
        this.name = name
        this.author = author
        this.createdAt = createdAt
        this.matcherType = matcherType
        this.rules = rules
        this.deployment = deployment
        this.importedAt = importedAt
        this.importedKvRecords = importedKvRecords
    }
}
