package gm.sel.applogic;

public class NavigationHelper extends DriverHelper  {
	
	  private String baseUrl;

	  public NavigationHelper(AppManage manager) {
	    super(manager.getWebDriver());
	    this.baseUrl = manager.getBaseUrl();
	  }
	  
	  public void openMainPage() {
		driver.get(baseUrl);
	  }
	  
	  public void easyStop(){
		driver.close();
	  }
	  
	  public void openNewWindow(){
		  //driver.
	  }

}
