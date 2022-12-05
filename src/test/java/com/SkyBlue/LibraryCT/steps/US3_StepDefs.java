package com.SkyBlue.LibraryCT.steps;

import com.SkyBlue.LibraryCT.pages.BookPage;
import com.SkyBlue.LibraryCT.utility.BrowserUtil;
import com.SkyBlue.LibraryCT.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US3_StepDefs {

    BookPage bookPage = new BookPage();
    List<String> bookCategoriesFromUI;

    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
        bookPage.mainCategoryElement.click();
        bookCategoriesFromUI = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        bookCategoriesFromUI.remove(0);
    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

        String query = "select name from book_categories";

        DB_Util.runQuery(query);

        List<String> bookCategoriesFromDB = DB_Util.getColumnDataAsList(1);
        System.out.println("BookCategoriesFromDB "+bookCategoriesFromDB);
        System.out.println("BookCategoriesFromUI "+bookCategoriesFromUI);
        Assert.assertEquals(bookCategoriesFromUI,bookCategoriesFromDB);
    }

}
