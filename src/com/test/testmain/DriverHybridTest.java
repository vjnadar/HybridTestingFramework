package com.test.testmain;


import constants.CommonConstants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Parameters;

import org.testng.annotations.Test;

import utilities.BrowserConfig;

import utilities.ExcelConfig;
import utilities.OperationConfig;

/**
 * Created by V.J.Nadar on 3/24/2017.
 */
public class DriverHybridTest
{
    private WebDriver driver;

    private int rowCount;

    private String testCaseID;

    private String runMode;

    private int firstTestRow;

    private int lastTestRow;

    private String operationType;

    private String page;

    private String object;

    private String keywordAction;

    private String input;
    
    private String input2;
    
    private String testStepNo;

    ExcelConfig ec;
    
    OperationConfig oc;

    @BeforeTest

  

    public void setTest()
    {
        ec=new ExcelConfig(CommonConstants.EXCELFILELOCATION);

        BrowserConfig.setBrowser("chrome");
        
        oc=new OperationConfig();
        
        driver=BrowserConfig.getDriver();
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(alwaysRun=true)
    public void hybridTest() throws IllegalArgumentException, IllegalAccessException, InterruptedException
    {
        rowCount=ec.getRowCount(CommonConstants.TC_SHEETNO);
        
        

        for(int i=1;i<=rowCount;i++)
        {
            testCaseID=ec.getData(CommonConstants.TC_TESTCASEID,i,CommonConstants.TC_TESTCASEID);

            runMode=ec.getData(CommonConstants.TC_TESTCASEID,i,CommonConstants.TC_RUNMODE);

            if(runMode.equalsIgnoreCase("Yes"))
            {
                firstTestRow=ec.getFirstTestRow(testCaseID,CommonConstants.TS_SHEETNO,CommonConstants.TS_TESTCASEID);

                lastTestRow=ec.getLastTestRow(firstTestRow,CommonConstants.TS_SHEETNO,CommonConstants.TS_TESTCASEID);

                for(int j=firstTestRow;j<=lastTestRow;j++)
                {
                	testStepNo=ec.getData(CommonConstants.TS_SHEETNO, j, CommonConstants.TS_TESTSTEPNO);
                	
                    operationType=ec.getData(CommonConstants.TS_SHEETNO,j,CommonConstants.TS_OPERATIONTYPE);

                    page=ec.getData(CommonConstants.TS_SHEETNO,j,CommonConstants.TS_PAGE);

                    object=ec.getData(CommonConstants.TS_SHEETNO,j,CommonConstants.TS_OBJECT);

                    keywordAction=ec.getData(CommonConstants.TS_SHEETNO,j,CommonConstants.TS_KEYWORD);

                    input=ec.getData(CommonConstants.TS_SHEETNO,j,CommonConstants.TS_INPUT);
                    
                    input2=ec.getData(CommonConstants.TS_SHEETNO,j,CommonConstants.TS_INPUT2);
                    
                    oc.setOperation(testCaseID,testStepNo,operationType, page, object, keywordAction, input,input2);
                    

                }


            }





        }

    }
    
    @Test(alwaysRun=true)
//    public void hybridTestsecond() throws IllegalArgumentException, IllegalAccessException, InterruptedException
//    {
//        rowCount=ec.getRowCount(CommonConstants.TC_SHEETNO);
//        
//        
//
//        for(int i=1;i<=rowCount;i++)
//        {
//            testCaseID=ec.getData(CommonConstants.TC_TESTCASEID,i,CommonConstants.TC_TESTCASEID);
//
//            runMode=ec.getData(CommonConstants.TC_TESTCASEID,i,CommonConstants.TC_RUNMODE);
//
//            if(runMode.equalsIgnoreCase("Yes"))
//            {
//                firstTestRow=ec.getFirstTestRow(testCaseID,CommonConstants.TS_SHEETNO,CommonConstants.TS_TESTCASEID);
//
//                lastTestRow=ec.getLastTestRow(firstTestRow,CommonConstants.TS_SHEETNO,CommonConstants.TS_TESTCASEID);
//
//                for(int j=firstTestRow;j<=lastTestRow;j++)
//                {
//                	testStepNo=ec.getData(CommonConstants.TS_SHEETNO, j, CommonConstants.TS_TESTSTEPNO);
//                	
//                    operationType=ec.getData(CommonConstants.TS_SHEETNO,j,CommonConstants.TS_OPERATIONTYPE);
//
//                    page=ec.getData(CommonConstants.TS_SHEETNO,j,CommonConstants.TS_PAGE);
//
//                    object=ec.getData(CommonConstants.TS_SHEETNO,j,CommonConstants.TS_OBJECT);
//
//                    keywordAction=ec.getData(CommonConstants.TS_SHEETNO,j,CommonConstants.TS_KEYWORD);
//
//                    input=ec.getData(CommonConstants.TS_SHEETNO,j,CommonConstants.TS_INPUT);
//                    
//                    input2=ec.getData(CommonConstants.TS_SHEETNO,j,CommonConstants.TS_INPUT2);
//                    
//                    oc.setOperation(testCaseID,testStepNo,operationType, page, object, keywordAction, input,input2);
//                    
//
//                }
//
//
//            }
//
//
//
//
//
//        }
//
//    }
    
    @AfterTest
    public void tearDown()
    {
    	driver.quit();
    }

}

