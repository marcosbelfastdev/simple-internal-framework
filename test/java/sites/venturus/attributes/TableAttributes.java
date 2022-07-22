package sites.venturus.attributes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.pages.BasePage;

import java.util.List;

import static java.util.Objects.isNull;

public class TableAttributes extends BasePage {

    public TableAttributes(WebDriver driver) {
        super(driver);
    }

    protected WebElement tableOnPage() {
        return make.getWebElement(By.xpath("//div[@class='ant-table-content']//table"));
    }

    protected List<WebElement> tableRows() {
        return tableOnPage().findElements(By.xpath("//tbody//tr"));
    }

    protected WebElement tableRow(int index) {
        return tableRows().get(index);
    }

    protected List<WebElement> tableColumnsOnRow(WebElement tableRow) {
        return tableOnPage().findElements(By.xpath("//td"));
    }

    protected WebElement paginationLinks() {
        return make.getWebElement(By.xpath("//ul[contains(@class,'pagination')]"));
    }

    protected WebElement enabledPaginationLink(String linkText) {
        List<WebElement> paginationLinks = paginationLinks().findElements(By.xpath("//li"));
        for (WebElement paginationLink : paginationLinks) {
            if (paginationLink.getAttribute("title").equals(linkText)) {
                if (isNull(paginationLink.getAttribute("aria-disabled")))
                    return paginationLink;
                if (paginationLink.getAttribute("aria-disabled").equals("true"))
                    return null;
                if (paginationLink.getAttribute("aria-disabled").equals("false"))
                    return paginationLink;
            }
        }
        return null;
    }

    protected String activePaginationLink() {
        List<WebElement> paginationLinks = null;
        try {
            paginationLinks = paginationLinks()
                    .findElements(By.xpath("//li[contains(@class,'item-active')]"));
        } catch (Exception ignore) {

        }

        return isNull(paginationLinks) ? null : paginationLinks.get(0).getAttribute("title");
    }

    protected WebElement enabledNextPage() {
        return enabledPaginationLink("Next Page");
    }

    protected WebElement enabledPreviousPage() {
        return enabledPaginationLink("Previous Page");
    }

    protected WebElement columnsSorter() {
        return make.getWebElement(By.xpath("//div[@class='ant-table-column-sorters']"));
    }

}
