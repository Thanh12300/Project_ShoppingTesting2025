import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable



'1. Login with valid username and valid password'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('Admin', 'admin123')
WebUI.verifyElementPresent(findTestObject('Object Repository/OrangeHRMProject/Login/txt_dashboard'), 10)

'2.Login successfully after a failed login attempt'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('Admin123', 'admin123')
WebUI.closeBrowser()

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('Admin', 'admin123')
WebUI.verifyElementPresent(findTestObject('Object Repository/OrangeHRMProject/Login/txt_dashboard'), 10)





