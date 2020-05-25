package request.circle

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Circle {

    private String name
    private String ruleMatcherType
    private Rules rules
    private List<Object> segmentations
    private String authorId

    Circle(String name, String ruleMatcherType, Rules rules, List<Object> segmentations, String authorId) {
        this.name = name
        this.ruleMatcherType = ruleMatcherType
        this.rules = rules
        this.segmentations = segmentations
        this.authorId = authorId
    }
}
