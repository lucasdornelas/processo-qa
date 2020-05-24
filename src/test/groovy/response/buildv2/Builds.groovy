package response.buildv2

class Builds {

    private List<Content> content
    private int page
    private int size
    private int totalPages
    private boolean last

    Builds(List<Content> content, int page, int size, int totalPages, boolean last) {
        this.content = content
        this.page = page
        this.size = size
        this.totalPages = totalPages
        this.last = last
    }
}
