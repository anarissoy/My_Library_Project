package com.SkyBlue.LibraryCT.steps;

import com.SkyBlue.LibraryCT.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US5_StepDefs {

    @Given("Establish the database connection")
    public void establish_the_database_connection() {

    }
    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {
        String query = "select bc.name, count(*)\n" +
                "from book_borrow bb\n" +
                "         inner join books b on bb.book_id = b.id\n" +
                "         inner join book_categories bc on b.book_category_id = bc.id\n" +
                "group by bc.name\n" +
                "order by 2 desc";

        DB_Util.runQuery(query);
    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String expectedBookCategoryName) {

        String actualBookCategoryName = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBookCategoryName,actualBookCategoryName);

    }
}
