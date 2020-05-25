package response.circle

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Claus {

    private String type
    private Content content

    String getType() {
        return type
    }

    Content getContent() {
        return content
    }
}
