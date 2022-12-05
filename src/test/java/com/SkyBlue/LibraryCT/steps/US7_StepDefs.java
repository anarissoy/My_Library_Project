package com.SkyBlue.LibraryCT.steps;

import com.SkyBlue.LibraryCT.pages.Anaris_US6_Page;
import com.SkyBlue.LibraryCT.pages.BookPage;
import com.SkyBlue.LibraryCT.utility.BrowserUtil;
import com.SkyBlue.LibraryCT.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US7_StepDefs {

    BookPage bookPage = new BookPage();
    Anaris_US6_Page anaris_us6_page = new Anaris_US6_Page();
    String bookName = "Limon6";

    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {
        anaris_us6_page.borrowBook(bookName).click();

    }

    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_page(String module) {

        bookPage.navigateModule(module);
        Assert.assertTrue(BrowserUtil.getElementsText(anaris_us6_page.allBorrowedBooksName).contains(bookName));

    }
    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {

        String query = "select b.name from books b join book_borrow bb on" +
                " b.id = bb.book_id join users u on bb.user_id = u.id where b.name = '"+bookName+"'";
        DB_Util.runQuery(query);

        List<String> actualList = DB_Util.getColumnDataAsList(1);
        System.out.println("actualList = " + actualList);
        System.out.println("bookName = " + bookName);
        Assert.assertTrue(actualList.contains(bookName));

    }
}
