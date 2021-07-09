package tests.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {


    public void openProductPage() {
        $("#ProductsPage").click();
    }

    public void pressAddToCardButton() {
        $(By.name("#CardButton")).click();
    }

    public void assertThatProductWasAddedToTheCard() {
        $("#Alert").shouldHave(Condition.text("Product was added to the card"));
    }

    public void assertThatProductHasAnImage() {
        $("#Product Image").shouldBe(Condition.visible);
    }

    public void assertThatProductHasPrice() {
        $("#Price").shouldHave(Condition.value("#Value"));
    }

    public void assertThatProductHasCorrectName() {
        $("#Product Name").shouldHave(Condition.text("Product Name"));
    }

    public void assertThatProductHasDescription() {
        $("#Description").shouldHave(Condition.text("Description"));
    }

    public void assertThatProductCorrectlyDisplayed() {
        assertThatProductHasAnImage();
        assertThatProductHasPrice();
        assertThatProductHasCorrectName();
        assertThatProductHasDescription();
    }


}
