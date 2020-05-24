package request.circle

class Content {

    private String key
    private List<String> value
    private String condition

    Content(String key, List<String> value, String condition) {
        this.key = key
        this.value = value
        this.condition = condition
    }
}
