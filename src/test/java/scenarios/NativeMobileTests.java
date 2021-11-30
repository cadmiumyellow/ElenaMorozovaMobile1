package scenarios;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.nativePageObjects.NativeBudgetPageObject;
import pageObjects.nativePageObjects.NativeRegisterUserPageObject;
import pageObjects.nativePageObjects.NativeSigninUserPageObject;
import setup.BaseTest;
import utils.Prop;

public class NativeMobileTests extends BaseTest {
    Prop prop = new Prop();

//    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
//    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
//        getPo().getWelement("signInBtn").click();
//        System.out.println("Simplest Android native test done");
//
//    }

    @Test(groups = {"native"}, description = "Check-in test")
    public void EpamTestAppCheckInNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException, TimeoutException {
        System.out.println("Starting check-in test");       //logged test start
        //NativePageObject po = new NativePageObject(getDriver());
        NativeRegisterUserPageObject regPo = new NativeRegisterUserPageObject(getDriver());
        NativeSigninUserPageObject signinPo = new NativeSigninUserPageObject(getDriver());
        NativeBudgetPageObject budgetPo = new NativeBudgetPageObject(getDriver());

        regPo.registerUser();
        System.out.println("Registered a new user");

        signinPo.signInUser();
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
