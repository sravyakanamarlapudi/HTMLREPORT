package Tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomTestListener implements ITestListener {
    private BufferedWriter writer;
    private List<String> passedTests = new ArrayList<>();
    private List<String> assertionFailures = new ArrayList<>();
    private List<String> timeouts = new ArrayList<>();
    private List<String> exceptions = new ArrayList<>();
    private List<String> skippedTests = new ArrayList<>();

    private Map<String, List<String>> failureGroups = new HashMap<>();

    @Override
    public void onTestStart(ITestResult result) {
// Not used
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        passedTests.add(result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        Throwable cause = result.getThrowable();

        if (cause instanceof AssertionError) {
            assertionFailures.add(testName);
        } else if (cause instanceof org.openqa.selenium.TimeoutException) {
            timeouts.add(testName);
        } else {
            exceptions.add(testName);
        }

        List<String> failures = failureGroups.getOrDefault(cause.getClass().getSimpleName(), new ArrayList<>());
        failures.add(testName);
        failureGroups.put(cause.getClass().getSimpleName(), failures);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skippedTests.add(result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// Not used
    }

    @Override
    public void onStart(ITestContext context) {
        try {
            writer = new BufferedWriter(new FileWriter("test-report.html"));
            writer.write("<html>");
            writer.write("<head><title>Test Report</title></head>");
            writer.write("<body>");
            writer.write("<h1>Test Report</h1>");
            writer.write("<p>Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "</p>");
            writer.write("<ul>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            writer.write("</ul>");

            if (!passedTests.isEmpty()) {
                writer.write("<h2>Passed Tests</h2>");
                writer.write("<ul>");
                for (String testName : passedTests) {
                    writer.write("<li>" + testName + "</li>");
                }
                writer.write("</ul>");
            }

            if (!assertionFailures.isEmpty() || !timeouts.isEmpty() || !exceptions.isEmpty()) {
                writer.write("<h2>Failed Tests</h2>");

                if (!assertionFailures.isEmpty()) {
                    writer.write("<h3>Assertion Failures</h3>");
                    writer.write("<ul>");
                    for (String testName : assertionFailures) {
                        writer.write("<li>" + testName + "</li>");
                    }
                    writer.write("</ul>");
                }

                if (!timeouts.isEmpty()) {
                    writer.write("<h3>Timeouts</h3>");
                    writer.write("<ul>");
                    for (String testName : timeouts) {
                        writer.write("<li>" + testName + "</li>");
                    }
                    writer.write("</ul>");
                }

                if (!exceptions.isEmpty()) {
                    writer.write("<h3>Exceptions</h3>");
                    writer.write("<ul>");
                    for (String testName : exceptions) {
                        writer.write("<li>" + testName + "</li>");
                    }
                    writer.write("</ul>");
                }

                writer.write("<h3>Failure Groups</h3>");
                writer.write("<ul>");
                for (String group : failureGroups.keySet()) {
                    List<String> failures = failureGroups.get(group);
                    writer.write("<li>" + group + "</li>");
                    writer.write("<ul>");
                    for (String testName : failures) {
                        writer.write("<li>" + testName + "</li>");
                    }
                    writer.write("</ul>");
                }
                writer.write("</ul>");
            }

            if (!skippedTests.isEmpty()) {
                writer.write("<h2>Skipped Tests</h2>");
                writer.write("<ul>");
                for (String testName : skippedTests) {
                    writer.write("<li>" + testName + "</li>");
                }
                writer.write("</ul>");
            }

            writer.write("</body>");
            writer.write("</html>");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






