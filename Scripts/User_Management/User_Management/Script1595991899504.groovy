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

WebUI.waitForPageLoad(10)
WebUI.delay(04)
CustomKeywords.'loginIntoWeb.login.loginWithValidMailPass'(GlobalVariable.Admin, GlobalVariable.Pass, "Admin")

CustomKeywords.'management_user.user_manage.uiVerification'()

WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/a_Useradd_button'))


CustomKeywords.'management_user.user_manage.registerUser'(Manager, GlobalVariable.Pass)
WebUI.delay(2)


WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/a_Useradd_button'))
CustomKeywords.'management_user.user_manage.registerUser'(Register, GlobalVariable.Pass)
WebUI.delay(03)

WebUI.click(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/edit_button'))
WebUI.delay(1)

CustomKeywords.'management_user.user_manage.editUser'(EditedEmail, GlobalVariable.Pass, 'role')
WebUI.delay(03)

//CustomKeywords.'management_user.user_manage.verifyUser'(EditedEmail, EditedRole)
//WebUI.delay(03)

CustomKeywords.'management_user.user_manage.deleteUser'()
WebUI.delay(03)
WebUI.closeBrowser()