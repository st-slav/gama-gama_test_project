package gm.sel.applogic;

import gm.sel.pages.PageManage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverHelper {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected PageManage pages;
	
	public DriverHelper(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		pages = new PageManage(driver);
	}
}
