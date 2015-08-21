package gm.sel.applogic;

import java.io.IOException;

import org.openqa.selenium.TimeoutException;

import gm.sel.model.User;

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
			.clickEnterButton()
			.ensurePageLoadedLogIn();
	  }
	
	public boolean isLoginIn(){
		try{
			pages.homePage.ensurePageLoadedLogIn();
			return true;
		} catch (TimeoutException to) {
			  return false;
		}
	}
	
	public void logout(){
		pages.homePage.clikLogoutLink()
			.ensurePageLoaded();
	}
	
	public void closeAuthForm(){
		pages.homePage.clikCloseAuthForm().ensurePageLoaded();
	}
	
	public boolean isAuthFormIn(){
		try{
			pages.homePage.ensureAuthFormVisibl();
			return true;
		} catch (TimeoutException to){
			return false;
		}
	}
}
