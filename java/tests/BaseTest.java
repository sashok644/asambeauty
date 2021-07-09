package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import ru.yandex.qatools.allure.annotations.Attachment;
import tests.helpers.IOSDriverProvider;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class BaseTest {

    @Before

    //this part will create and run the IOSDriver for each test. To use a normal WebDriver for the email test this @Before tag should be commented
    public void setUp() {
        closeWebDriver();
        Configuration.browser = IOSDriverProvider.class.getName();
        open();
    }

    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }
}
