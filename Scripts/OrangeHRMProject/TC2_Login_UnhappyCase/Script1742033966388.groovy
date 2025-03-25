import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable




'1. Login with valid username and invalid password'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('Admin', 'admin1234')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Invalid credentials')


'2. Login with invalid username and valid password'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('Admin22', 'admin123')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Invalid credentials')


'3. Login with invalid username and invalid password'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('Admin22', 'admin1234')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Invalid credentials')


'4. Login with blank username and valid password'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('', 'admin1234')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Required')

'5. Login with valid username and blank password'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('Admin', '')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Required')

'6. Login with blank username and blank password'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('', '')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Required')

'7. Login with non-existing account'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('aaa', '123')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Invalid credentials')

'8. Login with uppercase username and valid password'
'Precondition: Account has already existed'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('ADMIN', 'admin123')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Invalid credentials')

'9. Login with valid username and uppercase password'
'Precondition: Account has already existed'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('Admin', 'ADMIN123')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Invalid credentials')

'10. Login with leading space in username and valid password'
'Precondition: Account has already existed'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'(' Admin', 'admin123')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Invalid credentials')

'11. Login with trailing space in username and valid password'
'Precondition: Account has already existed'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('Admin ', 'admin123')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Invalid credentials')

'12. Login with valid username and leading space in password'
'Precondition: Account has already existed'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('Admin', ' admin123')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Invalid credentials')

'13. Login with valid username and trailing space in password'
'Precondition: Account has already existed'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('Admin', 'admin123 ')
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Invalid credentials')

'14. User is blocked after 3 failed login attempt'
'Precondition: Account has already existed'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'('Admin', 'admin123 ')

'15. Login with Sql injection'
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.orangeHRM)
CustomKeywords.'orangeHRMProject.customKeyOrangeHRM.login'("1' or 1=1--", "1' or 1=1--")
WebUI.verifyElementText(findTestObject('Object Repository/OrangeHRMProject/Login/txt_message'), 'Invalid credentials')

'16. Login same account in 2 tabs'

'17. Login with low internet'


'18. Login and lose power accidentally'