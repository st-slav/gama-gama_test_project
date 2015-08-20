package gm.sel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManage {

	private WebDriver driver;
	
	public HomePage homePage;
	
	public PageManage(WebDriver driver) {
		this.driver = driver;
		homePage = initElements(new HomePage(this));	
	}

	private <T extends Page> T initElements(T page) {
	  //PageFactory.initElements(driver, page);
	  //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), page);
	  PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
	  return page;
	}
	
	public WebDriver getWebDriver() {
	  return driver;
	}

}
