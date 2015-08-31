package gm.sel.pages;

//import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Sample page
 */
public class HomePage extends Page {

  public HomePage(PageManage pages) {
    super(pages);
  }
  
  @FindBy(xpath = "//div[@id='authblock']//div[@class='status-message']")
  private WebElement statusMessageInForm;
  
  public String getTextStatusMessageInForm(){
	  return statusMessageInForm.getText();
  }

  @FindBy(xpath = "//div[@id='cboxContent']//a[@class='noreload auth_remind-password js-remind-pwd' and @href='#']")
  private WebElement iLosePassLink;
  
  public HomePage clicILosePassLink() {
	  iLosePassLink.click();
	  return this;
  }

  @FindBy(xpath = "//div[@id='cboxContent']//a[@class='noreload auth_create-account js-register-acc']")
  private WebElement createAccountLink;
  
  public HomePage clickCreateAccount() {
	  createAccountLink.click();
	  return this;
  }
  
  @FindBy(xpath = "//div[@id='top_back']//a[@href='javascript:GamaGama.UI.showAuthForm();']")
  private WebElement enterLink;
  
  public HomePage clickEnterLink(){
	  enterLink.click();
	  return this;
  }
  
  @FindBy(xpath = "//input[@name='Email']")
  private WebElement emailField;
  
  public HomePage setEmailField(String text) {
	    emailField.clear();
	    emailField.sendKeys(text);
	    return this;
  }
  
  @FindBy(xpath = "//input[@class='auth_form_pass']")
  private WebElement passField;
  
  public HomePage setPassField(String text) {
	    passField.clear();
	    passField.sendKeys(text);
	    return this;
  }  
  
  @FindBy(xpath = "//div[@id='authblock']//button[@class='btn-small btn-blue auth_submit-block js-login']")
  private WebElement enterButton;
  
  public void clickEnterButton() {
	  enterButton.click();
  }
  
  @FindBy(xpath = "//div[@id='top_back']//a[@class='white logout' and @href='#']")
  private WebElement logoutLink;
  
  public HomePage clikLogoutLink() {
	  logoutLink.click();
	  return this;
  }
  
  @FindBy(xpath = "//button[@id='cboxClose']")
  private WebElement closeAuthFormButton;
  
  public HomePage clikCloseAuthFormButton() {
	  closeAuthFormButton.click();
	  return this;
  }
  
  @FindBy(xpath = "//div[@id='authblock']//div[@class='status-error']")
  private WebElement errorMessageInForm;
  
  public String getTextErrorMessageInForm(){
	  return errorMessageInForm.getText();
  }
  
  @FindBy(xpath = "//a[@class='noreload auth_remind-password' and @href='#']")
  private WebElement restorePassLink;
  
  public void clickRestorePassLink(){
	  restorePassLink.click();
  }
  
  @FindBy(xpath = "//a[@class='noreload auth_create-account' and @href='#']")
  private WebElement registerWithPassLink;
  
  public void clickRegisterWithPassLink(){
	  registerWithPassLink.click();
  }
  
  public HomePage ensureErrorAuthForm(){
	  waiter("//div[@id='cboxContent']//div[@class='status-error' and (text())]");
	  waiter("//div[@id='cboxContent']//div[@class='status-message' and not (text())]");
	  return this;
  }
  
  public HomePage ensureStatusMessageAuthForm(){
	  waiter("//div[@id='cboxContent']//div[@class='status-error' and not (text())]");
	  waiter("//div[@id='cboxContent']//div[@class='status-message' and (text())]");
	  try {
		  TimeUnit.SECONDS.sleep(4);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
	  return this;
  }
  
  public HomePage ensurePageLoaded(){
	  waiter("//iframe[@title='fb:like_box Facebook Social Plugin']");
	  waiter("//div[@id='top_back']//a[@href='javascript:GamaGama.UI.showAuthForm();']");
	  waiter("//div[@id='top_back']//a[@href='javascript:GamaGama.UI.showRegisterForm();']");
	  waiter("//div[@id='sh_button']");
	  return this;
  }  

  public HomePage ensurePageLoadedLogIn(){
	  waiter("//iframe[@title='fb:like_box Facebook Social Plugin']");
	  waiter("//a[@href='/personal/settings/']");
	  return this;	  
  }
  
  public HomePage ensureAuthFormVisibl(){
	  waiter("//div[@id='cboxContent']/div[@id='cboxLoadedContent']/div[@id='authblock']");
	  return this;
  }
  
  public HomePage ensureElementRestorePassLink(){
	  waiter("//a[@class='noreload auth_remind-password' and @href='#']");
	  return this;
  }
  
}
