package home_page

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

import internal.GlobalVariable

public class home {

	@Keyword
	def uiVerification (String User){

		//Navigation side Bar
		if (User == 'Admin'){
			WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/2_Nav_ユーザー管理'), 'ユーザー管理')
			WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/3_Nav_チャンネル管理'), 'チャンネル管理')
		}
		else {
			WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/2_Nav_ユーザー管理_MSR'), 'ユーザー管理')
		}

		
		WebUI.verifyElementPresent(findTestObject('Object Repository/Home/Page_Admin/content_manage'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/4_Nav_コンテンツ管理'), 'コンテンツ管理')
		WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/5_Nav_クイズ管理'), 'クイズ管理')
		WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/6_Nav_プレゼント管理'), 'プレゼント管理')
		WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/7_Nav_商品(EC)管理'), '商品(EC)管理')
		WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/8_Nav_クーポン管理'), 'クーポン管理')
		WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/9_Nav_データ管理'), 'データ管理')

		//Other UI Elements
		//WebUI.verifyElementPresent(findTestObject('Object Repository/Home/Page_Admin/las la-bell'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Home/Page_Admin/i_adminexamplecom_las la-user-tie'), 0)

	}

	@Keyword
	def adminAccessability (String email){


		WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/1_Nav_管理ユーザー管理'), '管理ユーザー管理')
		String H4 = WebUI.getText(findTestObject('Object Repository/Home/Page_Admin/h4_Title_Admin'))
		print (H4)
		WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/h4_Title_Admin'), '管理ユーザー管理\n追加')
		WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/span_adminexamplecom'), email)
	}

	@Keyword
	def contentManagerSupplierRegisterAccessability (String email){

		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Home/Page_Admin/1_Nav_管理ユーザー管理'),3)
		//WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/h4_Title_Content_ManagerSupplierRegister'), '(EC)管理画面\n追加')
		//WebUI.verifyElementText(findTestObject('Object Repository/Home/Page_Admin/span_adminexamplecom'), email)

	}


	@Keyword
	def logout (){
		WebUI.click(findTestObject('Object Repository/Home/Page_Admin/span_adminexamplecom'))
		WebUI.click(findTestObject('Object Repository/Home/Page_Admin/logout_Button'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/Page_Admin/header'), 0)
	}
}
