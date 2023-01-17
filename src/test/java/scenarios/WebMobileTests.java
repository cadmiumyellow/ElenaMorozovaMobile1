package scenarios;

import dataProviders.WebDataProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

    @Test(groups = {"web"}, description = "Make sure google search works for EPAM request",
    dataProviderClass = WebDataProvider.class, dataProvider = "webTestData")
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

        //Google search for EPAM
        po.searchFor(searchWord);
        po.getSearchField().sendKeys(Keys.ENTER);
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        System.out.println("Searching for: " + searchWord);

        //Get the results of google search for EPAM
        List<String> results = po.getSearchResults();

        //Check all search results contain search input
        Assert.assertTrue(po.checkAllSearchResultsContain(results, searchWord),
                "Search results do not contain search input");

        // Log that EPAM search test is over
        System.out.println("Checked that EPAM can be found by google search");
    }

}
