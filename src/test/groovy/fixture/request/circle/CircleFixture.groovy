package fixture.request.circle

import request.circle.Circle
import request.circle.Rules

class CircleFixture {

    private String name
    private String ruleMatcherType
    private Rules rules
    private List<Object> segmentations
    private String authorId

    CircleFixture() {
        this.name = "My circle"
        this.ruleMatcherType = "DARWIN"
        this.rules = new RulesFixture().build()
        this.segmentations = null
        this.authorId = "5e397f95-11af-4512-a0d7-c68b840e818b"
    }

    Circle build() { return new Circle(name, ruleMatcherType, rules, segmentations, authorId)}
}
