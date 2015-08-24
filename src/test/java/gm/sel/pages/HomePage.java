package gm.sel.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
/**
 * Sample page
 */
public class HomePage extends Page {

/*  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;*/

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
	    emailField.sendKeys(text);
	    return this;
  }
  
  @FindBy(xpath = "//input[@class='auth_form_pass']")
  @CacheLookup
  private WebElement passField;
  
  public HomePage setPassField(String text) {
	    passField.sendKeys(text);
	    return this;
  }  
  
  @FindBy(xpath = "//div[@id='authblock']//button[@class='btn-small btn-blue auth_submit-block js-login']")
  @CacheLookup
  private WebElement enterButton;
  
  public HomePage clickEnterButton() {
	  enterButton.click();
	  return this;
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
  private WebElement closeAuthForm;
  
  public HomePage clikCloseAuthForm() {
	  closeAuthForm.click();
	  return this;
  }
  
  public HomePage ensurePageLoaded(){
	  super.ensurePageLoaded();
//	  wait.until(presenceOfElementLocated(By.xpath("//div[@id='sh_button']")));
//	  driver.switchTo().Frame();
	  wait.until(presenceOfElementLocated(By.xpath("//iframe[@title='fb:like_box Facebook Social Plugin']")));
//	  driver.SwitchTo().DefaultContent();
	  wait.until(presenceOfElementLocated(By.xpath("//div[@id='top_back']//a[@href='javascript:GamaGama.UI.showAuthForm();']")));
	  return this;
  }  

  public HomePage ensurePageLoadedLogIn(){
	  super.ensurePageLoaded();
	  wait.until(presenceOfElementLocated(By.xpath("//iframe[@title='fb:like_box Facebook Social Plugin']")));
	  wait.until(presenceOfElementLocated(By.xpath("//a[@href='/personal/settings/']")));
	  return this;	  
  }
  
  public HomePage ensureAuthFormVisibl(){
	  super.ensureElementVisible();
	  wait.until(visibilityOfElementLocated(By.xpath("//div[@id='colorbox']")));
	  return this;
  }
//div[@id='colorbox']
}
