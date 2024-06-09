
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
WebUI.delay(2)

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.Admin, GlobalVariable.Pass, 'Admin')

WebUI.click(findTestObject('Object Repository/Content_Create/UI/sidebar_content'))
WebUI.delay(2)
CustomKeywords.'content_management.content_create_edit.verifyContentUI'()
WebUI.delay(1)

CustomKeywords.'content_management.content_create_edit.verifyContentBulkUI'()
WebUI.delay(2)

CustomKeywords.'content_management.content_create_edit.verifyAlertmsg'()
WebUI.delay(1)

CustomKeywords.'content_management.content_create_edit.verifyItemBox'()
WebUI.delay(1)

CustomKeywords.'content_management.content_create_edit.verifyPartialRequired'()
WebUI.delay(2)

CustomKeywords.'content_management.content_create_edit.verifyImageAndVideo'()
WebUI.delay(2)

CustomKeywords.'content_management.content_create_edit.verifyCheckBox'("Admin")
WebUI.delay(3)

CustomKeywords.'content_management.content_create_edit.verifyContentRegistration'()
WebUI.delay(2)

CustomKeywords.'content_management.content_create_edit.verifyEditUI'()
WebUI.delay(2)

CustomKeywords.'content_management.content_create_edit.verifyUpdateContent'()
WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/Content_Create/logout/arrow'))
WebUI.click(findTestObject('Object Repository/Content_Create/logout/logout_btn'))

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ContentRegister, GlobalVariable.Pass, 'ContentRegister')
WebUI.delay(1)

CustomKeywords.'content_management.content_create.verifyContentRegisterRole'("ContentRegister")

WebUI.closeBrowser()
