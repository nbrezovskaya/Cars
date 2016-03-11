package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Class, Describing element table
 */
public class Table extends BaseElement {

    /**
     * Constructor
     * @param loc locator
     */
    protected Table(By loc) {
        super(loc);
    }

    /**
     * Constructor
     * @param loc
     * @param nameOf
     */
    public Table(By loc, String nameOf) {
        super(loc, nameOf);
    }

    protected Table(String stringLocator, String nameOfElement) {
        super(stringLocator, nameOfElement);
    }

    /**
     * Returns Element type
     * @return Element type
     */
    @Override
    protected String getElementType() {
        return getLoc("loc.table");
    }

    /**
     * Takes the value column of the row with the specified cell
     * @param cell
     * @param column
     * @return null
     * or
     * @return text cell element
     */
    public String getColumnOfRowWithCell(String cell, int column) {
        waitForIsElementPresent();
        WebElement rowElement = element.findElement(By.xpath(String.format("//tr[td='%s']", cell)));
        if (rowElement == null) {
            return null;
        }
        WebElement cellElement = rowElement.findElement(By.xpath(String.format("td[%d]", column)));
        return cellElement == null ? null : cellElement.getText();
    }
}
