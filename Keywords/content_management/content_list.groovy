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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable

import com.thedeanda.lorem.Lorem as Lorem
import com.thedeanda.lorem.LoremIpsum as LoremIpsum

import org.junit.*;
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent


public class content_list {
	@Keyword
	def uiVerification(){

		WebUI.verifyTextPresent('コンテンツ管理', false)
		WebUI.verifyElementText(findTestObject('Content_management/uiVerification/add_button'), '追加')
		WebUI.verifyElementText(findTestObject('Content_management/uiVerification/content_id'), 'コンテンツID')
		WebUI.verifyElementText(findTestObject('Content_management/uiVerification/content_name'), 'コンテンツ名')
		WebUI.verifyElementText(findTestObject('Content_management/uiVerification/program_name'), '番組名')
		//WebUI.verifyElementText(findTestObject('Content_management/uiVerification/representation'),'固定表示枠')
		WebUI.verifyElementText(findTestObject('Content_management/uiVerification/start_date'), '表示開始日時')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/uiVerification/status'), 0)

	}

	@Keyword
	def tableVerification(){

		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/Page_SxTvappAdmin/Page_SxTvappAdmin/table_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/Page_SxTvappAdmin/tab_div'), 0)
	}

	@Keyword
	def verifyingAddButton(){
		WebUI.click(findTestObject('Object Repository/Content_management/uiVerification/add_button'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/verifyAddbutton/content_management_header'), 5)
		//WebUI.verifyElementHasAttribute(findTestObject('Object Repository/Content_management/verifyAddbutton/registration_div'), '登録', 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/verifyAddbutton/registration_div'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_management/verifyAddbutton/registration_div'),'登録')
		WebUI.back()
	}

	@Keyword
	def verifyEditUpdate(){

		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/td_'), 0)
		WebUI.click(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/button_'))
		WebUI.verifyElementPresent(findTestObject('Content_management/verifyEdit/content_mng'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/verifyEdit/update'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_management/verifyEdit/content_id'), 'コンテンツID')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/verifyEdit/content_name'), 5)
		WebUI.clearText(findTestObject('Object Repository/Content_management/verifyEdit/content_nm_placeholder'))
		WebUI.delay(5)

		Lorem lorem1 = LoremIpsum.getInstance()
		String name = lorem1.getFirstName()
		WebUI.setText(findTestObject('Object Repository/Content_management/verifyEdit/content_nm_placeholder'), name)

		WebUI.verifyElementText(findTestObject('Object Repository/Content_management/verifyEdit/content_des'), 'コンテンツ詳細情報')
		WebUI.clearText(findTestObject('Object Repository/Content_management/verifyEdit/des_placeholder'))
		def desc = org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(100)
		WebUI.setText(findTestObject('Object Repository/Content_management/verifyEdit/des_placeholder'), desc)

		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/verifyEdit/content_img'), 5)
		String filePath = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\tree.JPG'
		uploadFile(findTestObject('Object Repository/Content_management/verifyEdit/upload'), filePath)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_management/verifyEdit/upload_warn'), '5MB以下のファイルを選択して下さい')

		String filePath1 = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\chair.JPG'
		uploadFile(findTestObject('Object Repository/Content_management/verifyEdit/upload'), filePath1)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/verifyEdit/upload_img'), 5)

		WebUI.verifyElementText(findTestObject('Object Repository/Content_management/verifyEdit/content_video'),'コンテンツ動画' )

		String filePath3=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\video.MP4'
		uploadFile(findTestObject('Object Repository/Content_management/verifyEdit/upload_video'), filePath3)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Content_management/verifyEdit/registered_url_video'))

		WebUI.scrollToElement(findTestObject('Object Repository/Content_management/verifyEdit/category'), 5)
		WebUI.verifyElementText(findTestObject('Object Repository/Content_management/verifyEdit/category'), 'カテゴリ(固定タグ)')
		//WebUI.selectOptionByIndex(findTestObject('Object Repository/Content_management/verifyEdit/cat_dropdown'), 1)

		WebUI.verifyElementText(findTestObject('Object Repository/Content_management/verifyEdit/arb_tag'), '任意タグ(”,”区切りで入力)')
		WebUI.setText(findTestObject('Object Repository/Content_management/verifyEdit/arb_tag_placeholder'), 'コンテンツ,タグtest,タグ1,タグ')

		WebUI.verifyElementText(findTestObject('Object Repository/Content_management/verifyEdit/program_name'), '番組名')
		WebUI.click(findTestObject('Content_management/verifyEdit/Page_edit/prgm_dropdown'))
		WebUI.delay(3)

		WebUI.verifyElementText(findTestObject('Object Repository/Content_management/verifyEdit/item'), '紐付けアイテム')
		WebUI.click(findTestObject('Object Repository/Content_management/verifyEdit/update_btn'))

		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/verifyEdit/Page_SxTvappAdmin/div_Close'), 0)

		WebUI.click(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/verify/edit'))
		String contentName = WebUI.getAttribute(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/verify/content__name'), 'value')

		if ( contentName == name){
			print('verified successfully')
		}
		else{
			print('did not match')
		}

		WebUI.click(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/login_content_register/Logout_arrow'))
		WebUI.click(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/login_content_register/Logout'))
		WebUI.delay(2)
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

	@Keyword

	def verifyContentRegisterAccess(){
		WebUI.click(findTestObject('Object Repository/content_registerAccess/content_sidebar'))
		WebUI.click(findTestObject('Object Repository/content_registerAccess/edit_btn'))
		WebUI.verifyElementNotClickable(findTestObject('Object Repository/content_registerAccess/not_clickable'))

		String status =""

		if (status == "非公開"){

			WebUI.verifyElementClickable(findTestObject('Object Repository/content_registerAccess/update'))

		}
		else{
			//WebUI.verifyElementNotClickable(findTestObject('Object Repository/content_registerAccess/update'))
		}
	}
}
