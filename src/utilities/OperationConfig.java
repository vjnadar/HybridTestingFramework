package utilities;

import pagemethods.GeneralOperation;
import pagemethods.SignInPageOperation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OperationConfig
{
	GeneralOperation op;
	GeneralOperation op2;
	SignInPageOperation si;
	
	public OperationConfig()
	{
		op=new GeneralOperation();
		
		si=new SignInPageOperation();
	}
    public void setOperation(String testCaseID,String testStepNo,String operationType,String page, String object, String keyword,String input,String input2) throws IllegalArgumentException, IllegalAccessException, InterruptedException
    {
    	
    	
    	switch(operationType.toLowerCase())
    	{
    	case "generaloperation":
    		    		 
    		 executeGeneralMethods(testCaseID,testStepNo,page,object,keyword,input,input2);
    		 
    		 break;
    		 
    	case "signinpageoperation":
    		
    		 executeSignInPageMethods(testCaseID,testStepNo,keyword,input,input2);
    		
    		
    		break;
    	     	
    	}

    }
    
    private void executeGeneralMethods(String testCaseID,String testStepNo,String page, String object, String keyword,String input, String input2) throws IllegalArgumentException, IllegalAccessException, InterruptedException
    {
    	switch(keyword.toLowerCase())
    	{
    	case "navigate":
    	
				op.navigate(input);
		
    		break;
    		
    	case "getpagetitle":
		
    	       op.getPageTitle(input);
    	       
    	       break;
    	 
    	case "getattribute":
    		
    		op.getAttribute(page, object, input, input2);
    		break;
    		
    	case "sendkeys":
    		
    		op.sendKeys(page, object, input);
    		break;
    		
    	case "click":
    		
    		op.click(page, object);
    		
    		break;
    	    		
    	case "assertall":
            
    	    op.assertAll();
    	    break;
    	
    	}
    	
    	
    }
    
    private void executeSignInPageMethods(String testCaseID,String testStepNo,String keyword,String input1,String input2)
    {
    	switch(keyword.toLowerCase())
    	{
    	case "login":
    		
    		si.signIntoPage(testCaseID,testStepNo);
    		
    		break;
    	case "assertAll":
    		si.assertAll();
    	    break;
    	
    	
    	}
    	
    	
    }
    


}
