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

public class quiz_list {

	@Keyword

	def verifyQuizlistUI(){

		String header1= 'クイズ管理'
		String btn= '追加'
		String Header= header1 + '\n' + btn

		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/header_quiz'), Header)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/add_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/quiz_ID'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/quiz_ID'), 'クイズID')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/question'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/question'), '問題文')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/reply'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/reply'), '回答')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/program_name'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/program_name'), '番組名')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/status'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/status'), 'ステータス')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/edit_column'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/edit_btn'))
	}

	@Keyword

	def verifyTable(){
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/tbl_div'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/full_tab'), 0)
	}

	@Keyword

	def verifyAddbutton(){
		String AddHeader = 'クイズ管理'
		String BackBtn = 'バック'
		String HeaderM = AddHeader + '\n' + BackBtn

		WebUI.click(findTestObject('Object Repository/Quiz_management/quiz_add_btnVerify/add_btn'))
		WebUI.delay(2)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/quiz_add_btnVerify/add_header'), 'クイズ管理')

		WebUI.verifyElementPresent(findTestObject('Object Repository/Content_management/verifyAddbutton/reg_div'), 0)
		//WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz_management/quiz_add_btnVerify/back_btn'))
		WebUI.back()
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/quiz_add_btnVerify/add_btn'), 2)
	}

	@Keyword

	def verifyEditQuiz(){

		Lorem lorem1 = LoremIpsum.getInstance();
		String question = lorem1.getWords(5)
		String answer = lorem1.getWords(1)

		WebUI.click(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/edit_btn'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/EditQuiz/edit_header'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/EditQuiz/update'), '更新')
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/EditQuiz/quiz_ID'), 'クイズID')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/EditQuiz/quiz_ID'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/EditQuiz/question'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/EditQuiz/question'), '問題文')
		WebUI.setText(findTestObject('Object Repository/Quiz_management/EditQuiz/input__question'), question)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/EditQuiz/answer'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/EditQuiz/answer'), '正解')
		WebUI.setText(findTestObject('Object Repository/Quiz_management/EditQuiz/input__answer'), answer)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/EditQuiz/program_name'), 0)

		String programName = 0
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Quiz_management/EditQuiz/program_select'), programName)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/EditQuiz/broadcast_time'), '番組連動企画放送回(放送開始日時)')
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Quiz_management/EditQuiz/broadcast_time_select'), '2')
		//WebUI.selectOptionByIndex(findTestObject('Object Repository/Content_management/verifyEdit/Page_edit/broadcast_time_drop'), '1')
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/EditQuiz/points'), '獲得ポイント数')
		WebUI.clearText(findTestObject('Object Repository/Quiz_management/EditQuiz/input__points'))
		WebUI.setText(findTestObject('Object Repository/Quiz_management/EditQuiz/input__points'), "100")
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/EditQuiz/image'), 'バナー画像')
		WebUI.delay(5)
		String filePath = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\little.JPG'
		uploadFile(findTestObject('Object Repository/Quiz_management/EditQuiz/button_Upload Image'), filePath)
		WebUI.verifyElementText(findTestObject('Object Repository/Quiz_management/EditQuiz/warn'), '5MB以下のファイルを選択して下さい')
		WebUI.delay(5)

		String filePath1 = RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\quiz.JPG'
		uploadFile(findTestObject('Object Repository/Quiz_management/EditQuiz/button_Upload Image'), filePath1)
		WebUI.delay(3)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Quiz_management/EditQuiz/clickable_img_link'))

		WebUI.scrollToElement(findTestObject('Object Repository/Quiz_management/EditQuiz/update'), 2)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Quiz_management/EditQuiz/update'))
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Quiz_management/EditQuiz/success_msg'), 2)

		WebUI.click(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/edit_btn'))
		WebUI.delay(5)

		String QuestionPaper = WebUI.getAttribute(findTestObject('Object Repository/Quiz_management/EditQuiz/input__question'), 'attribute')
		String AnswerPaper = WebUI.getAttribute(findTestObject('Object Repository/Quiz_management/EditQuiz/input__answer'), 'attribute')
		String Name = WebUI.getAttribute(findTestObject('Object Repository/Quiz_management/EditQuiz/program_select'), 'attribute')


		if ( QuestionPaper == question && AnswerPaper == answer && Name == programName){
			print('verified successfully')
		}
		else{
			print('did not match')
		}
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
		WebUI.delay(3);
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

	def verifyContentRegisterAccess(){

		WebUI.click(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/quiz_sidebar'))
		WebUI.click(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/edit_btn'))

		String status =""

		if (status == "公開"){

			WebUI.verifyElementChecked(findTestObject('Object Repository/Quiz_management/quiz_list_UI/Page_Admin/status'), 2)
			WebUI.verifyElementNotClickable(findTestObject('Object Repository/Quiz_management/EditQuiz/status'))
		}
		else{
		}
	}
}
