package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Prop;

public class NativeRegisterUserPageObject {

    public NativeRegisterUserPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }
    Prop prop = new Prop();

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    WebElement registerBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement regEmailBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement regUsernameBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement regPasswordBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement regConfirmPasswordBtn;
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
