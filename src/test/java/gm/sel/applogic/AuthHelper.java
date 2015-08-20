package gm.sel.applogic;

import java.io.IOException;
import gm.sel.pages.HomePage;

public class AuthHelper extends AppManage {

	public AuthHelper(AppManage manage){
		super(manage.getWebDriver());
	}
	
	@Override
	public void loginAs(User user) {
		pages.HomePage.ensurePageLoaded()
			.setUsernameField(user.getLogin())
			.setPasswordField(user.getPassword())
			.clickSubmitButton();
	  }
}
