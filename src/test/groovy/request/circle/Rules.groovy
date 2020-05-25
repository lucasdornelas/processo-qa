package request.circle

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Rules {

    private String type
    private List<Claus> clauses
    private String logicalOperator

    Rules(String type, List<Claus> clauses, String logicalOperator) {
        this.type = type
        this.clauses = clauses
        this.logicalOperator = logicalOperator
    }
}
