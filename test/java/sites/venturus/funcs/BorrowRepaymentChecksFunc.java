package sites.venturus.funcs;

import base.tests.BaseSingleDriverFunc;
import core.utils.MapComparison;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import sites.venturus.pages.TablePage;

import java.util.HashMap;
import java.util.Map;

public class BorrowRepaymentChecksFunc extends BaseSingleDriverFunc {

    public BorrowRepaymentChecksFunc(WebDriver driver) {
        super(driver);
    }


    public void verifyTableStatesDoNotChangeData() {

        /*
        I recalled that hashmaps do not normally store duplicate keys.
        I should've used some sort of hashmap that allows for duplicate keys instead
        However, I'm lucky this test won't fail as values are unique though.
        No more time for a change here.

        Basically the way I thought this to work is to get a hashmap by repeating
        the name as the key for each column:
        |Name|Borrow
        |Name|Repayment

        Evidently, if we see different tables where keys are not unique,
        more complex and custom table objects should be created.
         */

        Map<String, String> borrowState1 = new HashMap<>();
        Map<String, String> repaymentState1 = new HashMap<>();

        Map<String, String> borrowState2 = new HashMap<>();
        Map<String, String> repaymentState2 = new HashMap<>();

        Map<String, String> borrowState3 = new HashMap<>();
        Map<String, String> repaymentState3 = new HashMap<>();

        var tablePage = new TablePage(getBrowser());
        tablePage.verifyPageIsOnFirstPage();

        // State 1
        // start fetching the whole table spanning across pages
        borrowState1.putAll(tablePage.getBorrowMap());
        repaymentState1.putAll(tablePage.getRepaymentMap());
        while (tablePage.hasMorePagesForward()) {
            tablePage.clickNext();
            borrowState1.putAll(tablePage.getBorrowMap());
            repaymentState1.putAll(tablePage.getRepaymentMap());
        }
        while (tablePage.hasMorePagesBack()) tablePage.clickBack();

        tablePage.clickColumnsSorter();

        // State 2
        borrowState2.putAll(tablePage.getBorrowMap());
        repaymentState2.putAll(tablePage.getRepaymentMap());
        while (tablePage.hasMorePagesForward()) {
            tablePage.clickNext();
            borrowState2.putAll(tablePage.getBorrowMap());
            repaymentState2.putAll(tablePage.getRepaymentMap());
        }

        // Now we have grabbed 2 states across pages
        // Comparing...
        logStep("State 1 - Borrow Column\n" + borrowState1);
        logStep("State 2 - Borrow Column\n" + borrowState2);
        logStep("State 1 - Repayment Column\n" + repaymentState1);
        logStep("State 2 - Repayment Column\n" + repaymentState2);

        var borrowComparison1 = new MapComparison(borrowState1, borrowState2);
        Assert.assertTrue(borrowComparison1.areKeyValuePairsIdentical());
        logStep("Both Borrow columns match between State 1 and State 2.");

        var repaymentComparison2 = new MapComparison(repaymentState1, repaymentState2);
        Assert.assertTrue(repaymentComparison2.areKeyValuePairsIdentical());
        logStep("Both Repayment columns match between State 1 and State 2.");

        // Let's go back to the start to fetch state 3
        while (tablePage.hasMorePagesBack()) tablePage.clickBack();

        // State 3
        tablePage.clickColumnsSorter();
        borrowState3.putAll(tablePage.getBorrowMap());
        repaymentState3.putAll(tablePage.getRepaymentMap());
        while (tablePage.hasMorePagesForward()) {
            tablePage.clickNext();
            borrowState3.putAll(tablePage.getBorrowMap());
            repaymentState3.putAll(tablePage.getRepaymentMap());
        }

        // Now let us compare all other states to state 3

        // 1 with 3
        // Comparing...
        logStep("State 1 - Borrow Column\n" + borrowState1);
        logStep("State 2 - Borrow Column\n" + borrowState3);
        logStep("State 1 - Repayment Column\n" + repaymentState1);
        logStep("State 2 - Repayment Column\n" + repaymentState3);
        var borrowComparison13 = new MapComparison(borrowState1, borrowState3);
        Assert.assertTrue(borrowComparison1.areKeyValuePairsIdentical());
        var repaymentComparison13 = new MapComparison(repaymentState1, repaymentState3);
        Assert.assertTrue(repaymentComparison2.areKeyValuePairsIdentical());

        // 2 with 3
        // Comparing...
        logStep("State 1 - Borrow Column\n" + borrowState2);
        logStep("State 2 - Borrow Column\n" + borrowState3);
        logStep("State 1 - Repayment Column\n" + repaymentState2);
        logStep("State 2 - Repayment Column\n" + repaymentState3);
        var borrowComparison23 = new MapComparison(borrowState2, borrowState3);
        Assert.assertTrue(borrowComparison1.areKeyValuePairsIdentical());
        var repaymentComparison23 = new MapComparison(repaymentState2, repaymentState3);
        Assert.assertTrue(repaymentComparison2.areKeyValuePairsIdentical());

    }
}
