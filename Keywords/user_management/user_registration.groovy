package user_management

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
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select
//import internal.GlobalVariable;
import java.util.List

public class user_registration {


	@Keyword
	def uiVerification(){
		String header1="管理ユーザー管理"
		String header2="バック"
		String header3=header1 + "\n" + header2

		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/h4_ RegisHeader1'), header1)
		//WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/a_backButton'), 'バック')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/h5_RegisHeader2'), '登録')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/label_mail'), 'メールアドレス')
		WebUI.verifyElementPresent(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'), 0)
		WebUI.verifyElementAttributeValue(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'), 'placeholder', 'メールアドレスを入力して下さい。', 0)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/label_password'), 'パスワード')
		WebUI.verifyElementPresent(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'), 0)
		WebUI.verifyElementAttributeValue(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'), 'placeholder', 'パスワードを入力して下さい。', 0)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/label_authority'), '権限')
		WebUI.verifyElementPresent(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_register'), '登録')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_cancel'), 'キャンセル')
	}

	@Keyword
	def requiredFieldVerification(){
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_register'))
		WebUI.delay(03)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_mailRequiredmsg'), '必須項目が入力されていません')
		String alertcolor1= WebUI.getCSSValue(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_mailRequiredmsg'), 'color')
		String hexcolor=Color.fromString(alertcolor1).asHex();
		String expectedColor="#dc6060"
		WebUI.verifyMatch(hexcolor, expectedColor,true)

		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_passwordRequiredmsg'), '必須項目が入力されていません')
		String alertcolor2= WebUI.getCSSValue(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_passwordRequiredmsg'), 'color')
		String hexcolor2=Color.fromString(alertcolor2).asHex();
		WebUI.verifyMatch(hexcolor2, expectedColor,true)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_authorityRequiredmsg'), '必須項目が入力されていません')
		String alertcolor3= WebUI.getCSSValue(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_authorityRequiredmsg'), 'color')
		String hexcolor3=Color.fromString(alertcolor3).asHex();
		WebUI.verifyMatch(hexcolor3, expectedColor,true)
		WebUI.click(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'))

		WebUI.selectOptionByValue(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'), 'CONTENT_SUPPLIER', false)
		WebUI.delay(02)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/label_Editableprogram'), '編集可能チャンネル')
		WebUI.verifyElementPresent(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/select_box_Editable_program'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_Edit_programRequiredmsg'), '必須項目が入力されていません')
		String alertcolor4= WebUI.getCSSValue(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_Edit_programRequiredmsg'), 'color')
		String hexcolor4=Color.fromString(alertcolor4).asHex();
		WebUI.verifyMatch(hexcolor4, expectedColor,true)
		WebUI.delay(03)
		WebUI.scrollToElement(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_register'), 0)
		WebUI.click(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'))
		WebUI.selectOptionByValue(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'), 'CONTENT_REGISTER', false)
		WebUI.delay(02)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/label_Editableprogram'), '編集可能チャンネル')
		WebUI.verifyElementPresent(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/select_box_Editable_program'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_Edit_programRequiredmsg'), '必須項目が入力されていません')
		WebUI.click(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'))
		WebUI.selectOptionByValue(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'), 'ADMIN', false)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/select_box_Editable_program'), 0)
		WebUI.doubleClick(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'))
		WebUI.selectOptionByValue(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'), 'CONTENT_MANAGER', false)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/select_box_Editable_program'), 0)
	}

	@Keyword
	def mailFieldVerification(){
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'), 'test@gmail')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_wrongMailmsg'), 'メールアドレスまたはパスワードが正しくありません。再度入力して下さい。')
		String expectedColor="#dc6060"
		String alertcolor5= WebUI.getCSSValue(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_wrongMailmsg'), 'color')
		String hexcolor5=Color.fromString(alertcolor5).asHex();
		WebUI.verifyMatch(hexcolor5, expectedColor,true)
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'), 'testgmail.com')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_wrongMailmsg'), 'メールアドレスまたはパスワードが正しくありません。再度入力して下さい。')
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'), 'test@gmail.com')
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_wrongMailmsg'), 0)
	}

	@Keyword
	def passwordFieldVerification(){
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'), 'abc')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_wrongPassmsg'), 'メールアドレスまたはパスワードが正しくありません。再度入力して下さい。')
		String alertcolor5= WebUI.getCSSValue(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_wrongPassmsg'), 'color')
		colorverification("#dc6060", alertcolor5)
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'), 'abcAB')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_wrongPassmsg'), 'メールアドレスまたはパスワードが正しくありません。再度入力して下さい。')
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'), 'abcABC123')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_wrongPassmsg'), 'メールアドレスまたはパスワードが正しくありません。再度入力して下さい。')
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'), 'aAC1@')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_wrongPassmsg'), 'メールアドレスまたはパスワードが正しくありません。再度入力して下さい。')
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'), 'aAC1@')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_wrongPassmsg'), 'メールアドレスまたはパスワードが正しくありません。再度入力して下さい。')

		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'), 'abcABC12@')
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_wrongPassmsg'), 0)
	}


	def colorverification( String expectedColor, String alertColor){

		String hexcolor=Color.fromString(alertColor).asHex();

		WebUI.verifyMatch(hexcolor, expectedColor,true)
	}

	@Keyword
	def RegisterddMailRegistration(String mail,String pass){

		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'), mail)
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'), pass)
		WebUI.click(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'))
		WebUI.selectOptionByValue(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'), 'CONTENT_REGISTER', false)
		WebUI.delay(02)
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/select_box_Editable_program'))
		//WebUI.selectOptionByIndex(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/select_box_Editable_program'), '0',false)
		WebUI.selectOptionByIndex(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/select_box_Editable_program'), '0')
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_register'))
		WebUI.delay(03)
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/h6_PopupHeader'), '確認')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/p_popUpDetails'), '登録済みのメールアドレスです。パスワード・権限を更新してもよろしいですか？')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_(Y)'), 'はい(Y)')
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_(N)'), 'いいえ(N)')
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_(N)'))
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/p_popUpDetails'), 0)
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_register'))
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_(Y)'))
		WebUI.delay(03)
		String confirmUpdatemsg1="×"
		String confirmUpdatemsg2="Close"
		String confirmUpdatemsg3="更新が完了しました"
		String confirmUpdatemsg=confirmUpdatemsg1 + "\n" + confirmUpdatemsg2 + "\n" + confirmUpdatemsg3

		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_updateConfirmationText'), confirmUpdatemsg)
	}

	@Keyword
	def successfulRegistration(String mail,String password){
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__email'), mail)
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.clearText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'))
		WebUI.sendKeys(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/input__password'), password)
		WebUI.delay(03)

		WebUI.click(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'))
		WebUI.selectOptionByValue(findTestObject('User_Managment/User_Registration/Page_SxTvappAdmin/select_AdminContents'), 'CONTENT_MANAGER', false)
		WebUI.delay(03)
		WebUI.click(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/button_register'))
		WebUI.delay(3)
		String confirmmsg1="×"
		String confirmmsg2="Close"
		String confirmmsg3="登録が完了しました"
		String confirmmsg=confirmmsg1 + "\n" + confirmmsg2 + "\n" + confirmmsg3
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/User_Registration/Page_SxTvappAdmin/div_registerConfirmation'), confirmmsg)
		String header1="管理ユーザー管理"
		String header2="追加"
		String header3=header1 + "\n" + header2
		WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/Page_SxTvappAdmin/h4_'), header3)




	}
}
