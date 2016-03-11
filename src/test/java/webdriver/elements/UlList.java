package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Class, Describing element ulList
 */
public class UlList  extends BaseElement{

    /**
     * Constructor
     * @param loc locator
     */
    protected UlList(By loc) {
        super(loc);
    }

    /**
     * Constructor
     * @param loc
     * @param nameOf
     */
    public UlList(By loc, String nameOf) {
        super(loc, nameOf);
    }

    /**
     * Constructor
     * @param stringLocator locator
     * @param nameOfElement name
     */
    protected UlList(String stringLocator, String nameOfElement) {
        super(stringLocator, nameOfElement);
    }


    /**
     * Get a list of options
     * @return null
     * or
     * @return list of options
     */
    public List<String> getLiList(){
        if (element == null) {
            return null;
        }
        List<WebElement> liList = element.findElements(By.cssSelector("li"));
        List<String> result = new ArrayList<>();
        for (WebElement webElement : liList) {
            if (!webElement.getText().equals(name)) {
                result.add(webElement.getText());
            }
        }
        return result;
    }
    /**
     * Returns Element type
     * @return Element type
     */
    @Override
    protected String getElementType() {
        return getLoc("loc.list");
    }
}
