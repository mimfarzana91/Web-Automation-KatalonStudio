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

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.Admin, GlobalVariable.Pass, "Admin")
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Coupon_Create/UI/coupon_sidebar'))
WebUI.delay(2)
CustomKeywords.'coupon_management.coupon_create_edit.verifyCouponUI'()
WebUI.delay(5)

CustomKeywords.'coupon_management.coupon_create_edit.verifyBulkUI'()
WebUI.delay(5)

CustomKeywords.'coupon_management.coupon_create_edit.verfyAlrtMsg'()
WebUI.delay(5)

CustomKeywords.'coupon_management.coupon_create_edit.verifyImage'()
WebUI.delay(5)

CustomKeywords.'coupon_management.coupon_create_edit.verifyStatus'("Admin")
WebUI.delay(2)

CustomKeywords.'coupon_management.coupon_create_edit.verifyCouponCreate'()
WebUI.delay(5)

CustomKeywords.'coupon_management.coupon_create_edit.verifyEditUI'()
WebUI.delay(2)

CustomKeywords.'coupon_management.coupon_create_edit.verifyCouponEdit'()
WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Coupon_Create/edit/arrow'))
WebUI.click(findTestObject('Object Repository/Coupon_Create/edit/logout'))

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ContentRegister, GlobalVariable.Pass, "ContentRegister")
WebUI.delay(5)

CustomKeywords.'coupon_management.coupon_create_edit.verifyContentRegisterRole'()
WebUI.delay(5)

WebUI.closeBrowser()
