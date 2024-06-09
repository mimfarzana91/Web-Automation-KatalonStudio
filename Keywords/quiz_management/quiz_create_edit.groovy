package quiz_management

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
import com.thedeanda.lorem.Lorem as Lorem
import com.thedeanda.lorem.LoremIpsum as LoremIpsum

//import org.junit
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.configuration.RunConfiguration
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import org.apache.commons.lang.RandomStringUtils as RandStr

public class quiz_create_edit {
	@Keyword
	def verifyUI(){
		String header1 = "クイズ管理"
		WebUI.delay(1)

		WebUI.click(findTestObject('Object Repository/Quiz Create Edit/UI/Add_btn_new'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/add_header'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/add_header'), header1)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/reg'), '登録')
		WebUI.delay(1)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/question'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/question'), '問題文')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/textarea__question'), 0)
		WebUI.delay(1)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/answer'), '正解')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/input__answer'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/program_name'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/program_name'), '番組名')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/select_program'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/broadcast_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/select_broadcast'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/number_points'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/input__points'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/earn_coupon'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/earn_coupon'), '獲得クーポン')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/select__coupon'), 0)
		WebUI.scrollToElement(findTestObject('Object Repository/Quiz Create Edit/UI/answer_start'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/answer_start'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/answer_start'), '回答開始時間(時:分:秒)(バナー表示開始時間)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/timepicker_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/ans_end'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/ans_end'), '回答終了時間(時:分:秒)(バナーインアクティブ時間)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/ans_end_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/announce_time'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/announce_time'), '正解発表時間(時:分:秒)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/announce_time_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/present_Img'), 0)
		//WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/present_Img'), 'プレゼント画像')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/button_Upload Image'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz Create Edit/UI/button_Upload Image'))
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/quiz_name'), 'バナーに表示するクイズ名')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/input__QuizName'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/status'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/input__public'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz Create Edit/UI/input__public'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/submit'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz Create Edit/UI/submit'))
	}
	@Keyword
	def verifyAlrtMsg(){
		Lorem lorem1 = LoremIpsum.getInstance()
		String ques = lorem1.getWords(5)
		String ans = lorem1.getWords(2)
		//String ans = lorem1.getParagraphs(1, 1)
		def ans1 = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(28)
		def actualColor = "rgb(220, 96, 96)"
		WebUI.click(findTestObject('Object Repository/Quiz Create Edit/UI/submit'))
		WebUI.scrollToElement(findTestObject('Object Repository/Quiz Create Edit/UI/question'), 0)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/ques_alrt'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/ques_alrt'), '必須項目が入力されていません')
		def color = WebUI.getCSSValue(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/ques_alrt'), 'color')
		WebUI.verifyMatch(color, actualColor, false)
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/textarea__question'), ques)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/ans_alrt'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/ans_alrt'), '必須項目が入力されていません')
		def color1 = WebUI.getCSSValue(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/ans_alrt'), 'color')
		WebUI.verifyMatch(color1, actualColor, false)
		WebUI.delay(1)
		//WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/input__answer'), ans1)
		//WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/16char_alrt'), '16文字以内でご入力ください')
		WebUI.delay(1)
		//WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/UI/input__answer'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/input__answer'), ans)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/program_alrt'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/program_alrt'), '必須項目が入力されていません')
		def color2 = WebUI.getCSSValue(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/program_alrt'), 'color')
		WebUI.verifyMatch(color2, actualColor, false)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Quiz Create Edit/UI/select_program'), '0')

		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/broadcast_alrt'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/broadcast_alrt'), '必須項目が入力されていません')
		def color3 = WebUI.getCSSValue(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/broadcast_alrt'), 'color')
		WebUI.verifyMatch(color3, actualColor, false)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Quiz Create Edit/UI/select_broadcast'), '0')

		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/points alrt'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/points alrt'), '獲得ポイント数か獲得クーポンのどちらかを指定して下さい')
		def color4 = WebUI.getCSSValue(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/points alrt'), 'color')
		WebUI.verifyMatch(color4, actualColor, false)
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/input__points'), '10')
		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/UI/input__points'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/input__points'), '  ')
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/point_hlfwid_alrt'), '半角数字で入力して下さい')

		WebUI.selectOptionByIndex(findTestObject('Object Repository/Quiz Create Edit/UI/select__coupon'), '1')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/coupon_alrt'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/coupon_alrt'), '獲得ポイント数か獲得クーポンのどちらかを指定して下さい')
		def color5 = WebUI.getCSSValue(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/coupon_alrt'), 'color')
		WebUI.verifyMatch(color5, actualColor, false)
		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/UI/input__points'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/input__points'), '10')
		//WebUI.deselectOptionByIndex(findTestObject('Object Repository/Quiz Create Edit/UI/select__coupon'), '1')

		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/start_time_alrt'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/start_time_alrt'), '必須項目が入力されていません')
		def color6 = WebUI.getCSSValue(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/start_time_alrt'), 'color')
		WebUI.verifyMatch(color6, actualColor, false)
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/star_tim_hr'), '20')
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/start_tim_mm'), '30')
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/start_tim_ss'), '45')

		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/end_time_alrt'), '必須項目が入力されていません')
		def color7 = WebUI.getCSSValue(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/end_time_alrt'), 'color')
		WebUI.verifyMatch(color7, actualColor, false)
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/end_tim_hr'), '20')
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/end_tim_mm'), '40')
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/end_tim_ss'), '30')

		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/announce_alrt'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/announce_alrt'), '必須項目が入力されていません')
		def color8 = WebUI.getCSSValue(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/announce_alrt'), 'color')
		WebUI.verifyMatch(color8, actualColor, false)
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/announce_hour'), '21')
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/announce_mm'), '30')
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/announce_ss'), '00')

		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/quiz_name_alrt'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/quiz_name_alrt'), '必須項目が入力されていません')

	}

	@Keyword
	verfyImg(){
		def actualColor = "rgb(220, 96, 96)"
		String filepath = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\tree.JPG"
		String filepath1 = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\tenor.gif"
		String filepath2 = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\hld.png"
		String filepath3 = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\English translation by Harris Rackham reads cherry sakura festival in japan.jpg"
		String filepath4 = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\gift.JPG"

		WebUI.refresh()
		WebUI.scrollToElement(findTestObject('Object Repository/Quiz Create Edit/UI/submit'), 0)
		WebUI.click(findTestObject('Object Repository/Quiz Create Edit/UI/submit'))

		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/img_alrt'), '必須項目が入力されていません')
		def color=WebUI.getCSSValue(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/img_alrt'), 'color')
		WebUI.verifyMatch(color, actualColor, false)
		uploadFile(findTestObject('Object Repository/Quiz Create Edit/UI/button_Upload Image'), filepath)
		WebUI.delay(2)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/5mb_alrt'), '5MB以下のファイルを選択して下さい')
		WebUI.delay(2)
		uploadFile(findTestObject('Object Repository/Quiz Create Edit/UI/button_Upload Image'), filepath1)
		WebUI.delay(2)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/jpg-png_alrt'), 'jpg/pngファイルを選択して下さい')
		WebUI.delay(2)
		uploadFile(findTestObject('Object Repository/Quiz Create Edit/UI/button_Upload Image'), filepath2)
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/clickable'))
		WebUI.delay(2)
		uploadFile(findTestObject('Object Repository/Quiz Create Edit/UI/button_Upload Image'), filepath4)
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/clickable'))
		WebUI.delay(2)
	}
	@Keyword
	def verifyProgramSelect(String role ){

		if (role == "Admin" ||role == "Contents Manager"){
			int TotalOptions = WebUI.getNumberOfTotalOption(findTestObject('Object Repository/Quiz Create Edit/UI/select_program'))
			WebUI.verifyEqual(TotalOptions, 2)
		}
		else{
			int TotalOptions = WebUI.getNumberOfTotalOption(findTestObject('Object Repository/Quiz Create Edit/UI/select_program'))
			WebUI.verifyEqual(TotalOptions, 1)
		}
	}
	@Keyword
	def verifyCheckbox(String role){
		if (role == "Admin" || role == "Contents Manager" || role == "Contents Supplier") {
			WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz Create Edit/UI/input__public'))
		}
		else {
			WebUI.verifyElementNotClickable(findTestObject('Object Repository/Quiz Create Edit/UI/input__public'))
		}
	}

	@Keyword
	def verifyCreate(){
		Lorem lorem1 = LoremIpsum.getInstance()
		String ques = lorem1.getWords(10)
		String ans = lorem1.getWords(1)
		String quiz = lorem1.getWords(2)
		def num = org.apache.commons.lang.RandomStringUtils.randomNumeric(2)

		String filePath = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\gift.JPG"
		WebUI.refresh()
		WebUI.scrollToElement(findTestObject('Object Repository/Quiz Create Edit/UI/question'), 0)
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/textarea__question'), ques)
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/input__answer'), ans)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Quiz Create Edit/UI/select_program'), '0')
		WebUI.delay(1)
		def TotalOptions = WebUI.getNumberOfTotalOption(findTestObject('Object Repository/Quiz Create Edit/UI/select_broadcast'))
		Random ran = new Random()
		int index = ran.nextInt(TotalOptions + 1)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Quiz Create Edit/UI/select_broadcast'), index)
		String set = ""
		if(set == "points"){
			WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/input__points'), num)
		}
		else{
			WebUI.selectOptionByIndex(findTestObject('Object Repository/Quiz Create Edit/UI/select__coupon'), index)
		}
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/star_tim_hr'), '20')
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/start_tim_mm'), '30')
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/start_tim_ss'), '45')
		WebUI.delay(1)

		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/end_tim_hr'), '20')
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/end_tim_mm'), '45')
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/end_tim_ss'), '30')
		WebUI.delay(1)

		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/announce_hour'), '21')
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/announce_mm'), '45')
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/announce_ss'), '00')
		WebUI.delay(2)

		uploadFile(findTestObject('Object Repository/Quiz Create Edit/UI/button_Upload Image'), filePath)
		//uploadFile(findTestObject('Object Repository/Quiz Create Edit/UI/button_Upload Image'), filePath)
		//WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/clickable'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/input__QuizName'), quiz)
		WebUI.click(findTestObject('Object Repository/Quiz Create Edit/UI/input__public'))
		WebUI.click(findTestObject('Object Repository/Quiz Create Edit/UI/submit'))
	}

	@Keyword
	def verifyEditUI(){
		String header = "クイズ管理"
		WebUI.refresh()

		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/edit_UI/edit_header'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/edit_UI/edit_header'), header)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/edit_UI/update'), "更新")
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/edit_UI/quiz_ID'), "クイズID")
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/edit_UI/ques_paper'), '問題文')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/textarea__question'), 0)
		WebUI.delay(1)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/answer'), '正解')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/input__answer'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/program_name'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/program_name'), '番組名')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/select_program'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/broadcast_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/select_broadcast'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/number_points'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/input__points'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/edit_UI/earn_coupon'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/edit_UI/earn_coupon'), '獲得クーポン')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/select__coupon'), 0)
		WebUI.scrollToElement(findTestObject('Object Repository/Quiz Create Edit/edit_UI/ans_start'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/edit_UI/ans_start'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/edit_UI/ans_start'), '回答開始時間(時:分:秒)(バナー表示開始時間)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/alrt_msg/timepicker_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/ans_end'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/ans_end'), '回答終了時間(時:分:秒)(バナーインアクティブ時間)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/ans_end_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/announce_time'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/announce_time'), '正解発表時間(時:分:秒)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/announce_time_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/present_Img'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/present_Img'), 'バナー画像')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/button_Upload Image'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz Create Edit/UI/button_Upload Image'))
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz Create Edit/UI/quiz_name'), 'バナーに表示するクイズ名')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/input__QuizName'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/status'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/input__public'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz Create Edit/UI/input__public'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/UI/submit'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz Create Edit/UI/submit'))
	}

	@Keyword
	def verifyEdit(){
		String filePath1=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\download.jpg'
		Lorem lorem1 = LoremIpsum.getInstance()
		String ques = lorem1.getWords(3)
		String ans = lorem1.getWords(1)
		String quiz = lorem1.getWords(1)
		WebUI.refresh()
		WebUI.scrollToElement(findTestObject('Object Repository/Quiz Create Edit/UI/question'), 0)
		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/UI/textarea__question'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/textarea__question'), ques)
		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/UI/input__answer'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/input__answer'), ans)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Quiz Create Edit/UI/select_program'), '0')
		WebUI.delay(1)
		def TotalOptions = WebUI.getNumberOfTotalOption(findTestObject('Object Repository/Quiz Create Edit/UI/select_broadcast'))
		Random ran = new Random()
		int index = ran.nextInt(TotalOptions + 1)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Quiz Create Edit/UI/select_broadcast'), index)

		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/hour/star_tim_hr'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/star_tim_hr'), '20')
		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/hour/start_tim_mm'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/start_tim_mm'), '35')
		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/hour/start_tim_ss'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/start_tim_ss'), '45')
		WebUI.delay(1)

		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/hour/end_tim_hr'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/end_tim_hr'), '20')
		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/hour/end_tim_mm'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/end_tim_mm'), '45')
		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/hour/end_tim_ss'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/end_tim_ss'), '35')
		WebUI.delay(1)

		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/hour/announce_hour'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/announce_hour'), '21')
		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/hour/announce_mm'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/announce_mm'), '45')
		WebUI.clearText(findTestObject('Object Repository/Quiz Create Edit/hour/announce_ss'))
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/hour/announce_ss'), '00')
		WebUI.delay(2)

		uploadFile(findTestObject('Object Repository/Quiz Create Edit/UI/button_Upload Image'), filePath1)
		WebUI.setText(findTestObject('Object Repository/Quiz Create Edit/UI/input__QuizName'), quiz)
		WebUI.click(findTestObject('Object Repository/Quiz Create Edit/edit_UI/update_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz Create Edit/edit_UI/success'), 0)

	}
	@Keyword
	def verifyContentRegisterRole(String role){
		WebUI.click(findTestObject('Object Repository/Quiz Create Edit/UI/add_btn'))
		WebUI.verifyElementNotClickable(findTestObject('Object Repository/Quiz Create Edit/UI/input__public'))

	}
	def uploadFile(TestObject to, String filePath) {
		WebUI.click(to)
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		WebUI.delay(3)
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}

