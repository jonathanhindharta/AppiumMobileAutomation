package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
public class PriceFilterTest extends BaseClass {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	@Test
	public void loginWithStandarUser() {
		loginPage.loginUsingStandardUser(driver);
	}
	
	@Test(dependsOnMethods = {"loginWithStandarUser"})
	public void checkPriceFilter() {
		homePage.checkFilterLowHighAndHighLow(driver);
	}
}
