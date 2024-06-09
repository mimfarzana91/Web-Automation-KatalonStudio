package coupon_management

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

public class coupon_create_edit {
	@Keyword
	def verifyCouponUI(){
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/coupon_header'), 0)
		WebUI.click(findTestObject('Object Repository/Coupon_Create/UI/add_coupon'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/add_reg_header'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_Create/UI/reg'), '登録')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/coupon name'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_Create/UI/coupon name'), 'クーポン名')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/input__coupon_name'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/coupon_contents'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/textarea__coupon_contents'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/main_img'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/button_Upload_mainImg'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/button_Upload_mainImg'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/coupon_img'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/btn_Upload_coupon_img'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/btn_Upload_coupon_img'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/expire_date'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/datepicker'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/companies'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/textarea__companies'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/precaution'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/textarea__precausion'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/howToUse'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/textarea__howTOuse'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/upper_limit'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/input__upperLimit'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/input__upperLimit'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/number_issues'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/input__number_issues'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/max_number_issues'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/input__maxNumberIssues'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/input__maxNumberIssues'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/program_name'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/select_program'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/broadcast_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/select_broadcast_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/start_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/start_time_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/active_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/active_time_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/banner_img'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/btn_bannerUpload'), 0)
		//WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/btn_bannerUpload'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/banner_title'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/banner_title_input'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/status'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/input__public'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/input__public'))
		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_Create/UI/submit'), '登録')
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/submit'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/cancel'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/cancel'))
	}

	@Keyword
	def verifyBulkUI(){
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/bulk_UI/bulk_reg'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/bulk_UI/label_CSV'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/bulk_UI/upload'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/bulk_UI/upload'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/bulk_UI/register'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/bulk_UI/register'))
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/bulk_UI/cancel'))
	}
	@Keyword
	def verfyAlrtMsg(){
		WebUI.click(findTestObject('Object Repository/Coupon_Create/UI/submit'))
		WebUI.scrollToElement(findTestObject('Object Repository/Coupon_Create/UI/coupon name'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_Create/couponImg_alert/couponImg_alrt'), '必須項目が入力されていません')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/couponImg_alert/couponImg_alrt'), 0)

		def color = WebUI.getCSSValue(findTestObject('Object Repository/Coupon_Create/couponImg_alert/couponImg_alrt'), 'color')
		String expt_color = "rgb(220, 20, 60)"
		WebUI.verifyMatch(color, expt_color, false)
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/input__coupon_name'), 'Joe')

		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/alrt_msg/mainImg_alrt'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_Create/alrt_msg/mainImg_alrt'), '必須項目が入力されていません')
		def color1 = WebUI.getCSSValue(findTestObject('Object Repository/Coupon_Create/alrt_msg/mainImg_alrt'), 'color')
		WebUI.verifyMatch(color1, expt_color, false)

		WebUI.verifyElementPresent(findTestObject('Coupon_Create/couponImg_alert/couponImg_alrt'), 0)
		def color2 = WebUI.getCSSValue(findTestObject('Coupon_Create/couponImg_alert/couponImg_alrt'), 'color')
		WebUI.verifyMatch(color2, expt_color, false)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/alrt_msg/calendar_Alrt'), 0)
		def color3 = WebUI.getCSSValue(findTestObject('Object Repository/Coupon_Create/alrt_msg/calendar_Alrt'), 'color')
		WebUI.verifyMatch(color3, expt_color, false)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/alrt_msg/comp_alrt'), 0)
		def color4 = WebUI.getCSSValue(findTestObject('Object Repository/Coupon_Create/alrt_msg/comp_alrt'), 'color')
		WebUI.verifyMatch(color4, expt_color, false)
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/textarea__companies'), 'Details are given')

		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/alrt_msg/precaution_alrt'), 0)
		def color5 = WebUI.getCSSValue(findTestObject('Object Repository/Coupon_Create/alrt_msg/precaution_alrt'), 'color')
		WebUI.verifyMatch(color5, expt_color, false)
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/textarea__precausion'), "Need precaution")

		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/alrt_msg/howtoUse_alrt'), 0)
		def color6 = WebUI.getCSSValue(findTestObject('Object Repository/Coupon_Create/alrt_msg/howtoUse_alrt'), 'color')
		WebUI.verifyMatch(color6, expt_color, false)
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/textarea__howTOuse'), "Do you know how to use?")

		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/alrt_msg/NoIssues_alrt'), 0)
		def color7 = WebUI.getCSSValue(findTestObject('Object Repository/Coupon_Create/alrt_msg/NoIssues_alrt'), 'color')
		WebUI.verifyMatch(color7, expt_color, false)
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/input__number_issues'), "10")


		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/alrt_msg/program_name_alrt'), 0)
		def color8 = WebUI.getCSSValue(findTestObject('Object Repository/Coupon_Create/alrt_msg/program_name_alrt'), 'color')
		WebUI.verifyMatch(color8, expt_color, false)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Coupon_Create/UI/select_program'), "0")
	}
	@Keyword
	def verifyImage(){
		String filePath = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\ guitar.JPG"
		String filePath1 = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\ hld.PNG"
		String filePath2 = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\ tree.JPG"
		String filePath3 = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\ tenor.gif"
		String filePath4 = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\ resize-images-print-photoshop-share.JPG"

		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/button_Upload_mainImg'), filePath1)
		WebUI.delay(3)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/alrt_msg/mainImg_clickable'))
		WebUI.delay(3)
		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/button_Upload_mainImg'), filePath2)
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('Coupon_Create/alrt_msg/MainImg_5mb'), 0)
		WebUI.delay(2)
		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/button_Upload_mainImg'), filePath3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/alrt_msg/jpg_png-alrt_MainImg'), 0)
		WebUI.delay(2)
		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/button_Upload_mainImg'), filePath4)
		WebUI.delay(3)
		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/button_Upload_mainImg'), filePath)
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/alrt_msg/mainImg_clickable'))
		WebUI.delay(2)

		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/btn_Upload_coupon_img'), filePath1)
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/couponImg_alert/couponImg_alrt'))
		WebUI.delay(2)
		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/btn_Upload_coupon_img'), filePath2)
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/couponImg_alert/5mb_alrt'), 0)
		WebUI.delay(2)
		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/btn_Upload_coupon_img'), filePath3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/couponImg_alert/jpg_png_alrt'), 0)
		WebUI.delay(2)

		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/btn_Upload_coupon_img'), filePath4)
		WebUI.delay(3)
		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/btn_Upload_coupon_img'), filePath)
		WebUI.delay(3)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/couponImg_alert/clickable'))
		WebUI.delay(2)


		/*uploadFile(findTestObject('Object Repository/Coupon_Create/UI/btn_bannerUpload'), filePath2)
		 WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/BnrImg_alrt/5mb_alrt'), 0)
		 WebUI.delay(1)
		 uploadFile(findTestObject('Object Repository/Coupon_Create/UI/btn_bannerUpload'), filePath3)
		 WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/BnrImg_alrt/jpg_png_alrt'), 0)
		 WebUI.delay(1)
		 uploadFile(findTestObject('Object Repository/Coupon_Create/UI/btn_bannerUpload'), filePath1)
		 WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/BnrImg_alrt/clickable'))*/
	}

	@Keyword
	def verifyStatus(String role){
		if (role == "Admin" || role == "Contents Manager" || role == "Contents Supplier") {
			WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/input__public'))
		}
		else {
			WebUI.verifyElementNotClickable(findTestObject('Object Repository/Coupon_Create/UI/input__public'))
		}
	}
	@Keyword
	def verifyCouponCreate(){
		Lorem lorem1 = LoremIpsum.getInstance()
		String name = lorem1.getName()
		String contents = lorem1.getWords(2,2)
		String comp = lorem1.getWords(4, 4)
		String precaution = lorem1.getParagraphs(1, 0)
		String Use = lorem1.getWords(3, 3)
		String BannerTitle = lorem1.getWords(2)
		String filePath1 = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\download.JPG"
		String filepath2 = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\gift.JPG"
		String filepath3 = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\guitar.JPG"
		WebUI.refresh()
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/input__coupon_name'), name)
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/textarea__coupon_contents'), contents)

		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/button_Upload_mainImg'), filePath1)
		WebUI.delay(3)
		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/btn_Upload_coupon_img'), filepath2)
		WebUI.click(findTestObject('Object Repository/Coupon_Create/UI/input__deadline'))
		WebUI.click(findTestObject('Object Repository/Coupon_Create/UI/click_date'))
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/textarea__companies'), comp)
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/textarea__precausion'), precaution)
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/textarea__howTOuse'), Use)
		WebUI.click(findTestObject('Object Repository/Coupon_Create/UI/input__upperLimit'))

		if(WebUI.verifyElementChecked(findTestObject('Object Repository/Coupon_Create/UI/input__upperLimit'), 0, FailureHandling.STOP_ON_FAILURE)){
			WebUI.verifyElementNotClickable(findTestObject('Object Repository/Coupon_Create/UI/input__number_issues'))
		}
		else {
			WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/input__number_issues'), "number of issues are written here")
		}

		WebUI.click(findTestObject('Object Repository/Coupon_Create/UI/input__maxNumberIssues'))
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Coupon_Create/UI/select_program'), "0")
		WebUI.delay(2)

		Random ran = new Random()
		int index = ran.nextInt(WebUI.getNumberOfTotalOption(findTestObject('Object Repository/Coupon_Create/UI/select_broadcast_time')) + 1)

		WebUI.selectOptionByIndex(findTestObject('Object Repository/Coupon_Create/UI/select_broadcast_time'), index)
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/start_hour'), '22')
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/start_min'), '25')
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/start_sec'), '15')

		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/broad_hour'), '22')
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/broad_min'), '35')
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/broad_sec'), '45')
		WebUI.delay(2)

		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/btn_bannerUpload'), filepath3)
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/bnrImg_clickable'))
		WebUI.delay(2)

		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/banner_title_input'), BannerTitle)
		WebUI.click(findTestObject('Object Repository/Coupon_Create/UI/input__public'))
		WebUI.click(findTestObject('Object Repository/Coupon_Create/UI/submit'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/alrt_msg/success_msg'), 0)
	}

	@Keyword
	def verifyEditUI(){
		WebUI.click(findTestObject('Object Repository/Coupon_Create/edit/edit_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/edit/edit_header'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/edit/update'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/edit/coupon_ID'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_Create/edit/coupon_ID'), 'クーポンID')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/edit/item_ID'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_Create/edit/item_ID'), 'アイテムID')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/edit/coupon_name'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_Create/edit/coupon_name'), 'クーポン名')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/input__coupon_name'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/coupon_contents'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/textarea__coupon_contents'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/main_img'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/button_Upload_mainImg'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/button_Upload_mainImg'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/coupon_img'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/btn_Upload_coupon_img'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/btn_Upload_coupon_img'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/expire_date'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/companies'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/textarea__companies'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/precaution'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/textarea__precausion'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/howToUse'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/upper_limit'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/input__upperLimit'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/input__upperLimit'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/number_issues'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/input__number_issues'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/max_number_issues'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/input__maxNumberIssues'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/input__maxNumberIssues'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/program_name'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/select_program'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/broadcast_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/select_broadcast_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/start_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/start_time_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/active_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/active_time_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/banner_img'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/btn_bannerUpload'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/btn_bannerUpload'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/banner_title'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/banner_title_input'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/status'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/UI/input__public'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/UI/input__public'))
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/edit/update_btn'))
	}
	@Keyword()
	def verifyCouponEdit(){
		Lorem lorem1 = LoremIpsum.getInstance()
		String edited_name = lorem1.getName()
		String contents = lorem1.getWords(10)
		String companies = lorem1.getWords(5)
		String howUse = lorem1.getWords(6)
		String precaution = lorem1.getWords(5)
		String filepath = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\chair.JPG"
		String filepath1 = RunConfiguration.getProjectDir().replace("/", "\\") + "\\Data Files\\quiz.JPG"
		WebUI.refresh()
		WebUI.clearText(findTestObject('Object Repository/Coupon_Create/UI/input__coupon_name'))
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/input__coupon_name'), edited_name)
		WebUI.clearText(findTestObject('Object Repository/Coupon_Create/UI/textarea__coupon_contents'))
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/textarea__coupon_contents'), contents)
		WebUI.delay(2)
		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/button_Upload_mainImg'), filepath)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/edit/clickable'))
		WebUI.delay(2)

		uploadFile(findTestObject('Object Repository/Coupon_Create/UI/btn_Upload_coupon_img'), filepath1)
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_Create/edit/coupon_clickable'))
		WebUI.click(findTestObject('Object Repository/Coupon_Create/UI/input__deadline'))
		WebUI.click(findTestObject('Object Repository/Coupon_Create/edit/new_date'))
		WebUI.clearText(findTestObject('Object Repository/Coupon_Create/UI/textarea__companies'))
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/textarea__companies'), companies)
		WebUI.clearText(findTestObject('Object Repository/Coupon_Create/UI/textarea__precausion'))
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/textarea__precausion'), precaution)
		WebUI.delay(1)
		WebUI.clearText(findTestObject('Object Repository/Coupon_Create/edit/clear_howUse'))
		WebUI.setText(findTestObject('Object Repository/Coupon_Create/edit/clear_howUse'), howUse)

		if(WebUI.verifyElementChecked(findTestObject('Object Repository/Coupon_Create/UI/input__upperLimit'), 0, FailureHandling.STOP_ON_FAILURE)){
			WebUI.verifyElementNotClickable(findTestObject('Object Repository/Coupon_Create/UI/input__number_issues'))
		}
		else {
			WebUI.setText(findTestObject('Object Repository/Coupon_Create/UI/input__number_issues'), "number of issues are written here")
		}

		WebUI.click(findTestObject('Object Repository/Coupon_Create/edit/update_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Coupon_Create/edit/success_msg'), 0)
	}

	@Keyword
	def verifyContentRegisterRole(){
		WebUI.click(findTestObject('Object Repository/Coupon_Create/contentRegister/sidebar'))
		WebUI.click(findTestObject('Object Repository/Coupon_Create/contentRegister/add'))
		int TotalOption = WebUI.getNumberOfTotalOption(findTestObject('Object Repository/Coupon_Create/UI/select_program'))
		WebUI.verifyEqual(TotalOption, 1)
		WebUI.verifyElementNotClickable(findTestObject('Object Repository/Coupon_Create/UI/input__public'))
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