package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SplashScreen extends BaseScreen {

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/version_text']")
    MobileElement versionTextView;
    public SplashScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getCurrentVersion(){
        return versionTextView.getText();
    }
    public AuthenticationScreen checkVersion(String version){
       // Assert.assertTrue(isShouldHave(versionTextView,version));
        return new AuthenticationScreen(driver);
    }
    public AuthenticationScreen gotoAuthenticationScreen(){
        return new AuthenticationScreen(driver);
    }
}
