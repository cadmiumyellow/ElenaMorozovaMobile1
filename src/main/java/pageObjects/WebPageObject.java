package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class WebPageObject {
    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    @FindBy(css = "input[name='q']")
    WebElement searchField;

    @FindBy(css = "#rso [data-hveid]")
    List<WebElement> searchResults;

    public void searchFor(String input) {
        searchField.sendKeys(input);
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public List<String> getSearchResults() {
        return searchResults
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public Boolean checkAllSearchResultsContain(List<String> searchResults, String searchInput) {
        Boolean isContain = false;
        for (String item : searchResults) {
            if (item.toLowerCase().contains(searchInput.toLowerCase())) {
                isContain = true;
            } else {
                isContain = false;
            }
        }
        return isContain;
    }
}