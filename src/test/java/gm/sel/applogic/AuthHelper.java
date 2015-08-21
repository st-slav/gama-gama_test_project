package gm.sel.applogic;

import java.io.IOException;

import gm.sel.model.User;
import gm.sel.pages.HomePage;

public class AuthHelper extends DriverHelper {

	public AuthHelper(AppManage manage){
		super(manage.getWebDriver());
	}
	
	public void loginAs(User user) {
		pages.homePage.ensurePageLoaded()
			.clickEnterLink()
			.ensureAuthFormVisibl()
			.setEmailField(user.getEmail())
			.setPassField(user.getPass())
			.clickEnterButton();
	  }
}
