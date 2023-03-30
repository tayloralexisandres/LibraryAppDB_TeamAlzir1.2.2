package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US08_StepDefns_Romana {

    @When("Execute query to get all columns.rk")
    public void execute_query_to_get_all_columns_rk() {

        DB_Util.runQuery("select * from users");

    }
    @Then("verify the below columns are listed in result.rk")
    public void verify_the_below_columns_are_listed_in_result_rk(List<String> expected) {

        List<String> actualColumnNames = DB_Util.getAllColumnNamesAsList();

        Assert.assertEquals(actualColumnNames,expected);

    }
}
