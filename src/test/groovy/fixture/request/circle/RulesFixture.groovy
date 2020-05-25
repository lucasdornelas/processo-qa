package fixture.request.circle

import request.circle.Claus
import request.circle.Rules

import static java.util.Collections.singletonList

class RulesFixture {

    private String type
    private List<Claus> clauses
    private String logicalOperator

    RulesFixture() {
        this.type = "CLAUSE"
        this.clauses = singletonList(new ClausFixture().build())
        this.logicalOperator = "OR"
    }

    Rules build() {return new Rules(type, clauses, logicalOperator)}
}
