package com.SkyBlue.LibraryCT.steps;

import com.SkyBlue.LibraryCT.pages.Anaris_US6_Page;
import com.SkyBlue.LibraryCT.pages.BookPage;
import com.SkyBlue.LibraryCT.utility.BrowserUtil;
import com.SkyBlue.LibraryCT.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class US4_StepDefs {

    BookPage bookPage = new BookPage();
    Anaris_US6_Page anaris_us6_page = new Anaris_US6_Page();
    String bookNameFromReq;

    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
        bookPage.search.sendKeys(bookName);
        BrowserUtil.waitFor(1);
        bookNameFromReq = bookName;
    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
        anaris_us6_page.editBook.click();
        BrowserUtil.waitFor(1);
    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {

        String bookNameFromUI = bookPage.bookName.getAttribute("value");
        String authorNameFromUI = bookPage.author.getAttribute("value");
        String isbnFromUI = bookPage.isbn.getAttribute("value");
        String yearFromUI = bookPage.year.getAttribute("value");
        String descFromUI = bookPage.description.getAttribute("value");

        String query = "select * from books where name = '"+bookNameFromReq+"'";

        DB_Util.runQuery(query);
        Map<String, String> mapFromDB = DB_Util.getRowMap(1);

        String actualNameOFBook = mapFromDB.get("name");
        String actualISBNOFBook = mapFromDB.get("isbn");
        String actualYearOFBook = mapFromDB.get("year");
        String actualAuthorOFBook = mapFromDB.get("author");
        String actualDescOfBook = mapFromDB.get("description");

        Assert.assertEquals(bookNameFromUI,actualNameOFBook);
        Assert.assertEquals(isbnFromUI,actualISBNOFBook);
        Assert.assertEquals(yearFromUI, actualYearOFBook);
        Assert.assertEquals(authorNameFromUI, actualAuthorOFBook);
        Assert.assertEquals(descFromUI, actualDescOfBook);
    }
}
