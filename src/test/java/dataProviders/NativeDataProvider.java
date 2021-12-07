package dataProviders;

import org.testng.annotations.DataProvider;

public class NativeDataProvider {
    @DataProvider(name = "nativeTestData")
    public Object[][] nativeTestData() {
        return new String[][]{
                {
                        "mama@mail.ru", "mama", "mama123456"
                }
        };
    }
}
