package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Prop;

public class NativeRegisterUserPageObject {
    public NativeRegisterUserPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }
    Prop prop = new Prop();

    @iOSXCUITFindBy(xpath = "//*[@name='Sign In']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInBtn;

    @iOSXCUITFindBy(xpath = "//*[@name='Register new account']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    WebElement registerBtn;

    @iOSXCUITFindBy(xpath = "//*[@value='user@example.com']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement regEmailBtn;

    @iOSXCUITFindBy(xpath = "//*[@value='TimApple']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement regUsernameBtn;

    @iOSXCUITFindBy(xpath = "//*[@value='Required']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement regPasswordBtn;

    @iOSXCUITFindBy(xpath = "//*[@value='Repeat please']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement regConfirmPasswordBtn;

    @iOSXCUITFindBy(xpath = "//*[@name='Register new account']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    WebElement registerNewAccountBtn;

    public void registerUser() {
        registerBtn.click();
        regEmailBtn.sendKeys(prop.getPropertyValue("email"));
        regUsernameBtn.sendKeys(prop.getPropertyValue("username"));
        regPasswordBtn.sendKeys(prop.getPropertyValue("password"));
        regConfirmPasswordBtn.sendKeys(prop.getPropertyValue("password"));
        registerNewAccountBtn.click();
    }
}
