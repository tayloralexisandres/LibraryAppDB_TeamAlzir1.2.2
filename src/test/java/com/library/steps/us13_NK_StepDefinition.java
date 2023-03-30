package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class us13_NK_StepDefinition {

    @When("Execute query to get all columns")
    public void executeQueryToGetAllColumns() {
        String query="select * from users where 1=0";
        DB_Util.runQuery(query);
    }

    @Then("verify the below columns are listed in result")
    public void verifyTheBelowColumnsAreListedInResult(List<String> columns) {
        List<String> allColumnNamesAsList = DB_Util.getAllColumnNamesAsList();
        Assert.assertEquals(allColumnNamesAsList,columns);
    }
}
