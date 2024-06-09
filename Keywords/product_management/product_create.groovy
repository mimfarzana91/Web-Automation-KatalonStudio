package product_management

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

//import com.kms.katalon.core.annotation.Keyword
//import com.kms.katalon.core.testobject.TestObject
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class product_create {

	@Keyword
	def uiVerification(){
		String header1="商品(EC)管理画面"
		String header2="商品名（64文字以内）"
		String header3= '必須'
		String header4=header2 + "\n" + header3
		String price1= '税抜き価格（半角数字/コンマ無し）'
		String price2 = '任意'
		String PriceTax = price1 + "\n" + price2
		String detail1= "詳細情報（500文字以内）"
		String detail2= "任意"
		String detailInfo = detail1 + "\n" + detail2
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/Page_Admin/h4_(EC)'), header1)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/Page_Admin/h5_register_header'), '登録')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/comm_name'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/price_arbitrary'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/detailed_info'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/Page_Admin/textarea_()_Productdetails'), 0)
		WebUI.scrollToElement(findTestObject('Object Repository/Product_management/Page_Admin/button_register'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/main_img'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/Page_Admin/input_Upload Image_file-upload'), 'Upload Image')
		
		//WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'), 'placeholder', 'リンク先URLを入力してください', 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/URL'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/program_name'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/Page_Admin/select_Game Of ThronesThe Witcher'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/bnr_display_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/display_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/active_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/start_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/bnr_img'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/bnr_title'), 0)
		WebUI.verifyElementNotClickable(findTestObject('Object Repository/Product_management/changed_product_UI/bnr_input'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/bnr_input'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/web_tran'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/input__web'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Product_management/changed_product_UI/input__web'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/Page_Admin/label_checkbox'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/Page_Admin/input__General_public'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/Page_Admin/button_register'), '登録')
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/Page_Admin/button_cancel'), 'キャンセル')
	}

	@Keyword
	def alertMsgVerification(){

		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/button_register'))
		WebUI.delay(03)
		WebUI.scrollToElement(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_productNameAlert'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_productNameAlert'), '必須項目が入力されていません')
		String alertcolor1= WebUI.getCSSValue(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_productNameAlert'), 'color')
		String hexcolor=Color.fromString(alertcolor1).asHex();
		String expectedColor="#dc5757"
		WebUI.verifyMatch(hexcolor, expectedColor,true)

		Lorem lorem1 = LoremIpsum.getInstance();
		String name1=lorem1.getName();
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'), name1)

		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'), 'tehjdj123')
		WebUI.delay(03)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_priceAlert'), '半角数字で入力して下さい')
		String alertcolor2= WebUI.getCSSValue(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_priceAlert'), 'color')
		String hexcolor2=Color.fromString(alertcolor2).asHex();
		WebUI.verifyMatch(hexcolor2, expectedColor,true)
		WebUI.scrollToElement(findTestObject('Object Repository/Product_management/Page_Admin/button_register'), 0)

		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_imageAlert'), '必須項目が入力されていません')
		String alertcolor3= WebUI.getCSSValue(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_imageAlert'), 'color')
		String hexcolor3=Color.fromString(alertcolor3).asHex();
		WebUI.verifyMatch(hexcolor3, expectedColor,true)

		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'), 'tehjdj123')
		WebUI.delay(03)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_Invalid link'), 'URLが不適切です')
		String alertcolor4= WebUI.getCSSValue(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_Invalid link'), 'color')
		String hexcolor4=Color.fromString(alertcolor4).asHex();
		WebUI.verifyMatch(hexcolor4, expectedColor,true)
		WebUI.delay(03)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_programmeNameAlert'), '必須項目が入力されていません')
		String alertcolor5= WebUI.getCSSValue(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_programmeNameAlert'), 'color')
		String hexcolor5=Color.fromString(alertcolor5).asHex();
		WebUI.verifyMatch(hexcolor5, expectedColor,true)
	}

	@Keyword
	def imageFileVerification(){


		String filePath1=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\resize-images-print-photoshop-share.jpg'
		String filePath2=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\hld.png'
		String filePath3=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\tenor.gif'
		String filePath4=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\DSC02014.JPG'

		uploadFile(findTestObject('Object Repository/Product_management/Page_Admin/input_Upload Image_file-upload'), filePath1)
		WebUI.delay(03)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_UploadedImageLink'), '登録済の画像を確認する')
		WebUI.verifyElementClickable(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_UploadedImageLink'))


		uploadFile(findTestObject('Object Repository/Product_management/Page_Admin/input_Upload Image_file-upload'), filePath2 )
		WebUI.delay(03)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_UploadedImageLink'), '登録済の画像を確認する')
		WebUI.verifyElementClickable(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/div_UploadedImageLink'))


		uploadFile(findTestObject('Object Repository/Product_management/Page_Admin/input_Upload Image_file-upload'), filePath3 )
		WebUI.delay(03)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/Page_Admin/div_jpgpng_alert'),'jpg/pngファイルを選択して下さい')


		uploadFile(findTestObject('Object Repository/Product_management/Page_Admin/input_Upload Image_file-upload'), filePath4 )
		WebUI.delay(03)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/Page_Admin/div_5MB_alert'), '5MB以下のファイルを選択して下さい')
	}

	@Keyword
	def programSelectBoxVerification(String role ){

		if (role == "Admin" ||role == "Contents Manager"){
			int TotalOptions = WebUI.getNumberOfTotalOption(findTestObject('Object Repository/Product_management/Page_Admin/select_Game Of ThronesThe Witcher'))
			println("No Roles are : " + TotalOptions)
			WebUI.verifyEqual(TotalOptions, 2)
		}
		else{
			int TotalOptions = WebUI.getNumberOfTotalOption(findTestObject('Object Repository/Product_management/Page_Admin/select_Game Of ThronesThe Witcher'))
			println("No Roles are : " + TotalOptions)
			WebUI.verifyEqual(TotalOptions, 1)
		}
	}

	@Keyword
	def generalPublicCheckboxVerification(String role){
		if (role == "Admin" || role == "Contents Manager" || role == "Contents Supplier") {
			WebUI.verifyElementClickable(findTestObject('Object Repository/Product_management/Page_Admin/input__General_public'))
		}
		else {
			WebUI.verifyElementNotClickable(findTestObject('Object Repository/Product_management/Page_Admin/input__General_public'))
		}
	}

	@Keyword
	def productCreate() {

		String alertmsg1="×"
		String alertmsg2="Close"
		String alertmsg3="登録が完了しました"
		String alertmsg=alertmsg1 + "\n" + alertmsg2 + "\n" + alertmsg3
		Lorem lorem1 = LoremIpsum.getInstance();
		String productName=lorem1.getName();
		String filePath1=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\resize-images-print-photoshop-share.jpg'
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'), productName)
		WebUI.delay(03)
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'), '231')
		WebUI.delay(03)
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/textarea_()_Productdetails'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/textarea_()_Productdetails'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/textarea_()_Productdetails'), 'product details showing')
		WebUI.scrollToElement(findTestObject('Object Repository/Product_management/Page_Admin/button_register'), 0)
		WebUI.delay(03)

		uploadFile(findTestObject('Object Repository/Product_management/Page_Admin/input_Upload Image_file-upload'), filePath1 )
		WebUI.delay(03)
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'), 'http://d2jsv439trwp8c.cloudfront.net/products/create')
		WebUI.delay(03)

		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/select_Game Of ThronesThe Witcher'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Product_management/Page_Admin/select_Game Of ThronesThe Witcher'), '1', false)
		WebUI.delay(03)

		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input__General_public'))
		WebUI.delay(03)
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/button_register'))
		WebUI.delay(04)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/PageAdmin/Page_Admin/div_ProductCreateSuccessmsg'), alertmsg)
		return productName
	}


	@Keyword
	def productEditPageUiVerification(){

		String header1="商品(EC)管理画面"
		String header2="バック"
		String header3=header1 + "\n" + header2

		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/Page_Admin/h4_(EC)'), header1)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/Page_Admin/Page_Admin/h5_Edit'), '更新')
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/Page_Admin/label_ProductID'), '商品ID')
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/Page_Admin/itemID'), 'アイテムID')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/Page_Admin/div_productIdnumber'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/Page_Admin/label_product_name'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/price_arbitrary'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/detailed_info'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/Page_Admin/textarea_()_Productdetails'), 0)
		WebUI.scrollToElement(findTestObject('Object Repository/Product_management/Page_Admin/button_register'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/main_img'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/Page_Admin/input_Upload Image_file-upload'), 'Upload Image')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/URL'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/program_name'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/Page_Admin/select_Game Of ThronesThe Witcher'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/bnr_display_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/display_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/active_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/start_time'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/bnr_img'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/bnr_title'), 0)
		WebUI.verifyElementNotClickable(findTestObject('Object Repository/Product_management/changed_product_UI/bnr_input'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/bnr_input'), 0)
		WebUI.delay(2)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/web_tran'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/changed_product_UI/input__web'), 0)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Product_management/changed_product_UI/input__web'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/Page_Admin/label_checkbox'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product_management/Page_Admin/input__General_public'), 0)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/Page_Admin/button_register'), '更新')
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/Page_Admin/button_cancel'), 'キャンセル')
	}

	@Keyword
	def editProduct(){

		String alertmsg1="×"
		String alertmsg2="Close"
		String alertmsg3="更新が完了しました"
		String alertmsg=alertmsg1 + "\n" + alertmsg2 + "\n" + alertmsg3
		Lorem lorem1 = LoremIpsum.getInstance();
		String productName=lorem1.getName();
		String filePath1=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\download.jpg'
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'), productName)
		WebUI.delay(03)
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'), '2231')
		WebUI.delay(03)
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/textarea_()_Productdetails'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/textarea_()_Productdetails'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/textarea_()_Productdetails'), 'product details showing')
		WebUI.scrollToElement(findTestObject('Object Repository/Product_management/Page_Admin/button_register'), 0)
		WebUI.delay(03)
		uploadFile(findTestObject('Object Repository/Product_management/Page_Admin/input_Upload Image_file-upload'), filePath1 )
		WebUI.delay(03)
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'), 'https://api.flutter.dev/flutter/flutter_driver/ByType/finderType.html')
		WebUI.delay(03)

		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/select_Game Of ThronesThe Witcher'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Product_management/Page_Admin/select_Game Of ThronesThe Witcher'), '1', false)
		WebUI.delay(03)

		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input__General_public'))
		WebUI.delay(03)
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/button_register'))
		WebUI.delay(04)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_pAdmin/Page_Admin/div_ProductCreateSuccessmsg'), alertmsg)
		return productName
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

