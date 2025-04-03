import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import shoppingProject.customKey

CustomKeywords.'shoppingProject.customKey.launchWeb'()

String name = 'thanhhuyen'
String email = 'th05@gmail.com'
String gender = 'Mrs'
String password = 'thanhhuyen123'
String day = '10'
String month = 'September'
String year = '1998'
String firstName = 'Tran'
String lastName = 'Thanh'
String company = 'Company A'
String address1 = 'Address 1'
String address2 = 'Address 2'
String country = 'United States'
String state = 'California'
String city = 'Los Angeles'
String zipcode = '90001'
String phone = '123456789'
String indexProduct = 2
CustomKeywords.'shoppingProject.customKey.register'(name, email)
CustomKeywords.'shoppingProject.customKey.fillAccountInfor'(gender,name,password,day,month,year)
CustomKeywords.'shoppingProject.customKey.fillAddress'(firstName, lastName, company, address1, address2, country, 
	state, city, zipcode, phone)
CustomKeywords.'shoppingProject.customKey.addToCartFromHomePage'(indexProduct)
CustomKeywords.'shoppingProject.customKey.checkAddressDetail'(address1, address2, country, state, city, zipcode)
CustomKeywords.'shoppingProject.customKey.deleteAccount'()


