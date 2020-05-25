package client


import static java.nio.file.Paths.get

class Client {

    public static final String PROPERTIES_PATH = "src/test/resources/test.properties"

    static Properties getProperties() throws IOException {
        Properties properties = new Properties()
        properties.load(new FileInputStream(get(PROPERTIES_PATH).toString()))
        return properties
    }

    URL getUrl(String baseUrl, String pathUrl) {
        Properties properties = getProperties()
        return new URL(properties.getProperty(baseUrl) + properties.getProperty(pathUrl));
    }
}
