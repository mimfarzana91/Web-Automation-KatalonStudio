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

WebUI.click(findTestObject('Object Repository/Present_management/verify_UI/1_sidebar'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Present_management/verify_UI/add_btn'))
WebUI.delay(4)

CustomKeywords.'present_management.present_create.verifyUI'()
WebUI.delay(4)

CustomKeywords.'present_management.present_create.verifyBulkUI'()
WebUI.delay(4)

CustomKeywords.'present_management.present_create.verifyImage'()
WebUI.delay(4)

CustomKeywords.'present_management.present_create.verifyAlertMessages'()
WebUI.delay(4)

CustomKeywords.'present_management.present_create.verifySelectBox'("Admin")
WebUI.delay(2)

CustomKeywords.'present_management.present_create.verifyCheckbox'("Admin")
WebUI.delay(2)

CustomKeywords.'present_management.present_create.verifyAddPresent'()
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Present_management/alert_msg/logout_arrow'))
WebUI.click(findTestObject('Object Repository/Present_management/alert_msg/Logout'))
WebUI.delay(2)

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ContentRegister, GlobalVariable.Pass, "ContentRegister")

WebUI.click(findTestObject('Object Repository/Present_management/verify_UI/1_sidebar'))
WebUI.click(findTestObject('Object Repository/Present_management/verify_UI/add_btn'))
CustomKeywords.'present_management.present_create.verifyContentRegisterRole'("ContentRegister")


WebUI.closeBrowser()