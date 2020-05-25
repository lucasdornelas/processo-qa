package request.circle

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Claus {

    private String type
    private Content content

    Claus(String type, Content content) {
        this.type = type
        this.content = content
    }
}
