package response.buildv2

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Author {

    private String id
    private String name
    private String email
    private String photoUrl
    private String createdAt

    String getId() {
        return id
    }

    String getName() {
        return name
    }

    String getEmail() {
        return email
    }

    String getPhotoUrl() {
        return photoUrl
    }

    String getCreatedAt() {
        return createdAt
    }
}
