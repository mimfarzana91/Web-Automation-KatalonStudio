package episode_management

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

public class episode_list {
	@Keyword
	def verifyUI(){
		String header1 = '番組放送日時管理'
		String header2 = '追加'
		String header = header1 + '\n' + header2

		WebUI.verifyElementText(findTestObject('Object Repository/Episode_list/verifyUI/header_div'), header)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Episode_list/verifyUI/planning_ID'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Episode_list/verifyUI/planning_ID'), '番組連動企画ID')
		WebUI.verifyElementText(findTestObject('Object Repository/Episode_list/verifyUI/program_name'), '番組名')
		WebUI.verifyElementText(findTestObject('Object Repository/Episode_list/verifyUI/broadcast_start_time'), '放送開始日時')
		WebUI.verifyElementText(findTestObject('Object Repository/Episode_list/verifyUI/brd_end_time'), '放送終了日時')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Episode_list/verifyUI/edit_colulmn'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Episode_list/verifyUI/edit_btn'), '編集')
	}
	@Keyword
	def verifytable(){
		WebUI.verifyElementPresent(findTestObject('Object Repository/Episode_list/table_verify/table'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Episode_list/table_verify/table_pagination'), 2)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/Episode_list/table_verify/pagination'), 0)
	}

	@Keyword
	def verifyAddBtn(){
		String addHeader = '番組放送日時管理'
		String back = 'バック'
		String AddHead = addHeader + "\n" + back
		WebUI.click(findTestObject('Object Repository/Episode_list/verifyUI/add_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Episode_list/verifyUI/add_episode_header'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Episode_list/verifyUI/add_episode_header'), addHeader)
		WebUI.verifyElementText(findTestObject('Object Repository/Episode_list/verifyUI/reg_header_add'), '登録')
		WebUI.back()
	}

	@Keyword
	def verifyEditBtn(){
		String header1 = '番組放送日時管理'
		String header2 = 'バック'
		String Header = header1 + "\n" + header2
		WebUI.click(findTestObject('Object Repository/Episode_list/verifyUI/edit_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Episode_list/Edit_UI/header'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Episode_list/Edit_UI/header'), header1)
		WebUI.verifyElementText(findTestObject('Object Repository/Episode_list/Edit_UI/update_header'), '更新')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Episode_list/Edit_UI/btn_update'), 2)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Episode_list/Edit_UI/btn_update'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Episode_list/Edit_UI/cancel_btn'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Episode_list/Edit_UI/cancel_btn'))
		WebUI.back()
	}
}
