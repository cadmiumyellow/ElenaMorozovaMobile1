package dataProviders;

import org.testng.annotations.DataProvider;

public class WebDataProvider {
    @DataProvider(name = "webTestData")
    public Object[][] webTestData() {
        return new String[][]{
                {
                        "http://google.com", "EPAM"
                }
        };
    }
}
