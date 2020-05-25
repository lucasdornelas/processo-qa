package response.builds

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Builds {

    private List<Content> content
    private int page
    private int size
    private int totalPages
    private boolean last

    List<Content> getContent() {
        return content
    }

    int getPage() {
        return page
    }

    int getSize() {
        return size
    }

    int getTotalPages() {
        return totalPages
    }

    boolean getLast() {
        return last
    }
}
