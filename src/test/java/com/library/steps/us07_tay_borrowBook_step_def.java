package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.BorrowedBooksPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class us07_tay_borrowBook_step_def {
    BorrowedBooksPage borrowedBooksPage=new BorrowedBooksPage();
    BookPage bookPage=new BookPage();

    List<WebElement> actaul;

    String bookname;


    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_page(String bk) {

        bookPage.navigateModule(bk);


        actaul=borrowedBooksPage.allBorrowedBooksName;
        List<String > emptyactual=new ArrayList<>();
        for (WebElement each : actaul) {
            emptyactual.add(String.valueOf(each));

        }

        BrowserUtil.waitFor(1);


    }
    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {
        DB_Util.createConnection();
        DB_Util.runQuery("select full_name, b.name, bb.borrowed_date\n" +
                "from users u\n" +
                "         inner join book_borrow bb on u.id = bb.user_id\n" +
                "         inner join books b on bb.book_id = b.id\n" +
                "where full_name = 'Test Student 56'\n" +
                "order by 3 desc");
        this.bookname=bookname;
        List<String> exptected=DB_Util.getColumnDataAsList(2);
        List<String> actual=BrowserUtil.getElementsText(borrowedBooksPage.allBorrowedBooksName);
        System.out.println("exptected = " + Arrays.asList(exptected));
        System.out.println("actual = " + actual);
        Assert.assertEquals(actual.contains(bookname),exptected.contains(bookname));

    }

}
