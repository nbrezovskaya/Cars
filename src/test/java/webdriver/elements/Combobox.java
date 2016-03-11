package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.opera.core.systems.scope.AbstractService.sleep;

/**
 * Class, Describing element combobox
 */
public class Combobox extends BaseElement {
    private static final Random RANDOM = new Random();

    /**
     * Constructor
     * @param loc locator
     */
    protected Combobox(By loc) {
        super(loc);
    }

    /**
     * Constructor
     * @param loc
     * @param nameOf
     */
    public Combobox(By loc, String nameOf) {
        super(loc, nameOf);
    }

    /**
     * Constructor
     * @param stringLocator locator
     * @param nameOfElement name
     */
    protected Combobox(String stringLocator, String nameOfElement) {
        super(stringLocator, nameOfElement);
    }

    /**
     * Select option randomly excluding the first
     * @param excludeFirst
     * @return  option text
     */
    public String clickRandomOption(boolean excludeFirst) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        WebElement option;
        if (excludeFirst) {
            option = options.get(RANDOM.nextInt(options.size() - 1) + 1);
        } else {
            option = options.get(RANDOM.nextInt(options.size()));
        }
        String text = option.getText();
        select.selectByVisibleText(text);
        return text;
    }

    /**
     * Returns Element type
     * @return Element type
     */
    @Override
    protected String getElementType() {
        return getLoc("loc.dropDownList");
    }

    /**
     * Select max option
     * @return max option
     */
    public String clickMaxOption() {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        String max = null;
        for (WebElement option : options) {
            if (max == null || max.compareTo(option.getText()) < 0) {
                max = option.getText();
            }
        }
        select.selectByVisibleText(max);
        return max;
    }

    /**
     * Click option
     * @param optionName
     */
    public void clickOption(String optionName) {
        waitForIsElementPresent();
        click();
        Select select = new Select(element);
        Assert.assertTrue(optionExists(select, optionName));
        select.selectByVisibleText(optionName);
    }

    /**
     * Select option exists
     * @param select
     * @param optionName
     * @return option exist
     * @return option is not exist
     */
    private boolean optionExists(Select select, String optionName) {
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(optionName)) {
                return true;
            }
        }
        return false;
    }
}
