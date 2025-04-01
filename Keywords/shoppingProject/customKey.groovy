package shoppingProject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI






public class customKey {

	//launch web
	@Keyword
	public static void launchWeb() {

		'2. Navigate to url http://automationexercise.com'
		WebUI.navigateToUrl('https://automationexercise.com/')
		'3. Verify that home page is visible successfully'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/HomePage/img_logo'), 5)
	}

	//TC1

	public static void verifyTextInRegister() {
		'4. Click on Signup / Login button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_signup_login'))

		'5. Verify New User Signup! is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/SignupLogin/SignUp/txt_signup'), 5)
	}

	@Keyword
	public static void register(String name, String email) {
		verifyTextInRegister()
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

	//TC12
	@Keyword
	public static void addToCart() {
		List<String> addedProducts = []

		'4. Click Products button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_product'))
		WebUI.scrollToElement(findTestObject('Object Repository/ShoppingProject/Shared/item_product', [('index'): 1]), 5)


		'5. Hover over first product and click Add to cart'
		String firstProductName = WebUI.getText(findTestObject('Object Repository/ShoppingProject/Product/item_product_name', [('index'): 1]))
		addedProducts.add(firstProductName)
		KeywordUtil.logInfo(firstProductName)
		WebUI.mouseOver(findTestObject('Object Repository/ShoppingProject/Shared/item_product', [('index'): 1]))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/btn_addcart', [('index'): 1]))

		'6. Click Continue Shopping button'
		WebUI.waitForElementVisible(findTestObject('Object Repository/ShoppingProject/Shared/popupCart'), 5)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Product/btn_popup_continue'))

		'7. Hover over second product and click Add to cart'
		WebUI.mouseOver(findTestObject('Object Repository/ShoppingProject/Shared/item_product', [('index'): 2]))
		WebUI.delay(2)
		String secondProductName = WebUI.getText(findTestObject('Object Repository/ShoppingProject/Product/item_product_name', [('index'): 2]))

		addedProducts.add(secondProductName)
		KeywordUtil.logInfo(secondProductName)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/btn_addcart', [('index'): 2]))
		'8. Click View Cart button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/link_viewcart'))

		'9. Verify both products are added to Cart'
		for (String productName : addedProducts) {
			boolean isFound = isProductInCart(productName)
			KeywordUtil.logInfo(productName)
			WebUI.verifyEqual(isFound, true, FailureHandling.CONTINUE_ON_FAILURE)
		}

		'10. Verify price calculation for each product'
		int productCount = WebUI.findWebElements(findTestObject('Object Repository/ShoppingProject/Cart/cart_product_name'), 10).size()
		for (int i = 1; i <= productCount; i++) {
			String price = WebUI.getText(findTestObject('Object Repository/ShoppingProject/Cart/cart_product_price', [('index'): i])).replace("Rs. ", "").trim()
			String quantity = WebUI.getText(findTestObject('Object Repository/ShoppingProject/Cart/cart_product_quantity', [('index'): i])).trim()
			String displayedTotal = WebUI.getText(findTestObject('Object Repository/ShoppingProject/Cart/cart_product_total', [('index'): i])).replace("Rs. ", "").trim()

			double priceValue = Double.parseDouble(price)
			int quantityValue = Integer.parseInt(quantity)
			double expectedTotal = priceValue * quantityValue
			double displayedTotalValue = Double.parseDouble(displayedTotal)

			WebUI.verifyEqual(expectedTotal, displayedTotalValue)
			KeywordUtil.logInfo("Product index ${i}: Expected total: ${expectedTotal}, Displayed: ${displayedTotalValue}")
		}
	}

	def static boolean isProductInCart(String productNameToCheck) {
		List<WebElement> cartProducts = WebUI.findWebElements(findTestObject('Object Repository/ShoppingProject/Cart/cart_product_name'), 10)

		for (WebElement product : cartProducts) {
			if (product.getText().trim().equalsIgnoreCase(productNameToCheck)) {
				KeywordUtil.markPassed("Product '" + productNameToCheck + "' is found in the cart.")
				return true
			}
		}

		KeywordUtil.markFailed("Product '" + productNameToCheck + "' is NOT found in the cart!")
		return false
	}


	//TC13
	@Keyword
	def verifyQuantityInCart(int quantity) {
		WebUI.scrollToElement(findTestObject('Object Repository/ShoppingProject/HomePage/list_product'), 5)

		'4. Click View Product for any product on home page'
		String productNameInHomePage = WebUI.getText(findTestObject('Object Repository/ShoppingProject/Product/item_product_name', [('index'): 3]))
		KeywordUtil.logInfo('Product in home page: ' + productNameInHomePage)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/item_product', [('index'): 3]))


		'5. Verify product detail is opened'
		String productNameInDetail = WebUI.getText(findTestObject('Object Repository/ShoppingProject/ProductDetail/txt_detail_productName'))
		KeywordUtil.logInfo('Product in details: ' + productNameInDetail)

		if (WebUI.verifyMatch(productNameInDetail, productNameInHomePage, false, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed('Product name on the detail page ("' + productNameInDetail + '") MATCHES the product name on the home page ("' + productNameInHomePage + '").')
		} else {
			KeywordUtil.markFailedAndStop('ERROR: Product name on the detail page ("' + productNameInDetail + '") DOES NOT match the product name on the home page ("' + productNameInHomePage + '").')
		}

		'6. Increase quantity'
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/ProductDetail/input_quantity'), quantity.toString())

		'7. Click Add to cart button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/ProductDetail/btn_add_product'))

		'8. Click View Cart button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/link_viewcart'))

		'9. Verify that product is displayed in cart page with exact quantity'
		if (!isProductInCart(productNameInDetail)) {
			KeywordUtil.markFailedAndStop("ERROR: Product '" + productNameInDetail + "' is NOT found in the cart.")
		}

		WebElement quantityElement = DriverFactory.getWebDriver().findElement(By.xpath("//td[@class='cart_quantity']//button"))
		String quantityText = quantityElement.getText().trim()
		int quantityInCart = Integer.parseInt(quantityText)


		if (quantityInCart == quantity) {
			KeywordUtil.markPassed("Quantity verification passed! Expected: ${quantity}, Found: ${quantityInCart}")
		} else {
			KeywordUtil.markFailed("ERROR: Expected quantity ${quantity} but found ${quantityInCart} in cart.")
		}
	}


	//TC14
	@Keyword
	def checkRegisterWhileCheckOut(String name, String email) {
		'4. Add products to cart'
		WebUI.scrollToElement(findTestObject('Object Repository/ShoppingProject/HomePage/list_product'), 5)
		WebUI.mouseOver(findTestObject('Object Repository/ShoppingProject/Shared/item_product', [('index'): 1]))
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/btn_addcart', [('index'): 1]))

		'5. Click Cart button'
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_cart'))

		'6. Verify that cart page is displayed'
		WebUI.verifyTextPresent('Shopping Cart', false)

		'7. Click Proceed To Checkout'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Cart/btn_proceed_checkout',['(textCheckout)':'Proceed To Checkout']))

		'8. Click Register / Login button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Cart/btn_popup_login_register'))
	}

	@Keyword
	def checkCheckout() {
		'12.Click Cart button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_cart'))

		'13. Click Proceed To Checkout button'

		WebUI.click(findTestObject('Object Repository/ShoppingProject/Cart/btn_proceed_checkout',['(textCheckout)':'Proceed To Checkout']))

		'14. Verify Address Details and Review Your Order'
		

		'15. Enter description in comment text area and click Place Order'

		'16. Enter payment details: Name on Card, Card Number, CVC, Expiration date'

		'17. Click Pay and Confirm Order button'

		'18. Verify success message Your order has been placed successfully!'
	}

	//TC15



	//TC16




	//TC17
	@Keyword
	def checkRemoveProductFromCart() {
		'4. Add products to cart'
		WebUI.scrollToElement(findTestObject('Object Repository/ShoppingProject/HomePage/list_product'), 5)
		WebUI.mouseOver(findTestObject('Object Repository/ShoppingProject/Shared/item_product', [('index'): 1]))
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/btn_addcart', [('index'): 1]))
		WebUI.waitForElementVisible(findTestObject('Object Repository/ShoppingProject/Shared/popupCart'), 5)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Product/btn_popup_continue'))

		'5. Click Cart button'
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_cart'))

		'6. Verify that cart page is displayed'
		WebUI.verifyTextPresent('Shopping Cart', false)

		'7. Click X button corresponding to particular product'
		List<WebElement> productsBefore = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ShoppingProject/Cart/row_product'),5)
		int productCountBefore = productsBefore.size()
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Cart/btn_remove',[('index'): 2]))
		List<WebElement> productsAfter = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ShoppingProject/Cart/row_product'),5)
		int productCountAfter = productsAfter.size()
		'8. Verify that product is removed from the cart'
		if (productCountBefore > 1) {
			if (productCountAfter == productCountBefore - 1) {
				KeywordUtil.markPassed("Remove product successfully!")
			} else {
				KeywordUtil.markFailed("Error: Remove product failed!")
			}
		} else {
			WebUI.verifyTextPresent('Cart is empty!', false, FailureHandling.CONTINUE_ON_FAILURE)
			KeywordUtil.markPassed("Cart is empty after removing the last product!")
		}
	}



	//TC18
	@Keyword
	def checkCategoryInSidebar() {
		WebUI.scrollToElement(findTestObject('Object Repository/ShoppingProject/HomePage/txt_sidebar_category', [('textInSideBar'):'Category']), 10, FailureHandling.STOP_ON_FAILURE)
		'3. Verify that categories are visible on left side bar'
		boolean isCategoryVisible = WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/HomePage/txt_sidebar_category', [('textInSideBar'):'Category']),
		10, FailureHandling.CONTINUE_ON_FAILURE)

		if (isCategoryVisible) {
			KeywordUtil.markPassed("Categories are visible on the left sidebar.")
		} else {
			KeywordUtil.markFailed("Categories are NOT visible on the left sidebar.")
		}
	}

	@Keyword
	def checkCategoryProduct(String parentCategory, String childCategory) {
		'4. Click on parent category'
		WebUI.waitForElementVisible(findTestObject('Object Repository/ShoppingProject/HomePage/txt_category_parent', [('categoryParent'): parentCategory]), 10)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/txt_category_parent', [('categoryParent'): parentCategory]))

		'5. Click on child category under the selected parent category'
		WebUI.waitForElementVisible(findTestObject('Object Repository/ShoppingProject/HomePage/txt_category_child', [('categoryParent'): parentCategory, 'categoryChild': childCategory]), 10)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/txt_category_child', [('categoryParent'): parentCategory, 'categoryChild': childCategory]))

		'6. Wait for page to load and verify category text'
		WebUI.waitForPageLoad(10)
		String categoryText = parentCategory + " - " + childCategory + " Products"
		boolean isCategoryDisplayed = WebUI.verifyTextPresent(categoryText, false, FailureHandling.CONTINUE_ON_FAILURE)


		if (isCategoryDisplayed) {
			KeywordUtil.markPassed("${parentCategory} - ${childCategory} category page is displayed correctly.")
		} else {
			KeywordUtil.markFailed("${parentCategory} - ${childCategory} category page did not load correctly.")
		}
	}

	//TC19
	@Keyword
	def checkBrandInSidebar() {
		'3. Click on Products button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_product'))
		'4. Verify that Brands are visible on left side bar'
		boolean isBrandVisible = WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/HomePage/txt_sidebar_category', [('textInSideBar'):'Brands']),
		10, FailureHandling.CONTINUE_ON_FAILURE)

		if (isBrandVisible) {
			KeywordUtil.markPassed("Brands are visible on the left sidebar.")
		} else {
			KeywordUtil.markFailed("Brands are NOT visible on the left sidebar.")
		}
	}

	@Keyword
	def checkBrandProduct(String brand) {
		'5. Click on any brand name'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/txt_brand',[('brandName'):brand]))
		'6. Verify that user is navigated to brand page and brand products are displayed'
		String brandText = 'Brand' + ' - ' + brand + " Products"
		boolean isBrandDisplayed = WebUI.verifyTextPresent(brandText, false, FailureHandling.CONTINUE_ON_FAILURE)
		if (isBrandDisplayed) {
			KeywordUtil.markPassed("${brand} page is displayed correctly.")
		} else {
			KeywordUtil.markFailed("${brand} page did not load correctly.")
		}

		boolean isProductDisplayed = WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/HomePage/list_product'), 5)
		if (isProductDisplayed) {
			KeywordUtil.markPassed("Products are displayed correctly.")
		} else {
			KeywordUtil.markFailed("Products did not load correctly.")
		}
	}

	//TC20
	@Keyword
	def checkCartAfterLogin(String name, String password) {
		'8. Add those products to cart'
		WebUI.mouseOver(findTestObject('Object Repository/ShoppingProject/Shared/item_product', [('index'): 2]))
		String productNameInProductPage = WebUI.getText(findTestObject('Object Repository/ShoppingProject/Product/item_product_name', [('indexProduct'): '2']))
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/btn_addcart', [('index'): 2]))

		'9. Click Cart button and verify that products are visible in cart'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_cart'))

		if (!isProductInCart(productNameInProductPage)) {
			KeywordUtil.markFailedAndStop("ERROR: Product '" + productNameInProductPage + "' is NOT found in the cart before login.")
		}

		'10. Click Signup / Login button and submit login details'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_signup_login'))
		login(name, password)

		'11. Again, go to Cart page'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_cart'))

		'12. Verify that those products are visible in cart after login as well'
		if (!isProductInCart(productNameInProductPage)) {
			KeywordUtil.markFailedAndStop("ERROR: Product '" + productNameInProductPage + "' is NOT found in the cart after login.")
		}
	}

	//TC21
	@Keyword
	def addReviewOnProduct(String name, String email, String review) {
		'3. Click on Products button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_product'))

		'4. Verify user is navigated to ALL PRODUCTS page successfully'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Product/title_AllProducts'), 5)
		'5. Click on View Product button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Product/link_view_product', [('index'):1]))
		'6. Verify Write Your Review is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/ProductDetail/txt_title_review'), 5)

		'7. Enter name, email and review'
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/ProductDetail/input_review_name'), name)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/ProductDetail/input_review_email'), email)
		WebUI.setText(findTestObject('Object Repository/ShoppingProject/ProductDetail/input_review'), review)
		'8. Click Submit button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/ProductDetail/btn_review_submit'))
		'9. Verify success message Thank you for your review.'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/ProductDetail/txt_review_success', [('message'):'Thank you for your review.']), 5)
	}


	//TC22
	@Keyword
	def checkAddToCartFromRecommend() {
		'3. Scroll to bottom of page'
		WebUI.scrollToPosition(0, 99999)

		'4. Verify RECOMMENDED ITEMS are visible'
		boolean isRecommendedItemDisplayed = WebUI.verifyElementPresent('recommended items', 5)
		if (isRecommendedItemDisplayed) {
			KeywordUtil.markPassed("Recommended Items is displayed correctly.")
		} else {
			KeywordUtil.markFailed("Recommended Items did not load correctly.")
		}

		'5. Click on Add To Cart on Recommended product'
		String productName = WebUI.getText(findTestObject('Object Repository/ShoppingProject/HomePage/item_recommend_name', [('indexProduct'): '2']))
		KeywordUtil.logInfo("Selected product: " + productName)
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/btn_item_recommend', [('indexProduct'): '2']))

		'6. Click on View Cart button'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/link_viewcart'))

		'7. Verify that product is displayed in cart page'
		String cartProductName = WebUI.getText(findTestObject('Object Repository/ShoppingProject/Cart/cart_product_name'))
		WebUI.verifyMatch(cartProductName, productName, false)
		KeywordUtil.markPassed("Product successfully added to cart and verified.")
	}

	//TC23
	def addToCartFromHomePage(int indexProduct) {
		WebUI.mouseOver(findTestObject('Object Repository/ShoppingProject/Shared/item_product', [('index'): indexProduct]))
		String productNameInProductPage = WebUI.getText(findTestObject('Object Repository/ShoppingProject/Product/item_product_name', [('indexProduct'): indexProduct]))
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Shared/btn_addcart', [('index'): indexProduct]))
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/link_cart'))
		WebUI.verifyTextPresent('Shopping Cart', false)
		if (!isProductInCart(productNameInProductPage)) {
			KeywordUtil.markFailedAndStop("ERROR: Product '" + productNameInProductPage + "' is NOT found in the cart before login.")
		}
	}
	
	
	def checkAddressDetail(String address1,String address2, String country, String state, String city, String zipcode) {
		WebUI.click(findTestObject('Object Repository/ShoppingProject/Cart/btn_proceed_checkout'))
		'12. Verify that the delivery address is same address filled at the time registration of account'
		String actualDeliveryAddress1 = WebUI.getText(findTestObject('Object Repository/ShoppingProject/CheckoutPage/txt_delivery_address', [('index'): 2]))
		String actualDeliveryAddress2 = WebUI.getText(findTestObject('Object Repository/ShoppingProject/CheckoutPage/txt_delivery_address', [('index'): 3]))
		String expectedCityStatePostcode = city + ' ' + state + ' ' + zipcode
		String actualDeliveryCityStatePostcode = WebUI.getText(findTestObject('Object Repository/ShoppingProject/CheckoutPage/txt_delivery_city_state_postcode'))
		
		WebUI.verifyMatch(actualDeliveryAddress1, address1, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(actualDeliveryAddress2, address2, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(actualDeliveryCityStatePostcode, expectedCityStatePostcode, false, FailureHandling.CONTINUE_ON_FAILURE)
		
		'13. Verify that the billing address is same address filled at the time registration of account'
		String actualBillingAddress1 = WebUI.getText(findTestObject('Object Repository/ShoppingProject/CheckoutPage/txt_delivery_address', [('index'): 2]))
		String actualBillingAddress2 = WebUI.getText(findTestObject('Object Repository/ShoppingProject/CheckoutPage/txt_delivery_address', [('index'): 3]))
		String actualBillingCityStatePostcode = WebUI.getText(findTestObject('Object Repository/ShoppingProject/CheckoutPage/txt_delivery_city_state_postcode'))
		
		WebUI.verifyMatch(actualBillingAddress1, address1, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(actualBillingAddress2, address2, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(actualBillingCityStatePostcode, expectedCityStatePostcode, false, FailureHandling.CONTINUE_ON_FAILURE)
	}

	//TC24



	//TC25
	@Keyword
	def verifyScrollUsingArrowButton() {
		'4. Scroll down page to bottom'
		WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight);', [])

		'5. Verify SUBSCRIPTION is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Shared/txt_subscription'), 10)

		'6. Click on arrow at bottom right side to move upward'
		WebUI.click(findTestObject('Object Repository/ShoppingProject/HomePage/btn_scroll_up'))

		'7. Verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen'
		WebUI.verifyTextPresent('Full-Fledged practice website for Automation Engineers', false)
	}

	//TC26
	@Keyword
	def verifyScrollWithoutArrowButton() {
		'4. Scroll down page to bottom'
		WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight);', [])

		'5. Verify SUBSCRIPTION is visible'
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShoppingProject/Shared/txt_subscription'), 10)
		'6. Scroll up page to top'
		WebUI.executeJavaScript('window.scrollTo(0, 0);', [])

		'7. Verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen'
		WebUI.verifyTextPresent('Full-Fledged practice website for Automation Engineers', false)
	}
}
