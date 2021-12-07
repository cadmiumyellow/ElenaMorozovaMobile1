package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativeBudgetPageObject {

        public NativeBudgetPageObject(AppiumDriver appiumDriver) {
            PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
        }

        @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
        WebElement addNewExpenseBtn;
        @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.view.ViewGroup/android.widget.FrameLayout[2]/" +
                "android.view.ViewGroup/android.widget.TextView")
        WebElement pageTitle;

        public String getPageTitleText() {
            return pageTitle.getText();
        }

        public String getAddNewExpenseBtnText() {
            return addNewExpenseBtn.getText();
        }
}

