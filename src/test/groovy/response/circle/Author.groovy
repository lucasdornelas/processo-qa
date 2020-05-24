package response.circle

class Author {

    private String id
    private String name
    private String email
    private String photoUrl
    private String createdAt

    Author(String id, String name, String email, String photoUrl, String createdAt) {
        this.id = id
        this.name = name
        this.email = email
        this.photoUrl = photoUrl
        this.createdAt = createdAt
    }
}
