package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativeRegisterUserPageObject {
    public NativeRegisterUserPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign In']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Register new account']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    WebElement registerBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Email']/following-sibling::XCUIElementTypeTextField")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement regEmailBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Username']/following-sibling::XCUIElementTypeTextField")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement regUsernameBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Password']/following-sibling::XCUIElementTypeSecureTextField")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement regPasswordBtn;

    @iOSXCUITFindBy(xpath = "////XCUIElementTypeStaticText[@name='Confirm password']/following-sibling::XCUIElementTypeSecureTextField")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement regConfirmPasswordBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Register new account']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    WebElement registerNewAccountBtn;

    public void registerUser(String email, String username, String password) {
        registerBtn.click();
        regEmailBtn.sendKeys(email);
        regUsernameBtn.sendKeys(username);
        regPasswordBtn.sendKeys(password);
        regConfirmPasswordBtn.sendKeys(password);
        registerNewAccountBtn.click();
    }
}
