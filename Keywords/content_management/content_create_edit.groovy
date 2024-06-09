package content_management

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
import internal.GlobalVariable

public class content_create_edit {
	@Keyword
	def verifyContentUI(){
		String header1 = "コンテンツ管理"
		String header2 = "追加"
		String header = header1 + "\n" + header2

		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/content_header'), header)
		WebUI.click(findTestObject('Object Repository/Content_Create/UI/add_btn'))
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/content_add_header'), 'コンテンツ管理')
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/register_header'), '登録')
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/con_name'), 'コンテンツ名')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/input__cont_name'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/detail_info'), 'コンテンツ詳細情報')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/textarea__detail_info'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/cont_image'), 'コンテンツ画像')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/Upload Image'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/UI/Upload Image'))
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/video_text'),'コンテンツ動画')
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/cat'), 'カテゴリ(固定タグ)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/select_cat'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/tag'), '任意タグ(”,”区切りで入力)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/input_tag'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/program_name'), '番組名')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/select_program'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/tie_item'), '紐付けアイテム')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/select-item'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/broadcast_time'), '番組連動企画放送回(放送開始日時)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/select_broadcast_time'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/archive_date_time'), 'アーカイブ表示開始日時')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/archive_date_time_div'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/start_time'), 'バナー表示開始時間(時:分:秒)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/start_timepicker'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/banner_active_time'), 'バナーインアクティブ時間(時:分:秒)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/banner_active_timepicker'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/banner_image'), 'バナー画像')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/banner_Upload Image'), 0)
		WebUI.delay(2)
		WebUI.verifyElementNotClickable(findTestObject('Object Repository/Content_Create/UI/banner_Upload Image'))
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/banner_title'), 'バナータイトル')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/input__banner_title'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/Status'), '一般公開')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/checkbox'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/UI/checkbox'))
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/register_btn'), '登録')
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/UI/register_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/cancel'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/UI/cancel'))
		WebUI.delay(2)
	}

	@Keyword
	def verifyContentBulkUI(){
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/bulk_ui/bulk_reg_header'), '一括登録')
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/bulk_ui/upload_label_CSV'), 'CSVファイルをアップロード')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/bulk_ui/upload'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/bulk_ui/upload'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/bulk_ui/submit'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/bulk_ui/submit'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/bulk_ui/cancel'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/bulk_ui/cancel'))
		WebUI.delay(3)
	}
	@Keyword
	def verifyAlertmsg(){
		Lorem lorem1 = LoremIpsum.getInstance()
		String name = lorem1.getName()

		WebUI.click(findTestObject('Object Repository/Content_Create/UI/register_btn'))
		WebUI.scrollToElement(findTestObject('Object Repository/Content_Create/UI/register_header'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/alrt_msg/content_name_alt'), '必須項目が入力されていません')
		def Color = WebUI.getCSSValue(findTestObject('Object Repository/Content_Create/alrt_msg/content_name_alt'), 'color')
		String alrtColor = 'rgb(220, 96, 96)'
		WebUI.verifyMatch(Color,alrtColor, false)
		WebUI.setText(findTestObject('Object Repository/Content_Create/UI/input__cont_name'), name)

		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/alrt_msg/catgory_alt'), '必須項目が入力されていません')
		def color1 = WebUI.getCSSValue(findTestObject('Object Repository/Content_Create/alrt_msg/catgory_alt'), 'color')
		WebUI.verifyMatch(color1, alrtColor, false)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Content_Create/UI/select_cat'), '1')

		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/alrt_msg/program_name_alrt'), '必須項目が入力されていません')
		def color2 = WebUI.getCSSValue(findTestObject('Object Repository/Content_Create/alrt_msg/program_name_alrt'), 'color')
		WebUI.verifyMatch(color2, alrtColor, false)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Content_Create/UI/select_program'), '1')
	}
	@Keyword
	def verifyItemBox(){
		WebUI.scrollToElement(findTestObject('Object Repository/Content_Create/UI/select_program'), 0)
		WebUI.click(findTestObject('Object Repository/Content_Create/UI/select-item'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Content_Create/logout/type_item'), 'サン')
		WebUI.click(findTestObject('Object Repository/Content_Create/logout/item_box'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Content_Create/logout/item_box'))
		WebUI.click(findTestObject('Object Repository/Content_Create/logout/item_box'))
		WebUI.click(findTestObject('Object Repository/Content_Create/logout/item_box'))
		WebUI.click(findTestObject('Object Repository/Content_Create/logout/item_box'))
		WebUI.click(findTestObject('Object Repository/Content_Create/logout/item_box'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/logout/warn'), 0)
		WebUI.click(findTestObject('Object Repository/Content_Create/logout/ok_btn'))
	}
	@Keyword
	def verifyPartialRequired(){
		String alrtcolor = 'rgb(220, 96, 96)'
		WebUI.click(findTestObject('Object Repository/Content_Create/alrt_msg/calendar_field'))
		WebUI.click(findTestObject('Object Repository/Content_Create/alrt_msg/deadline'))
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/hour'), '22')
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/min'), '30')
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/sec'), '15')
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/banner_hour'), '00')
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/banner_min'), '40')
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/bnr_sec2'), '30')
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Content_Create/UI/banner_active_time'))
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/alrt_msg/alrt_banner_active_hour'), '必須項目が入力されていません')
		def color1 = WebUI.getCSSValue(findTestObject('Object Repository/Content_Create/alrt_msg/alrt_banner_active_hour'), 'color')
		WebUI.verifyMatch(color1, alrtcolor, false)
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/active_hr2'), '00')
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/active_mm2'), '45')
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/active_sec2'), '45')
	}

	@Keyword
	def verifyImageAndVideo() {
		String filePath1=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\tree.jpg'
		String filePath2=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\tenor.gif'
		String filePath3=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\resize-images-print-photoshop-share.jpg'
		String filePath4=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\chair.JPG'
		String filePath5=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\hld.png'
		String filePath6=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\little.jpg'
		String filePath7=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\video.mp4'
		String filePath8=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\SampleVideo_supersimple_video_super_simple111.mp4'
		//String filePath9=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\testvideo.db'

		WebUI.refresh()
		WebUI.click(findTestObject('Object Repository/Content_Create/UI/register_btn'))
		WebUI.scrollToElement(findTestObject('Object Repository/Content_Create/UI/register_header'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/alrt_msg/upload_image_alt'), "必須項目が入力されていません")
		uploadFile(findTestObject('Object Repository/Content_Create/UI/Upload Image'), filePath1)
		WebUI.delay(1)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/alrt_msg/div_5MB_alrt'), '5MB以下のファイルを選択して下さい')
		WebUI.delay(1)

		uploadFile(findTestObject('Object Repository/Content_Create/UI/Upload Image'), filePath2)
		WebUI.delay(2)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/alrt_msg/jpg_png'), 'jpg/pngファイルを選択して下さい')
		WebUI.delay(2)

		uploadFile(findTestObject('Object Repository/Content_Create/UI/Upload Image'), filePath3)
		WebUI.delay(2)

		uploadFile(findTestObject('Object Repository/Content_Create/UI/Upload Image'), filePath4)
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/alrt_msg/img_clickable'))
		WebUI.delay(2)

		uploadFile(findTestObject('Object Repository/Content_Create/UI/Upload Image'), filePath5)
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/alrt_msg/img_clickable'))
		WebUI.delay(5)

		uploadFile(findTestObject('Object Repository/Content_Create/UI/Upload Video'), filePath6)
		WebUI.delay(5)

		WebUI.uploadFile(findTestObject('Object Repository/Content_Create/UI/Upload Video'), filePath8)
		WebUI.delay(5)

		//uploadFile(findTestObject('Object Repository/Content_Create/UI/Upload Video'), filePath9)
		//WebUI.delay(1)

		uploadFile(findTestObject('Object Repository/Content_Create/UI/Upload Video'), filePath7)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/alrt_msg/video_clickable'))
		WebUI.delay(2)

		//Banner Image validation check below 

		/*uploadFile(findTestObject('Object Repository/Content_Create/UI/banner_Upload Image'), filePath6)
		WebUI.delay(1)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/banner_5mb_alert'), '5MB以下のファイルを選択して下さい')

		uploadFile(findTestObject('Object Repository/Content_Create/UI/banner_Upload Image'), filePath3)
		WebUI.delay(1)

		uploadFile(findTestObject('Object Repository/Content_Create/UI/banner_Upload Image'), filePath2)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/banner_jpg_alert'), 'jpg/pngファイルを選択して下さい')
		WebUI.delay(1)

		uploadFile(findTestObject('Object Repository/Content_Create/UI/banner_Upload Image'), filePath4)
		WebUI.delay(1)

		uploadFile(findTestObject('Object Repository/Content_Create/UI/banner_Upload Image'), filePath5)
		WebUI.delay(1)*/

	}

	@Keyword
	def verifyCheckBox(String role){
		if (role == "Admin" || role == "Contents Manager" || role == "Contents Supplier") {
			WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/UI/checkbox'))
		}
		else {
			WebUI.verifyElementNotClickable(findTestObject('Object Repository/Content_Create/UI/checkbox'))
		}
	}
	@Keyword
	def verifyContentRegistration(){
		Lorem lorem1=LoremIpsum.getInstance()
		String name = lorem1.getName()
		String info = lorem1.getParagraphs(1, 1)
		String title = lorem1.getWords(3)

		WebUI.refresh()
		WebUI.setText(findTestObject('Object Repository/Content_Create/UI/input__cont_name'), name )
		WebUI.setText(findTestObject('Object Repository/Content_Create/UI/textarea__detail_info'), info )
		WebUI.delay(1)

		String image = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\gift.JPG'
		String video1 = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\video.MP4'
		String banner = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\guiter.JPG'

		uploadFile(findTestObject('Object Repository/Content_Create/UI/Upload Image'), image)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/alrt_msg/img_clickable'))
		WebUI.delay(4)
		uploadFile(findTestObject('Object Repository/Content_Create/UI/Upload Video'), video1)
		WebUI.delay(5)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/alrt_msg/video_clickable'))
		WebUI.delay(1)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Content_Create/UI/select_cat'), '1')
		WebUI.setText(findTestObject('Object Repository/Content_Create/UI/input_tag'), 'age,moment,capture')
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Content_Create/UI/select_program'), '0')
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Content_Create/UI/select_broadcast_time'), '1')
		WebUI.click(findTestObject('Object Repository/Content_Create/alrt_msg/calendar_field'))
		WebUI.click(findTestObject('Object Repository/Content_Create/alrt_msg/deadline'))
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/hour'), '22')
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/min'), '30')
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/sec'), '30')
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/banner_hour'), '00')
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/banner_min'), '40')
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/bnr_sec2'), '30')
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/active_hr2'), '00')
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/active_mm2'), '45')
		WebUI.setText(findTestObject('Object Repository/Content_Create/alrt_msg/active_sec2'), '45')
		WebUI.delay(2)
		//uploadFile(findTestObject('Object Repository/Content_Create/UI/button_Uploadimage'), banner)
		//WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/UI/banner_img_click'))
		WebUI.setText(findTestObject('Object Repository/Content_Create/UI/input__banner_title'), title)
		WebUI.click(findTestObject('Object Repository/Content_Create/UI/checkbox'))
		WebUI.click(findTestObject('Object Repository/Content_Create/UI/register_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/alrt_msg/success_msg'), 0)
	}

	@Keyword
	def verifyEditUI(){

		WebUI.click(findTestObject('Object Repository/Content_Create/UpdateUI/edit'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UpdateUI/update_header'), 1)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UpdateUI/update_header'), 'コンテンツ管理')
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UpdateUI/update'), '更新')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UpdateUI/content_ID'), 0)
		WebUI.delay(1)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UpdateUI/content_nam'), 'コンテンツ名')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/input__cont_name'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/detail_info'), 'コンテンツ詳細情報')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/textarea__detail_info'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/cont_image'), 'コンテンツ画像')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/Upload Image'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/UI/Upload Image'))
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/video_text'),'コンテンツ動画')
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/cat'), 'カテゴリ(固定タグ)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/select_cat'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/tag'), '任意タグ(”,”区切りで入力)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/input_tag'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/program_name'), '番組名')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/select_program'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/tie_item'), '紐付けアイテム')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/select-item'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/broadcast_time'), '番組連動企画放送回(放送開始日時)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/select_broadcast_time'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/archive_date_time'), 'アーカイブ表示開始日時')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/archive_date_time_div'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/start_time'), 'バナー表示開始時間(時:分:秒)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/start_timepicker'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/banner_active_time'), 'バナーインアクティブ時間(時:分:秒)')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/banner_active_timepicker'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/banner_image'), 'バナー画像')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/banner_Upload Image'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/UI/banner_Upload Image'))
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/banner_title'), 'バナータイトル')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/input__banner_title'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_Create/UI/Status'), '一般公開')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UI/checkbox'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/UI/checkbox'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/UpdateUI/update_btn'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/UpdateUI/update_btn'))
	}

	@Keyword
	def verifyUpdateContent(){
		Lorem lorem1 = LoremIpsum.getInstance()
		String Content_Name = lorem1.getName()
		String UpdateImage = RunConfiguration.getProjectDir().replace("/", "\\") + 'Data Files\\guiter.JPG'
		WebUI.refresh()
		WebUI.clearText(findTestObject('Object Repository/Content_Create/UI/input__cont_name'))
		WebUI.setText(findTestObject('Object Repository/Content_Create/UI/input__cont_name'), Content_Name)
		WebUI.uploadFile(findTestObject('Object Repository/Content_Create/UI/Upload Image'), UpdateImage)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_Create/alrt_msg/img_clickable'))
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Content_Create/UI/select_cat'), '0')
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Content_Create/UI/select_program'), '0')
		WebUI.click(findTestObject('Object Repository/Content_Create/UpdateUI/update_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_Create/Update/update_success'), 0)
	}

	@Keyword
	def verifyContentRegisterRole(String role){
		WebUI.click(findTestObject('Object Repository/Content_Create/UI/sidebar_content'))
		WebUI.click(findTestObject('Object Repository/Content_Create/UI/add_btn'))
		WebUI.verifyElementNotClickable(findTestObject('Object Repository/Content_Create/UI/checkbox'))
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
