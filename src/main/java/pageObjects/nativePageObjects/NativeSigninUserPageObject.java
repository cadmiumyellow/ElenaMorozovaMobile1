package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Prop;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

public class NativeSigninUserPageObject {
    public NativeSigninUserPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }
    Prop prop = new Prop();

    @HowToUseLocators(iOSXCUITAutomation = ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Username or email']/following-sibling::XCUIElementTypeTextField")
    @iOSXCUITFindBy(xpath = "//*[@value='user@example.com']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    RemoteWebElement loginEmailBtn;

    @HowToUseLocators(iOSXCUITAutomation = ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Password']/following-sibling::XCUIElementTypeSecureTextField")
    @iOSXCUITFindBy(xpath = "//*[@value='Required']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    RemoteWebElement loginPasswordBtn;

    @HowToUseLocators(iOSXCUITAutomation = ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Sign In']") //label
    @iOSXCUITFindBy(id = "Sign In")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    RemoteWebElement signInBtn;

    public void signInUser() {
        loginEmailBtn.sendKeys(prop.getPropertyValue("email"));
        loginPasswordBtn.sendKeys(prop.getPropertyValue("password"));
        signInBtn.click();
    }
}
