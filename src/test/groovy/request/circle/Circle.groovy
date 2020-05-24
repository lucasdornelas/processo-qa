package request.circle

class Circle {

    private String name;
    private String ruleMatcherType;
    private Rules rules;
    private List<Object> segmentations;

    Circle(String name, String ruleMatcherType, Rules rules, List<Object> segmentations) {
        this.name = name
        this.ruleMatcherType = ruleMatcherType
        this.rules = rules
        this.segmentations = segmentations
    }
}
