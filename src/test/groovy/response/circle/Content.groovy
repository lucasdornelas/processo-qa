package response.circle

class Content {

    private String key
    private String condition
    private List<String> value

    Content(String key, String condition, List<String> value) {
        this.key = key
        this.condition = condition
        this.value = value
    }
}
