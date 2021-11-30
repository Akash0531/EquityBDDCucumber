package com.equitymobile.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( plugin = {"pretty"
        , "html:target/cucumber-html-reports"
        , "summary"
        ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
        ,monochrome=true
        ,features = {"src/test/resources/alwaysRun","src/test/resources/features"}
        ,glue = {"com.equitymobile.stepdef"}
       ,tags = "@sendMoneyMobile"
        )
    public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
}
