import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import groovy.json.JsonSlurper as JsonSlurper
import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.verification.WSResponseManager as WSResponseManager

response = WS.sendRequest(findTestObject('REST User Operations/Get all users'))

def jsonResponseText = response.getResponseText()

println(jsonResponseText)

def jsonSlurper = new JsonSlurper()

def jsonResponse = jsonSlurper.parseText(jsonResponseText)

emailid = jsonResponse.data[0].email

System.out.println('Email ID is :' + emailid)

GlobalVariable.email = emailid

System.out.println(GlobalVariable.email)

WS.sendRequest(findTestObject('REST User Operations/PUT update request'))

WS.delay(5)

request = findTestObject('REST User Operations/PUT update request')

println(WS.comment(request.getRestUrl()))

println(WS.comment(request.getHttpBody()))

CustomKeywords.'CustomKeyWordd.setter'(GlobalVariable.email)

CustomKeywords.'CustomKeyWordd.getter'()

