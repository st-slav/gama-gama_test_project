package gm.sel;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import gm.sel.applogic.AppManage;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {
	
	protected AppManage app;

  @BeforeSuite
  public void init() throws IOException {
	  app = new AppManage(); 
  }

  @AfterSuite//(alwaysRun = true)
  public void stop() {
	  app.stop();
  }

}
