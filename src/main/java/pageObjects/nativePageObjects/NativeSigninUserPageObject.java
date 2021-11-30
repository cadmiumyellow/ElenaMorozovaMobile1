package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Prop;

public class NativeSigninUserPageObject {
    public NativeSigninUserPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }
    Prop prop = new Prop();

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    WebElement loginEmailBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    WebElement loginPasswordBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInBtn;

    public void signInUser() {
        loginEmailBtn.sendKeys(prop.getPropertyValue("email"));
        loginPasswordBtn.sendKeys(prop.getPropertyValue("password"));
        signInBtn.click();
    }
}
