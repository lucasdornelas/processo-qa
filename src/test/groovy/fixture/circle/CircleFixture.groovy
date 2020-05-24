package fixture.circle

import request.circle.Circle
import request.circle.Rules

class CircleFixture {

    private String name
    private String ruleMatcherType
    private Rules rules
    private List<Object> segmentations

    CircleFixture() {
        this.name = "My circle"
        this.ruleMatcherType = "DARWIN"
        this.rules = new RulesFixture().build()
        this.segmentations = null
    }

    Circle build() { return new Circle(name, ruleMatcherType, rules, segmentations)}
}
