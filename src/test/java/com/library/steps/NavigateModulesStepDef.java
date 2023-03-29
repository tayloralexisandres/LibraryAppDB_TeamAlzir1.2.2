package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class NavigateModulesStepDef {
    BookPage bookPage;

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String page) {
        bookPage=new BookPage();
        bookPage.navigateModule(page);
        BrowserUtil.waitFor(1);
        System.out.println("User is on the "+page+" page.");
    }
}



