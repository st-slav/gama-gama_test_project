package gm.sel.applogic;

import java.io.IOException;

import gm.sel.model.User;
import gm.sel.pages.HomePage;

public class AuthHelper extends DriverHelper {

	public AuthHelper(AppManage manage){
		super(manage.getWebDriver());
	}
	
	@Override
	public void loginAs(User user) {
		pages.homePage.ensurePageLoaded()
			.clikEnterButton()
			.ensureElementVisible()
			.setUsernameField(user.getEmail())
			.setPasswordField(user.getPassword())
			.clickEnterButtonAuth();
	  }
}
