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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl(GlobalVariable.url)

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.Admin, GlobalVariable.Pass, "Admin")
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Quiz Create Edit/UI/quiz_sidebar'))
WebUI.click(findTestObject('Object Repository/Quiz Create Edit/edit_UI/edit'))
CustomKeywords.'quiz_management.quiz_create_edit.verifyEditUI'()
WebUI.delay(1)

CustomKeywords.'quiz_management.quiz_create_edit.verifyEdit'()
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Quiz Create Edit/contentRegister_role/arrow'))
WebUI.click(findTestObject('Object Repository/Quiz Create Edit/contentRegister_role/logout'))
CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ContentRegister, GlobalVariable.Pass, "ContentRegister")
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Quiz Create Edit/contentRegister_role/sidebar'))
CustomKeywords.'quiz_management.quiz_create_edit.verifyContentRegisterRole'("ContentRegister")
WebUI.closeBrowser()