package gm.sel;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gm.sel.model.User;
import gm.sel.pages.HomePage;

public class AuthTest extends TestNgTestBase {

/*  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }*/

  @Test
  public void testLogIn() {
    User user = new User().setEmail("st.mam_@hotmail.com").setPass("1");
    app.getAuthHelper().loginAs(user);
//    Assert.assertFalse("".equals(homepage.header.getText()));
  }
}
