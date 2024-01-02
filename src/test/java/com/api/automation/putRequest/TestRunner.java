package com.api.automation.putRequest;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

public class TestRunner
{

	
	@Test
	public Karate runTest()
	{
		return Karate.run("putRequest").relativeTo(getClass());
	}
	
	@Test
	public Karate runTestUsingClassPath()
	{
		return Karate.run("classpath:com/api/automation/putRequest/putRequest.feature");
		
		
	}
}
