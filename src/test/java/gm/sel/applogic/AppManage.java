package gm.sel.applogic;

import java.io.IOException;

import gm.sel.util.PropertyLoader;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

public class AppManage {
	
	private AuthHelper authHelper;
	
	private WebDriver driver;
	private String baseUrl;
	private String gridHubUrl;
	private Capabilities capabilities;
	
	
	public AppManage() throws IOException{
	    baseUrl = PropertyLoader.loadProperty("site.url");
	    gridHubUrl = PropertyLoader.loadProperty("grid.url");
	    if ("".equals(gridHubUrl)) {
	      gridHubUrl = null;
	    }
	    capabilities = PropertyLoader.loadCapabilities();
	    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
	    
	    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
	    
	    authHelper = new AuthHelper(this);
	    
	    driver.get(baseUrl);
	}
	
	public AuthHelper getAuthHelper(){
		return authHelper;
	}
	
	protected WebDriver getWebDriver() {
		return driver;
	}

	public void stop() {
		if (driver != null) {
			driver.quit();
	    }
	}

}
