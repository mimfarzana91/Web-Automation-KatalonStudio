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
//import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.url)
WebUI.waitForPageLoad(10)
WebUI.delay(04)

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.Admin, GlobalVariable.Pass, "Admin")
WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/a_(EC)_Product'))
WebUI.delay(04)
WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/Page_Admin/button_Edit_Product'))
WebUI.delay(03)
CustomKeywords.'product_management.product_create.productEditPageUiVerification'()
WebUI.delay(03)
CustomKeywords.'product_management.product_create.programSelectBoxVerification'("Admin")
WebUI.delay(2)
CustomKeywords.'product_management.product_create.generalPublicCheckboxVerification'("Admin")
WebUI.delay(02)
WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_Admin/span_adminexamplecom'))
WebUI.delay(02)
WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_Admin/a_Logout'))
WebUI.delay(02)
CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ManagerMail, GlobalVariable.Pass, "Contents Manager")
WebUI.delay(04)
WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/Page_Admin/button_Edit_Product'))
WebUI.delay(03)
WebUI.scrollToElement(findTestObject('Object Repository/Product_management/Page_Admin/button_register'), 0)
CustomKeywords.'product_management.product_create.programSelectBoxVerification'("Contents Manager")
CustomKeywords.'product_management.product_create.generalPublicCheckboxVerification'("Contents Manager")

WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_Admin/span_adminexamplecom'))
WebUI.delay(02)
WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_Admin/a_Logout'))
WebUI.delay(02)

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.SupplierMail, GlobalVariable.Pass, "Contents Supplier")
WebUI.delay(04)
WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/Page_Admin/button_Edit_Product'))
WebUI.delay(03)
WebUI.scrollToElement(findTestObject('Object Repository/Product_management/Page_Admin/button_register'), 0)
CustomKeywords.'product_management.product_create.programSelectBoxVerification'("Contents Supplier")
CustomKeywords.'product_management.product_create.generalPublicCheckboxVerification'("Contents Supplier")


WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_Admin/span_adminexamplecom'))
WebUI.delay(02)
WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_Admin/a_Logout'))
WebUI.delay(02)

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ContentRegister, GlobalVariable.Pass, "Contents Register")
WebUI.delay(04)
WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/Page_Admin/button_Edit_Product'))
WebUI.delay(03)
WebUI.scrollToElement(findTestObject('Object Repository/Product_management/Page_Admin/button_register'), 0)
CustomKeywords.'product_management.product_create.programSelectBoxVerification'("Contents Register")
CustomKeywords.'product_management.product_create.generalPublicCheckboxVerification'("Contents Register")


WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_Admin/span_adminexamplecom'))
WebUI.delay(02)
WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_Admin/a_Logout'))


WebUI.delay(04)
CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.Admin, GlobalVariable.Pass, "Admin")
WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/a_(EC)_Product'))
WebUI.delay(04)
WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/Page_Admin/button_Edit_Product'))
WebUI.delay(03)
CustomKeywords.'product_management.product_create.editProduct'()

WebUI.closeBrowser()
