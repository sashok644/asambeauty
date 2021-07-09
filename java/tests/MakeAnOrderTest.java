package tests;

import org.junit.Test;
import tests.pages.CheckoutPage;
import tests.pages.LoginPage;
import tests.pages.ProductPage;


public class MakeAnOrderTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void testBuyItems() {
        //opens simulator and then do nothing because we have no application to test
        loginPage.openLoginPage();
        loginPage.login("test@email.com", "password");
        loginPage.pressLoginButton();
        loginPage.assertThatUserLoggedIn();
        //user opens some page with the product
        productPage.openProductPage();
        productPage.assertThatProductCorrectlyDisplayed();
        productPage.pressAddToCardButton();
        productPage.assertThatProductWasAddedToTheCard();
//        in the test requirements were no word about the Cart page and buttons
//        so we can assume that from the Product page user can go directly to Checkout page
        checkoutPage.openCheckoutPage();
        checkoutPage.assertThatUsernameIsLoggedIn();
        checkoutPage.assertThatCartHasAllAddedItems(2, 5);
        checkoutPage.pressCheckoutButton();
        checkoutPage.assertSuccessfulCheckout();
    }

}



