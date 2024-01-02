package com.api.automation;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner.Builder;

public class ParallelRunner 
{
	@SuppressWarnings("rawtypes")
	@Test
	public void executeKarateTest()
	{
		Builder aRunner = new Builder();
		aRunner.path(("classpath:com/api/automation"));
		
		Results result = aRunner.parallel(5);
		System.out.println("Total Feature => " + result.getFeatureResults());
		System.out.println("Total Scenario => " + result.getScenarioResults());
		System.out.println("Total Scenario => " + result.getScenariosTotal());
		System.out.println("Passed Feature => " + result.getFeaturesPassed());
		System.out.println("Passed Scenario => " + result.getScenariosPassed());
		
		Assertions.assertEquals(0, result.getFailCount(), "There are some Failed Scenarios");
	}
}
