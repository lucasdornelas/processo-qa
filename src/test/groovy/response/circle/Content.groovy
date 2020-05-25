package response.circle

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Content {

    private String key
    private String condition
    private List<String> value

    String getKey() {
        return key
    }

    String getCondition() {
        return condition
    }

    List<String> getValue() {
        return value
    }
}
