package loginIntoWeb

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
import org.openqa.selenium.support.Color;

import internal.GlobalVariable

public class login {

	@Keyword
	def uiVerification(){

		//WebUI.waitForPageLoad(15)
		WebUI.verifyElementText(findTestObject('Object Repository/login/Page_Admin/header'), 'ログイン')
		WebUI.verifyElementText(findTestObject('Object Repository/login/Page_Admin/label_'), 'メールアドレス')
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), 0)
		WebUI.verifyElementAttributeValue(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), 'placeholder', 'メールアドレスを入力して下さい。', 0)
		WebUI.verifyElementText(findTestObject('Object Repository/login/Page_Admin/Page_Admin/label_'), 'パスワード')
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), 0)
		WebUI.verifyElementAttributeValue(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), 'placeholder', 'パスワードを入力して下さい。', 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/Page_Admin/Page_Admin/button_'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/login/Page_Admin/Page_Admin/button_'), 'ログイン')
		WebUI.verifyElementText(findTestObject('Object Repository/login/Page_Admin/Page_Admin/p_'), 'パスワードをお忘れの方は、管理者にご連絡下さい。')

	}

	@Keyword
	def maillPasswordNotSpecified(){
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/button_'))
		WebUI.verifyElementText(findTestObject('Object Repository/login/Page_Admin/mailErrormsg'),'メールアドレスまたはパスワードが正しくありません。再度入力して下さい。')
		String expectedColor="#dc5757";
		String alertColor= WebUI.getCSSValue(findTestObject('Object Repository/login/Page_Admin/mailErrormsg'), 'color')
		System.out.println(alertColor);
		String hexcolor=Color.fromString(alertColor).asHex();
		System.out.println(hexcolor);
		WebUI.verifyMatch(hexcolor, expectedColor,true)
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.delay(02)
		WebUI.sendKeys(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), 'test@gmail.com')
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/button_'))
		WebUI.verifyElementText(findTestObject('Object Repository/login/Page_Admin/Page_Admin/passwordErrormsg'), 'メールアドレスまたはパスワードが正しくありません。再度入力して下さい。')
		String alertColor2= WebUI.getCSSValue(findTestObject('Object Repository/login/Page_Admin/Page_Admin/passwordErrormsg'), 'color')
		System.out.println(alertColor2);
		String hexcolor2=Color.fromString(alertColor2).asHex();
		System.out.println(hexcolor2);
		WebUI.verifyMatch(hexcolor2, expectedColor,true)
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.delay(02)
		WebUI.sendKeys(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), '24346fdgfg@')
	}
	@Keyword
	def mailNotInFormat(){
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.clearText(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.delay(02)
		WebUI.sendKeys(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), 'admin@gmailcom')
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/button_'))
		WebUI.verifyElementText(findTestObject('Object Repository/login/Page_Admin/mailErrormsg'),'メールアドレスまたはパスワードが正しくありません。再度入力して下さい。')
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.clearText(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.delay(02)
		WebUI.sendKeys(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), 'admingmail.com')
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/button_'))
		WebUI.delay(02)
		WebUI.verifyElementText(findTestObject('Object Repository/login/Page_Admin/mailErrormsg'),'メールアドレスまたはパスワードが正しくありません。再度入力して下さい。')
	}

	@Keyword
	def correctmailWrongPass(){
		String alertmsg1="×"
		String alertmsg2="Close"
		String alertmsg3="メールアドレスまたはパスワードが正しくありません。再度入力して下さい。"
		String alertmsg=alertmsg1 + "\n" + alertmsg2 + "\n" + alertmsg3

		WebUI.click(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.clearText(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.delay(02)
		WebUI.sendKeys(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), 'admin@example.com')
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/button_'))
		WebUI.delay(02)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/login/Page_Admin/mailErrormsg'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/login/Page_Admin/Page_Admin/errorAlertMessage'), alertmsg)
		String expectedColor="#722d2d";
		String alertColor= WebUI.getCSSValue(findTestObject('Object Repository/login/Page_Admin/Page_Admin/errorAlertMessage'), 'color')
		System.out.println(alertColor);
		String hexcolor=Color.fromString(alertColor).asHex();
		System.out.println(hexcolor);
		WebUI.verifyMatch(hexcolor, expectedColor,true)
	}

	@Keyword
	def wrongmailCorrectPass(){
		String alertmsg1="×"
		String alertmsg2="Close"
		String alertmsg3="メールアドレスまたはパスワードが正しくありません。再度入力して下さい。"
		String alertmsg=alertmsg1 + "\n" + alertmsg2 + "\n" + alertmsg3

		WebUI.click(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.clearText(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.delay(02)
		WebUI.sendKeys(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), 'dmin2@example.com')
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.clearText(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.delay(02)
		WebUI.sendKeys(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), 'Password123@')
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/button_'))
		WebUI.verifyElementText(findTestObject('Object Repository/login/Page_Admin/Page_Admin/errorAlertMessage'),alertmsg)
	}

	@Keyword
	def loginWithuserMAilPass(String mail, String Pass){
		String alertmsg1="×"
		String alertmsg2="Close"
		String alertmsg3="メールアドレスまたはパスワードが正しくありません。再度入力して下さい。"
		String alertmsg=alertmsg1 + "\n" + alertmsg2 + "\n" + alertmsg3


		WebUI.click(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.clearText(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.delay(02)
		WebUI.sendKeys(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), mail)
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.clearText(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.delay(02)
		WebUI.sendKeys(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), Pass)
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/button_'))
		WebUI.verifyElementText(findTestObject('Object Repository/login/Page_Admin/Page_Admin/errorAlertMessage'), alertmsg)
	}
	/*
	 @Keyword
	 def loginWithValidMailPass(String mail, String Pass){
	 String header1="管理ユーザー管理"
	 String header2="追加"
	 String header3=header1 + "\n" + header2
	 WebUI.click(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
	 WebUI.clearText(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
	 WebUI.delay(02)
	 WebUI.sendKeys(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), mail)
	 WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
	 WebUI.clearText(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
	 WebUI.delay(02)
	 WebUI.sendKeys(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), Pass)
	 WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/button_'))
	 WebUI.waitForElementVisible(findTestObject('Object Repository/User_Managment/Page_Admin/h4_'), 4)
	 WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/Page_Admin/h4_'), header3)
	 }
	 */
	@Keyword
	def loginWithValidMailPass(String mail, String Pass, String role){
		String header1="管理ユーザー管理"
		String header2="追加"
		String header3=header1 + "\n" + header2
		String header4 = "商品(EC)管理画面"
		String header5 = "追加"
		String header6 = header4 + "\n" + header5

		WebUI.click(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.clearText(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.delay(02)
		WebUI.sendKeys(findTestObject('Object Repository/login/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), mail)
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.clearText(findTestObject('Object Repository/login/Page_Admin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'))
		WebUI.delay(02)
		WebUI.sendKeys(findTestObject('Object Repository/login/PageAdmin/Page_Admin/input__form-control ng-untouched ng-pristine ng-invalid'), Pass)
		WebUI.click(findTestObject('Object Repository/login/Page_Admin/Page_Admin/button_'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/User_Managment/Page_Admin/h4_'), 4)

		if (role == "Admin"){

			WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/Page_Admin/h4_'), header3)
		}

		else {

			WebUI.verifyElementText(findTestObject('Object Repository/User_Managment/Page_Admin/h4_'), header6)
		}
	}
}
