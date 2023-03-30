package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class US05_YA_StepDefs {

    String actualPopularGenre;
    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {
        String query ="select bc.name,count(*) from book_borrow bb\n" +
                "inner join books b on bb.book_id = b.id\n" +
                "inner join book_categories bc on b.book_category_id=bc.id group by name\n" +
                "order by 2 desc;";
        DB_Util.runQuery(query);

        actualPopularGenre = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualPopularGenre = " + actualPopularGenre);

    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String expectedPopularGenre) {

        Assert.assertEquals(expectedPopularGenre, actualPopularGenre);

    }



}
