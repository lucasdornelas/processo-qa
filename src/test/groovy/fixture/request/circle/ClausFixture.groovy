package fixture.request.circle

import request.circle.Claus
import request.circle.Content

class ClausFixture {

    private String type
    private Content content

    ClausFixture() {
        this.type = "RULE"
        this.content = new ContentFixture().build()
    }

    Claus build() {return new Claus(type, content)}
}
