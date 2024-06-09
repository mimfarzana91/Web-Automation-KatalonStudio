package management_user

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import com.thedeanda.lorem.Lorem as Lorem
import com.thedeanda.lorem.LoremIpsum as LoremIpsum
import com.kms.katalon.core.configuration.RunConfiguration
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent

import internal.GlobalVariable

public class user_manage {

	@Keyword
	def uiVerification(){

		String column1 = "ユーザーID(メールアドレス)"
		String column2 = "権限"

		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/column1'), column1)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/column2'),column2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/div__loader-wrapper'), 0)
	}

	@Keyword
	def registerUser(String email, String password){

		WebUI.click(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/input__email'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/input__email'), email)
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/input__password'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/input__password'), password)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/select_AdminContents ManagerContents SupplierContents Register'), 'Admin', false)
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/button_'))

		WebUI.delay(3)

		String message = WebUI.getText(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/registration_Successful'))
		print (message)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/registration_Successful'), '×\nClose\n登録が完了しました')
	}

	@Keyword
	def verifyUser (String email, String role){

		WebUI.click(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/div__loader-wrapper'))
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/user_email_verification'), email)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/user_role_varifiacation'), role)
	}

	@Keyword
	def editUser(String email, String password, String role){


		WebUI.click(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/input__email'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/input__email'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/input__email'), email)
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/input__password'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/input__password'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/input__password'), password)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/select_AdminContents ManagerContents SupplierContents Register'), '2')
		//WebUI.selectOptionByIndex(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/select_AdminContents ManagerContents SupplierContents Register'), "2", false)
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/button_'))

		WebUI.delay(3)

		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/update_successful'), '×\nClose\n更新が完了しました')
	}

	@Keyword
	def deleteUser(){

		WebUI.click(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/delete_button'))
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/h6_PopupHeader'), '確認')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/delete_popup_body'), '本当に実行しますか？')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_(Y)'), 'はい(Y)')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_(N)'), 'いいえ(N)')
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_(N)'))
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/user_email_verification'), 0)

		WebUI.click(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/delete_button'))
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_(Y)'))
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/delete_succesful'), '×\nClose\n削除が完了しました')
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/User_Managment/User_Management/Page_SxTvappAdmin/user_email_verification'), 0)
	}
}
