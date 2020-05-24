package response.buildv2

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
