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
import java.util.Random


WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.url)
WebUI.waitForPageLoad(10)

CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.Admin,GlobalVariable.Pass, "Admin")

WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/a_Useradd_button'))
CustomKeywords.'user_management.user_registration.uiVerification'()
CustomKeywords.'user_management.user_registration.requiredFieldVerification'()
CustomKeywords.'user_management.user_registration.mailFieldVerification'()
CustomKeywords.'user_management.user_registration.passwordFieldVerification'()
Random rand = new Random();
String number=rand.nextInt(100).toString();
String mailAdres="testmail1+";
String mailaddress2="@gmail.com";
String emailId= mailAdres + number + mailaddress2;

CustomKeywords.'user_management.user_registration.successfulRegistration'(emailId, GlobalVariable.Pass)
WebUI.delay(03)
WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/a_Useradd_button'))

CustomKeywords.'user_management.user_registration.RegisterddMailRegistration'(emailId, GlobalVariable.Pass)


WebUI.delay(02)
WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/span_adminexamplecom'))
WebUI.delay(02)
WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/a_Logout'))
WebUI.delay(02)
CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ManagerMail,GlobalVariable.Pass,"Content Manager")

WebUI.delay(02)
WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/span_adminexamplecom'))
WebUI.delay(02)
WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/a_Logout'))
CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.ContentRegister,GlobalVariable.Pass,"Content Register") 


WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/span_adminexamplecom'))
WebUI.delay(02)
WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/a_Logout'))
CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.SupplierMail,GlobalVariable.Pass,"Content Supplier") 

WebUI.closeBrowser()




