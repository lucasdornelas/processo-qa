package response.buildv2

class Circle {

    private String id
    private String name
    private Author author
    private String createdAt
    private String matcherType
    private Rules rules
    private String importedAt
    private int importedKvRecords

    Circle(String id, String name, Author author, String createdAt, String matcherType, Rules rules, String importedAt, int importedKvRecords) {
        this.id = id
        this.name = name
        this.author = author
        this.createdAt = createdAt
        this.matcherType = matcherType
        this.rules = rules
        this.importedAt = importedAt
        this.importedKvRecords = importedKvRecords
    }
}
