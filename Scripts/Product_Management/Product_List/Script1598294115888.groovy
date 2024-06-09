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

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.Admin, GlobalVariable.Pass, "Admin")
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Product_List/a_(EC)_Product'))
WebUI.delay(3)
CustomKeywords.'product_list_screen.product_list.uiVerification'()
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.tableVerification'()
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.addButtonVerification'()
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.editProduct'('Admin')
WebUI.delay(2)
CustomKeywords.'home_page.home.logout'()

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ManagerMail,GlobalVariable.Pass, "Manager")
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.uiVerification'()
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.tableVerification'()
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.addButtonVerification'()
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.editProduct'('Manager')
CustomKeywords.'home_page.home.logout'()

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.SupplierMail, GlobalVariable.Pass, "Supplier")
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.uiVerification'()
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.tableVerification'()
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.addButtonVerification'()
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.editProduct'('Supplier')
CustomKeywords.'home_page.home.logout'()

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ContentRegister,GlobalVariable.Pass, "ContentRegister")
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.uiVerification'()
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.tableVerification'()
WebUI.delay(2)
CustomKeywords.'product_list_screen.product_list.addButtonVerification'()


WebUI.closeBrowser()
