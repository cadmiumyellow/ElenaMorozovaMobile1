package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class NativeSigninUserPageObject {
    public NativeSigninUserPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Username or email']/following-sibling::XCUIElementTypeTextField")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    WebElement loginEmailBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Password']/following-sibling::XCUIElementTypeSecureTextField")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    WebElement loginPasswordBtn;

    @HowToUseLocators(iOSXCUITAutomation = ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign In']")
    @iOSXCUITFindBy(id = "Sign In")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    RemoteWebElement signInBtn;

    public void signInUser(String email, String password) {
        loginEmailBtn.sendKeys(email);
        loginPasswordBtn.sendKeys(password);
        signInBtn.click();
    }
}
