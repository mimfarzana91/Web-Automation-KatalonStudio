package product_list_screen

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

public class product_list {

	@Keyword
	def uiVerification(){

		String header1="商品(EC)管理画面"
		String header2="追加"
		String header3=header1 + "\n" + header2
		WebUI.verifyElementText(findTestObject('Object Repository/Product_List/H4'), header3)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_List/Add_Button'), header2)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_List/Product_ID'), '商品ID')
		WebUI.verifyElementText(findTestObject('Object Repository/Product_List/item_ID'), 'アイテムID')
		WebUI.verifyElementText(findTestObject('Object Repository/Product_List/Product_Name'), '商品名')
		WebUI.verifyElementText(findTestObject('Object Repository/Product_List/Channel_Name'), 'チャンネル名')
		WebUI.verifyElementText(findTestObject('Object Repository/Product_List/Product_Status'), 'ステータス')
	}


	@Keyword
	def tableVerification(){

		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Product_List/Column1'), 0)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Product_List/Column2'), 0)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Product_List/Column2'), 0)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Product_List/Column2'), 0)
	}

	@Keyword
	def addButtonVerification(){

		WebUI.click(findTestObject('Object Repository/Product_List/Add_Button'))
		String header1="商品(EC)管理画面"
		String header2="バック"
		String header3=header1 + "\n" + header2
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/Page_Admin/h4_(EC)'), header1)
		//WebUI.verifyElementText(findTestObject('Object Repository/Product_management/Page_Admin/a_back_button'), 'バック')
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/Page_Admin/h5_register_header'), '登録')
		WebUI.back()
	}

	@Keyword
	def editProduct(String User){

		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/Page_Admin/Page_Admin/edit'), '編集')
		WebUI.click(findTestObject('Object Repository/Product_List/Edit_Button'))

		//String productID = WebUI.getText(findTestObject('Object Repository/Product_List/Edit_Column1'))
		String productID = 27
		if (User == 'Admin' || User == 'Manager'){
			productID = 27
		}

		else {
			productID = 25
		}
		String alertmsg1="×"
		String alertmsg2="Close"
		String alertmsg3="更新が完了しました"
		String alertmsg=alertmsg1 + "\n" + alertmsg2 + "\n" + alertmsg3
		Lorem lorem1 = LoremIpsum.getInstance();
		String productName=lorem1.getName();
		int randomNumber = new Random().nextInt(99 - 10 + 1) + 10
		String productPrice = Integer.toString(randomNumber)
		print(productPrice)
		String productDetails = lorem1.getName()
		String productUrl = lorem1.getUrl()
		String filePath1=RunConfiguration.getProjectDir().replace("/", "\\") + '\\Data Files\\download.jpg'
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'), productName)
		WebUI.delay(01)
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'))
		WebUI.setText(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'), productPrice)
		WebUI.delay(01)
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/textarea_()_Productdetails'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/textarea_()_Productdetails'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/textarea_()_Productdetails'), productDetails)
		WebUI.scrollToElement(findTestObject('Object Repository/Product_management/Page_Admin/button_register'), 0)
		WebUI.delay(04)
		uploadFile(findTestObject('Object Repository/Product_management/Page_Admin/input_Upload Image_file-upload'), filePath1 )
		WebUI.delay(02)
		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'))
		WebUI.clearText(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'))
		WebUI.sendKeys(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'), productUrl)
		WebUI.delay(03)

		WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/select_Game Of ThronesThe Witcher'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Product_management/PageAdmin/select_Game Of ThronesThe Witcher'), '1', false)
		WebUI.delay(03)


		String Status = ""
		if( WebUI.verifyElementChecked(findTestObject('Object Repository/Product_management/Page_Admin/input__General_public'), 5, FailureHandling.OPTIONAL) ){

			WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input__General_public'))
			WebUI.delay(03)
			Status = "非公開"
		}
		else {

			WebUI.click(findTestObject('Object Repository/Product_management/Page_Admin/input__General_public'))
			WebUI.delay(03)
			Status = "公開"
		}

		print(Status)


		WebUI.click(findTestObject('Object Repository/Product_List/Update_Button'))
		WebUI.delay(04)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_management/AlertmsgLink/Page_Admin/Page_Admin/div_ProductCreateSuccessmsg'), alertmsg)

		WebUI.verifyElementText(findTestObject('Object Repository/Product_List/Edit_Column3'), productName)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_List/Edit_Column4'), Status)

		WebUI.click(findTestObject('Object Repository/Product_List/Edit_Button'))
		WebUI.delay(03)
		//WebUI.verifyElementText(findTestObject('Object Repository/Product_List/Edit_Screen_ID'), productID)

		String Name = WebUI.getAttribute(findTestObject('Object Repository/Product_management/Page_Admin/input__Productname'), 'value')
		String Price = WebUI.getAttribute(findTestObject('Object Repository/Product_management/Page_Admin/input_()_price'), 'value')
		String Details = WebUI.getAttribute(findTestObject('Object Repository/Product_management/Page_Admin/textarea_()_Productdetails'), 'value')
		String Url = WebUI.getAttribute(findTestObject('Object Repository/Product_management/Page_Admin/input_()_product site'), 'value')

		if (Name == productName && Price == productPrice && Details == productDetails && Url == productUrl){

			print{'Verified Successfull'}
		}
		else {

			print ('Verification is not right')
		}

		if (Status == '公開'){

			WebUI.verifyElementChecked(findTestObject('Object Repository/Product_management/Page_Admin/input__General_public'), 10)
		}

		else {

			WebUI.verifyElementNotChecked(findTestObject('Object Repository/Product_management/Page_Admin/input__General_public'), 10)
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
		WebUI.delay(3)
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
