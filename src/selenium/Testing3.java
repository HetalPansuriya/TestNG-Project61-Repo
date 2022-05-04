package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
  
	SoftAssert softAssert = new SoftAssert();
	// we do not use soft Assert in industry..but if we want to still run test after assert fails..then we can use this way
	
  @Test	(priority = 1)//create new user test@test.com
  public void createUser() {
		System.out.println("I am in home test");
		System.out.println("Before assertion");
		Assert.assertTrue(2>3,  "Verifying Element");
		System.out.println("After assertion");
		Assert.assertEquals("abc", "abc");
  }
  @Test	(priority = 2, dependsOnMethods = "createUser" )//Edit User
  public void editUser() {
	  
	  System.out.println("Before assert");
	  softAssert.assertTrue(2>3, "Verifying Element");
	  System.out.println("After assert");
	  softAssert.assertAll();
  }
  
  @Test		(priority = 3, dependsOnMethods = "editUser")//delete User
  public void deleteUser() {
	  System.out.println("I an in end test");
	  System.out.println("Before assert");
	  softAssert.assertTrue(2>3, "Verifying Element");
	  System.out.println("After assert");
	  softAssert.assertEquals("abc", "abc1");
	  System.out.println("After second assert");
	  softAssert.assertAll();
  }


}
