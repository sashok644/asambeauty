package tests.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MailPage {

    private static String mailUsername = System.getProperty("mail.username", "test1mail1@protonmail.com");
    private static String mailPassword = System.getProperty("mail.password", "12345678");

    public static void openInbox() {

        open("https://account.protonmail.com/login");
        login();
    }

    private static void login() {
        $("#username").val(mailUsername).pressEnter();
        $("#password").val(mailPassword).pressEnter();
    }


    public void openConfirmationLetter() {
        $(byName("searchbox")).waitUntil(visible, 10000).click();                                       //user clicks the search field and do the confirmation email search
        $(byId("global_search")).val("Confirmation").pressEnter();
        $(byAttribute("data-testid", "message-item:Confirmation")).shouldBe(visible).click();    //user clicks on the confirmation email

    }

    public void assertThatConfirmationTextIsPresent() {
        $(byAttribute("data-testid", "message-content:body")).click();
        $(byAttribute("data-testid", "message-content:body")).lastChild().shouldHave(text("test"));
    }


    public void userCanRefreshMessages() {
        $(by("title", "Refresh")).click();
    }
}

