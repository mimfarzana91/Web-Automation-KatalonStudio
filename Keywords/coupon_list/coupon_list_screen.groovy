package coupon_list

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

public class coupon_list_screen {

	@Keyword
	def uiVerification(){

		WebUI.click(findTestObject('Object Repository/Home/Page_Admin/8_Nav_クーポン管理'))

		String header1="クーポン管理"
		String header2="追加"
		String header3=header1 + "\n" + header2
		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_List/H4_Coupon_List'), header3)
		WebUI.verifyElementText(findTestObject('Object Repository/Product_List/Add_Button'), header2)
		WebUI.verifyElementText(findTestObject('Coupon_List/Coupon_ID'),'クーポンID')
		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_List/Item_ID'), 'アイテムID')
		WebUI.verifyElementText(findTestObject('Coupon_List/Coupon_Name'),'クーポン名')
		WebUI.verifyElementText(findTestObject('Coupon_List/Program_Name'),'番組名')
		WebUI.verifyElementText(findTestObject('Coupon_List/Expiration_Date'),'有効期限')
		WebUI.verifyElementText(findTestObject('Coupon_List/Coupon_Status'),'ステータス')
		//WebUI.verifyElementPresent(findTestObject('Coupon_List/Edit_Column1'), 0)
		WebUI.verifyElementNotPresent(findTestObject('Coupon_List/Item_11_Col1'),0)
	}

	@Keyword
	def tableVerification(){

		WebUI.verifyElementNotPresent(findTestObject('Coupon_List/Item_11_Col1'),0)
		WebUI.verifyElementNotPresent(findTestObject('Coupon_List/Item_11_Col2'),0)
		WebUI.verifyElementNotPresent(findTestObject('Coupon_List/Item_11_Col3'),0)
		WebUI.verifyElementNotPresent(findTestObject('Coupon_List/Item_11_Col4'),0)
		WebUI.verifyElementNotPresent(findTestObject('Coupon_List/Item_11_Col5'),0)
	}


	@Keyword
	def paginationVerification(){

		WebUI.verifyElementClickable(findTestObject('Coupon_List/Pagination_1Page'))
		WebUI.verifyElementClickable(findTestObject('Coupon_List/Pagination_End'))
		WebUI.verifyElementClickable(findTestObject('Object Repository/Coupon_List/Page_2_Link'))
	}

	@Keyword
	def couponEdit(){

		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_List/Edit_Button'), '編集')
		WebUI.click(findTestObject('Object Repository/Coupon_List/Edit_Button'))
		WebUI.delay(3)

		String header1="クーポン管理"
		String header2="バック"
		String header3=header1 + "\n" + header2
		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_List/H4_Coupon_List'), header1)
		//WebUI.verifyElementText(findTestObject('Object Repository/Coupon_List/Back_Button'), header2)
	}

	@Keyword
	def couponAdd(){

		WebUI.click(findTestObject('Object Repository/Coupon_List/Add_Button'))
		WebUI.delay(3)

		String header1="クーポン管理"
		String header2="バック"
		String header3=header1 + "\n" + header2
		WebUI.verifyElementText(findTestObject('Object Repository/Coupon_List/H4_Coupon_List'), header1)
		//WebUI.verifyElementText(findTestObject('Object Repository/Coupon_List/Back_Button'), header2)
		WebUI.back()
	}
}
