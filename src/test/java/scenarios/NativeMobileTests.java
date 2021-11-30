package scenarios;

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
    public void EpamTestAppCheckInNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
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
        String addNewExpenseText = budgetPo.getAddNewExpenseBtnText();    //got text of the button
        Assert.assertTrue(addNewExpenseText.equalsIgnoreCase(prop.getPropertyValue("addExpense")));
        Assert.assertEquals(budgetPo.getPageTitleText(), prop.getPropertyValue("pageTitle"));

        System.out.println("Check-in test is done");

    }
}
