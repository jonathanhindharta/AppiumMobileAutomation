package tests;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckOutCompletePage;
import pages.CheckOutInformationPage;
import pages.CheckOutOverViewPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckOutTest extends BaseClass {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	CartPage cartPage = new CartPage();
	CheckOutOverViewPage checkOutOverViewPage = new CheckOutOverViewPage();
	CheckOutInformationPage checkOutInformationPage = new CheckOutInformationPage();
	CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage();
	
	@Test
	public void loginWithStandarUser() {
		loginPage.loginUsingStandardUser(driver);
	}
	
	@Test(dependsOnMethods = {"loginWithStandarUser"})
	public void checkOutFirstProduct() {
		homePage.checkOutFirstProduct(driver);
	}
	
	@Test(dependsOnMethods = {"checkOutFirstProduct"})
	public void checkCartDetailAndCheckOut() {
		cartPage.checkCartDetailAndCheckOut(driver, homePage.productNameAdded, homePage.priceAdded);
	}
	
	@Test(dependsOnMethods = {"checkCartDetailAndCheckOut"})
	public void checkCheckOutInformationPageAndContinue() {
		checkOutInformationPage.checkCheckOutInformationPageAndContinue(driver);
	}
	
	@Test(dependsOnMethods = {"checkCheckOutInformationPageAndContinue"})
	public void checkCheckOutOverviewAndFinish() {
		checkOutOverViewPage.checkCheckOutOverviewAndFinish(driver, homePage.productNameAdded, homePage.priceAdded);
	}
	
	@Test(dependsOnMethods = {"checkCheckOutOverviewAndFinish"})
	public void checkCheckOutComplete() {
		checkOutCompletePage.checkCheckOutCompletePage(driver);
	}
}
