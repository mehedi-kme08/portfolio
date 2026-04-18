package com.portfolio.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features",
    glue     = "com.portfolio.stepdefs",
    plugin   = {
        "pretty",
        "html:build/cucumber-reports/cucumber.html",
        "json:build/cucumber-reports/cucumber.json",
        "junit:build/cucumber-reports/cucumber.xml"
    },
    monochrome = true,
    // Change tags here or override with -Dcucumber.filter.tags="@smoke" on the command line
    tags = "not @wip"
)
public class TestRunner {
    // Entry point – run via: ./gradlew test
}
