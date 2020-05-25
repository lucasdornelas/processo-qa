package fixture.request.circle

import request.circle.Content

import static java.util.Collections.singletonList

class ContentFixture {

    private String key
    private List<String> value
    private String condition

    ContentFixture() {
        this.key = "username"
        this.value = singletonList("rafael")
        this.condition = "EQUAL"
    }

    Content build() { return new Content(key, value, condition) }
}
