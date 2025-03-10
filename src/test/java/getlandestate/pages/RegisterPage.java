package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    public RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
