package gm.sel.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	  wait = new WebDriverWait(driver, 30); 
  }
  
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }
  
  //ждёт загрузки страницы и возвращает её имя
  public Page ensurePageLoaded() {
	  return this;
  }

  //ждёт загрузки страницы и возвращает 1 или 0
  public boolean waitPageLoaded() {
	  try {
		  ensurePageLoaded();
		  return true;
	  } catch (TimeoutException to) {
		  return false;
	  }
	}

}
