package fixture.response.builds

import com.fasterxml.jackson.databind.ObjectMapper
import response.builds.Builds

class BuildsFixture {

    static Builds build(String pathResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(pathResponse), Builds.class);
    }
}
