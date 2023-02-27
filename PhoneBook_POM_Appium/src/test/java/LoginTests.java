import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {
    @Test
    public void loginSuccess(){
       boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("benb@gmail.com")
                .fillPassword("Beny$123456")
                .submitLogin()
                .isContactListPresent();
       Assert.assertTrue(res);
    }
    @Test
    public void loginSuccessModel(){
        boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .login(Auth.builder().email("benb@gmail.com").password("Beny$123456").build())
                .isContactListPresent();
        Assert.assertTrue(res);
    }
    @AfterMethod
    public void postCondition(){
       if( new ContactListScreen(driver).isContactListPresent()){
           new ContactListScreen(driver).logout();
           new SplashScreen(driver);
       }
    }
}
