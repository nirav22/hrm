package org.example;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", tags = "@invalid", format = {"pretty", "json:target/Destination/cucumber.json"})


public class RunTest
{

}

