package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class US02_DN_StepDefs {

    DashBoardPage dashBoardPage;
    String actualBorrowedBookNumber;


    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {

        dashBoardPage=new DashBoardPage();

        actualBorrowedBookNumber = dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBookNumber = " + actualBorrowedBookNumber);


    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        String query="select count(*) from book_borrow where is_returned=0";

        DB_Util.runQuery(query);

        String expectedBorrowedBookNumber = DB_Util.getCellValue(1, 1);
        System.out.println("expectedBorrowedBookNumber = " + expectedBorrowedBookNumber);

        //Assertions
        Assert.assertEquals(expectedBorrowedBookNumber,actualBorrowedBookNumber);


    }
}
