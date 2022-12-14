package com.SkyBlue.LibraryCT.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features" ,
        glue = "com/SkyBlue/LibraryCT/steps" ,
        dryRun = false,
        tags = "@smoke",
        publish = true
)
public class CukesRunner {
}






//plugin = {
//                "html:target/cucumber-report.html",
//                "rerun:target/rerun.txt" ,
//                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
//        },
//        features = "src/test/resources/features" ,
//        glue = "com/SkyBlue/LibraryCT/steps",
//        dryRun = false,
//        tags = "@smoke"
