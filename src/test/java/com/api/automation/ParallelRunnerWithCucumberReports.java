package com.api.automation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@SuppressWarnings("deprecation")
@KarateOptions(features = "classpath:com/api/automation")
public class ParallelRunnerWithCucumberReports {
	@Test
	public void testParallel() {
		Results results = Runner.path("classpath:com/api/automation").outputCucumberJson(true).parallel(5);
		// Get the path off the report
		generateReport(results.getReportDir());
		assertTrue(results.getFailCount() == 0, results.getErrorMessages());
	}

	public static void generateReport(String karateOutputPath) {
		Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] { "json" }, true);
		List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
		jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
		Configuration config = new Configuration(new File("target"), "API Automation");
		ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
		reportBuilder.generateReports();

	}

}
