package response.builds

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

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    class Content {
        private String key
        private List<String> value
        private String condition

        String getKey() {
            return key
        }

        String getValue() {
            return value
        }

        String getCondition() {
            return condition
        }
    }
}
