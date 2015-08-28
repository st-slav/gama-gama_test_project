package gm.sel;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import gm.sel.model.User;

public class AuthTest extends TestNgTestBase {

  @AfterMethod
  public void postConditions() throws Exception {
	  if (app.getAuthHelper().isAuthFormIn()){
		  app.getAuthHelper().closeAuthForm();
	  } else if ( app.getAuthHelper().isLoginIn()){		  
		  app.getAuthHelper().logout();
	  }
  }  	
 
  @Test
  public void testLogInEmailEmptyPassEmpty_7() throws Exception {
	  User user = new User().setEmail(null).setPass(null);
	  app.getAuthHelper().loginAs(user);
	  Assert.assertTrue(app.getAuthHelper().compareTextErrorMessageInForm("������� E-mail, �� ������� �� ����������������"));
  }
  
  @Test
  public void testLogInEmailRegistryPassEmpty_5() throws Exception {
	  User user = new User().setEmail("st.mam_@hotmail.com").setPass(null);
	  app.getAuthHelper().loginAs(user);
	  Assert.assertTrue(app.getAuthHelper().compareTextErrorMessageInForm("������� ��� ������"));
  }

  @Test
  public void testILosePassEmailRegistryPassWrong_3(){
	  User user = new User().setEmail("st.mam@yandex.ru").setPass("22");
	  app.getAuthHelper().recoveryPass(user);
	  Assert.assertTrue(app.getAuthHelper().compareTextStatusMessageInForm("���������� �� �������������� ����������"));
  }
 
  @Test
  public void testILosePassEmailNotRegister_8(){
	  User user = new User().setEmail("a@a.a").setPass(null);
	  app.getAuthHelper().recoveryPass(user);
	  Assert.assertTrue(app.getAuthHelper().compareTextErrorMessageInForm("������������ � ����� Email �� ���������������"));
  }
 
  @Test
  public void testILosePassEmailEmptyPassEmpty_9(){
	  User user = new User().setEmail(null).setPass(null);
	  app.getAuthHelper().recoveryPass(user);
	  Assert.assertTrue(app.getAuthHelper().compareTextErrorMessageInForm("������� E-mail, �� ������� �� ����������������"));
  }
  
  @Test
  public void testCreatAccEmailRegister_10(){
	  User user = new User().setEmail("st.mam@yandex.ru").setPass("22");
	  app.getAuthHelper().registration(user);
	  Assert.assertTrue(app.getAuthHelper().compareTextErrorMessageInForm("������������ � ����� e-mail ��� ���������������. ������ ������?"));
	  app.getAuthHelper().restorePass();
	  Assert.assertTrue(app.getAuthHelper().compareTextStatusMessageInForm("���������� �� �������������� ����������"));
  }
  
  @Test
  public void testCreatAccEmailValid_11(){
	  User user = new User().setEmail("a@a.a").setPass(null);
	  app.getAuthHelper().registration(user);
	  Assert.assertTrue(app.getAuthHelper().compareTextErrorMessageInForm("���������� ���� ������"));
  }
  
  @Test
  public void testCreatAccEmailEmptyPassEmty_12(){
	  User user = new User().setEmail(null).setPass(null);
	  app.getAuthHelper().registration(user);
	  Assert.assertTrue(app.getAuthHelper().compareTextErrorMessageInForm("������� E-mail, �� ������� ����� ��������� �������"));
  }
  
  @Test
  public void testCreatAccEmailNotValid_15(){
	  User user = new User().setEmail("c@c.c").setPass("1");
	  app.getAuthHelper().registration(user);
	  Assert.assertTrue(app.getAuthHelper().compareTextErrorMessageInForm("E-Mail ������������"));
  }

  @Test
  public void testLogInEmailRegistryPassWrong_4(){
	  User user = new User().setEmail("st.mam@yandex.ru").setPass("22");
	  app.getAuthHelper().loginAs(user);
	  Assert.assertTrue(app.getAuthHelper().compareTextErrorMessageInForm("������������ ������. ������������"));
	  Assert.assertTrue(app.getAuthHelper().restorePassLinkVisible());
	  app.getAuthHelper().restorePass();
	  Assert.assertTrue(app.getAuthHelper().compareTextStatusMessageInForm("���������� �� �������������� ����������"));
  }
  
  @Test
  public void atestLogInTrue_2() throws Exception {
    User user = new User().setEmail("st.mam_@hotmail.com").setPass("1");
    app.getAuthHelper().loginAs(user);
    Assert.assertTrue(app.getAuthHelper().isLoginIn());
  }

}
