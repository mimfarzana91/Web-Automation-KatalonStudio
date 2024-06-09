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
import org.apache.commons.lang.RandomStringUtils as RandStr

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.waitForPageLoad(10)

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.Admin, GlobalVariable.Pass,"Admin")

WebUI.delay(5)

WebUI.click(findTestObject('Content_management/uiVerification/content_management_button'))

WebUI.delay(5)

CustomKeywords.'content_management.content_list.uiVerification'()

WebUI.delay(5)

CustomKeywords.'content_management.content_list.tableVerification'()

WebUI.delay(5)

CustomKeywords.'content_management.content_list.verifyingAddButton'()

WebUI.delay(5)

CustomKeywords.'content_management.content_list.verifyEditUpdate'()

WebUI.delay(2)

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ContentRegister, GlobalVariable.Pass, "contentRegister")

WebUI.delay(2)

CustomKeywords.'content_management.content_list.verifyContentRegisterAccess'()

WebUI.delay(2)

WebUI.closeBrowser()
