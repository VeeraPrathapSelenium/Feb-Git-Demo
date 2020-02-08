package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing {
	
	@Test
	public void doTest() {
		
		
		
		String Expected="A";
		String Actual="B";
		
		//Assert.assertEquals(Actual,Expected, "Comparing two elements");
		
		SoftAssert ast=new SoftAssert();
		ast.assertEquals("A", "B");
		System.out.println("Testing asserts");
		ast.assertAll();
		
	}

}
