package shoppingProject

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.stringtemplate.v4.compiler.STParser.list_return

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import io.netty.handler.codec.http.multipart.FileUpload

public class customKey {

	//launch web
	@Keyword
	public static void launchWeb() {

		'1. Launch browser'
		WebUI.openBrowser('')
		'2. Navigate to url http://automationexercise.com'
		WebUI.navigateToUrl('https://automationexercise.com/')
		'3. Verify that home page is visible successfully'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/HomePage/img_logo'), 5)
	}

	//register account
	@Keyword
	public static void register(String name, String email) {
		'4. Click on Signup / Login button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_signup_login'))

		'5. Verify New User Signup! is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/SignupLogin/SignUp/txt_signup'), 5)

		'6. Enter name and email address'
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/SignupLogin/SignUp/input_name'), name)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/SignupLogin/SignUp/input_signup_email'), email)

		'7. Click Signup button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/SignupLogin/SignUp/btn_signup'))
	}

	//fill account information
	@Keyword
	public static void fillAccountInfor(String gender,String name, String password, String day, String month, String year) {
		'9. Fill details: Title, Name, Email, Password, Date of birth'
		if (gender == 'Mr') {
			WebUI.click(findTestObject('Object Repository/ShoppingProject/AccountInfor/rdo_gender', [('title') : 'Mr']))
		} else {
			WebUI.click(findTestObject('Object Repository/ShoppingProject/AccountInfor/rdo_gender', [('title') : 'Mrs']))
		}
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/AccountInfor/input_name_infor'), name)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/AccountInfor/input_password'), password)

		WebUI.selectOptionByLabel(findTestObject('Object Repository/ShoppingProject/AccountInfor/select_day'), day, false)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/ShoppingProject/AccountInfor/select_month'), month, false)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/ShoppingProject/AccountInfor/select_year'), year, false)

		'10. Select checkbox Sign up for our newsletter!'
		WebUI.check(findTestObject('Object Repository/ShoppingProject/AccountInfor/chb_newsletter'))

		'11. Select checkbox Receive special offers from our partners!'
		WebUI.check(findTestObject('Object Repository/ShoppingProject/AccountInfor/chb_offer'))
	}


	//fill address
	@Keyword
	public static void fillAddress(String firstName, String lastName, String company, String address1,
			String address2, String country, String state, String city, String zipcode, String phone) {
		'12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number'
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/AccountInfor/input_firstname'), firstName)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/AccountInfor/input_lastname'), lastName)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/AccountInfor/input_company'), company)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/AccountInfor/input_address1'), address1)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/AccountInfor/input_address2'), address2)

		WebUI.selectOptionByLabel(findTestObject('Object Repository/ShoppingProject/AccountInfor/select_country'), country, false)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/AccountInfor/input_state'), state)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/AccountInfor/input_city'), city)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/AccountInfor/input_zipcode'), zipcode)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/AccountInfor/input_phone'), phone)
		'13. Click Create Account button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/AccountInfor/btn_createAccount'))
		'14. Verify that ACCOUNT CREATED! is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Shared/txt_title', [('mess'):'account-created']), 0)

		'15. Click Continue button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/btn_continue',[('buttonName'):'continue-button']))
	}

	//verify login
	@Keyword
	public static void verifyLogin(String name) {
		'16. Verify that Logged in as username is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Shared/txt_username', [('username') : name]), 0)
	}


	//delete account
	@Keyword
	public static void deleteAccount() {
		'17. Click Delete Account button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_delete'))
		'18. Verify that ACCOUNT DELETED! is visible and click Continue button'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Shared/txt_title',[('mess'):'account-deleted']), 0)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/btn_continue',[('buttonName'):'continue-button']))
	}


	//login
	@Keyword
	public static void login(String email, String password) {
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_signup_login'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/SignupLogin/Login/txt_login_title'), 5)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/SignupLogin/Login/input_login_email'), email)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/SignupLogin/Login/input_login_password'), password)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/SignupLogin/Login/btn_login'))
	}

	//logout
	@Keyword
	public static void logout() {
		WebUI.click(findTestObject('Object Repository/ShoppingProject/SignupLogin/Logout/link_logout'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/SignupLogin/Login/txt_login_title'), 10)
	}

	//contact
	@Keyword
	public static void checkContact(String name, String email, String subject, String message, String filePath) {
		'4. Click on Contact Us button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Contact/link_contact'))

		'5. Verify GET IN TOUCH is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Contact/txt_contact_title'), 5)

		'6. Enter name, email, subject and message'
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/Contact/input_contact_name'), name)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/Contact/input_contact_email'), email)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/Contact/input_contact_message'), message)

		'7. Upload file'
		WebUI.uploadFile(findTestObject('Object Repository/ShoppingProject/Contact/input_contact_file'), filePath )

		'8. Click Submit button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Contact/btn_contact_submit'))

		'9. Click OK button'
		WebUI.waitForAlert(10)
		WebUI.acceptAlert()

		'10. Verify success message Success! Your details have been submitted successfully. is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Contact/txt_contact_success'), 5)

		'11. Click Home button and verify that landed to home page successfully'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Contact/btn_home'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/HomePage/img_logo'), 5)
	}

	@Keyword
	public static void checkTestCasePage() {
		'4. Click on Test Cases button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/TestCasePage/link_testcase'))
		'5. Verify user is navigated to test cases page successfully'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/TestCasePage/txt_testcase_title'), 5)
	}


	@Keyword
	public static void checkProductPage() {
		'4. Click on Products button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_product'))
		'5. Verify user is navigated to ALL PRODUCTS page successfully'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Product/title_AllProducts'), 5)
		'6. The products list is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Product/list_allproducts'), 10)
		'7. Click on View Product of first product'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Product/link_firstproduct'))

		'8. User is landed to product detail page'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/ProductDetail/txt_productName'), 10)

		'9. Verify that detail detail is visible: product name, category, price, availability, condition, brand'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/ProductDetail/txt_productCategory'), 10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/ProductDetail/txt_productPrice'), 10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/ProductDetail/txt_availability'), 10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/ProductDetail/txt_condition'), 10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/ProductDetail/txt_brand'), 10)
	}

	@Keyword
	public static void searchProduct(String productName) {
		'4. Click on Products button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_product'))
		'5. Verify user is navigated to ALL PRODUCTS page successfully'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Product/title_AllProducts'), 5)
		'6. Enter product name in search input and click search button'
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/Product/input_search_product'), productName)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Product/btn_search_product'))
		'7. Verify SEARCHED PRODUCTS is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Product/txt_search_product'), 10)

		'8. Verify all the products related to search are visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Product/list_search_product'),10)
	}

	@Keyword
	public static verifySubscriptionHomePage(String email) {
		'5. Verify text SUBSCRIPTION'
		WebUI.scrollToElement(findTestObject('Object Repository/ShoppingProject/Shared/txt_subscription'), 10)

		'6. Enter email address in input and click arrow button'
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/Shared/input_subscription_email'), email)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/btn_subscription'))
		'7. Verify success message You have been successfully subscribed! is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Shared/txt_subscription_success',[('message'):'You have been successfully subscribed!']), 10)
	}

	@Keyword
	public static void verifySubscriptionCart(String email) {
		'4. Click Cart button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_cart'))

		'5. Verify text SUBSCRIPTION'
		WebUI.scrollToElement(findTestObject('Object Repository/ShoppingProject/Shared/txt_subscription'), 10)

		'6. Enter email address in input and click arrow button'
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/Shared/input_subscription_email'), email)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/btn_subscription'))
		'7. Verify success message You have been successfully subscribed! is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Shared/txt_subscription_success',[('message'):'You have been successfully subscribed!']), 10)
	}

	@Keyword
	public static void addToCart() {
		'4. Click Products button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_product'))

		'5. Hover over first product and click Add to cart'
		WebUI.mouseOver(findTestObject('Object Repository/ShoppingProject/Product/item_product', [('index'): 1]))
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Product/btn_addcart', [('index'): 1]))

		'6. Click Continue Shopping button'
		WebUI.waitForElementVisible(findTestObject('Object Repository/ShoppingProject/Product/popupCart'), 5)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Product/btn_popup_continue'))

		'7. Hover over second product and click Add to cart'
		WebUI.mouseOver(findTestObject('Object Repository/ShoppingProject/Product/item_product', [('index'): 2]))
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Product/btn_addcart', [('index'): 2]))

		'8. Click View Cart button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Product/link_viewcart'))

		'9. Verify both products are added to Cart'
		int productCount = WebUI.findWebElements(findTestObject('Object Repository/ShoppingProject/Cart/cart_product_name'), 10).size()
		for (int i = 1; i <= productCount; i++) {
			TestObject cartProduct = findTestObject('Object Repository/ShoppingProject/Cart/cart_product_name', [('index'): i])
			WebUI.verifyElementPresent(cartProduct, 10)
		}

		'10. Verify their prices, quantity and total price'
		for (int i = 1; i <= productCount; i++) {
			String price = WebUI.getText(findTestObject('Object Repository/ShoppingProject/Cart/cart_product_price', [('index'): i]))
			String quantity = WebUI.getText(findTestObject('Object Repository/ShoppingProject/Cart/cart_product_quantity', [('index'): i]))
			String displayedTotal = WebUI.getText(findTestObject('Object Repository/ShoppingProject/Cart/cart_product_total', [('index'): i]))

			double priceValue = Double.parseDouble(price.replace("Rs. ", ""))
			int quantityValue = Integer.parseInt(quantity)
			double expectedTotal = priceValue * quantityValue


			WebUI.verifyEqual(expectedTotal.toString(), displayedTotal.replace("Rs. ", ""))
			WebUI.comment("Expected: " + expectedTotal + ", Displayed: " + displayedTotal)
		}
	}
}
