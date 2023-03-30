package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US01_OR_StepDefinitions {
    @When("Execute query to get all columns.OR")
    public void execute_query_to_get_all_columns_or() {
        DB_Util.runQuery("select * from users");

    }
    @Then("verify the below columns are listed in result.OR")
    public void verify_the_below_columns_are_listed_in_result_or(List<String> expected) {

        List<String> actualColumn = DB_Util.getAllColumnNamesAsList();
        Assert.assertEquals(actualColumn,expected);
    }
}
