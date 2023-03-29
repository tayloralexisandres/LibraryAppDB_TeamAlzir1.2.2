package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchTitle_clickAdd_clickBorrow_stepDef {
    String bookname;
    @Given("the user searches for {string} book")
    public void the_user_searches_for_book(String bookname) {
        this.bookname=bookname;
        BookPage bookPage=new BookPage();
        bookPage.search.sendKeys(bookname);
        BrowserUtil.waitFor(2);
        System.out.println("searched book title is "+bookname);
    }
    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {
        this.bookname=bookname;
        WebElement clickMe= Driver.getDriver().findElement(By.xpath("//td[.='"+bookname+"']"));
        clickMe.click();
        BrowserUtil.waitFor(2);

    }

    @When("the librarian click to add book")
    public void theLibrarianClickToAddBook() {
        BookPage bookPage=new BookPage();
        bookPage.addBook.click();
        BrowserUtil.waitFor(2);
    }
}
