package sites.venturus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import sites.venturus.attributes.TableAttributes;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class TablePage extends TableAttributes {

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public Map<String, String> getBorrowMap() {
        logStep("Reading 'Borrow' column...");
        Map<String, String> map = new HashMap<>();
        for (int i=0; i<tableRows().size(); i++) {
            String name = tableRows().get(i).findElements(By.xpath("//td[1]")).get(i).getText();
            String borrow = tableRows().get(i).findElements(By.xpath("//td[2]")).get(i).getText();
            map.put(name, borrow);
        }
        screenshot("'Borrow' column has been stored for verification.");
        return map;
    }

    public Map<String, String> getRepaymentMap() {
        logStep("Reading 'Repayment' column...");
        Map<String, String> map = new HashMap<>();
        for (int i=0; i<tableRows().size(); i++) {
            String name = tableRows().get(i).findElements(By.xpath("//td[1]")).get(i).getText();
            String repayment = tableRows().get(i).findElements(By.xpath("//td[3]")).get(i).getText();
            map.put(name, repayment);
        }
        screenshot("'Repayment' column has been stored for verification.");
        return map;
    }

    public TablePage clickNext() {
        scrollToFindElement(enabledNextPage(), 1);
        if (isNull(enabledNextPage()))
            return this;
        logStep("About to click Next...");
        click(enabledNextPage());
        scrollToTop();
        return this;
    }

    public TablePage clickBack() {
        scrollToFindElement(enabledPreviousPage(), 1);
        if (isNull(enabledPreviousPage()))
            return this;
        logStep("About to click Previous...");
        click(enabledPreviousPage());
        scrollToTop();
        return this;
    }

    public TablePage verifyPageIsOnFirstPage() {
        Assert.assertEquals(activePaginationLink(), "1");
        logStep("Validated this is the first page of the table.");
        return this;
    }

    public String getCurrentTablePage() {
        return activePaginationLink();
    }

    public boolean hasMorePagesForward() {
        return !isNull(enabledNextPage());
    }

    public boolean hasMorePagesBack() {
        return !isNull(enabledPreviousPage());
    }

    public TablePage clickColumnsSorter() {
        screenshot("About to click on the columns sorter...");
        clickInteractableElement(columnsSorter());
        return this;
    }
}
