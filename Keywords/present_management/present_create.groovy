package present_management

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
import org.apache.commons.lang.RandomStringUtils as RandStr

import internal.GlobalVariable
import com.thedeanda.lorem.Lorem as Lorem
import com.thedeanda.lorem.LoremIpsum as LoremIpsum
import com.kms.katalon.core.configuration.RunConfiguration
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent

public class present_create {

	@Keyword

	def verifyUI(){

		String header1="プレゼント管理"
		String btn="バック"
		String header3=header1 + "\n" + btn

		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/header'), header1)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/reg_div'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/reg_div'), "登録")
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/present_name'), "プレゼント名")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/present_name_input'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/prsnt_content'), "プレゼント内容")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/content_textarea'), 5)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/precaution'), "利用上の注意")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/precaution_textarea'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/present_image'), "プレゼント画像")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/btn_Upload Image'), 2)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Present_management/verify_UI/btn_Upload Image'))
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/deadline'), "応募期限")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/input__deadline'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/app_points'), "必要応募ポイント数(半角数字)")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/input_points'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/program_name'), "番組名")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/select_program_nme'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/broadcast_time'), "番組連動企画放送回(放送開始日時)")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/select_brdcast_time'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/display_starttime'), "バナー表示開始時間(時:分:秒)")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/start_timepicker'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/banner_activetime'), "バナーインアクティブ時間(時:分:秒)")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/active_timepicker'), 5)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/status'), "一般公開")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/checkbox'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/submit'), "登録")
		WebUI.verifyElementClickable(findTestObject('Object Repository/Present_management/verify_UI/submit'))
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/cancelbtn'), 2)
		//WebUI.verifyElementClickable(findTestObject('Object Repository/Present_management/verify_UI/cancelbtn'))
	}
	@Keyword
	def verifyBulkUI(){

		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/bulk_div/bulk'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/bulk_div/bulk'), "一括登録")
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/bulk_div/csv_file'), "CSVファイルをアップロード")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/bulk_div/upload_csv'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Present_management/bulk_div/upload_csv'))
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/bulk_div/bulk_reg'), "登録")
		WebUI.verifyElementClickable(findTestObject('Object Repository/Present_management/bulk_div/bulk_reg'))
		WebUI.verifyElementClickable(findTestObject('Object Repository/Present_management/bulk_div/bulk_cancel'))
	}

	@Keyword
	def verifyAlertMessages(){
		WebUI.scrollToElement(findTestObject('Object Repository/Present_management/verify_UI/header'), 2)
		WebUI.click(findTestObject('Object Repository/Present_management/verify_UI/submit'))
		WebUI.scrollToElement(findTestObject('Object Repository/Present_management/alert_msg/present_name_alrt'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/alert_msg/present_name_alrt'), '必須項目が入力されていません')

		String color = WebUI.getCSSValue(findTestObject('Object Repository/Present_management/alert_msg/css_present_name_alrt'), "color")
		String expectedcolor = "rgb(220, 96, 96)"
		WebUI.verifyEqual(color, expectedcolor)

		Lorem lorem1 = LoremIpsum.getInstance();
		String name = lorem1.getName()
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/present_name_input'), name)

		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/alert_msg/present_content_alrt'), "必須項目が入力されていません")
		String color2 = WebUI.getCSSValue(findTestObject('Object Repository/Present_management/alert_msg/present_content_alrt'), 'color')
		WebUI.verifyMatch(color, expectedcolor, false)
		String content = lorem1.getParagraphs(2, 1)
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/content_textarea'), content)

		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/alert_msg/precaution_alrt'), '必須項目が入力されていません')
		String color3 = WebUI.getCSSValue(findTestObject('Object Repository/Present_management/alert_msg/precaution_alrt'), 'color')
		WebUI.verifyEqual(color3, expectedcolor)
		String precaution = lorem1.getParagraphs(2, 2)
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/content_textarea'), precaution)

		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/alert_msg/deadline_alrt'), '必須項目が入力されていません')
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/alert_msg/app_point_alrt'), '必須項目が入力されていません')
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/input_points'), "asfdg")
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/alert_msg/app_point_alrt'), '半角数字で入力して下さい')
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/input_points'), '10')
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/alert_msg/program_nam-alrt'), '必須項目が入力されていません')
	}

	@Keyword
	def verifyImage(){
		String filepath = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\resize-images-print-photoshop-share.JPG'
		String filepath1 = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\tree.JPG'
		String filepath2 = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\tenor.gif'
		String filepath3 = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\gift.JPG'

		uploadFile(findTestObject('Object Repository/Present_management/verify_UI/btn_Upload Image'), filepath)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Present_management/verify_UI/img_link'))
		WebUI.delay(2)

		uploadFile(findTestObject('Object Repository/Present_management/verify_UI/btn_Upload Image'), filepath1)
		WebUI.delay(2)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/warn'), "5MB以下のファイルを選択して下さい")
		WebUI.delay(2)

		uploadFile(findTestObject('Object Repository/Present_management/verify_UI/btn_Upload Image'), filepath2)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/jpg_alrt'), "jpg/pngファイルを選択して下さい")
		WebUI.delay(2)

		uploadFile(findTestObject('Object Repository/Present_management/verify_UI/btn_Upload Image'), filepath3)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Present_management/verify_UI/link'))
	}

	@Keyword

	def verifySelectBox(String role){
		if (role == "Admin" ||role == "Contents Manager"){
			int TotalOptn = WebUI.getNumberOfTotalOption(findTestObject('Object Repository/Present_management/selectverify/select_program_name'))
			WebUI.verifyEqual(TotalOptn, 2)
		}
		else {
			int TotalOptn = WebUI.getNumberOfSelectedOption(findTestObject('Object Repository/Present_management/selectverify/select_program_name'))
			WebUI.verifyEqual(TotalOptn, 1)
		}
	}

	@Keyword
	def verifyCheckbox(String role){
		if (role == "Admin" || role == "Contents Manager" || role == "Contents Supplier") {
			WebUI.verifyElementClickable(findTestObject('Object Repository/Present_management/verify_UI/status'))
		}
		else {
			WebUI.verifyElementNotClickable(findTestObject('Object Repository/Present_management/verify_UI/status'))
		}
	}

	@Keyword
	def verifyAddPresent(){
		Lorem lorem1= LoremIpsum.getInstance()
		String name = lorem1.getName()
		String content = lorem1.getParagraphs(1, 1)
		String precaution = lorem1.getParagraphs(1, 1)
		WebUI.refresh()
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/present_name_input'), name)
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/content_textarea'), content)
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/precaution_textarea'), precaution)

		String filepath4 = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\gift.JPG'
		uploadFile(findTestObject('Object Repository/Present_management/verify_UI/btn_Upload Image'), filepath4)

		Date today = new Date()
		String todaysDate = today.format('YYYYMMDD-hhmm')
		String Name = 'auto_eng ' + todaysDate
		WebUI.comment(Name)
		//WebUI.executeJavaScript("document.getElementsByClassName('form-control ng-valid ng-touched ng-dirty')[11].removeAttribute('readonly');", null)
		//WebUI.sendKeys(findTestObject('Object Repository/Present_management/verify_UI/input_start_Date'), Name)
		//WebUI.selectOptionByValue(findTestObject('Object Repository/Present_management/verify_UI/start_timepicker'), Name)
		WebUI.click(findTestObject('Object Repository/Present_management/verify_UI/calendar_click'))
		WebUI.click(findTestObject('Object Repository/Present_management/verify_UI/calendar_frame'))
		WebUI.click(findTestObject('Object Repository/Present_management/verify_UI/current_date'))

		def points = org.apache.commons.lang.RandomStringUtils.randomNumeric(2)
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/input_points'), points)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Present_management/verify_UI/select_program_nme'), '0')
		//WebUI.selectOptionByIndex(findTestObject('Object Repository/Present_management/verify_UI/select_brdcast_time'), '2')
		WebUI.click(findTestObject('Object Repository/Present_management/verify_UI/submit'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/alert_msg/success_msg'), 2)
	}

	@Keyword
	def VerifyPresentEditPageUI(){


		String header1="プレゼント管理"
		String btn="バック"
		String header3=header1 + "\n" + btn

		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/header'), 'プレゼント管理')
		//WebUI.verifyElementClickable(findTestObject('Object Repository/Present_management/verify_UI/back_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/alert_msg/update_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/EditUI/present_id'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/EditUI/present_name'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/present_name_input'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/prsnt_content'), "プレゼント内容")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/content_textarea'), 5)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/precaution'), "利用上の注意")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/precaution_textarea'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/present_image'), "プレゼント画像")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/btn_Upload Image'), 2)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Present_management/verify_UI/btn_Upload Image'))
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/deadline'), "応募期限")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/input__deadline'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/app_points'), "必要応募ポイント数(半角数字)")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/input_points'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/program_name'), "番組名")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/select_program_nme'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/broadcast_time'), "番組連動企画放送回(放送開始日時)")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/select_brdcast_time'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/display_starttime'), "バナー表示開始時間(時:分:秒)")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/start_timepicker'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_management/verify_UI/banner_activetime'), "バナーインアクティブ時間(時:分:秒)")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/active_timepicker'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/EditUI/status'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/checkbox'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/EditUI/update_btn'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/verify_UI/cancelbtn'), 2)
		//WebUI.verifyElementClickable(findTestObject('Object Repository/Present_management/verify_UI/cancelbtn'))
	}


	@Keyword
	def verifypresentUpdate(){
		Lorem lorem1= LoremIpsum.getInstance()
		String name1 = lorem1.getName()
		String content1 = lorem1.getParagraphs(1, 1)
		String precaution1 = lorem1.getParagraphs(1, 1)
		WebUI.refresh()
		WebUI.clearText(findTestObject('Object Repository/Present_management/verify_UI/present_name_input'))
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/present_name_input'), name1)
		WebUI.clearText(findTestObject('Object Repository/Present_management/verify_UI/content_textarea'))
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/content_textarea'), content1)
		WebUI.clearText(findTestObject('Object Repository/Present_management/verify_UI/precaution_textarea'))
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/precaution_textarea'), precaution1)
		String filepath4 = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\gift.JPG'
		uploadFile(findTestObject('Object Repository/Present_management/verify_UI/btn_Upload Image'), filepath4)
		def points1 = org.apache.commons.lang.RandomStringUtils.randomNumeric(2)
		WebUI.clearText(findTestObject('Object Repository/Present_management/verify_UI/input_points'))
		WebUI.setText(findTestObject('Object Repository/Present_management/verify_UI/input_points'), points1)
		WebUI.click(findTestObject('Object Repository/Present_management/EditUI/update_btn'))
		WebUI.delay(1)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_management/EditUI/div_Close'), 2)
	}
	@Keyword
	def verifyContentRegisterRole(role){


		WebUI.verifyElementNotClickable(findTestObject('Object Repository/Present_management/alert_msg/status_not_clickable'))
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