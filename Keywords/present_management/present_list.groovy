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

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.thedeanda.lorem.Lorem as Lorem
import com.thedeanda.lorem.LoremIpsum as LoremIpsum
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

import internal.GlobalVariable

public class present_list {
	@Keyword
	def uiVerification(){
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_list/present_UI/header'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_list/present_UI/add_btn'), 5)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_list/present_UI/present_ID'), 'プレゼントID')
		WebUI.verifyElementText(findTestObject('Object Repository/Present_list/present_UI/item_id'), 'アイテムID')
		WebUI.verifyElementText(findTestObject('Object Repository/Present_list/present_UI/present_name'), 'プレゼント名')
		WebUI.verifyElementText(findTestObject('Object Repository/Present_list/present_UI/program_name'), '番組名')
		WebUI.verifyElementText(findTestObject('Object Repository/Present_list/present_UI/date'), '応募期限')
		WebUI.verifyElementText(findTestObject('Object Repository/Present_list/present_UI/status'), 'ステータス')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_list/present_UI/edit_table'), 0)
	}

	@Keyword
	def tableVerification(){
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_list/table_div/tab_div'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_list/table_div/header_pagination_div'), 2)
	}
	@Keyword
	def VerifyaddButton(){
		String header1="プレゼント管理"
		String header2= "バック"
		String header3=header1 + "\n" + header2
		WebUI.click(findTestObject('Object Repository/Present_list/present_UI/add_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_list/Addbutton_verify/addbutton/header'), 1)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_list/Addbutton_verify/addbutton/header'), header1)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_list/Addbutton_verify/addbutton/registration'), '登録')
		//WebUI.verifyElementPresent(findTestObject('Object Repository/Present_list/Addbutton_verify/addbutton/back_btn'), 2)
		WebUI.back()
	}

	@Keyword
	def verifyEdit(){
		String headerN="プレゼント管理"
		String headerM="バック"
		String headerO=headerN + "\n" + headerM
		WebUI.click(findTestObject('Object Repository/Present_list/Page_editPresent/edit_btn'))
		//WebUI.verifyElementClickable(findTestObject('Object Repository/Present_list/Page_editPresent/back'))
		WebUI.verifyElementText(findTestObject('Object Repository/Present_list/Page_editPresent/header_div'), headerN)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_list/Page_editPresent/update2'), 2)

		Lorem loremN = LoremIpsum.getInstance();
		String presentName=loremN.getName();
		String precaution= loremN.getParagraphs(1, 1);

		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_list/Page_editPresent/present_name'), 2)
		WebUI.clearText(findTestObject('Object Repository/Present_list/Page_editPresent/input__present_name'))
		WebUI.setText(findTestObject('Object Repository/Present_list/Page_editPresent/input__present_name'), presentName)

		//WebUI.verifyElementPresent(findTestObject('Object Repository/Present_list/Page_editPresent/present_content'), 0)
		WebUI.setText(findTestObject('Object Repository/Present_list/Page_editPresent/present_content__details'), "This is details where...")
		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_list/Page_editPresent/precaution'), 0)
		WebUI.setText(findTestObject('Object Repository/Present_list/Page_editPresent/precaution_details'), precaution)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Present_list/Page_editPresent/presentImage'), 0)
		WebUI.delay(5)
		String filePath = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\succu.JPG'
		uploadFile(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/Page_SxTvappAdmin/button_Upload Image'), filePath)
		WebUI.delay(2)

		WebUI.verifyElementText(findTestObject('Object Repository/Present_list/Page_editPresent/WARN'), '5MB以下のファイルを選択して下さい')
		WebUI.delay(2)
		String filePath2= RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\gift.JPG'
		uploadFile(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/Page_SxTvappAdmin/button_Upload Image'), filePath2)
		WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/Present_list/Page_editPresent/img_upload_msg'), '登録済の画像を確認する')
		WebUI.verifyElementClickable(findTestObject('Object Repository/Present_list/Page_editPresent/img_upload_msg'))

		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/app_points'), 2)
		WebUI.clearText(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/app_points_placeholder'))
		WebUI.setText(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/app_points_placeholder'), '10')

		WebUI.delay(2)
		WebUI.scrollToElement(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/broadcast_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/broadcast_time'), 0)
		WebUI.delay(5)

		WebUI.click(findTestObject('Object Repository/Content_management/verifyEdit/update_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/verifyEdit/success_msg'), 0)
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
	def verifyContentregisterLogin(String Email, String pass, String Role){
		WebUI.click(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/login_content_register/Logout_arrow'))
		WebUI.click(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/login_content_register/Logout'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/login_content_register/input__form-control ng-untouched ng-pristine ng-invalid'), Email)
		WebUI.setText(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/login_content_register/pass'), pass)
		WebUI.click(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/login_content_register/button_'))
	}

	@Keyword
	def verifycontentRegisterAccess(String status){
		WebUI.click(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/content_register_edit/present_sidebar'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/Present_list/Page_editPresent/edit_contentReg'))

		if (status == "公開"){

			WebUI.verifyElementNotClickable(findTestObject('Content_management/verifyEdit/Page_edit/content_register_edit/btn_not_clickable'))
		}

		else {
		}
	}
}
