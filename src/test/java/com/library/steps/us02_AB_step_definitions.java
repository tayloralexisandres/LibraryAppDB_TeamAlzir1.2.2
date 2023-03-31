package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class us09_AB_step_definitions {

    DashBoardPage dashBoardPage;
    String actualBorrowedBookNumber;
    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {
        dashBoardPage = new DashBoardPage();
        actualBorrowedBookNumber = dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBookNumber = " + actualBorrowedBookNumber);
    }

    String query;
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        query = "select count(*) from book_borrow where is_returned=0;";
        DB_Util.runQuery(query);
        String expectedBorrowedBookNumber = DB_Util.getCellValue(1,1);
        Assert.assertEquals(expectedBorrowedBookNumber,actualBorrowedBookNumber);
    }
}
