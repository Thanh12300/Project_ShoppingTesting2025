import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.beans.Customizer

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


3. Verify that home page is visible successfully
4. Click on Signup / Login button
5. Verify Login to your account is visible
6. Enter correct email address and password
7. Click login button
8. Verify that Logged in as username is visible
9. Click Logout button
10. Verify that user is navigated to login page'
CustomKeywords.'shoppingProject.customKey.launchWeb'()

CustomKeywords.'shoppingProject.customKey.login'('minh@gmail.com', '123456789')
CustomKeywords.'shoppingProject.customKey.verifyLogin'('minh')
CustomKeywords.'shoppingProject.customKey.logout'()
WebUI.takeScreenshot()

