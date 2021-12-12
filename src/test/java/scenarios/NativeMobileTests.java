package scenarios;

import dataProviders.NativeDataProvider;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.nativePageObjects.NativeBudgetPageObject;
import pageObjects.nativePageObjects.NativeRegisterUserPageObject;
import pageObjects.nativePageObjects.NativeSigninUserPageObject;
import setup.BaseTest;
import utils.Prop;
import dataProviders.NativeDataProvider;

public class NativeMobileTests extends BaseTest {
    Prop prop = new Prop();

    @Test(groups = {"native"}, description = "Check-in test",
            dataProviderClass = NativeDataProvider.class, dataProvider = "nativeTestData")
    public void epamTestAppCheckInNativeTest(String email, String username, String password) throws IllegalAccessException, NoSuchFieldException, InstantiationException, TimeoutException {
        System.out.println("Starting check-in test");       //logged test start
        NativeRegisterUserPageObject regPo = new NativeRegisterUserPageObject(getDriver());
        NativeSigninUserPageObject signinPo = new NativeSigninUserPageObject(getDriver());
        NativeBudgetPageObject budgetPo = new NativeBudgetPageObject(getDriver());

        regPo.registerUser(email, username, password);
        System.out.println("Registered a new user");

        signinPo.signInUser(email, password);
        System.out.println("Signed in a new user");

        // Checking we are on the Budget Activity page
        String addNewExpenseText = budgetPo.getAddNewExpenseBtnText().toLowerCase();    //got text of the button
        String pageTitle = budgetPo.getPageTitleText().toLowerCase();                   //got page title text
        Assert.assertTrue(prop.getPropertyValue("addExpense").toLowerCase().startsWith(
                addNewExpenseText));
        Assert.assertTrue(prop.getPropertyValue("pageTitle").toLowerCase().startsWith(
                pageTitle));

        System.out.println("Check-in test is done");

    }
}
