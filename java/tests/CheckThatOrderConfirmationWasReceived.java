package tests;

import org.junit.Test;
import tests.pages.MailPage;

public class CheckThatOrderConfirmationWasReceived extends BaseTest {

    MailPage gMailPage = new MailPage();


    @Test
    public void testConfirmationEmail() {
        //To run it with the normal WebDriver you need to comment @Before tag and setUp method in the BaseTest
        gMailPage.openInbox();
        gMailPage.openConfirmationLetter();
        gMailPage.assertThatConfirmationTextIsPresent();
    }


}
