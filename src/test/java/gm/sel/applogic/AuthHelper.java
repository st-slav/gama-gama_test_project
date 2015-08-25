package gm.sel.applogic;

import java.io.IOException;

import org.openqa.selenium.TimeoutException;

import gm.sel.model.User;

public class AuthHelper extends DriverHelper {

	public AuthHelper(AppManage manage){
		super(manage.getWebDriver());
	}
	
	public void loginAs(User user) {
		this.inputDataiInForm(user);
		pages.homePage.clickEnterButton();
			//.ensurePageLoadedLogIn();
	  }
	
	public void inputDataiInForm(User user){
		pages.homePage.ensurePageLoaded()
			.clickEnterLink()
			.ensureAuthFormVisibl()
			.setEmailField(user.getEmail())
			.setPassField(user.getPass());
	}
	
	public boolean compareTextErrorMessageInForm(String text){
		return pages.homePage.getTextErrorMessageInForm() == text;
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
		pages.homePage.clikCloseAuthFormButton().ensurePageLoaded();
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
