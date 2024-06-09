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
WebUI.waitForPageLoad(5)


//Admin
CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.Admin, GlobalVariable.Pass, "Admin")
//CustomKeywords.'login.login.loginWithValidMailPass'(AdminMail, Pass)
//CustomKeywords.'home_page.home.uiVerification'("Admin")
//CustomKeywords.'home_page.home.adminAccessability'('Admin')
CustomKeywords.'home_page.home.logout'()


//Content Manager
CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ManagerMail,GlobalVariable.Pass, "Manager")
//CustomKeywords.'login.login.loginWithValidMailPass'(ManagerMail, Pass)
CustomKeywords.'home_page.home.uiVerification'('Manager')
CustomKeywords.'home_page.home.contentManagerSupplierRegisterAccessability'("Manager")
CustomKeywords.'home_page.home.logout'()


//Content Supplier
CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.SupplierMail, GlobalVariable.Pass, "Supplier")
//CustomKeywords.'login.login.loginWithValidMailPass'(SupplierMail, Pass)
CustomKeywords.'home_page.home.uiVerification'("Supplier")
CustomKeywords.'home_page.home.contentManagerSupplierRegisterAccessability'("Supplier")
CustomKeywords.'home_page.home.logout'()


//Content Register
CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ContentRegister,GlobalVariable.Pass, "ContentRegister")
//CustomKeywords.'login.login.loginWithValidMailPass'(RegisterMail, Pass)
CustomKeywords.'home_page.home.uiVerification'("ContentRegister")
CustomKeywords.'home_page.home.contentManagerSupplierRegisterAccessability'(RegisterMail)
CustomKeywords.'home_page.home.logout'()

WebUI.closeBrowser()