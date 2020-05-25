package response.buildv2

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Circle {

    private String id
    private String name
    private Author author
    private String createdAt
    private String matcherType
    private Rules rules
    private String importedAt
    private int importedKvRecords

    String getId() {
        return id
    }

    String getName() {
        return name
    }

    Author getAuthor() {
        return author
    }

    String getCreatedAt() {
        return createdAt
    }

    String getMatcherType() {
        return matcherType
    }

    Rules getRules() {
        return rules
    }

    String getImportedAt() {
        return importedAt
    }

    int getImportedKvRecords() {
        return importedKvRecords
    }
}
