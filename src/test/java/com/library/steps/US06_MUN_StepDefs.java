package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class US06_MUN_StepDefs {

    BookPage bookPage = new BookPage();

    @And("the librarian enter book name {string}")
    public void theLibrarianEnterBookName(String BookName) {
        bookPage.bookName.sendKeys(BookName);


    }

    @When("the librarian enter ISBN {string}")
    public void theLibrarianEnterISBN(String ISBN) {
        bookPage.isbn.sendKeys(ISBN);
    }

    @And("the librarian enter year {string}")
    public void theLibrarianEnterYear(String Year) {
        bookPage.year.sendKeys(Year);
    }

    @When("the librarian enter author {string}")
    public void theLibrarianEnterAuthor(String Author) {
        bookPage.author.sendKeys(Author);
    }

    @And("the librarian choose the book category {string}")
    public void theLibrarianChooseTheBookCategory(String BookCategory) {
        Select bookcategory = new Select(bookPage.categoryDropdown);
        bookcategory.selectByVisibleText(BookCategory);

    }

    @And("the librarian click to save changes")
    public void theLibrarianClickToSaveChanges() {
        bookPage.saveChanges.click();
    }

    @Then("verify {string} message is displayed")
    public void verifyMessageIsDisplayed(String expectedMessage) {
        BrowserUtil.waitForClickablility(bookPage.toastMessage,3);
        Assert.assertTrue(bookPage.toastMessage.isDisplayed());
        BrowserUtil.waitFor(3);
    }

    @And("verify {string} information must match with DB")
    public void verifyInformationMustMatchWithDB(String expectedBookName) {
     BrowserUtil.waitFor(3);
        String query = "select name, author, isbn from books where name = '" + expectedBookName + "'";
        DB_Util.runQuery("select name, author, isbn from books where name = '" + expectedBookName + "'");

        Map<String, String> rowMap = DB_Util.getRowMap(1);

        String actualBookName = rowMap.get("name");

        Assert.assertEquals(expectedBookName, actualBookName);

    }
}



