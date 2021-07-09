package tests.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    public void openLoginPage() {
        $("#LoginPage").click();
    }

    public void login(String email, String password) {
        $("#Email").setValue(email).pressEnter();
        $("#Passwd").setValue(password).pressEnter();
    }

    public void pressLoginButton() {
        $("#Login").click();
    }

    public void pressCancelButton() {
        $("#Cancel").click();
    }


    public void assertThatUserLoggedIn() {
        $("#Alert").shouldHave(Condition.text("User Logged in Successfully"));
    }

    public void assertThatLoginErrorIsShown() {
        $("#Alert").shouldHave(Condition.text("Invalid Credentials"));

    }

}
