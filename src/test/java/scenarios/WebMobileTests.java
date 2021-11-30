package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;

import java.util.List;

public class WebMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
    public void simpleWebTest() throws InterruptedException {
        getDriver().get("http://iana.org"); // open IANA homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check IANA homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Internet Assigned Numbers Authority") : "This is not IANA homepage";

        // Log that test finished
        System.out.println("Site opening done");
    }

    @Parameters({"url","searchWord"})
    @Test(groups = {"web"}, description = "Make sure google search works for EPAM request")
    public void epamGoogleSearchTest(String url, String searchWord) throws InterruptedException, StaleElementReferenceException {
        WebPageObject po = new WebPageObject(getDriver());
        getDriver().get(url);           // open google page
        System.out.println("Opened google page");

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check Google homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Google") : "This is not google.com homepage";

        //Google search for EPAM depending on the platform in use
        String platform = getDriver().getCapabilities().getCapability("platformName").toString();
        po.searchFor(searchWord, platform);

        new WebDriverWait(getDriver(), 20).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        System.out.println("Searching for: " + searchWord);

        //Get the results of google search for EPAM
        List<String> results = po.getSearchResults();

        //Check search results are not empty and contain "EPAM"
        Assert.assertTrue(results.size() > 0);
        Assert.assertTrue(po.getSearchResults().get(0).toLowerCase().contains(searchWord.toLowerCase()),
                "Search results do not contain search input");

        // Log that EPAM search test is over
        System.out.println("Checked that EPAM can be found by google search");
    }
}
