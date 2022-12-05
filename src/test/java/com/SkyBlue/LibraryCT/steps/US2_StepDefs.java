package com.SkyBlue.LibraryCT.steps;

import com.SkyBlue.LibraryCT.pages.DashBoardPage;
import com.SkyBlue.LibraryCT.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US2_StepDefs {

    DashBoardPage dashBoardPage = new DashBoardPage();
    String borrowedBooksNumFromUI = "";

    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {

        borrowedBooksNumFromUI += ""+dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("BorrowedBooksFromUI "+borrowedBooksNumFromUI);


    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        String query = "select count(*) from book_borrow where is_returned = 0";

        DB_Util.runQuery(query);

        String actualBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();
        System.out.println("BorrowedBooksNumberFromDB "+actualBorrowedBooksNumber);

        Assert.assertEquals(borrowedBooksNumFromUI,actualBorrowedBooksNumber);



    }
}
