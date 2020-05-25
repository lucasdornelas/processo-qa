package response.circle

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Rules {

    private String type
    private List<Claus> clauses
    private String logicalOperator

    String getType() {
        return type
    }

    List<Claus> getClauses() {
        return clauses
    }

    String getLogicalOperator() {
        return logicalOperator
    }
}
