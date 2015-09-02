package gm.sel.applogic;

import java.math.BigInteger;
import java.security.SecureRandom;

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
		System.out.println(pages.homePage.ensureErrorAuthForm().getTextErrorMessageInForm());
		return pages.homePage.ensureErrorAuthForm().getTextErrorMessageInForm().equals(text);
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
	
	public boolean restorePassLinkVisible() {
		try{
			pages.homePage.ensureElementRestorePassLink();
			return true;
		} catch (TimeoutException to){
			return false;
		}
	}
	
	public void restorePass(){
		pages.homePage.clickRestorePassLink();
		pages.homePage.ensureStatusMessageAuthForm();
	}
	
	public void registerWithPassLink(){
		pages.homePage.clickRegisterWithPassLink();
		pages.homePage.ensurePageLoadedLogIn();
	}
	
	public boolean compareTextStatusMessageInForm(String text){
		return pages.homePage.ensureStatusMessageAuthForm().getTextStatusMessageInForm().equals(text);
	}

	public void recoveryPass(User user) {
		this.inputDataiInForm(user);
		pages.homePage.clicILosePassLink();	
	}

	public void registration(User user) {
		this.inputDataiInForm(user);
		pages.homePage.clickCreateAccount();
	}

	public String emailGenerate() {
		return new BigInteger(60, new SecureRandom()).toString(32)+"@bbbb.ru";
	}

}
