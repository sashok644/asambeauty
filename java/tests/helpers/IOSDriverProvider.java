package tests.helpers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.IOSMobileCapabilityType.BUNDLE_ID;
import static io.appium.java_client.remote.MobileCapabilityType.*;


public class IOSDriverProvider implements WebDriverProvider {
    @CheckReturnValue
    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability(PLATFORM_NAME, "iOS");
        capabilities.setCapability(VERSION, "15.0");
        capabilities.setCapability(BUNDLE_ID, "com.apple.Preferences");
        capabilities.setCapability(DEVICE_NAME, "iPhone 12");
        capabilities.setCapability(AUTOMATION_NAME, "XCUITest");
        try {
            return new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
