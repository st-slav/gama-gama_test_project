package gm.sel.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
/**
 * Sample page
 */
public class HomePage extends Page {

  public HomePage(PageManage pages) {
    super(pages);
  }
  
  @FindBy(xpath = "//div[@id='top_back']//a[@href='javascript:GamaGama.UI.showAuthForm();']")
  @CacheLookup
  private WebElement enterLink;
  
  public HomePage clickEnterLink(){
	  enterLink.click();
	  return this;
  }

  @FindBy(xpath = "//input[@name='Email']")
  @CacheLookup
  private WebElement emailField;
  
  public HomePage setEmailField(String text) {
	    emailField.clear();
	    emailField.sendKeys(text);
	    return this;
  }
  
  @FindBy(xpath = "//input[@class='auth_form_pass']")
  @CacheLookup
  private WebElement passField;
  
  public HomePage setPassField(String text) {
	    passField.clear();
	    passField.sendKeys(text);
	    return this;
  }  
  
  @FindBy(xpath = "//div[@id='authblock']//button[@class='btn-small btn-blue auth_submit-block js-login']")
  @CacheLookup
  private WebElement enterButton;
  
  public void clickEnterButton() {
	  enterButton.click();
  }
  
  @FindBy(xpath = "//div[@id='top_back']//a[@class='white logout' and @href='#']")
  @CacheLookup
  private WebElement logoutLink;
  
  public HomePage clikLogoutLink() {
	  logoutLink.click();
	  return this;
  }
  
  @FindBy(xpath = "//button[@id='cboxClose']")
  @CacheLookup
  private WebElement closeAuthFormButton;
  
  public HomePage clikCloseAuthFormButton() {
	  closeAuthFormButton.click();
	  return this;
  }
  
  @FindBy(xpath = "//div[@id='authblock']//div[@class='status-error']")
  @CacheLookup
  private WebElement errorMessageInForm;
  
  public String getTextErrorMessageInForm(){
	  return errorMessageInForm.getText();
  }
  
  public HomePage ensureErrorAuthForm(){
	  wait.until(presenceOfElementLocated(By.xpath("//div[@id='cboxContent']//div[@class='status-error' and (text())]")));
	  wait.until(presenceOfElementLocated(By.xpath("//div[@id='cboxContent']//div[@class='status-message' and not (text())]")));
	  return this;
  }
  
  public HomePage ensureStatusMessageAuthForm(){
	  wait.until(presenceOfElementLocated(By.xpath("//div[@id='cboxContent']//div[@class='status-error' and not (text())]")));
	  wait.until(presenceOfElementLocated(By.xpath("//div[@id='cboxContent']//div[@class='status-message' and (text())]")));
	  try {
		  TimeUnit.SECONDS.sleep(3);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
	  return this;
  }
  
  public HomePage ensurePageLoaded(){
//	  super.ensurePageLoaded();
	  wait.until(presenceOfElementLocated(By.xpath("//iframe[@title='fb:like_box Facebook Social Plugin']")));
	  wait.until(elementToBeClickable(enterLink));
	  return this;
  }  

  public HomePage ensurePageLoadedLogIn(){
//	  super.ensurePageLoaded();
	  wait.until(presenceOfElementLocated(By.xpath("//iframe[@title='fb:like_box Facebook Social Plugin']")));
	  wait.until(presenceOfElementLocated(By.xpath("//a[@href='/personal/settings/']")));
	  return this;	  
  }
  
  public HomePage ensureAuthFormVisibl(){
//	  super.ensureElementVisible();
	  wait.until(visibilityOfElementLocated(By.xpath("//div[@id='cboxContent']/div[@id='cboxLoadedContent']/div[@id='authblock']")));
	  return this;
  }
  
  @FindBy(xpath = "//a[@class='noreload auth_remind-password' and @href='#']")
  @CacheLookup
  private WebElement restorePassLink;
  
  public void clickRestorePassLink(){
	  restorePassLink.click();
  }
  
  public HomePage ensureElementRestorePassLink(){
	  wait.until(presenceOfElementLocated(By.xpath("//a[@class='noreload auth_remind-password' and @href='#']")));
	  return this;
  }
  
  @FindBy(xpath = "//div[@id='authblock']//div[@class='status-message']")
  @CacheLookup
  private WebElement statusMessageInForm;
  
  public String getTextStatusMessageInForm(){
	  return statusMessageInForm.getText();
  }

  @FindBy(xpath = "//div[@id='cboxContent']//a[@class='noreload auth_remind-password js-remind-pwd' and @href='#']")
  @CacheLookup
  private WebElement iLosePassLink;
  
  public HomePage clicILosePassLink() {
	  iLosePassLink.click();
	  return this;
  }

  @FindBy(xpath = "//div[@id='cboxContent']//a[@class='noreload auth_create-account js-register-acc']")
  @CacheLookup
  private WebElement createAccountLink;
  
  public HomePage clickCreateAccount() {
	  createAccountLink.click();
	  return this;
  }
  
}
