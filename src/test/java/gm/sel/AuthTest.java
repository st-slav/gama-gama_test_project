package gm.sel;

//import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import gm.sel.model.User;
import gm.sel.pages.HomePage;

public class AuthTest extends TestNgTestBase {

  @Test
  public void testLogIn() throws Exception {
    User user = new User().setEmail("st.mam_@hotmail.com").setPass("1");
    app.getAuthHelper().loginAs(user);
//    Assert.assertFalse("".equals(homepage.header.getText()));
    Assert.assertTrue(app.getAuthHelper().isLoginIn());
  }
  
  //@AfterMethod
  @Test
  public void postConditions() throws Exception {
	  if (app.getAuthHelper().isLoginIn()){
		  app.getAuthHelper().logout();
	  } else if (app.getAuthHelper().isAuthFormIn()){
		  app.getAuthHelper().closeAuthForm();
	  }
	  Assert.assertFalse(app.getAuthHelper().isLoginIn());
  }
}
