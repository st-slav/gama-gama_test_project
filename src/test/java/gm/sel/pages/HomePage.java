package gm.sel.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
//presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
  public WebElement enterLink;
  
  public void clickEnterLink(){
	  enterLink.click();
  }
  
  
  
  public HomePage ensurePageLoaded(){
	  super.ensurePageLoaded();
//	  wait.until(presenceOfElementLocated(By.xpath("//div[@id='sh_button']")));
	  wait.until(presenceOfElementLocated(By.xpath("//div[@id='u_0_6']")));
	  return this;
  }  
  
  public HomePage ensureAuthFormVisibl(){
	  super.ensureElementVisible();
	  wait.until(visibilityOfElementLocated(By.xpath("//div[@id='colorbox']")));
	  return this;
  }
//div[@id='colorbox']
  
}
