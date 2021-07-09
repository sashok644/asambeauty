package tests.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutPage {


    public void openCheckoutPage() {
        $("#CheckoutPage").click();
    }

    public void pressCheckoutButton() {
        $(By.name("#Checkout")).click();
    }


    public void showAmountOfItemsInTheCart(int amountOfItems) {
        $$(byId("#ProductItemsList")).shouldHave(size(amountOfItems));
    }

    public void showAmountOfProduct(int amountOfProducts) {
        $$(byId("#ProductAmount")).shouldHave(size(amountOfProducts));
    }


    public void assertThatCartHasAllAddedItems(int amountOfItems, int amountOfProducts) {
        showAmountOfItemsInTheCart(amountOfItems);
        showAmountOfProduct(amountOfProducts);
    }

    public void assertThatUsernameIsLoggedIn() {
        $("#username").shouldBe(Condition.visible);
    }


    public void assertSuccessfulCheckout() {
        $("#Alert").shouldHave(Condition.exactText("Checkout Successful"));
    }

    public void assertFailedCheckout() {
        $("#Alert").shouldHave(Condition.exactText("Checkout Failed"));
    }

}
