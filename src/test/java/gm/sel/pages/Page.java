package gm.sel.pages;

//import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected PageManage pages;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */	
  public Page(PageManage pages) {
	  this.pages = pages;
	  driver = pages.getWebDriver();
	  wait = new WebDriverWait(driver, 10); 
  }
  
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }
  
  protected void waiter(String xpathLocator){
	  wait.until(presenceOfElementLocated(By.xpath(xpathLocator)));
  }
}
